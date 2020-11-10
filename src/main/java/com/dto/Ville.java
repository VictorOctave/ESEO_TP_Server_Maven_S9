package com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ville {

	private String nomCommune;
	
	private String codeCommune;
	
	private String codePostal;
	
	private String ligne;
	
	private String libelleAcheminement;
	
	private String longitude;
	
	private String latitude;
}
