package rev.web.doc.viewer.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rev.web.doc.viewer.domain.entity.Page;
import rev.web.doc.viewer.domain.entity.Title;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<Page, String> {

    List<Title> findAllByTitleIsNotNull();

    @Transactional
    @Modifying
    @Query(value="INSERT INTO `api_doc`.`page` (`page_id`, `description`, `title`, `url`, `crud_id`) VALUES (:page_id, :description, :title, :url, :crud_id) ", nativeQuery = true)
    void create(@Param("page_id")String pageId,
                @Param("description")String description,
                @Param("title")String title,
                @Param("url")String url,
                @Param("crud_id")Integer crudId
    );

    @Transactional
    @Modifying
    @Query(value="UPDATE `api_doc`.`page` SET `description` = :description, `title` = :title, `url` = :url, `crud_id` = :crudId WHERE (`page_id` = :pageId);", nativeQuery = true)
    void update(String pageId, String description, String title, String url, Integer crudId);
}
