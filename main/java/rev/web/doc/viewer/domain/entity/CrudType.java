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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "crud_id")
    private Integer crudId;

    private String type;
    // 1 : GET
    // 2 : POST
    // 3 : DELETE
    // 4 : PATCH

}
