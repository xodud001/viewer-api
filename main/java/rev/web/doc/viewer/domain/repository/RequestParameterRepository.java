package rev.web.doc.viewer.domain.repository;

import org.springframework.data.repository.CrudRepository;
import rev.web.doc.viewer.domain.entity.RequestParameter;

import java.util.List;
import java.util.Optional;

public interface RequestParameterRepository extends CrudRepository<RequestParameter, Long> {
    List<RequestParameter> findByPageId(Long id);
}
