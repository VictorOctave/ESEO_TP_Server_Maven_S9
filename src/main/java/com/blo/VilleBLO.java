package com.blo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {

	public ArrayList<Ville> getInfoVille(String codeCommune, String codePostal, String nomCommune) throws ClassNotFoundException, SQLException;
	
	public void creerVille(Ville ville) throws ClassNotFoundException, SQLException;
	
	public void modifierVille(Ville ville) throws ClassNotFoundException, SQLException;
}
