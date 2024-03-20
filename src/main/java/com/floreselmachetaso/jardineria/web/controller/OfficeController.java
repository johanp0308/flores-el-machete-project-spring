package com.floreselmachetaso.jardineria.web.controller;


import com.floreselmachetaso.jardineria.domain.service.OfficeService;
import com.floreselmachetaso.jardineria.persistence.DTO.OfficeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/offices")
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping("/oficces-with-city")
    public ResponseEntity<List<OfficeDTO>> getAllOfficeWithCity() {
        List<OfficeDTO> offices = officeService.getAllOfficeWCity();
        return new ResponseEntity<>(offices, HttpStatus.OK);
    }

    @GetMapping("/officess-in-spain")
    public ResponseEntity<List<OfficeDTO>> getAllOfficeWithCountry() {
        List<OfficeDTO> offices = officeService.getallWOfficeWCountry();
        return new ResponseEntity<>(offices, HttpStatus.OK);
    }

    @GetMapping("/offices-with-employee-with-customer-pay-a-gama-frut")
    public ResponseEntity<List<OfficeDTO>> findAllOfficeWithEmployeeWithCustomerPayAGamaFrut() {
        List<OfficeDTO> offices = officeService.findAllOfficeWEmployeWCustomerPayAGamaFrut();
        return new ResponseEntity<>(offices, HttpStatus.OK);
    }
}
