package com.einvoice.dto.custom;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

public class PartyTaxScheme implements Serializable {

    @JsonProperty("CompanyID")
    private String companyId;

    @JsonProperty("TaxScheme")
    private Map<String, String> taxScheme;

    public PartyTaxScheme() {
    }

    public PartyTaxScheme(String companyId, Map<String, String> taxScheme) {
        this.companyId = companyId;
        this.taxScheme = taxScheme;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public Map<String, String> getTaxScheme() {
        return taxScheme;
    }

    public void setTaxScheme(Map<String, String> taxScheme) {
        this.taxScheme = taxScheme;
    }
}
