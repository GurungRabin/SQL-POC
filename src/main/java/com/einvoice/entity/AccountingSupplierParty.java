package com.einvoice.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accounting_supplier_party")
public class AccountingSupplierParty implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "scheme_id")
    private String schemeId;

    private String text;

    @Column(name = "party_identification_id")
    private String partyIdentificationId;

    @Column(name = "party_name")
    private String partyName;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "additional_street_name")
    private String additionalStreetName;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "postal_zone")
    private String postalZone;

    @Column(name = "country_identification_code")
    private String countryIdentificationCode;

    @Column(name = "company_id_party_tax_scheme")
    private String companyIdPartyTaxScheme;

    @Column(name = "tax_scheme_id")
    private String taxSchemeId;

    @Column(name = "registration_name_party_legal_entity")
    private String registrationNamePartyLegalEntity;

    @Column(name = "company_id_party_legal_entity")
    private String companyIdPartyLegalEntity;

    public AccountingSupplierParty() {
    }

    public AccountingSupplierParty(String schemeId, String text, String partyIdentificationId, String partyName, String streetName, String additionalStreetName, String cityName, String postalZone, String countryIdentificationCode, String companyIdPartyTaxScheme, String taxSchemeId, String registrationNamePartyLegalEntity, String companyIdPartyLegalEntity) {
        this.schemeId = schemeId;
        this.text = text;
        this.partyIdentificationId = partyIdentificationId;
        this.partyName = partyName;
        this.streetName = streetName;
        this.additionalStreetName = additionalStreetName;
        this.cityName = cityName;
        this.postalZone = postalZone;
        this.countryIdentificationCode = countryIdentificationCode;
        this.companyIdPartyTaxScheme = companyIdPartyTaxScheme;
        this.taxSchemeId = taxSchemeId;
        this.registrationNamePartyLegalEntity = registrationNamePartyLegalEntity;
        this.companyIdPartyLegalEntity = companyIdPartyLegalEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPartyIdentificationId() {
        return partyIdentificationId;
    }

    public void setPartyIdentificationId(String partyIdentificationId) {
        this.partyIdentificationId = partyIdentificationId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAdditionalStreetName() {
        return additionalStreetName;
    }

    public void setAdditionalStreetName(String additionalStreetName) {
        this.additionalStreetName = additionalStreetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPostalZone() {
        return postalZone;
    }

    public void setPostalZone(String postalZone) {
        this.postalZone = postalZone;
    }

    public String getCountryIdentificationCode() {
        return countryIdentificationCode;
    }

    public void setCountryIdentificationCode(String countryIdentificationCode) {
        this.countryIdentificationCode = countryIdentificationCode;
    }

    public String getCompanyIdPartyTaxScheme() {
        return companyIdPartyTaxScheme;
    }

    public void setCompanyIdPartyTaxScheme(String companyIdPartyTaxScheme) {
        this.companyIdPartyTaxScheme = companyIdPartyTaxScheme;
    }

    public String getTaxSchemeId() {
        return taxSchemeId;
    }

    public void setTaxSchemeId(String taxSchemeId) {
        this.taxSchemeId = taxSchemeId;
    }

    public String getRegistrationNamePartyLegalEntity() {
        return registrationNamePartyLegalEntity;
    }

    public void setRegistrationNamePartyLegalEntity(String registrationNamePartyLegalEntity) {
        this.registrationNamePartyLegalEntity = registrationNamePartyLegalEntity;
    }

    public String getCompanyIdPartyLegalEntity() {
        return companyIdPartyLegalEntity;
    }

    public void setCompanyIdPartyLegalEntity(String companyIdPartyLegalEntity) {
        this.companyIdPartyLegalEntity = companyIdPartyLegalEntity;
    }
}
