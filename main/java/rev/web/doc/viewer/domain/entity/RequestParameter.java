package rev.web.doc.viewer.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, exclude = {"page", "dataType", "parameterType"})
@ToString(exclude = {"page", "dataType", "parameterType"})
@Builder
@Entity
@Table(name = "request_parameter")
public class RequestParameter {

    @Id
    @Column(name = "req_param_id")
    private String reqParamId;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name="page_id" )
    @JsonIgnore
    private Page page;

    @OneToOne
    @JoinColumn(name="data_id")
    private DataType dataType;

    @OneToOne
    @JoinColumn(name="param_id")
    private ParamType parameterType;

    public boolean equal(RequestParameter other){
         return this.getReqParamId().equals(other.getReqParamId());
    }
}
