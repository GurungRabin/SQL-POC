package com.einvoice.service;

import com.einvoice.dto.EInvoiceDto;
import com.einvoice.entity.EInvoiceEntity;

import java.util.List;

public interface EInvoiceService {

    public EInvoiceDto createInvoice(EInvoiceDto eInvoiceDto);

    public EInvoiceDto getInvoiceById(Integer invoice_id);

    public EInvoiceDto updateInvoice(EInvoiceDto updateInvoice);

    public void deleteInvoice(Integer invoice_id);

    public List<EInvoiceDto> getAllInvoices();

    List<EInvoiceEntity> findAllByAccountingsupplierpartyGroupByCountryIdentificationCode(String countryCode);

    List<EInvoiceEntity> findAllByCityName(String country);

}
