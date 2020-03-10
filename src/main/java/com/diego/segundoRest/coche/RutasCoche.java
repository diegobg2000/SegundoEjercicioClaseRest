package com.diego.segundoRest.coche;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RutasCoche {
	
	@GetMapping("/coche")
	public ResponseEntity<Coche> unCoche(){
		
		Coche coche1 = new Coche();
		coche1.setMarca("Porche");
		coche1.setModelo("Panamera");
		return new ResponseEntity<Coche>(coche1, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/addCoche")
	public ResponseEntity<Coche> encviarCoche(@RequestBody Coche coche){
		System.out.println(coche);
		return new ResponseEntity<Coche>(coche, HttpStatus.OK);
	}

}
