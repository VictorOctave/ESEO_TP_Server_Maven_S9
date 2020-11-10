package com.blo;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAOImpl;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO{

	@Autowired
	VilleDAOImpl dao;

	@Override
	public ArrayList<Ville> getInfoVille(String codePostal, String nomCommune) throws ClassNotFoundException, SQLException {
		
		ArrayList<Ville> listeVilles = new ArrayList<>();
		
		if(nomCommune != null) {
			listeVilles = dao.findVilleByName(nomCommune);
		} else if(codePostal != null) {
			listeVilles = dao.findVilleByPostalCode(codePostal);
		} else {
			listeVilles = dao.findAllVilles();
		}
		
		return listeVilles;
	}

}
