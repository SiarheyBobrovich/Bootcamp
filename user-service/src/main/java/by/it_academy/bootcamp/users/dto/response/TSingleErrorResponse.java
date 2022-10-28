package by.it_academy.bootcamp.users.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Error. contains a description
 */
@Schema(description = "Error. contains a description")
public class TSingleErrorResponse   {
    @JsonProperty("logref")
    private String logref = null;

    @JsonProperty("message")
    private String message = null;

    /**
    * error type
    * @return logref
    **/
    @Schema(example = "error", required = true, description = "error type")
    public String getLogref() {
        return logref;
    }

    public void setLogref(String logref) {
        this.logref = logref;
    }

    /**
    * error message
    * @return message
    **/
    @Schema(example = "Try again later", required = true, description = "error message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TSingleErrorResponse logref(String logref) {
        this.logref = logref;
        return this;
    }

    public TSingleErrorResponse message(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "TSingleErrorResponse{" +
                "logref='" + logref + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
