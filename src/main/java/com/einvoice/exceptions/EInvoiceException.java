package com.einvoice.exceptions;

import org.springframework.http.HttpStatus;

public class EInvoiceException extends RuntimeException{

    private String message;
    private HttpStatus statusCode;

    public EInvoiceException() {
        super();
    }
    public EInvoiceException(String message, Throwable cause, HttpStatus statusCode) {
        super(message, cause);
        this.message = message;
        this.statusCode = statusCode;
    }
    public EInvoiceException(String message, HttpStatus statusCode) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }
    public EInvoiceException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}
