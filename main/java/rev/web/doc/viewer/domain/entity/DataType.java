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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "data_id")
    private Integer dataId;

    private String type;
}
