package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLOImpl;
import com.dto.Ville;

@RestController
public class VilleController {
	
	@Autowired
	VilleBLOImpl service;
	
	@GetMapping("/ville")
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(value = "codepostal", required = false) String codePostal,
			@RequestParam(value = "nom", required = false) String nomCommune) throws ClassNotFoundException, SQLException {
		System.out.println("Appel Get"); 
		
		return service.getInfoVille(codePostal, nomCommune);
	}
	
	@PostMapping("/ville")
	public void appelPost(@RequestBody Ville ville) throws ClassNotFoundException, SQLException {
		System.out.println("Appel Post"); 
		service.creerVille(ville);
	}
	
	@PutMapping("/ville")
	public void appelPut(@RequestBody Ville ville) throws ClassNotFoundException, SQLException {
		System.out.println("Appel Put"); 
		service.modifierVille(ville);
	}
}
