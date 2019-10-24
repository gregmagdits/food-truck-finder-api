package biz.pagodatech.foodtruckfinder.api.exception.advice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ErrorResponse {
    @JsonProperty("error_msg")
    private final String errorMsg;
}
