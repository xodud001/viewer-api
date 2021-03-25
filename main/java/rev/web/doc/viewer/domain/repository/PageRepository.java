package rev.web.doc.viewer.domain.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import rev.web.doc.viewer.domain.entity.Page;
import rev.web.doc.viewer.domain.entity.Title;

import java.util.List;

public interface PageRepository extends CrudRepository<Page, Long> {

    List<Page> findAll();

}
