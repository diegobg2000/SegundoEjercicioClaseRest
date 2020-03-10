package com.diego.segundoRest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.diego.segundoRest.coche.Coche;

@SpringBootTest
class SegundoEjercicioClaseRestApplicationTests {

	@Test
	void pruebaGET() throws URISyntaxException {
		
		URI url = new URI("http://localhost:8080/coche");
		RequestEntity<Coche> request = new RequestEntity<Coche>(HttpMethod.GET, url);
		
		ResponseEntity<Coche> response;
		
		RestTemplate ejecutor = new RestTemplate();
		/*Pasada esta linea si hago un Syso en la response podre coger el body o el codigo de status que me hayan pasado e imprimirlo */
		response = ejecutor.exchange(request, Coche.class);
		
		
		System.out.println(response.getBody());
		System.out.println(response.hasBody());

		/*
		System.out.println(response);
		System.out.println(response.getStatusCodeValue());

		*/
		
		/*Lo que va a verificar este test es si la resquest tiene un body
		 * Esta unica parte no es competencia de este año pero lo anterior si*/
		assertTrue(response.hasBody());
	}
	
	
	void pruebaPOST() throws URISyntaxException {
		
		Coche coche = new Coche();
		coche.setMarca("Mercedes-Benz");
		coche.setModelo("CLA");
		
		URI myURL = new URI("http://localhost:8080/addCoche");
		RequestEntity<Coche> request = new RequestEntity<Coche>(HttpMethod.POST, myURL);
		
		ResponseEntity<Coche> response;
		
		RestTemplate restTemplate = new RestTemplate();
		/*Pasada esta linea si hago un Syso en la response podre coger el body o el codigo de status que me hayan pasado e imprimirlo */
		response = restTemplate.exchange(request, Coche.class);
		
		
		System.out.println(response.getBody());
		System.out.println(response.hasBody());

		/*
		System.out.println(response);
		System.out.println(response.getStatusCodeValue());

		*/
		
		/*Lo que va a verificar este test es si la resquest tiene un body
		 * Esta unica parte no es competencia de este año pero lo anterior si*/
		assertTrue(request.hasBody());
		assertTrue(response.hasBody());

	}
	


}
