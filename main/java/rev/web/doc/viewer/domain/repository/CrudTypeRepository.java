package rev.web.doc.viewer.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rev.web.doc.viewer.domain.entity.CrudType;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrudTypeRepository extends JpaRepository<CrudType, Integer> {
    Optional<CrudType> findById(Integer id);

    List<CrudType> findAll();
}
