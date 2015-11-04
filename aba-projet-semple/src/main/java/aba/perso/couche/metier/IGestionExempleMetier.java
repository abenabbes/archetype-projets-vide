/**
 * 
 */
package aba.perso.couche.metier;

import java.util.List;

import aba.perso.couche.entites.ExempleEntite;
import aba.perso.couche.vo.ExempleVo;

/**
 * Interface de la couche metier.<br>
 * ----------------------------------<br>
 * @author ali
 *
 */
public interface IGestionExempleMetier {

	/**
	 * Methode service de mise à jour de l'objet.<br>
	 * @param exemple l'objet
	 * @return un objet exemple
	 */
	ExempleEntite miseAJourExemple(ExempleVo exemple);
	
	/**
	 * Methode service pour lister tous les objets exemple existants.
	 * @return une liste de l'objet Exemple.
	 */
	List<ExempleEntite> rechercherTous();
	
	/**
	 * Methode service d'ajout d'un objet dans la base de données.<br>
	 * Cette methode utilise la methode merge de l'entity manager.<br>
	 * @param exemple l'objet
	 * @return un objet exemple
	 */
	ExempleEntite ajouterExemple(ExempleVo exemple);
	
	/**
	   * Recherche de l'ensemble des entités
	   *
	   * @return Liste d'entités
	   */
	 public List<ExempleEntite> listerToutesEntite();
	
	
}
