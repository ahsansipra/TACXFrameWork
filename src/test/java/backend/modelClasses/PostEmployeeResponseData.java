package backend.modelClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostEmployeeResponseData {
    private String name;
    private Integer salary;
    private Integer age;
    private Integer id;
}
