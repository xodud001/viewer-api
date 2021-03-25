package rev.web.doc.viewer.domain.entity;

import lombok.*;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Entity
@Data
@Immutable
@Table(name = "page")
public class Title extends AbstractPage{

}
