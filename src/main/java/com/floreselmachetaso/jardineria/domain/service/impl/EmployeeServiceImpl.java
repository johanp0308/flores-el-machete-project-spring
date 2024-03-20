package com.floreselmachetaso.jardineria.domain.service.impl;

import com.floreselmachetaso.jardineria.domain.repository.EmployeeRepository;
import com.floreselmachetaso.jardineria.domain.service.EmployeeService;
import com.floreselmachetaso.jardineria.persistence.DTO.EmployeeDTO;
import com.floreselmachetaso.jardineria.persistence.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


//
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    /*
     * Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de jefe igual a 7.
     */
    @Override
    public List<EmployeeDTO> getAllEmplyeWCodeBoss() {
        List<Object[]> employeesData = employeeRepository.findAllEmplyeWCodeBoss();
        return employeesData.stream()
                .map(row -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setEmployeeCode((int) row[0]);
                    employeeDTO.setFirstName((String) row[1]);
                    employeeDTO.setLastName1((String) row[2]);
                    employeeDTO.setLastName2((String) row[3]);
                    employeeDTO.setEmail((String) row[4]);
                    employeeDTO.setBoss((int) row[5]);
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }



    /*
     * Devuelve el nombre del puesto, nombre, apellidos y email del jefe de la empresa
     */

    @Override
    public List<EmployeeDTO> getBossEveryone() {
        List<Object[]> bossData = employeeRepository.findBossEvryOne();
        return bossData.stream()
                .map(row -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setJobTitle((String) row[0]);
                    employeeDTO.setFirstName((String) row[1]);
                    employeeDTO.setLastName1((String) row[2]);
                    employeeDTO.setLastName2((String) row[3]);
                    employeeDTO.setEmail((String) row[4]);
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    /*
     * Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean representantes de ventas.
     */
    @Override
    public List<EmployeeDTO> getAllNotSalesRepresentative() {
        return employeeRepository.findAllNotSalesRepresentative().stream()
                .map(row -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setFirstName((String) row[0]);
                    employeeDTO.setLastName1((String) row[1]);
                    employeeDTO.setLastName2((String) row[2]);
                    employeeDTO.setJobTitle((String) row[3]);
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }


    /*
     * Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.
     */
    @Override
    public List<EmployeeDTO> getAllEmployeeAndBoss() {
        List<Object[]> employeesData = employeeRepository.findAllEmployeeAndBoss();
        return employeesData.stream()
                .map(row -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setFirstName((String) row[0]);
                    employeeDTO.setBossName((String) row[1]);
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    /*
     * Devuelve un listado que muestre el nombre de cada empleados, el nombre de su jefe y el nombre del jefe de sus jefe.
     */
    @Override
    public List<EmployeeDTO> getAllEmployeeAndBossAndBoss() {
        return employeeRepository.findAllEmployeeAndBossAndBoss().stream()
                .map(row -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setFirstName((String) row[0]);
                    employeeDTO.setBossName((String) row[1]);
                    employeeDTO.setBossBossName((String) row[2]);
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }


    /*
     * Devuelve un listado que muestre solamente los empleados que no tienen una oficina asociada.
     */
    @Override
    public List<EmployeeDTO> getAllEmployeeNotOffice() {
        return employeeRepository.findAllEmployeeNotOffice().stream()
                .map(row -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setFirstName((String) row[0]);
                    employeeDTO.setLastName1((String) row[1]);
                    return employeeDTO;
                })
                .collect(Collectors.toList());

    }

    @Override
    public List<EmployeeDTO> getAllEmployeeNotCustomer() {
        return employeeRepository.findAllEmployeeNotCustomer().stream()
                .map(row -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setEmployeeCode((Integer) row[0]);
                    employeeDTO.setFirstName((String) row[1]);
                    employeeDTO.setLastName1((String) row[2]);
                    employeeDTO.setLastName2((String) row[3]);
                    employeeDTO.setExtension((String) row[4]);
                    employeeDTO.setEmail((String) row[5]);
                    employeeDTO.setOffice((String) row[6]);
                    employeeDTO.setBoss((Integer) row[7]);
                    employeeDTO.setJobTitle((String) row[8]);

                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Object[]> getAllEmployeeNotCustomerAndOffice() {
        return employeeRepository.findAllEmployeeNotCustomerWDataOffice().stream()
                .map(row -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();

                    // Mapear los datos del empleado
                    employeeDTO.setEmployeeCode((Integer) row[0]);
                    employeeDTO.setFirstName((String) row[1]);
                    // Ajusta según sea necesario para otros campos del empleado

                    // Devolver un objeto que contenga el DTO del empleado y los datos de la oficina
                    return new Object[]{employeeDTO, row[6], row[10]};
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Object[]> getAllEmployeeNotOfficeAndCustomer() {
        return employeeRepository.findAllEmployeeNotOfficeANotCustomer().stream()
                .map(row -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();

                    // Mapear los datos del empleado
                    employeeDTO.setEmployeeCode((Integer) row[0]);
                    employeeDTO.setFirstName((String) row[1]);
                    employeeDTO.setLastName1((String) row[2]);
                    employeeDTO.setLastName2((String) row[3]);
                    employeeDTO.setExtension((String) row[4]);
                    employeeDTO.setEmail((String) row[5]);
                    employeeDTO.setJobTitle((String) row[6]);
                    // Ajusta según sea necesario para otros campos del empleado

                    // Devolver un objeto que contenga el DTO del empleado y los datos de la oficina
                    return new Object[]{employeeDTO, row[7]}; // Agregar los datos de la oficina aquí
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Object[]> getAllEmployeeNotCustomerAndBoss() {
        return employeeRepository.findAllDataEmployeNotCustomerAndBoss().stream()
                .map(row -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();

                    // Mapear los datos del empleado
                    employeeDTO.setEmployeeCode((Integer) row[0]);
                    employeeDTO.setFirstName((String) row[1]);
                    employeeDTO.setLastName1((String) row[2]);
                    employeeDTO.setLastName2((String) row[3]);
                    employeeDTO.setExtension((String) row[4]);
                    employeeDTO.setEmail((String) row[5]);
                    employeeDTO.setOffice((String) row[6]);
                    employeeDTO.setBoss((Integer) row[7]);
                    employeeDTO.setJobTitle((String) row[8]);
                    // Ajusta aquí sea necesario para otros campos del empleado

                    // Datos del jefe
                    String bossFirstName = (String) row[9];
                    String bossLastName = (String) row[10];

                    // Devolver un objeto que contenga el DTO del empleado y los datos del jefe
                    return new Object[]{employeeDTO, bossFirstName, bossLastName};
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Object[]> countEmployee() {
        return employeeRepository.amountEmployee();
    }

    @Override
    public List<Object[]> getEmployeeAndClients() {
        return employeeRepository.findAllSalesRepresandNumberCustomer();
    }
}



