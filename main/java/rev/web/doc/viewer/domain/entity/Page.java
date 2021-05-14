package rev.web.doc.viewer.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, exclude = {"parameters", "crudType"})
@ToString(exclude = {"parameters", "crudType"})
@Entity
@Builder
@Table(name = "page")
public class Page{

    @Id
    @Column(name = "page_id")
    private String pageId;

    private String title;

    private String description;

    private String url;

    @OneToOne
    @JoinColumn(name="crud_id")
    private CrudType crudType;

    @OneToMany(mappedBy = "page")
    @Column(updatable = false, insertable = false)
    private List<RequestParameter> parameters;
}
