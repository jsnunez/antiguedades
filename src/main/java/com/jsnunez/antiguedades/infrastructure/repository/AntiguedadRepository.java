package com.jsnunez.antiguedades.infrastructure.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsnunez.antiguedades.domain.DTO.AntiguedadDTO;
import com.jsnunez.antiguedades.domain.entities.Antiguedad;

public interface AntiguedadRepository extends JpaRepository<Antiguedad,Long> {
    @Query(value = "SELECT * FROM antiguedades WHERE disponible = 1", nativeQuery = true)
    List<Antiguedad> findAllAvailableForSale();
    

      @Query("SELECT a FROM Antiguedad a WHERE a.categoria.nombre = :categoria AND a.precio BETWEEN :minPrecio AND :maxPrecio")
    List<Antiguedad> findByCategoriaAndPrecioRange(@Param("categoria") int categoria, @Param("minPrecio") double d, @Param("maxPrecio") double e);


//  @Query("select nombre from Antiguedad where disponible=1;")
//     List<AntiguedadDTO> findAllAvailableForSale();
}
