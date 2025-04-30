package onlineshop.rest.api.exception;

import onlineshop.rest.api.payloads.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice

public class RestControllerExceptionHandler {
    public ResponseEntity<ApiResponse> resolveException(BlogapiException exception) {
        String message = exception.getMessage();
        HttpStatus status = exception.getStatus();

        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setSuccess(Boolean.FALSE);
        apiResponse.setMessage(message);

        return new ResponseEntity<>(apiResponse, status);
    }
}
