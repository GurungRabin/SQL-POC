package com.einvoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.einvoice.entity.EInvoiceEntity;

import java.util.List;


@Repository
public interface EInvoiceRepository extends JpaRepository<EInvoiceEntity, Integer> {

    // retrieve all einvoice whose accounting supplier party is located in the city with name 'cityName'
    List<EInvoiceEntity> findAllByAccountingsupplierpartyCityName(String cityName);

    @Query("select new com.einvoice.entity.EInvoiceEntity(e.invoice_id, e.id,\n" +
            "e.customizationid, e.profileid, e.issuedate,\n"+
            "e.duedate, e.invoicetypecode, e.documentcurrencycode,\n"+
            "e.accountingcost, e.buyerreference, e.accountingsupplierparty) " +
            "from EInvoiceEntity e group by e.accountingsupplierparty.countryIdentificationCode")
    List<EInvoiceEntity> findAllByAccountingsupplierpartyGroupByCountryIdentificationCode(String code);


}
