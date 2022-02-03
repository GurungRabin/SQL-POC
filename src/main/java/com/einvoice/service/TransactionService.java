package com.einvoice.service;

import com.einvoice.dto.TransactionDto;
import com.einvoice.entity.TransactionEntity;

import java.util.List;

public interface TransactionService {

    TransactionDto saveTransaction(TransactionDto transactionDto);

    List<TransactionEntity> findAll();
}
