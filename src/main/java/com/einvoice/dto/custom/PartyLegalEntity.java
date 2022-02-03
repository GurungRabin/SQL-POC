package com.einvoice.dto.custom;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PartyLegalEntity implements Serializable {

    @JsonProperty("RegistrationName")
    private String registrationName;

    @JsonProperty("CompanyID")
    private String companyId;

    public PartyLegalEntity() {
    }

    public PartyLegalEntity(String registrationName, String companyId) {
        this.registrationName = registrationName;
        this.companyId = companyId;
    }

    public String getRegistrationName() {
        return registrationName;
    }

    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
