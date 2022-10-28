package by.it_academy.bootcamp.users.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/**
 * Error. Contains error descriptions with links to entity fields
 */
@Schema(description = "Error. Contains error descriptions with links to entity fields")
public class TMultipleErrorResponse {
    @JsonProperty("logref")
    private String logref = null;

    @JsonProperty("errors")
    private List<TMultipleErrorResponseErrors> errors = new ArrayList<>();

    /**
     * error type
     * @return logref
     **/
    @ApiModelProperty(example = "structured_error")
    public String getLogref() {
        return logref;
    }

    public void setLogref(String logref) {
        this.logref = logref;
    }

    /**
    * field name
    * @return errors
    **/
    @ApiModelProperty
    public List<TMultipleErrorResponseErrors> getErrors() {
        return errors;
    }

    public void setErrors(List<TMultipleErrorResponseErrors> errors) {
        this.errors = errors;
    }

    public TMultipleErrorResponse logref(String logref) {
        this.logref = logref;
        return this;
    }

    public TMultipleErrorResponse errors(List<TMultipleErrorResponseErrors> errors) {
        this.errors = errors;
        return this;
    }

    public TMultipleErrorResponse addErrorsItem(TMultipleErrorResponseErrors errorsItem) {
        this.errors.add(errorsItem);
        return this;
    }

    @Override
    public String toString() {
        return "TMultipleErrorResponse{" +
                "logref='" + logref + '\'' +
                ", errors=" + errors +
                '}';
    }
}
