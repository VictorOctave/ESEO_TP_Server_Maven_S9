package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLOImpl;
import com.dto.Ville;

@RestController
public class VilleController {
	
	@Autowired
	VilleBLOImpl service;
	
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> getVilles(@RequestParam(value = "codepostal", required = false) String codePostal,
			@RequestParam(value = "nom", required = false) String nomCommune) throws ClassNotFoundException, SQLException {
		System.out.println("Appel Get"); 
		
		return service.getInfoVille(codePostal, nomCommune);
	}
}
