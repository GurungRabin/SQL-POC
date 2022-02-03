package com.einvoice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TransactionDto implements Serializable {

    private Integer id;

    @JsonProperty("eInvoiceDto")
    private EInvoiceDto eInvoiceDto;

    private String status;

    private Date createdDate;

    private String createdBy;

}
