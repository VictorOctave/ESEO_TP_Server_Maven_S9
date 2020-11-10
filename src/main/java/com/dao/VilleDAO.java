package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {

	public ArrayList<Ville> findAllVilles() throws SQLException, ClassNotFoundException;
	
	public ArrayList<Ville> findVilleByPostalCode(String codePostal) throws SQLException, ClassNotFoundException;
	
	public ArrayList<Ville> findVilleByTownCode(String codePostal) throws SQLException, ClassNotFoundException;
	
	public ArrayList<Ville> findVilleByName(String nomCommune) throws SQLException, ClassNotFoundException;

	public void creerVille(Ville ville) throws ClassNotFoundException, SQLException;
	
	public void modifierVille(Ville ville) throws ClassNotFoundException, SQLException;
}
