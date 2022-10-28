package by.it_academy.bootcamp.users.controller.handler;

import by.it_academy.bootcamp.users.dto.response.TMultipleErrorResponse;
import by.it_academy.bootcamp.users.dto.response.TMultipleErrorResponseErrors;
import by.it_academy.bootcamp.users.dto.response.TSingleErrorResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Objects;

@RestControllerAdvice
public class GlobalHandler {
    private static final Logger log = LogManager.getLogger(GlobalHandler.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handle(IllegalArgumentException e) {
        TSingleErrorResponse tSingleErrorResponse = new TSingleErrorResponse();
        tSingleErrorResponse.message(e.getMessage());
        log.info(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public TSingleErrorResponse handle(RuntimeException exception) {
        log.error(exception.getMessage());
        return new TSingleErrorResponse().logref("error")
                .message("Internal Server Error. The server was unable to process the request correctly");
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public TSingleErrorResponse handle(HttpMessageNotReadableException exception) {
        log.error(exception.getMessage());
        String message = exception.getMessage();
        TSingleErrorResponse error = new TSingleErrorResponse()
                .logref("error");

        if (!Objects.isNull(message)) {
            error.message(message.split(";")[0]);
        }

        return error;
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public TMultipleErrorResponse handle(ConstraintViolationException exception) {
        final TMultipleErrorResponse errorResponse = new TMultipleErrorResponse();
        errorResponse.logref("structured_error");

        exception.getConstraintViolations().forEach(
                x -> {
                    String[] fieldPaths = x.getPropertyPath().toString().split("\\.");
                    errorResponse.addErrorsItem(new TMultipleErrorResponseErrors()
                        .field(fieldPaths[fieldPaths.length - 1])
                        .message(x.getMessage()));
                }
        );

        log.info(errorResponse);
        return errorResponse;
    }
}
