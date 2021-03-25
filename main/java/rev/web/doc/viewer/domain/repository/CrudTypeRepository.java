package rev.web.doc.viewer.domain.repository;

import org.springframework.data.repository.CrudRepository;
import rev.web.doc.viewer.domain.entity.CrudType;

import java.util.List;
import java.util.Optional;

public interface CrudTypeRepository extends CrudRepository<CrudType, Integer> {
    Optional<CrudType> findById(Integer id);

    List<CrudType> findAll();
}
