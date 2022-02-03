package com.einvoice.dto;

import com.einvoice.dto.custom.Party;
import com.einvoice.dto.custom.PartyLegalEntity;
import com.einvoice.dto.custom.PartyTaxScheme;
import com.einvoice.dto.custom.PostalAddress;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

public class AccountingSupplierPartyDto implements Serializable {

    @JsonProperty("Party")
    private Party party;


    public AccountingSupplierPartyDto() {
    }

    public AccountingSupplierPartyDto(Party party) {
        this.party = party;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }
}