package com.einvoice.dto.custom;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

public class Party implements Serializable {

    @JsonProperty("EndpointID")
    private Map<String, Object> endpointID;

    @JsonProperty("PartyIdentification")
    private Map<String, String> partyIdentification;

    @JsonProperty("PartyName")
    private Map<String,String> partyName;

    @JsonProperty("PostalAddress")
    private PostalAddress postalAddress;

    @JsonProperty("PartyTaxScheme")
    private PartyTaxScheme partyTaxScheme;

    @JsonProperty("PartyLegalEntity")
    private PartyLegalEntity partyLegalEntity;


    public Party() {
    }

    public Party(Map<String, Object> endpointID, PartyLegalEntity partyLegalEntity) {
        this.endpointID = endpointID;
        this.partyLegalEntity = partyLegalEntity;
    }

    public Map<String, Object> getEndpointID() {
        return endpointID;
    }

    public void setEndpointID(Map<String, Object> endpointID) {
        this.endpointID = endpointID;
    }

    public Map<String, String> getPartyIdentification() {
        return partyIdentification;
    }

    public void setPartyIdentification(Map<String, String> partyIdentification) {
        this.partyIdentification = partyIdentification;
    }

    public Map<String, String> getPartyName() {
        return partyName;
    }

    public void setPartyName(Map<String, String> partyName) {
        this.partyName = partyName;
    }

    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    public PartyTaxScheme getPartyTaxScheme() {
        return partyTaxScheme;
    }

    public void setPartyTaxScheme(PartyTaxScheme partyTaxScheme) {
        this.partyTaxScheme = partyTaxScheme;
    }

    public PartyLegalEntity getPartyLegalEntity() {
        return partyLegalEntity;
    }

    public void setPartyLegalEntity(PartyLegalEntity partyLegalEntity) {
        this.partyLegalEntity = partyLegalEntity;
    }
}
