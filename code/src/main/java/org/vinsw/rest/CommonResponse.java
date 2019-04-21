package org.vinsw.rest;

import java.util.List;

/**
 * Represent a common response
 */
public class CommonResponse {

    private Status status;

    private List<Error> errors;

    public CommonResponse withStatus(Status status) {
        this.status = status;
        return this;
    }

    public CommonResponse withErrors(List<Error> errors) {
        this.errors = errors;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public enum Status {
        SUCCESS,
        INVALID_INPUT,
        CONNECTION_KO
    }
}
