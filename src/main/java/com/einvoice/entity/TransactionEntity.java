package com.einvoice.entity;

import com.einvoice.dto.EInvoiceDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class TransactionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private EInvoiceEntity eInvoiceEntity;

    private String status;

    private java.util.Date createdDate = new Date();

    private String createdBy;

}
