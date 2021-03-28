package rev.web.doc.viewer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rev.web.doc.viewer.domain.dto.PageDto;
import rev.web.doc.viewer.domain.entity.Page;
import rev.web.doc.viewer.domain.repository.PageRepository;
import rev.web.doc.viewer.service.PageService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class PageController {

    private final PageService pageService;

    @Autowired
    public PageController(PageService pageService){
        this.pageService = pageService;
    }

    @GetMapping("/pages")
    public List<PageDto> getPates(){
        return pageService.getPages();
    }

    @GetMapping("/page/{id}")
    public PageDto getPate(@PathVariable("id") Long id){
        return pageService.getPage(id);
    }

    @PostMapping("/pages")
    public ResponseEntity<?> create(@Validated @RequestBody Page resource ) throws URISyntaxException {
        Page page = Page.builder()
                .title(resource.getTitle())
                .description(resource.getDescription())
                .build();
        pageService.createPage(page);
        URI location = new URI("/pages/" + page.getId());
        return ResponseEntity.created(location).body("SUCCESS");
    }
}
