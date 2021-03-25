package rev.web.doc.viewer.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rev.web.doc.viewer.domain.entity.Page;
import rev.web.doc.viewer.domain.entity.RequestParameter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageDto {

    private long id;

    private String title;

    private String description;

    private String crudType;

    private String url;

    private List<RequestParameter> params;
}
