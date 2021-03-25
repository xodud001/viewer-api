package rev.web.doc.viewer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rev.web.doc.viewer.domain.dto.PageDto;
import rev.web.doc.viewer.domain.entity.CrudType;
import rev.web.doc.viewer.service.CrudTypeService;
import rev.web.doc.viewer.service.PageService;

import java.util.List;

@CrossOrigin
@RestController
public class CrudTypeController  {
    private final CrudTypeService crudTypeService;

    @Autowired
    public CrudTypeController(CrudTypeService crudTypeService){
        this.crudTypeService = crudTypeService;
    }

    @GetMapping("/types")
    public List<CrudType> getTypes(){
        return crudTypeService.getTypes();
    }
}
