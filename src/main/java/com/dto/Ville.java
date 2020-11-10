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

	public String nomCommune;
	
	public String codeCommune;
	
	public String codePostal;
	
	public String ligne;
	
	public String libelleAcheminement;
}
