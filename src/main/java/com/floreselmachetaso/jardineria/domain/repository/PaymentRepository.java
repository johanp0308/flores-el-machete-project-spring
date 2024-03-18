package com.floreselmachetaso.jardineria.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.floreselmachetaso.jardineria.persistence.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {

    /*
     * ¿Cuál fue el pago medio en 2009?
     */
    @Query("SELECT AVG(total) AS pago_medio_year  " + //
                "FROM pago  " + //
                "WHERE YEAR(fecha_pago) = ?")
    List<Object[]> averagePayYear(int Year);


}
