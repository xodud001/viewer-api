package rev.web.doc.viewer.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "request_parameter")
public class RequestParameter {

    @Id
    @Column(name = "req_param_id")
    private String reqParamId;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name="page_id")
    @JsonIgnore
    private Page page;

    @OneToOne
    @JoinColumn(name="data_id")
    private DataType dataType;

    @OneToOne
    @JoinColumn(name="param_id")
    private ParamType parameterType;
}
