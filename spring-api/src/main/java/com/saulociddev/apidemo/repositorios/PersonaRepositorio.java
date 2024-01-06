package com.saulociddev.apidemo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.saulociddev.apidemo.entidades.Persona;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona,String>{

    @Query("SELECT p FROM Persona p WHERE p.dni = :dni")
    public Persona buscarPorDni(@Param("dni") Long dni);

}
