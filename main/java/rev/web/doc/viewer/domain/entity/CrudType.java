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
@Table(name = "crud_type")
public class CrudType {

    @Id
    @Column(name = "crud_id",insertable = false, updatable = false)
    private Integer crudId;
    @Column(insertable = false, updatable = false)
    private String type;
    // 1 : GET
    // 2 : POST
    // 3 : DELETE
    // 4 : PATCH

}
