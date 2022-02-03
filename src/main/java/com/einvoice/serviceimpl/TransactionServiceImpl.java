package com.einvoice.serviceimpl;

import com.einvoice.dto.AccountingSupplierPartyDto;
import com.einvoice.dto.EInvoiceDto;
import com.einvoice.dto.TransactionDto;
import com.einvoice.entity.AccountingSupplierParty;
import com.einvoice.entity.EInvoiceEntity;
import com.einvoice.entity.TransactionEntity;
import com.einvoice.repository.AccountingSupplierPartyRepository;
import com.einvoice.repository.EInvoiceRepository;
import com.einvoice.repository.TransactionRepository;
import com.einvoice.service.TransactionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    private EInvoiceRepository eInvoiceRepository;

    private AccountingSupplierPartyRepository accountingSupplierPartyRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  EInvoiceRepository eInvoiceRepository,
                                  AccountingSupplierPartyRepository accountingSupplierPartyRepository) {
        this.transactionRepository = transactionRepository;
        this.eInvoiceRepository = eInvoiceRepository;
        this.accountingSupplierPartyRepository = accountingSupplierPartyRepository;
    }

    @Override
    public TransactionDto saveTransaction(TransactionDto transactionDto) {
        EInvoiceDto eInvoiceDto = transactionDto.getEInvoiceDto();

        EInvoiceEntity eInvoiceEntity = new EInvoiceEntity();
        BeanUtils.copyProperties(eInvoiceDto, eInvoiceEntity);
        // extract accounting supplier party data and save it to its respective table
        AccountingSupplierPartyDto accountingSupplierPartyDto = eInvoiceDto.getAccountingsupplierparty();
        String schemeID = accountingSupplierPartyDto.getParty().getEndpointID().get("@schemeID").toString();
        String text = accountingSupplierPartyDto.getParty().getEndpointID().get("#text").toString();
        String partyIdentificationID = accountingSupplierPartyDto.getParty().getPartyIdentification().get("ID");
        String partyName = accountingSupplierPartyDto.getParty().getPartyName().get("Name");
        String identificationCode = accountingSupplierPartyDto.getParty().getPostalAddress().getCountry().get("IdentificationCode");
        String partyTaxSchemeID = accountingSupplierPartyDto.getParty().getPartyTaxScheme().getTaxScheme().get("ID");
        AccountingSupplierParty accountingSupplierParty = new AccountingSupplierParty(
                schemeID,
                text,
                partyIdentificationID,
                partyName,
                accountingSupplierPartyDto.getParty().getPostalAddress().getStreetName(),
                accountingSupplierPartyDto.getParty().getPostalAddress().getAdditionalStreetName(),
                accountingSupplierPartyDto.getParty().getPostalAddress().getCityName(),
                accountingSupplierPartyDto.getParty().getPostalAddress().getPostalZone(),
                identificationCode,
                accountingSupplierPartyDto.getParty().getPartyTaxScheme().getCompanyId(),
                partyTaxSchemeID,
                accountingSupplierPartyDto.getParty().getPartyLegalEntity().getRegistrationName(),
                accountingSupplierPartyDto.getParty().getPartyLegalEntity().getCompanyId()
        );
        accountingSupplierParty = accountingSupplierPartyRepository.save(accountingSupplierParty);

        // making relation with two tables
        eInvoiceEntity.setAccountingsupplierparty(accountingSupplierParty);

        EInvoiceEntity savedEntity = eInvoiceRepository.save(eInvoiceEntity);

        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setEInvoiceEntity(eInvoiceEntity);
        transactionEntity.setStatus("Transaction Complete");
        transactionEntity.setCreatedBy(transactionDto.getCreatedBy());

        transactionEntity = transactionRepository.save(transactionEntity);
        BeanUtils.copyProperties(transactionEntity, transactionDto);
        return transactionDto;
    }

    @Override
    public List<TransactionEntity> findAll() {
        return transactionRepository.findAll();
    }


}
