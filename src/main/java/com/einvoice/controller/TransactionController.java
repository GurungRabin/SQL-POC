package com.einvoice.controller;

import com.einvoice.dto.JSONResponse;
import com.einvoice.dto.TransactionDto;
import com.einvoice.repository.TransactionRepository;
import com.einvoice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<JSONResponse> save(@RequestBody TransactionDto transactionDto) {
        TransactionDto transactionDto1 =  transactionService.saveTransaction(transactionDto);
        return new ResponseEntity<>(new JSONResponse(200, "Successfully created!", transactionDto1), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<JSONResponse> findAll() {
        return new ResponseEntity<>(new JSONResponse(200, "Successfully fetched!",
                transactionService.findAll()), HttpStatus.OK);
    }
}
