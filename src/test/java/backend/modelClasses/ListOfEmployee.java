package backend.modelClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListOfEmployee {
    private String status;
    private List<EmployeeResponseData> data;
}
