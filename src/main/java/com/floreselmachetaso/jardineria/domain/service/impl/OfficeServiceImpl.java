package com.floreselmachetaso.jardineria.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.floreselmachetaso.jardineria.domain.repository.OfficeRepository;
import com.floreselmachetaso.jardineria.domain.service.OfficeService;
import com.floreselmachetaso.jardineria.persistence.DTO.CustomerDTO;
import com.floreselmachetaso.jardineria.persistence.DTO.OfficeDTO;

public class OfficeServiceImpl implements OfficeService{
    
    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeServiceImpl(OfficeRepository officeRepository){
        this.officeRepository = officeRepository;
    }

    @Override
    public List<OfficeDTO> getAllOfficeWCity() {
        List<Object[]> lista = officeRepository.findAllOfficeWCity();
        return (List<OfficeDTO>) lista.stream().map(ele -> {
            OfficeDTO cDto = new OfficeDTO();
            cDto.setOfficeCode(String.valueOf(ele[0]));
            cDto.setCity((String.valueOf(ele[1])));
            return cDto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<OfficeDTO> getallWOfficeWCountry() {
        List<Object[]> lista = officeRepository.findAllOfficeWCity();
        return (List<OfficeDTO>) lista.stream().map(ele -> {
            OfficeDTO cDto = new OfficeDTO();
            cDto.setOfficeCode(String.valueOf(ele[0]));
            cDto.setPhone((String.valueOf(ele[1])));
            return cDto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<OfficeDTO> findAllOfficeWEmployeWCustomerPayAGamaFrut() {
        List<Object[]> lista = officeRepository.findAllOfficeWCity();
        return (List<OfficeDTO>) lista.stream().map(ele -> {
            OfficeDTO cDto = new OfficeDTO();
            cDto.setOfficeCode(String.valueOf(ele[0]));
            cDto.setCity((String.valueOf(ele[1])));
            cDto.setCountry(String.valueOf(ele[2]));
            cDto.setRegion(String.valueOf(ele[3]));
            cDto.setPostalCode(String.valueOf(ele[4]));
            cDto.setPhone(String.valueOf(ele[5]));
            cDto.setAddressLine1(String.valueOf(ele[6]));
            cDto.setAddressLine2(String.valueOf(ele[7]));
            return cDto;
        }).collect(Collectors.toList());
    }



}
