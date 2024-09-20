package com.jsnunez.antiguedades.infrastructure.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsnunez.antiguedades.domain.DTO.AntiguedadDTO;
import com.jsnunez.antiguedades.domain.entities.Antiguedad;

public interface AntiguedadRepository extends JpaRepository<Antiguedad,Long> {
//  @Query("select nombre from Antiguedad where disponible=1;")
//     List<AntiguedadDTO> findAllAvailableForSale();
}
