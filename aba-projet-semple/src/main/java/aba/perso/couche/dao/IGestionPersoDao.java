package aba.perso.couche.dao;



import java.util.List;

import aba.perso.couche.entites.ExempleEntite;
import aba.perso.couche.exceptions.DAOException;
import aba.perso.couche.generic.IGenericPersoDAO;

/**
 * Interface de la couche persistance.<br>
 * -------------------------------------<br>
 * @author ali
 *
 */
public interface IGestionPersoDao extends IGenericPersoDAO<ExempleEntite, Long>{
	
	/**
	 * Recherche de la liste des entitées avec ID.
	 * @param id identifiant technique.
	 * @return une liste de ExempleEntite.
	 * @throws DAOException exception.
	 */
	public List<ExempleEntite> rechercherListeExempleById(final Long id) throws DAOException;
	
	/**
	 * Recherche de la liste des entitées avec ID et NOM.
	 * @param id identifiant technique.
	 * @param nom nom de l'objet.
	 * @return une liste de ExempleEntite.
	 * @throws DAOException exception.
	 */
	public List<ExempleEntite> rechercherListeExempleByIdEtNom(final Long id, final String nom) throws DAOException;

	/**
	 * Recherche d'une seule entitée avec ID.
	 * @param id identifiant technique.
	 * @return l'objet Entite
	 * @throws DAOException exception
	 */
	public ExempleEntite rechercherExempleParId(final Long id) throws DAOException;
}
