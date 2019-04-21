package org.vinsw.rest;

/**
 * Map a field goes in error with a specific message.
 * e.g. An attribute missing in a request
 */
public class Error {

    private String field;

    private String msg;

    public Error(String field, String msg) {
        this.field = field;
        this.msg = msg;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
