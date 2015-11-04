package aba.perso.couche.service;

import java.util.List;


import aba.perso.couche.entites.ExempleEntite;
import aba.perso.couche.vo.ExempleVo;

/**
 * Interface de la couche service.<br>
 * ----------------------------------<br>
 * @author ali
 *
 */
public interface IGestionExempleService {

	/**
	 * Methode service de mise à jour de l'objet.<br>
	 * @param exemple l'objet
	 * @return un objet exemple
	 */
	ExempleEntite ajouterExemple(ExempleVo exemple);
	
	/**
	 * Methode service pour lister tous les objets exemple existants.
	 * @return une liste de l'objet Exemple.
	 */
	List<ExempleEntite> rechercherTous();
}
