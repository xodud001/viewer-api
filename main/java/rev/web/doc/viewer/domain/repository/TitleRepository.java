package rev.web.doc.viewer.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rev.web.doc.viewer.domain.entity.Title;

import java.util.List;

@Repository
public interface TitleRepository  extends JpaRepository<Title, Long> {

    List<Title> findAll();
}
