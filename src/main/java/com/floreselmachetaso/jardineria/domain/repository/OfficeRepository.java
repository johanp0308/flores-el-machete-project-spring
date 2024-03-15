package com.floreselmachetaso.jardineria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.floreselmachetaso.jardineria.persistence.entities.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, String>  {

    /*
     * The Query is: Devuelve un listado con el código de oficina y la ciudad donde hay oficinas.
     * 
     */
    @Query("SELECT o.codigo_oficina as Codigo, o.ciudad as Ciudad FROM oficina o")
    List<Object[]> findAllOfficeWCity();
    
    /*
     * Devuelve un listado con la ciudad y el teléfono de las oficinas de España.
     */
    @Query("SELECT o.ciudad as Ciduad, o.telefono as Telefono FROM oficina o WHERE o.pais LIKE ?")
    List<Object[]> findAllWOfficeWPais(String country);
    




}
