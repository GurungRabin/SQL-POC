package com.einvoice.dto.custom;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Country implements Serializable {

    @JsonProperty("IdentificationCode")
    private String identificationCode;

    public Country() {
    }

    public Country(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    public String getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }
}
