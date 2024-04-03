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

import com.unsis.spring.app.entity.Cuenta;
import com.unsis.spring.app.services.CuentaService;

@RestController
@RequestMapping("/api/v1")
public class CuentaController {
    @Autowired
	private CuentaService cuentaService;

    @GetMapping(value="/cuenta")
	public ResponseEntity<Object> get(){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Cuenta> list  = cuentaService.findAll();
			return new ResponseEntity<Object>(list,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}

     @GetMapping(value="/cuenta/{id}")
     public ResponseEntity<Object> getById(@PathVariable Long id){ 
         try {
			 Cuenta data  = cuentaService.findById(id);
             return new ResponseEntity<Object>(data,HttpStatus.OK);
         } 
         catch (Exception e) {
             Map<String, Object> map = new HashMap<String, Object>();
             map.put("message", e.getMessage());
             return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
         } 
      }

      @PostMapping(value="/cuenta")
      public ResponseEntity<Object> create(@RequestBody Cuenta cuenta){ 
          Map<String, Object> map = new HashMap<String, Object>();
          try {
              Cuenta res = cuentaService.save(cuenta);  
              return new ResponseEntity<Object>(res,HttpStatus.OK);
          } 
          catch (Exception e) {
              map.put("message", e.getMessage());
              return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
          } 
       }

       @PutMapping("/cuenta/{id}")
       public ResponseEntity<Object> update(@RequestBody Cuenta cuenta, @PathVariable Long id){ 
           Map<String, Object> map = new HashMap<String, Object>();
           try {
               
              Cuenta currentrCuenta = cuentaService.findById(id);
               
              currentrCuenta.setNombres(cuenta.getNombres());
              currentrCuenta.setApellidoP(cuenta.getApellidoP());
              currentrCuenta.setApellidoM(cuenta.getApellidoM());
              currentrCuenta.setCorreo(cuenta.getCorreo());
              currentrCuenta.setContrasena(cuenta.getContrasena());
              currentrCuenta.setRol(cuenta.getRol());
              Cuenta updatedCuenta = cuentaService.save(currentrCuenta);
               
              return new ResponseEntity<Object>(updatedCuenta,HttpStatus.OK);
           } 
           catch (Exception e) {
               map.put("message", e.getMessage());
               return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
           } 
        }

        @DeleteMapping("/cuenta/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try { 
			Cuenta currentrCuenta = cuentaService.findById(id); 
			cuentaService.delete(currentrCuenta);
			map.put("deleted", true);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}
  
}
