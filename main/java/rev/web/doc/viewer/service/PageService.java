package rev.web.doc.viewer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rev.web.doc.viewer.domain.entity.Page;
import rev.web.doc.viewer.domain.entity.Title;
import rev.web.doc.viewer.domain.repository.PageRepository;

import java.util.List;

@Service
public class PageService {

    private final PageRepository pageRepository;

    @Autowired
    public PageService(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    public List<Title> getTitles() {
        return pageRepository.findAllByTitleIsNotNull();
    }

    public Page getPage(Long id) {
        return pageRepository.findById(id).orElse(null);
    }
}
