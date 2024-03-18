package com.floreselmachetaso.jardineria.persistence.entities;

import java.util.List;

import com.floreselmachetaso.jardineria.persistence.DTO.OfficeDTO;
import jakarta.persistence.*;


@Entity
@Table(name = "oficina")
public class Office {
    @Id
    @Column(name = "codigo_oficina", nullable = false)
    private String officeCode;

    @Column(name = "ciudad", nullable = false)
    private String city;

    @Column(name = "pais", nullable = false)
    private String country;

    @Column(name = "region")
    private String region;

    @Column(name = "codigo_postal", nullable = false)
    private String postalCode;

    @Column(name = "telefono", nullable = false)
    private String phone;

    @Column(name = "linea_direccion1", nullable = false)
    private String addressLine1;

    @Column(name = "linea_direccion2")
    private String addressLine2;

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Office{" +
                "officeCode='" + officeCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", employees=" + employees +
                '}';
    }

    public OfficeDTO toDTO() {
        OfficeDTO officeDTO = new OfficeDTO();
        officeDTO.setOfficeCode(this.officeCode);
        officeDTO.setCity(this.city);
        officeDTO.setCountry(this.country);
        officeDTO.setRegion(this.region);
        officeDTO.setPostalCode(this.postalCode);
        officeDTO.setPhone(this.phone);
        officeDTO.setAddressLine1(this.addressLine1);
        officeDTO.setAddressLine2(this.addressLine2);
        return officeDTO;
    }
}
