package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.Ville;

public interface VilleDAO {

	public List<Ville> findAllVilles() throws SQLException, ClassNotFoundException;
	
	public List<Ville> findVilleByPostalCode(String codePostal) throws SQLException, ClassNotFoundException;
	
	public List<Ville> findVilleByTownCode(String codePostal, boolean evenIfDeleted) throws SQLException, ClassNotFoundException;
	
	public List<Ville> findVilleByName(String nomCommune) throws SQLException, ClassNotFoundException;

	public void creerVille(Ville ville) throws ClassNotFoundException, SQLException;
	
	public void modifierVille(Ville ville) throws ClassNotFoundException, SQLException;
}
