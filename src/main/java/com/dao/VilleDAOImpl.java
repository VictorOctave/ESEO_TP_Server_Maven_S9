package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {

	@Override
	public ArrayList<Ville> findAllVilles() throws SQLException, ClassNotFoundException {
		ArrayList<Ville> listeVilles = new ArrayList<>();
		
	    Connection connexion = JDBCConfiguration.getConnection();
	    Statement stmt = connexion.createStatement();
	    ResultSet res = stmt.executeQuery("SELECT * FROM ville_france");
		
		while(res.next()) {
			Ville ville = new Ville();
			ville.setCodeCommune(res.getString(1));
			ville.setNomCommune(res.getString(2));
			ville.setCodePostal(res.getString(3));
			ville.setLibelleAcheminement(res.getString(4));
			ville.setLigne(res.getString(5));
			ville.setLatitude(res.getString(6));
			ville.setLatitude(res.getString(7));
	        listeVilles.add(ville);
		}
			
	    connexion.close();
		
		return listeVilles;
	}
	
	@Override
	public ArrayList<Ville> findVilleByPostalCode(String codePostal) throws SQLException, ClassNotFoundException {
		ArrayList<Ville> listeVilles = new ArrayList<>();
		
	    Connection connexion = JDBCConfiguration.getConnection();
	    Statement stmt = connexion.createStatement();
	    ResultSet res = stmt.executeQuery("SELECT * FROM ville_france WHERE Code_postal="+codePostal);
		
		while(res.next()) {
			Ville ville = new Ville();
			ville.setCodeCommune(res.getString(1));
			ville.setNomCommune(res.getString(2));
			ville.setCodePostal(res.getString(3));
			ville.setLibelleAcheminement(res.getString(4));
			ville.setLigne(res.getString(5));
			ville.setLatitude(res.getString(6));
			ville.setLatitude(res.getString(7));
	        listeVilles.add(ville);
		}
			
	    connexion.close();
		
		return listeVilles;
	}
	
	@Override
	public ArrayList<Ville> findVilleByTownCode(String codeCommune) throws SQLException, ClassNotFoundException {
		ArrayList<Ville> listeVilles = new ArrayList<>();
		
	    Connection connexion = JDBCConfiguration.getConnection();
	    Statement stmt = connexion.createStatement();
	    ResultSet res = stmt.executeQuery("SELECT * FROM ville_france WHERE Code_commune_INSEE="+codeCommune);
		
		while(res.next()) {
			Ville ville = new Ville();
			ville.setCodeCommune(res.getString(1));
			ville.setNomCommune(res.getString(2));
			ville.setCodePostal(res.getString(3));
			ville.setLibelleAcheminement(res.getString(4));
			ville.setLigne(res.getString(5));
			ville.setLatitude(res.getString(6));
			ville.setLatitude(res.getString(7));
	        listeVilles.add(ville);
		}
			
	    connexion.close();
		
		return listeVilles;
	}
	
	@Override
	public ArrayList<Ville> findVilleByName(String nomCommune) throws SQLException, ClassNotFoundException {
		ArrayList<Ville> listeVilles = new ArrayList<>();
		
	    Connection connexion = JDBCConfiguration.getConnection();
	    Statement stmt = connexion.createStatement();
	    ResultSet res = stmt.executeQuery("SELECT * FROM ville_france WHERE Nom_commune='"+nomCommune.toUpperCase()+"'");
		
		while(res.next()) {
			Ville ville = new Ville();
			ville.setCodeCommune(res.getString(1));
			ville.setNomCommune(res.getString(2));
			ville.setCodePostal(res.getString(3));
			ville.setLibelleAcheminement(res.getString(4));
			ville.setLigne(res.getString(5));
			ville.setLatitude(res.getString(6));
			ville.setLatitude(res.getString(7));
	        listeVilles.add(ville);
		}
			
	    connexion.close();
		
		return listeVilles;
	}
	
	@Override
	public void creerVille(Ville ville) throws ClassNotFoundException, SQLException {
		Connection connexion = JDBCConfiguration.getConnection();
	    Statement stmt = connexion.createStatement();
	    stmt.executeUpdate("INSERT INTO ville_france VALUES ("+ville.getCodeCommune()+
	    		",'"+ville.getNomCommune()+"',"+ville.getCodePostal()+",'"+ville.getLibelleAcheminement()
	    		+"','"+ville.getLigne()+"',"+ville.getLatitude()+","+ville.getLongitude()+")");
	    
	    connexion.close();
	}
	
	@Override
	public void modifierVille(Ville ville) throws ClassNotFoundException, SQLException {
		Connection connexion = JDBCConfiguration.getConnection();
	    Statement stmt = connexion.createStatement();
	    stmt.executeUpdate("UPDATE ville_france SET Nom_commune='"+ville.getNomCommune()
	    					+"', Code_postal="+ville.getCodePostal()+", Libelle_acheminement='"
	    					+ville.getLibelleAcheminement()+"', Ligne_5='"+ville.getLigne()
	    					+"', Latitude="+ville.getLatitude()+", Longitude="+ville.getLongitude()
	    					+" WHERE Code_commune_INSEE="+ville.getCodeCommune());
	    
	    connexion.close();
	}
}
