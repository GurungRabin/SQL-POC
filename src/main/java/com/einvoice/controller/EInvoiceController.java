package com.einvoice.controller;

import com.einvoice.entity.EInvoiceEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.einvoice.dto.EInvoiceDto;
import com.einvoice.dto.JSONResponse;
import com.einvoice.exceptions.EInvoiceException;
import com.einvoice.service.EInvoiceService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/einvoice")
public class EInvoiceController {

    Logger logger = LoggerFactory.getLogger(EInvoiceController.class);

    @Autowired
    private EInvoiceService eInvoiceService;

    @PostMapping("/create")
    public ResponseEntity<JSONResponse> createInvoice(@RequestBody EInvoiceDto eInvoiceDto){
        JSONResponse response = null;
        ResponseEntity<JSONResponse> responseEntity = null;
        System.out.println("eInvoiceDto>>"+eInvoiceDto);
        logger.info("DTO : {}", eInvoiceDto);
        try{
        	EInvoiceDto savedDto = eInvoiceService.createInvoice(eInvoiceDto);
            if (savedDto == null){
                throw new EInvoiceException("Uable to create Invoice", HttpStatus.BAD_REQUEST);
            }
            response = new JSONResponse(HttpStatus.OK.value(), "Invoice Created Successfully", savedDto);
            responseEntity = new ResponseEntity<JSONResponse>(response, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Error : {}", e);
            throw new EInvoiceException("Internal Servicer Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/findById")
    public ResponseEntity<JSONResponse> getInvoiceById(@RequestParam("invoiceId") Integer invoiceId){
        JSONResponse response = null;
        try{
            EInvoiceDto dto = eInvoiceService.getInvoiceById(invoiceId);
            response = new JSONResponse(HttpStatus.OK.value(), "Invoice Found Successfully", dto);
        }catch (NoSuchElementException e){
            logger.error("NoSuchElementException : {}", e);
            throw new EInvoiceException("There is no Invoice with given ID", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            logger.error("Error : {}", e);
            throw new EInvoiceException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<JSONResponse>(response, HttpStatus.OK);
    }

    @GetMapping("/find/{countryCode}")
    public ResponseEntity<JSONResponse> findWithCountryCode(@PathVariable("countryCode") String countryCode) {
        List<EInvoiceEntity> eInvoiceEntityList = eInvoiceService.findAllByAccountingsupplierpartyGroupByCountryIdentificationCode(countryCode);
        return new ResponseEntity<>(new JSONResponse(200, "Successfully fetched!", eInvoiceEntityList), HttpStatus.OK);
    }

    @GetMapping("/find/city/{cityName}")
    public ResponseEntity<JSONResponse> findAllByCity(@PathVariable("cityName") String cityName) {

        return new ResponseEntity<>(new JSONResponse(200, "Successfully fetched!",
                eInvoiceService.findAllByCityName(cityName)), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<JSONResponse> updateInvoice(@RequestBody EInvoiceDto invoiceDto){
        JSONResponse response = null;
        try{
            EInvoiceDto updatedDto = eInvoiceService.updateInvoice(invoiceDto);
            response = new JSONResponse(HttpStatus.OK.value(), "Invoice Updated Successfully", updatedDto);
        }catch (NoSuchElementException e){
            logger.error("NoSuchElementException : {}", e);
            throw new EInvoiceException("There is no Invoice with given ID to update", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            logger.error("Error : {}", e);
            throw new EInvoiceException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<JSONResponse>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<JSONResponse> deleteInvoice(@RequestParam("invoiceId")Integer invoiceId){
        JSONResponse response = null;
        try{
            eInvoiceService.deleteInvoice(invoiceId);
            response = new JSONResponse(HttpStatus.OK.value(), "Invoice Deleted Successfully", null);
        }catch (NoSuchElementException | EmptyResultDataAccessException e){
            logger.error("NoSuchElementException : {}", e);
            throw new EInvoiceException("There is no Invoice with given ID to delete", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            logger.error("Error : {}", e);
            throw new EInvoiceException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<JSONResponse>(response, HttpStatus.OK);
    }

    @GetMapping("/allinvoices")
    public ResponseEntity<JSONResponse> getAllInvoices(){
        JSONResponse response = null;
        try{
            List<EInvoiceDto> eInvoiceDtoList = eInvoiceService.getAllInvoices();
            response = new JSONResponse(HttpStatus.OK.value(), "Data found successfully", eInvoiceDtoList);
        }catch (Exception e){
            logger.error("Error : {}", e);
            throw new EInvoiceException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<JSONResponse>(response, HttpStatus.OK);
    }
}
