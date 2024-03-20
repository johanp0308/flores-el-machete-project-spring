package com.floreselmachetaso.jardineria.domain.service;

import java.util.List;

import com.floreselmachetaso.jardineria.persistence.DTO.OfficeDTO;

public interface OfficeService {
    List<OfficeDTO> getAllOfficeWCity();
    List<OfficeDTO> getallWOfficeWCountry();
    List<OfficeDTO> findAllOfficeWEmployeWCustomerPayAGamaFrut();
}
