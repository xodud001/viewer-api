package rev.web.doc.viewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rev.web.doc.viewer.domain.entity.CrudType;
import rev.web.doc.viewer.domain.entity.Page;
import rev.web.doc.viewer.domain.repository.CrudTypeRepository;
import rev.web.doc.viewer.domain.repository.PageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CrudTypeService {

    private final CrudTypeRepository crudTypeRepository;

    @Autowired
    public CrudTypeService(CrudTypeRepository crudTypeRepository) { this.crudTypeRepository = crudTypeRepository;}

    public String getType(Integer id) {
        Optional<CrudType> type = crudTypeRepository.findById(id);

        if(type.isPresent()) return type.get().getType();
        else return "NULL";
    }

    public List<CrudType> getTypes() {
        return crudTypeRepository.findAll();
    }
}
