package com.einvoice.dto.custom;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

public class PostalAddress implements Serializable {

    @JsonProperty("StreetName")
    private String streetName;

    @JsonProperty("AdditionalStreetName")
    private String additionalStreetName;

    @JsonProperty("CityName")
    private String cityName;

    @JsonProperty("PostalZone")
    private String postalZone;

    @JsonProperty("Country")
    private Map<String, String> country;

    public PostalAddress() {
    }

    public PostalAddress(String streetName, String additionalStreetName, String cityName, String postalZone, Map<String, String> country) {
        this.streetName = streetName;
        this.additionalStreetName = additionalStreetName;
        this.cityName = cityName;
        this.postalZone = postalZone;
        this.country = country;
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

    public Map<String, String> getCountry() {
        return country;
    }

    public void setCountry(Map<String, String> country) {
        this.country = country;
    }
}
