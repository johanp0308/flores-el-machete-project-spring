package com.floreselmachetaso.jardineria.persistence.entities;

import com.floreselmachetaso.jardineria.persistence.DTO.CustomerDTO;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cliente", nullable = false)
    private Integer customerCode;

    @Column(name = "nombre_cliente", nullable = false)
    private String customerName;

    @Column(name = "nombre_contacto")
    private String contactName;

    @Column(name = "apellido_contacto")
    private String contactLastName;

    @Column(name = "telefono", nullable = false)
    private String phone;

    @Column(name = "fax", nullable = false)
    private String fax;

    @Column(name = "linea_direccion1", nullable = false)
    private String addressLine1;

    @Column(name = "linea_direccion2")
    private String addressLine2;

    @Column(name = "ciudad", nullable = false)
    private String city;

    @Column(name = "region")
    private String region;

    @Column(name = "pais")
    private String country;

    @Column(name = "codigo_postal")
    private String postalCode;

    @Column(name = "limite_credito")
    private Double creditLimit;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_empleado_rep_ventas")
    private Employee salesRepresentativeEmployee;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Payment> payments;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Order> orders;


    public Integer getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(Integer customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Employee getSalesRepresentativeEmployee() {
        return salesRepresentativeEmployee;
    }

    public void setSalesRepresentativeEmployee(Employee salesRepresentativeEmployee) {
        this.salesRepresentativeEmployee = salesRepresentativeEmployee;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerCode=" + customerCode +
                ", customerName='" + customerName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactLastName='" + contactLastName + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", creditLimit=" + creditLimit +
                ", salesRepresentativeEmployee=" + salesRepresentativeEmployee +
                ", payments=" + payments +
                ", orders=" + orders +
                '}';
    }

    public CustomerDTO toDTO(){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerCode(this.customerCode);
        customerDTO.setCustomerName(this.customerName);
        customerDTO.setContactName(this.contactName);
        customerDTO.setContactLastName(this.contactLastName);
        customerDTO.setPhone(this.phone);
        customerDTO.setFax(this.fax);
        customerDTO.setAddressLine1(this.addressLine1);
        customerDTO.setAddressLine2(this.addressLine2);
        customerDTO.setCity(this.city);
        customerDTO.setRegion(this.region);
        customerDTO.setCountry(this.country);
        customerDTO.setPostalCode(this.postalCode);
        customerDTO.setCreditLimit(this.creditLimit);
        customerDTO.setSalesRepresentativeEmployee(this.salesRepresentativeEmployee.getEmployeeCode());
 return customerDTO;
    }

}
