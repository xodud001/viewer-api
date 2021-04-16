package rev.web.doc.viewer.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "request_parameter")
public class RequestParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

// Path Parameters : 0
// Query Parameters : 1
// Form Data Parameters : 2
// Body Parameters : 3
// Headers : 4
    private int parameterType;

    private String name;

    private String dataType;

    private String description;

    private Long pageId;
}
