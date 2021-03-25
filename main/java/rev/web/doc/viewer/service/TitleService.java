package rev.web.doc.viewer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rev.web.doc.viewer.domain.entity.Title;
import rev.web.doc.viewer.domain.repository.TitleRepository;

import java.util.List;

@Service
public class TitleService {

    private final TitleRepository titleRepository;

    @Autowired
    public TitleService(TitleRepository titleRepository){
        this.titleRepository = titleRepository;
    }

    public List<Title> getTitles(){
        return titleRepository.findAll();
    }
}
