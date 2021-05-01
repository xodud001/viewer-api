package rev.web.doc.viewer.domain.entity;

public interface Title{ // Page 에서 타이틀만 가져오는 Mapping Interface
    Long getPageId();
    String getTitle();
}
