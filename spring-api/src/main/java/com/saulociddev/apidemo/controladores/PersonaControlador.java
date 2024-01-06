package com.saulociddev.apidemo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.saulociddev.apidemo.entidades.Persona;
import com.saulociddev.apidemo.excepciones.MiExcepcion;
import com.saulociddev.apidemo.servicios.PersonaServicio;

@RestController
@RequestMapping("/personas")
@CrossOrigin("*") // permite que cualqueira consuma el controlador
// @CrossOrigin ("http://localhost:3000") solo dicha url la consume
public class PersonaControlador {
    
    @Autowired
    private PersonaServicio perServ;

    @GetMapping("")
    public ResponseEntity<Object> listarPersonas() {
        return ResponseEntity.status(200).body(perServ.listarPersonas());
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Object> buscarPorDni(@PathVariable Long dni) {
        return ResponseEntity.status(200).body(perServ.buscarPorDni(dni));
    }

    @PostMapping("/guardar")
    public ResponseEntity<Object> buscarPorDni(@RequestBody Persona p) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(perServ.guardarPersona(p));
        } catch (MiExcepcion e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Object> borrarPersona(@PathVariable String id){
        try {
            perServ.eliminarPersona(id);
            return ResponseEntity.status(200).body("Deleted");
        } catch (MiExcepcion e) {
            return ResponseEntity.status(400).body(null);
        }
    }

}
