package rev.web.doc.viewer.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "page")
public class Page{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "page_id")
    private Long pageId;

    private String title;

    private String description;

    private String url;

    @OneToOne
    @JoinColumn(name="crud_id")
    private CrudType crudType;

    @OneToMany(mappedBy = "page")
    private List<RequestParameter> parameters;
}
