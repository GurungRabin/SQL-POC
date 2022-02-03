package com.einvoice.serviceimpl;

import com.einvoice.dto.AccountingSupplierPartyDto;
import com.einvoice.entity.AccountingSupplierParty;
import com.einvoice.repository.AccountingSupplierPartyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einvoice.dto.EInvoiceDto;
import com.einvoice.entity.EInvoiceEntity;
import com.einvoice.repository.EInvoiceRepository;
import com.einvoice.service.EInvoiceService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EInvoiceServiceImpl implements EInvoiceService {

    private EInvoiceRepository eInvoiceRepository;

    private AccountingSupplierPartyRepository accountingSupplierPartyRepository;

    // this is a better way to autowire things
    @Autowired
    public EInvoiceServiceImpl(EInvoiceRepository eInvoiceRepository, AccountingSupplierPartyRepository accountingSupplierPartyRepository) {
        this.eInvoiceRepository = eInvoiceRepository;
        this.accountingSupplierPartyRepository = accountingSupplierPartyRepository;
    }

    @Override
    public EInvoiceDto createInvoice(EInvoiceDto eInvoiceDto) {
        EInvoiceEntity eInvoiceEntity = new EInvoiceEntity();
        BeanUtils.copyProperties(eInvoiceDto, eInvoiceEntity);
        // extract accounting supplier party data and save it to its respective table
        AccountingSupplierPartyDto accountingSupplierPartyDto = eInvoiceDto.getAccountingsupplierparty();
        String schemeID = accountingSupplierPartyDto.getParty().getEndpointID().get("@schemeID").toString();
        String text = accountingSupplierPartyDto.getParty().getEndpointID().get("#text").toString();
        String partyIdentificationID = accountingSupplierPartyDto.getParty().getPartyIdentification().get("ID");
        String partyName = accountingSupplierPartyDto.getParty().getPartyName().get("Name");
        String identificationCode = accountingSupplierPartyDto.getParty().getPostalAddress().getCountry().get("IdentificationCode");
        String partyTaxSchemeID = accountingSupplierPartyDto.getParty().getPartyTaxScheme().getTaxScheme().get("ID");
        AccountingSupplierParty accountingSupplierParty = new AccountingSupplierParty(
                schemeID,
                text,
                partyIdentificationID,
                partyName,
                accountingSupplierPartyDto.getParty().getPostalAddress().getStreetName(),
                accountingSupplierPartyDto.getParty().getPostalAddress().getAdditionalStreetName(),
                accountingSupplierPartyDto.getParty().getPostalAddress().getCityName(),
                accountingSupplierPartyDto.getParty().getPostalAddress().getPostalZone(),
                identificationCode,
                accountingSupplierPartyDto.getParty().getPartyTaxScheme().getCompanyId(),
                partyTaxSchemeID,
                accountingSupplierPartyDto.getParty().getPartyLegalEntity().getRegistrationName(),
                accountingSupplierPartyDto.getParty().getPartyLegalEntity().getCompanyId()
        );
        accountingSupplierParty = accountingSupplierPartyRepository.save(accountingSupplierParty);

        // making relation with two tables
        eInvoiceEntity.setAccountingsupplierparty(accountingSupplierParty);

        EInvoiceEntity savedEntity = eInvoiceRepository.save(eInvoiceEntity);
        EInvoiceDto savedDto = new EInvoiceDto();
        BeanUtils.copyProperties(savedEntity, savedDto);
        return savedDto;
    }

    @Override
    public EInvoiceDto getInvoiceById(Integer invoice_id) {
        EInvoiceEntity eInvoiceEntity = eInvoiceRepository.findById(invoice_id).get();
        EInvoiceDto eInvoiceDto = new EInvoiceDto();
        BeanUtils.copyProperties(eInvoiceEntity, eInvoiceDto);
        return eInvoiceDto;
    }

    @Override
    public EInvoiceDto updateInvoice(EInvoiceDto updateInvoice) {
        EInvoiceEntity entity = new EInvoiceEntity();
        BeanUtils.copyProperties(updateInvoice, entity);
        EInvoiceEntity updatedEntity = eInvoiceRepository.save(entity);
        EInvoiceDto updatedDto = new EInvoiceDto();
        BeanUtils.copyProperties(updatedEntity, updatedDto);
        return updatedDto;
    }

    @Override
    public void deleteInvoice(Integer invoice_id) {
        eInvoiceRepository.deleteById(invoice_id);
    }

    @Override
    public List<EInvoiceDto> getAllInvoices() {
        return eInvoiceRepository.findAll().stream().map(eInvoiceEntity -> {
            EInvoiceDto dto = new EInvoiceDto();
            BeanUtils.copyProperties(eInvoiceEntity, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<EInvoiceEntity> findAllByAccountingsupplierpartyGroupByCountryIdentificationCode(String countryCode) {
        return eInvoiceRepository.findAllByAccountingsupplierpartyGroupByCountryIdentificationCode(countryCode);
    }

    @Override
    public List<EInvoiceEntity> findAllByCityName(String cityName) {
        return eInvoiceRepository.findAllByAccountingsupplierpartyCityName(cityName );
    }

}
