package aba.perso.couche.dao;


import java.util.List;

import aba.perso.couche.entites.ExempleEntite;
import aba.perso.couche.generic.IGenericDAO;
import aba.perso.couche.vo.ExempleVo;

/**
 * Interface de la couche persistance.<br>
 * -------------------------------------<br>
 * @author ali
 *
 */
public interface IGestionExempleDao extends IGenericDAO<ExempleEntite>{

	/**
	 * Methode persistance d'ajout d'un objet dans la base de données.<br>
	 * Cette methode utilise la methode merge de l'entity manager.<br>
	 * @param exemple l'objet
	 * @return un objet exemple
	 */
	ExempleEntite ajouterExemple(ExempleVo exemple);
	
	/**
	 * Methode persistance pour lister tous les objets dans la base de données.
	 * @return une liste de l'objet Exemple.
	 */
	List<ExempleEntite> rechercherTous();
	
}
