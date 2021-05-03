package rev.web.doc.viewer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rev.web.doc.viewer.domain.entity.Page;
import rev.web.doc.viewer.domain.entity.Title;
import rev.web.doc.viewer.service.PageService;

import java.util.List;

@CrossOrigin
@RestController
public class PageController {

    private final PageService pageService;

    @Autowired
    public PageController(PageService pageService){
        this.pageService = pageService;
    }

    @GetMapping("/titles")
    public List<Title> getTitles(){
        return pageService.getTitles();
    }

    @GetMapping("/page/{id}")
    public Page getPage(@PathVariable("id") String id){
        return pageService.getPage(id);
    }

    @PostMapping("/page")
    public void createPage(@RequestBody Page page){
        pageService.createPage(page);
    }
    @PatchMapping("/page")
    public void updatePage(@RequestBody Page page){
        pageService.updatePage(page);
    }

    @DeleteMapping("/page/{id}")
    public void deletePage(@PathVariable("id") String id){
        pageService.deletePage(id);
    }


}
