package rev.web.doc.viewer.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import rev.web.doc.viewer.domain.entity.RequestParameter;

import java.util.List;

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
