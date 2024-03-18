package com.floreselmachetaso.jardineria.persistence.entities;

import com.floreselmachetaso.jardineria.persistence.DTO.PaymentDTO;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pago")

public class Payment {

    @Id
    @Column(name = "id_transaccion ", nullable = false)
    private String transactionId;

    @Column(name = "forma_pago", nullable = false)
    private String paymentMethod;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_pago", nullable = false)
    private Date paymentDate;

    @Column(name = "total", nullable = false)
    private Double total;


    @ManyToOne
    @JoinColumn(name = "codigo_cliente")
    private Customer customer;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "transactionId='" + transactionId + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDate=" + paymentDate +
                ", total=" + total +
                ", customer=" + customer +
                '}';
    }

  public PaymentDTO toDTO(){
      PaymentDTO paymentDTO = new PaymentDTO();
      paymentDTO.setTransactionId(this.transactionId);
      paymentDTO.setPaymentMethod(this.paymentMethod);
      paymentDTO.setPaymentDate(this.paymentDate);
      paymentDTO.setTotal(this.total);
      return paymentDTO;
  }

}
