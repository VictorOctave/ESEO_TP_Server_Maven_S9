package com.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Ville> appelGet(@RequestParam(value = "codecommune", required = false) String codeCommune,
			@RequestParam(value = "codepostal", required = false) String codePostal,
			@RequestParam(value = "nom", required = false) String nomCommune) throws ClassNotFoundException, SQLException {
		System.out.println("Appel Get"); 
		
		return service.getInfoVille(codeCommune, codePostal, nomCommune);
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
	
	@DeleteMapping("/ville/delete/{codeCommuneInsee}")
	public void appelDelete(@PathVariable String codeCommuneInsee) throws ClassNotFoundException, SQLException {
		System.out.println("Appel Delete"); 
		Ville ville = service.getInfoVille(codeCommuneInsee, null, null).get(0);
		ville.setDeleted(true);
		service.modifierVille(ville);
	}
}
