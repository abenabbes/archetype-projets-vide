/**
 * 
 */
package aba.perso.couche.generic;

import java.util.List;

import aba.perso.couche.exceptions.DAOException;


/**
 * Interface générique de définition d'un DAO.<br>
 * @author ali
 *
 */
public interface IGenericDAO<E> {

	/**
	   * Recherche d'une entité par son identifiant
	   *
	   * @param id Identifiant de l'élément
	   * @return Entité
	   */
	  public E rechercheEntiteParId(Long id) throws DAOException ;
	 
	  /**
	   * Recherche de l'ensemble des entités
	   *
	   * @return Liste d'entités
	   */
	  public List<E> listerToutesEntite() throws DAOException;
	 
	  /**
	   * Insertion d'une entité
	   *
	   * @param entity Entité à insérer
	   */
	  public void insererEntite(E entity);
	 
	  /**
	   * Mise à jour d'un élément
	   *
	   * @param entity Entité à mettre à jour
	   */
	  public E miseAJourEntite(E entity);
	 
	  /**
	   * Suppression d'une entité
	   *
	   * @param entity Entité à supprimer
	   */
	  public void supprimerEntite(E entity);
	  
	  /**
	   * Rechercher une entité par une namedQuery.
	   * @param queryName nom de la requête.
	   * @param params paamétres de la requête.
	   * @return une liste d'entité.
	   */
	  List<E> findByNamedQuery(final String queryName, String[] params);
}
