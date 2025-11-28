package design.pattern.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ServiceResult<T> {

    private boolean success = true;
    private T data;
    private Map<String, String> errorMessage;

    public ServiceResult(T data) {
        this.data = data;
    }
    public ServiceResult() {}

    public void addErrorMessage(String key, String value) {
        if (Objects.isNull(errorMessage)) {
            errorMessage = new HashMap<>();
        }
        errorMessage.put(key, value);
    }
}
