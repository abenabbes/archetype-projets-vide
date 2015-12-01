/**
 * 
 */
package aba.perso.couche.generic;

import java.util.List;
import java.util.Map;

import aba.perso.couche.exceptions.DAOException;


/**
 * Interface générique de définition d'un DAO pour toutes les entitées.<br>
 * @author ali
 *
 */
public interface IGenericPersoDAO<E, K> {

	 /**
	  * ABA ____NOV.<br>
	  * 
	  * Recherche de l'ensemble des entités sans paramétres.
	  *
	  * @return Une liste de l'entité rechercher.
	  */
	  public List<E> listerEntitesSansParamsGen() throws DAOException;
	  
	 /**
	  * ABA ____NOV.<br>
	  * 
	  * Recherche de l'ensemble des entités avec une requete SQL et des paramétres.<br>
	  * @param requete la requete SQL.
	  * @param parametres les paramétres de la requête.
	  * @return Une liste de l'entité rechercher.
	  * @throws DAOException exception.
	  */
	  public List<E> listerEntitesAvecRequeteEtParamsGen(final String requete, final Map<String, Object> parametres) throws DAOException;
	  
	  /**
	   * Recherche d'une entité par son identifiant
	   *
	   * @param id Identifiant de l'élément
	   * @return Entité
	   */
	  public E rechercheEntiteParIdGen(final K id) throws DAOException ;
	  
	  /**
	   * Ajouter dans la base une entité.
	   * @param entity l'entité à ajouter.
	   * @throws DAOException une exception.
	   */
	  public void ajouterEntiteGen(final E entity) throws DAOException ;
	  
	  /**
	   * Mise à jour d'une entité récuperé de la base de données.
	   *
	   * @param entity Entité à mettre à jour
	   * @param id identifiant technique de l'entité à mettre à jour
	   * @return l'entité mis à jour.
	   */
	  public E miseAJourEntiteGen(E entity, K id);
	  
	  /**
	   * Suppression d'une entité
	   *
	   * @param entity Entité à supprimer
	   */
	  public Boolean supprimerEntite(K idEntity);
	  
	  /**
	   * Rechercher une entité par Query et avec des parametres.
	   * @param queryName nom de la requête.
	   * @param params paamétres de la requête.
	   * @return une liste d'entité.
	   */
	  E rechercheEntiteParNamedQueryEtParIdGen(final String NameQuery, final Map<String, Object> parametres) throws DAOException;
}
