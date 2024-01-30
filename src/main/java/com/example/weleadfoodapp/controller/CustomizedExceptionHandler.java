package com.example.weleadfoodapp.controller;

import com.example.weleadfoodapp.base.BaseComponent;
import com.example.weleadfoodapp.transfer.ApiError;
import com.example.weleadfoodapp.transfer.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.NoSuchElementException;


@RestControllerAdvice
public class CustomizedExceptionHandler extends BaseComponent {
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiResponse<?>> handleAllExceptions(final Exception ex, final WebRequest request) {
        logger.error("Unexpected exception occurred.", ex);
        return new ResponseEntity<>(
                ApiResponse.builder()
                        .data(getApiError(ex, HttpStatus.INTERNAL_SERVER_ERROR, request))
                        .build()
                , HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<ApiResponse<?>> handleNonExistence(final NoSuchElementException ex,
                                                                   final WebRequest request) {
        logger.error("Reference to a non-existing object.", ex);
        return new ResponseEntity<>(
                ApiResponse.builder().data(getApiError(ex, HttpStatus.NOT_FOUND, request)).build(),
                HttpStatus.NOT_FOUND
        );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<ApiResponse<?>> handleMissingServletRequestParameter(
            final MissingServletRequestParameterException ex, final WebRequest request) {
        logger.error("There was a parameter missing from incoming request.", ex);
        return new ResponseEntity<>(
                ApiResponse.builder()
                        .data(getApiError(ex, HttpStatus.BAD_REQUEST, request))
                        .build()
                , HttpStatus.BAD_REQUEST
        );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
                                                                          final WebRequest request) {
        logger.error("Method argument is invalid.", ex);
        return new ResponseEntity<>(
                ApiResponse.builder()
                        .data(getApiError(ex, HttpStatus.BAD_REQUEST, request))
                        .build()
                , HttpStatus.BAD_REQUEST
        );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentTypeMismatch(final MethodArgumentTypeMismatchException ex,
                                                                           final WebRequest request) {
        logger.error("Method argument, although matched, is of wrong type.", ex);
        return new ResponseEntity<>(
                ApiResponse.builder().data(getApiError(ex, HttpStatus.BAD_REQUEST, request)).build(),
                HttpStatus.BAD_REQUEST
        );
    }

    private ApiError getApiError(final Exception ex, final HttpStatus status, final WebRequest request) {
        String path = request.getDescription(false);
        if (path.indexOf("uri=") == 0) {
            path = StringUtils.replace(path, "uri=", "");
        }
        return new ApiError(status.value(), ex.getMessage(), path);
    }

    private ApiError getApiError(final Exception ex, final HttpStatus status, final WebRequest request,
                                 String customMessage) {
        String path = request.getDescription(false);
        if (path.indexOf("uri=") == 0) {
            path = StringUtils.replace(path, "uri=", "");
        }
        return new ApiError(status.value(), customMessage != null ? customMessage : ex.getMessage(), path);
    }
}