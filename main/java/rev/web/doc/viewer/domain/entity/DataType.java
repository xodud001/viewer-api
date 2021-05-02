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
@Table(name = "data_type")
public class DataType {

    @Id
    @Column(name = "data_id", insertable = false, updatable = false)
    private Integer dataId;

    @Column(insertable = false, updatable = false)
    private String type;
}
