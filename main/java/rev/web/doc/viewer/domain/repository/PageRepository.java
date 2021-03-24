package rev.web.doc.viewer.domain.repository;

import org.springframework.data.repository.CrudRepository;
import rev.web.doc.viewer.domain.entity.Page;

import java.util.List;

public interface PageRepository extends CrudRepository<Page, Long> {
    List<Page> findAll();
}
