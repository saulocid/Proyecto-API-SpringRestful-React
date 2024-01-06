package com.saulociddev.apidemo.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saulociddev.apidemo.entidades.Persona;
import com.saulociddev.apidemo.excepciones.MiExcepcion;
import com.saulociddev.apidemo.repositorios.PersonaRepositorio;
import jakarta.transaction.Transactional;

@Service
public class PersonaServicio {

    @Autowired
    private PersonaRepositorio perRepo;

    @Transactional // creamos una persona
    public Persona crearPersona(String nombre, Long dni, Integer edad) throws MiExcepcion{

        validarDni(dni);
        validarEdad(edad);
        validarStr(nombre);

        Persona p = new Persona();

        p.setDni(dni);
        p.setEdad(edad);
        p.setNombre(nombre);

        return perRepo.save(p);

    }

    @Transactional // guardar objeto persona traída por parámetro
    public Persona guardarPersona(Persona p) throws MiExcepcion{
        validarPersona(p);
        return perRepo.save(p);
    }

    // Traemos todas las personas de la lista
    public List<Persona> listarPersonas(){
        return perRepo.findAll();
    }

    // buscamos a la persona por dni de tipo único
    public Persona buscarPorDni(Long dni){
        return perRepo.buscarPorDni(dni);
    }

    @Transactional // modificamos nombre
    public void modificarNombre(String id, String nombre) throws MiExcepcion{

        validarStr(id);
        validarStr(nombre);

        Optional<Persona> res = perRepo.findById(id);

        if(res.isPresent()){
            Persona p = res.get();
            p.setNombre(nombre);
            perRepo.save(p);
        }
    }

    @Transactional // modificamos dni
    public void modificarDni(String id, Long dni) throws MiExcepcion{

        validarStr(id);
        validarDni(dni);

        Optional<Persona> res = perRepo.findById(id);

        if(res.isPresent()){
            Persona p = res.get();
            p.setDni(dni);
            perRepo.save(p);
        }
    }

    @Transactional // modificamos edad
    public void modificarEdad(String id, Integer edad) throws MiExcepcion{

        validarStr(id);
        validarEdad(edad);

        Optional<Persona> res = perRepo.findById(id);

        if(res.isPresent()){
            Persona p = res.get();
            p.setEdad(edad);
            perRepo.save(p);
        }
    }

    @Transactional // eliminamos persona por id
    public void eliminarPersona(String id) throws MiExcepcion{

        validarStr(id);

        Optional<Persona> res = perRepo.findById(id);

        if(res.isPresent()){
            Persona p = res.get();
            perRepo.delete(p);
        }
    }

    // validamos String como son el id y el nombre
    public void validarStr(String dato) throws MiExcepcion{
        if(dato.isEmpty() || dato == null){
            throw new MiExcepcion("El dato no puede ser nulo");
        }
    }

    // validamos el Long de dni
    public void validarDni(Long dni) throws MiExcepcion{
        if(dni == null){
            throw new MiExcepcion("El dni no puede ser nulo");
        }
    }

    // validamos el Integer de edad
    public void validarEdad(Integer edad) throws MiExcepcion{
        if(edad == null){
            throw new MiExcepcion("La edad no puede ser nula");
        }
    }
    
    // validamos persona
    public void validarPersona(Persona p) throws MiExcepcion{
        if(p.getNombre() == null || p.getNombre().isEmpty()){
            throw new MiExcepcion("El nombre no puede estar vacío");
        }
        if(p.getEdad() == null || p.getEdad() < 0){
            throw new MiExcepcion("La edad no puede estar vacía");
        }
        if(p.getDni() == null || p.getDni()<10000000 || p.getDni() > 99999999){
            throw new MiExcepcion("El dni no puede estar vacío. Dni inválido");
        }
    }

}
