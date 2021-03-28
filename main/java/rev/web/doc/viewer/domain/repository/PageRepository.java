package rev.web.doc.viewer.domain.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import rev.web.doc.viewer.domain.entity.Page;
import rev.web.doc.viewer.domain.entity.Title;

import java.util.List;
import java.util.Optional;

public interface PageRepository extends CrudRepository<Page, Long> {

    List<Page> findAll();

    Optional<Page> findById(Long id);
}
