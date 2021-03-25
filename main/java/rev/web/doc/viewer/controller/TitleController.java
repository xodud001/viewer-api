package rev.web.doc.viewer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rev.web.doc.viewer.domain.dto.PageDto;
import rev.web.doc.viewer.domain.entity.Title;
import rev.web.doc.viewer.service.TitleService;

import java.util.List;

@RestController
public class TitleController {

    private final TitleService titleService;

    @Autowired
    public TitleController(TitleService titleService){
        this.titleService = titleService;
    }

    @GetMapping("/titles")
    public List<Title> getTitles(){
        return titleService.getTitles();
    }
}
