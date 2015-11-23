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
	  * @return La liste des entités.
	  */
	  public List<E> listerEntitesSansParamsGen() throws DAOException;
	  
	 /**
	  * ABA ____NOV.<br>
	  * 
	  * Recherche de l'ensemble des entités avec une requete SQL et des paramétres.<br>
	  * @param requete la requete SQL.
	  * @param parametres les paramétres de la requête.
	  * @return La liste des entités.
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
	   * @return l'entité.
	   * @throws DAOException une exception.
	   */
	  public E ajouterEntiteGen(final E entity) throws DAOException ;
	 
	  //---------------------------------------------
	 
	 
	  /**
	   * Insertion d'une entité
	   *
	   * @param entity Entité à insérer
	   */
	//  public void insererEntite(E entity);
	 
	  /**
	   * Mise à jour d'un élément
	   *
	   * @param entity Entité à mettre à jour
	   */
	  //public E miseAJourEntite(E entity);
	 
	  /**
	   * Suppression d'une entité
	   *
	   * @param entity Entité à supprimer
	   */
	 // public void supprimerEntite(E entity);
	  
	  /**
	   * Rechercher une entité par une namedQuery.
	   * @param queryName nom de la requête.
	   * @param params paamétres de la requête.
	   * @return une liste d'entité.
	   */
	  //List<E> findByNamedQuery(final String queryName, String[] params);
}
