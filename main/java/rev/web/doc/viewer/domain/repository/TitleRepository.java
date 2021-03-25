package rev.web.doc.viewer.domain.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import rev.web.doc.viewer.domain.entity.Title;

import java.util.List;

public interface TitleRepository  extends CrudRepository<Title, Long> {

    List<Title> findAll();
}
