package backend.modelClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostEmployeeResponse {
    private String status;
    private PostEmployeeResponseData data;
    private String message;
    String test;
}
