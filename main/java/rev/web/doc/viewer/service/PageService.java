package rev.web.doc.viewer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rev.web.doc.viewer.domain.entity.Page;
import rev.web.doc.viewer.domain.entity.RequestParameter;
import rev.web.doc.viewer.domain.entity.Title;
import rev.web.doc.viewer.domain.repository.PageRepository;
import rev.web.doc.viewer.domain.repository.RequestParameterRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PageService {

    private final PageRepository pageRepository;
    private final RequestParameterRepository requestParameterRepository;

    @Autowired
    public PageService(PageRepository pageRepository,
                       RequestParameterRepository requestParameterRepository) {
        this.pageRepository = pageRepository;
        this.requestParameterRepository = requestParameterRepository;
    }

    public List<Title> getTitles() {
        return pageRepository.findAllByTitleIsNotNull();
    }

    public Page getPage(String id) {
        return pageRepository.findById(id).orElse(null);
    }

    @Transactional
    public void createPage(Page page) {
        pageRepository.create(
                page.getPageId(),
                page.getDescription(),
                page.getTitle(),
                page.getUrl(),
                page.getCrudType().getCrudId()
        );
        requestParameterRepository.saveAll(page.getParameters());

        page.getParameters().forEach( e -> {
            try {
                requestParameterRepository.updatePageId(page.getPageId(), e.getReqParamId());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    @Transactional
    public void updatePage(Page page) {
        pageRepository.update(
                page.getPageId(),
                page.getDescription(),
                page.getTitle(),
                page.getUrl(),
                page.getCrudType().getCrudId()
        );
        //TODO: 받은 Params에서 기존의 Params 중에 없는 요소는 생성, 있는 요소는 업데이트. 기존 Params 에서 받은 Params와 매핑되지 않는 요소는 삭제
        List<RequestParameter> exists = requestParameterRepository.findAllByPageId(page.getPageId());
        List<RequestParameter> receives = page.getParameters();

        List<RequestParameter> create = new ArrayList<>();
        List<RequestParameter> update = new ArrayList<>();
        List<RequestParameter> remove = new ArrayList<>();
        exists.forEach( e -> {
            receives.forEach( r -> {
                if(e.equal(r)) update.add(r);
            });
        });
        for(RequestParameter exist : exists){
            boolean isExist = false;
            for(RequestParameter receive : receives) isExist = isExist || exist.equal(receive);
            if(!isExist) remove.add(exist);
        }
        for(RequestParameter receive : receives){
            boolean isExist = false;
            for(RequestParameter exist : exists) isExist = isExist || receive.equal(exist);
            if(!isExist) create.add(receive);
        }
        requestParameterRepository.deleteAll(remove);

        update.forEach( e -> {
            try{
                requestParameterRepository.update(
                        e.getReqParamId(),
                        e.getName(),
                        e.getDataType().getDataId(),
                        e.getDescription()
                );
            } catch (Exception exception){
                exception.printStackTrace();
            }
        });

        requestParameterRepository.saveAll(create);
        create.forEach( e -> {
            try {
                requestParameterRepository.updatePageId(page.getPageId(), e.getReqParamId());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    @Transactional
    public void deletePage(String id) {
        requestParameterRepository.deleteAllByPage(pageRepository.findById(id).orElse(null));
        pageRepository.deleteById(id);
    }


}
