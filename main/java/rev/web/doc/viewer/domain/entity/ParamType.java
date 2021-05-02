package rev.web.doc.viewer.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "param_type")
public class ParamType {

    @Id
    @Column(name = "param_id", insertable = false, updatable = false)
    private Integer paramId;

    // Path Parameters : 0
    // Query Parameters : 1
    // Form Data Parameters : 2
    // Body Parameters : 3
    // Headers : 4
    @Column(insertable = false, updatable = false)
    private String type;
}
