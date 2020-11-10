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
	public ArrayList<Ville> getInfoVille(String codeCommune, String codePostal, String nomCommune) throws ClassNotFoundException, SQLException {
		
		ArrayList<Ville> listeVilles;
		
		if(codeCommune != null) {
			listeVilles = dao.findVilleByTownCode(codeCommune, false);
		} else if(nomCommune != null) {
			listeVilles = dao.findVilleByName(nomCommune);
		} else if(codePostal != null) {
			listeVilles = dao.findVilleByPostalCode(codePostal);
		} else {
			listeVilles = dao.findAllVilles();
		}
		
		return listeVilles;
	}
	
	@Override
	public void creerVille(Ville ville) throws ClassNotFoundException, SQLException {
		dao.creerVille(ville);
	}
	
	@Override
	public void modifierVille(Ville ville) throws ClassNotFoundException, SQLException {
		if(dao.findVilleByTownCode(ville.getCodeCommune(), true).size()==0) {
			dao.creerVille(ville);
		} else {
			dao.modifierVille(ville);
		}
	}

}
