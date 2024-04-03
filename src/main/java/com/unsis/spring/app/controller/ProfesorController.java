package com.unsis.spring.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unsis.spring.app.entity.Profesor;
import com.unsis.spring.app.services.ProfesorService;


@RestController
@RequestMapping("/api/v1")
public class ProfesorController {

 @Autowired
	private ProfesorService profesorService;

    @GetMapping(value="/profesor")
	public ResponseEntity<Object> get(){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Profesor> list  = profesorService.findAll();
			return new ResponseEntity<Object>(list,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}

     @GetMapping(value="/profesor/{id}")
     public ResponseEntity<Object> getById(@PathVariable Long id){ 
         try {
             Profesor data  = profesorService.findById(id);
             return new ResponseEntity<Object>(data,HttpStatus.OK);
         } 
         catch (Exception e) {
             Map<String, Object> map = new HashMap<String, Object>();
             map.put("message", e.getMessage());
             return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
         } 
      }

      @PostMapping(value="/profesor")
	public ResponseEntity<Object> create(@RequestBody Profesor profesor){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Profesor res = profesorService.save(profesor);  
			return new ResponseEntity<Object>(res,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}

     @PutMapping("/profesor/{id}")
     public ResponseEntity<Object> update(@RequestBody Profesor profesor, @PathVariable Long id){ 
         Map<String, Object> map = new HashMap<String, Object>();
         try {
             
             Profesor currentrProfesor = profesorService.findById(id);
             
             currentrProfesor.setInstituto(profesor.getInstituto());
             currentrProfesor.setCuenta(profesor.getCuenta());
             
			 Profesor updatedProfesor = profesorService.save(currentrProfesor);
             
             return new ResponseEntity<Object>(updatedProfesor,HttpStatus.OK);
         } 
         catch (Exception e) {
             map.put("message", e.getMessage());
             return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
         } 
      }

      @DeleteMapping("/profesor/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try { 
			Profesor currentrProfesor = profesorService.findById(id); 
			profesorService.delete(currentrProfesor);
			map.put("deleted", true);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}
    
}
