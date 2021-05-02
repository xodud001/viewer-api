package rev.web.doc.viewer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rev.web.doc.viewer.domain.entity.Page;
import rev.web.doc.viewer.domain.entity.Title;
import rev.web.doc.viewer.domain.repository.PageRepository;
import rev.web.doc.viewer.domain.repository.RequestParameterRepository;

import javax.transaction.Transactional;
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
    public void deletePage(String id) {
        requestParameterRepository.deleteAllByPage(pageRepository.findById(id).orElse(null));
        pageRepository.deleteById(id);
    }
}
