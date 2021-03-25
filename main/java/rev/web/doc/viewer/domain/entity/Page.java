package rev.web.doc.viewer.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "page")
public class Page extends AbstractPage{

    private Long id;

    private String title;

    private String description;

    private Integer crudType;

    private String url;

}
