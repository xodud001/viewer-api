package rev.web.doc.viewer.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rev.web.doc.viewer.domain.entity.Page;
import rev.web.doc.viewer.domain.entity.RequestParameter;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RequestParameterRepository extends JpaRepository<RequestParameter, String>  {

    @Transactional
    @Modifying // select 문이 아님을 나타낸다
    @Query(value = "UPDATE `api_doc`.`request_parameter` SET `page_id` = :pageId WHERE (`req_param_id` = :reqParamId)", nativeQuery = true)
    void updatePageId(@Param("pageId")String pageId, @Param("reqParamId")String reqParamId) throws Exception;

    @Query(value = "select * from `api_doc`.`request_parameter` WHERE `page_id` = :pageId", nativeQuery = true)
    List<RequestParameter> findAllByPageId(String pageId);

    @Transactional
    void deleteAllByPage(Page page);

    @Transactional
    @Modifying // select 문이 아님을 나타낸다
    @Query(value = "UPDATE `api_doc`.`request_parameter` SET `name` = :name, `data_id` = :dataId, `description` = :description WHERE (`req_param_id` = :reqParamId)", nativeQuery = true)
    void update(String reqParamId, String name, Integer dataId, String description);
}
