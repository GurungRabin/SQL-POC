package com.einvoice.exceptions;

import com.einvoice.dto.JSONResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandeler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EInvoiceException.class)
    public ResponseEntity<JSONResponse> handleEInvoiceExceptions(EInvoiceException invoiceException,
                                                                 WebRequest request){
        JSONResponse response = new JSONResponse(invoiceException.getStatusCode().value(),
                invoiceException.getMessage(), null);
        return new ResponseEntity<JSONResponse>(response, invoiceException.getStatusCode());
    }
}
