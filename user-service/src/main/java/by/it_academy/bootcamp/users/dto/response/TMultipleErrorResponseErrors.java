package by.it_academy.bootcamp.users.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * TMultipleErrorResponseErrors
 */
@Schema
public class TMultipleErrorResponseErrors   {
    @JsonProperty("field")
    private String field;
    @JsonProperty("message")
    private String message;


    /**
    * error message
    * @return message
    **/
    @ApiModelProperty(example = "must not be empty")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
    * field name
    * @return field
    **/
    @ApiModelProperty(example = "email")
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public TMultipleErrorResponseErrors field(String field) {
      this.field = field;
      return this;
    }

    public TMultipleErrorResponseErrors message(String message) {
      this.message = message;
      return this;
    }

    @Override
    public String toString() {
        return "TMultipleErrorResponseErrors{" +
                "field='" + field + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
