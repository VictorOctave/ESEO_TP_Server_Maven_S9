package com.dao;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {
	
	private static final String ERREUR = "ERROR : ";
	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass());

	@Override
	public ArrayList<Ville> findAllVilles() {
		ArrayList<Ville> listeVilles = new ArrayList<>();
		
		try (Connection connexion = JDBCConfiguration.getConnection();
				Statement stmt = connexion.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM ville_france WHERE deleted=false");){
					this.traitementResultat(res, listeVilles);
				} catch (ClassNotFoundException | SQLException e) {
					logger.error(ERREUR, e);
				} 
		
		return listeVilles;
	}
	
	@Override
	public ArrayList<Ville> findVilleByPostalCode(String codePostal) {
		ArrayList<Ville> listeVilles = new ArrayList<>();
		
		try (Connection connexion = JDBCConfiguration.getConnection();
				Statement stmt = connexion.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM ville_france WHERE Code_postal="+codePostal
						+" AND deleted=false");){
			
			this.traitementResultat(res, listeVilles);
			
		} catch (ClassNotFoundException | SQLException e) {
			logger.error(ERREUR, e);
		} 
		
		return listeVilles;
	}
	
	@Override
	public ArrayList<Ville> findVilleByTownCode(String codeCommune, boolean evenIfDeleted) {
		ArrayList<Ville> listeVilles = new ArrayList<>();
		
		String ifDeleted = evenIfDeleted ? "" : " AND deleted=false";
		
		try (Connection connexion = JDBCConfiguration.getConnection();
			Statement stmt = connexion.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM ville_france "
					+ "WHERE Code_commune_INSEE="+codeCommune+ ifDeleted)){
		    
			this.traitementResultat(res, listeVilles);
			
		} catch (ClassNotFoundException | SQLException e) {
			logger.error(ERREUR, e);
		}
	 
		return listeVilles;
	}
	
	@Override
	public ArrayList<Ville> findVilleByName(String nomCommune) throws SQLException, ClassNotFoundException {
		ArrayList<Ville> listeVilles = new ArrayList<>();
		
		try (Connection connexion = JDBCConfiguration.getConnection();
				Statement stmt = connexion.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM ville_france WHERE Nom_commune='"+nomCommune.toUpperCase()+"'"
						+" AND deleted=false");){
			
			this.traitementResultat(res, listeVilles);
		} catch (ClassNotFoundException | SQLException e) {
			logger.error(ERREUR, e);
		} 
		
		
		return listeVilles;
	}
	
	@Override
	public void creerVille(Ville ville) throws ClassNotFoundException, SQLException {
		try (Connection connexion = JDBCConfiguration.getConnection();
			    Statement stmt = connexion.createStatement();){
			stmt.executeUpdate("INSERT INTO ville_france VALUES ("+ville.getCodeCommune()+
		    		",'"+ville.getNomCommune()+"',"+ville.getCodePostal()+",'"+ville.getLibelleAcheminement()
		    		+"','"+ville.getLigne()+"',"+ville.getLatitude()+","+ville.getLongitude()+","
		    		+ville.isDeleted()+")");
		} catch (ClassNotFoundException | SQLException e) {
			logger.error(ERREUR, e);
		} 
	}
	
	@Override
	public void modifierVille(Ville ville) throws ClassNotFoundException, SQLException {
		try (Connection connexion = JDBCConfiguration.getConnection();
			    Statement stmt = connexion.createStatement();){
			
			stmt.executeUpdate("UPDATE ville_france SET Nom_commune='"+ville.getNomCommune()
							+"', Code_postal="+ville.getCodePostal()+", Libelle_acheminement='"
							+ville.getLibelleAcheminement()+"', Ligne_5='"+ville.getLigne()
							+"', Latitude="+ville.getLatitude()+", Longitude="+ville.getLongitude()
							+", deleted="+ville.isDeleted()+" WHERE Code_commune_INSEE="+ville.getCodeCommune());
			
		} catch (ClassNotFoundException | SQLException e) {
			logger.error(ERREUR, e);
		}
	}
	
	public void traitementResultat(ResultSet res, ArrayList<Ville> listeVilles) throws SQLException {
		while(res.next()) {
			Ville ville = new Ville();
			ville.setCodeCommune(res.getString(1));
			ville.setNomCommune(res.getString(2));
			ville.setCodePostal(res.getString(3));
			ville.setLibelleAcheminement(res.getString(4));
			ville.setLigne(res.getString(5));
			ville.setLatitude(res.getString(6));
			ville.setLongitude(res.getString(7));
	        listeVilles.add(ville);
		}
	}
}
