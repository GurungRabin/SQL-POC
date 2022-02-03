package com.einvoice.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "einvoice")
public class EInvoiceEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer invoice_id;

    private String id;

    private String customizationid;

    private String profileid;


    private String issuedate;


    private String duedate;


    private String invoicetypecode;


    private String documentcurrencycode;


    private String accountingcost;


    private String buyerreference;


    @OneToOne
    private AccountingSupplierParty accountingsupplierparty;

    public EInvoiceEntity(Integer invoice_id, String id, String customizationid, String profileid, String issuedate, String duedate, String invoicetypecode, String documentcurrencycode, String accountingcost, String buyerreference, AccountingSupplierParty accountingsupplierparty) {
        this.invoice_id = invoice_id;
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

    // todo: do same as AccountingSupplierParty
    private String accountingcustomerparty;


    private String delivery;


    private String paymentmeans;


    private String paymentterms;


    private String allowancecharge;


    private String taxtotal;


    private String legalmonetarytotal;

    private String invoiceline;

    public EInvoiceEntity() {
    }

    public EInvoiceEntity(String id, String customizationid, String profileid, String issuedate, String duedate, String invoicetypecode, String documentcurrencycode, String accountingcost, String buyerreference, AccountingSupplierParty accountingsupplierparty, String accountingcustomerparty, String delivery, String paymentmeans, String paymentterms, String allowancecharge, String taxtotal, String legalmonetarytotal, String invoiceline) {
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
        this.accountingcustomerparty = accountingcustomerparty;
        this.delivery = delivery;
        this.paymentmeans = paymentmeans;
        this.paymentterms = paymentterms;
        this.allowancecharge = allowancecharge;
        this.taxtotal = taxtotal;
        this.legalmonetarytotal = legalmonetarytotal;
        this.invoiceline = invoiceline;
    }

    public Integer getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Integer invoice_id) {
        this.invoice_id = invoice_id;
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

    public AccountingSupplierParty getAccountingsupplierparty() {
        return accountingsupplierparty;
    }

    public void setAccountingsupplierparty(AccountingSupplierParty accountingsupplierparty) {
        this.accountingsupplierparty = accountingsupplierparty;
    }

    public String getAccountingcustomerparty() {
        return accountingcustomerparty;
    }

    public void setAccountingcustomerparty(String accountingcustomerparty) {
        this.accountingcustomerparty = accountingcustomerparty;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getPaymentmeans() {
        return paymentmeans;
    }

    public void setPaymentmeans(String paymentmeans) {
        this.paymentmeans = paymentmeans;
    }

    public String getPaymentterms() {
        return paymentterms;
    }

    public void setPaymentterms(String paymentterms) {
        this.paymentterms = paymentterms;
    }

    public String getAllowancecharge() {
        return allowancecharge;
    }

    public void setAllowancecharge(String allowancecharge) {
        this.allowancecharge = allowancecharge;
    }

    public String getTaxtotal() {
        return taxtotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTaxtotal(String taxtotal) {
        this.taxtotal = taxtotal;
    }

    public String getLegalmonetarytotal() {
        return legalmonetarytotal;
    }

    public void setLegalmonetarytotal(String legalmonetarytotal) {
        this.legalmonetarytotal = legalmonetarytotal;
    }

    public String getInvoiceline() {
        return invoiceline;
    }

    public void setInvoiceline(String invoiceline) {
        this.invoiceline = invoiceline;
    }
}