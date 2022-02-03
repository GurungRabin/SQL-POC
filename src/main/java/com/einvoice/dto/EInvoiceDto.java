package com.einvoice.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class EInvoiceDto implements Serializable {

    @JsonProperty("ID")
    private String id;

    @JsonProperty("CustomizationID")
    private String customizationid;

    @JsonProperty("ProfileID")
    private String profileid;

    @JsonProperty("IssueDate")
    private String issuedate;

    @JsonProperty("DueDate")
    private String duedate;

    @JsonProperty("InvoiceTypeCode")
    private String invoicetypecode;

    @JsonProperty("DocumentCurrencyCode")
    private String documentcurrencycode;

    @JsonProperty("AccountingCost")
    private String accountingcost;

    @JsonProperty("BuyerReference")
    private String buyerreference;

    @JsonProperty("AccountingSupplierParty")
    private AccountingSupplierPartyDto accountingsupplierparty;

//    @JsonProperty("AccountingCUstomerParty")
//    private String accountingcustomerparty;
//
//    @JsonProperty("Delivery")
//    private String delivery;
//
//    @JsonProperty("PaymentMeans")
//    private String paymentmeans;
//
//    @JsonProperty("PaymentTerms")
//    private String paymentterms;
//
//    @JsonProperty("AllowanceCharge")
//    private String allowancecharge;
//
//    @JsonProperty("TaxTotal")
//    private String taxtotal;
//
//    @JsonProperty("LegalMonetaryTotal")
//    private String legalmonetarytotal;
//
//    @JsonProperty("InvoiceLine")
//    private String invoiceline;


    public EInvoiceDto() {

    }

    public EInvoiceDto(String id, String customizationid, String profileid, String issuedate, String duedate, String invoicetypecode, String documentcurrencycode, String accountingcost, String buyerreference, AccountingSupplierPartyDto accountingsupplierparty) {
        this.id = id;
        this.customizationid = customizationid;
        this.profileid = profileid;
        this.issuedate = issuedate;
        this.duedate = duedate;
        this.invoicetypecode = invoicetypecode;
        this.documentcurrencycode = documentcurrencycode;
        this.accountingcost = accountingcost;
        this.buyerreference = buyerreference;
        this.accountingsupplierparty = accountingsupplierparty;
    }

    public String getInvoice_id() {
        return id;
    }

    public void setInvoice_id(String invoice_id) {
        this.id = invoice_id;
    }

    public String getCustomizationid() {
        return customizationid;
    }

    public void setCustomizationid(String customizationid) {
        this.customizationid = customizationid;
    }

    public String getProfileid() {
        return profileid;
    }

    public void setProfileid(String profileid) {
        this.profileid = profileid;
    }

    public String getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getInvoicetypecode() {
        return invoicetypecode;
    }

    public void setInvoicetypecode(String invoicetypecode) {
        this.invoicetypecode = invoicetypecode;
    }

    public String getDocumentcurrencycode() {
        return documentcurrencycode;
    }

    public void setDocumentcurrencycode(String documentcurrencycode) {
        this.documentcurrencycode = documentcurrencycode;
    }

    public String getAccountingcost() {
        return accountingcost;
    }

    public void setAccountingcost(String accountingcost) {
        this.accountingcost = accountingcost;
    }

    public String getBuyerreference() {
        return buyerreference;
    }

    public void setBuyerreference(String buyerreference) {
        this.buyerreference = buyerreference;
    }

    public AccountingSupplierPartyDto getAccountingsupplierparty() {
        return accountingsupplierparty;
    }

    public void setAccountingsupplierparty(AccountingSupplierPartyDto accountingsupplierparty) {
        this.accountingsupplierparty = accountingsupplierparty;
    }
}