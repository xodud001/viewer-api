package rev.web.doc.viewer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rev.web.doc.viewer.domain.dto.PageDto;
import rev.web.doc.viewer.domain.entity.Page;
import rev.web.doc.viewer.domain.repository.PageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PageService {

    private final PageRepository pageRepository;
    private final CrudTypeService crudTypeService;
    private final RequestParameterService requestParameterService;

    @Autowired
    public PageService(PageRepository pageRepository,
                       CrudTypeService crudTypeService,
                       RequestParameterService requestParameterService) {
        this.pageRepository = pageRepository;
        this.crudTypeService = crudTypeService;
        this.requestParameterService = requestParameterService;
    }

    public List<PageDto> getPages() {
        List<Page> pages = pageRepository.findAll();
        List<PageDto> pageDtos = new ArrayList<>();
        pages.forEach( page -> {
            pageDtos.add(
                createPageDto(page)
            );
        });
        return pageDtos;
    }

    public PageDto getPage(Long id){
        Page page = pageRepository.findById(id).orElse(null);
        assert page != null;
        return createPageDto(page);
    }
    public void createPage(Page page){
        pageRepository.save(page);
    }

    private PageDto createPageDto(Page page){
        return PageDto.builder()
                .id(page.getId())
                .title(page.getTitle())
                .description(page.getDescription())
                .crudType(crudTypeService.getType(page.getCrudType()))
                .url(page.getUrl())
                .params(requestParameterService.getRequestParametersByPageId(page.getId()))
                .build();
    }
}
