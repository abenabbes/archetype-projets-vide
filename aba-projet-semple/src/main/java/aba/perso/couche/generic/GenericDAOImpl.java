/**
 * 
 */
package aba.perso.couche.generic;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aba.perso.couche.exceptions.DAOException;

/**
 * Implémentation JPA de l'interface générique DAO.<br>
 * @author ali
 *
 */
public class GenericDAOImpl<E> implements IGenericDAO<E> {

	//============= ATTRIBUTS
	/** Logger */
	private static Logger LOGGER = LoggerFactory.getLogger(GenericDAOImpl.class);
	
	/** Définition du gestionnaire d'entités */
	@PersistenceContext
	protected EntityManager entityManager;
	
	/** Entite typé */
	private Class<E> entityBean;
	 
	/**
	 * Constructeur par défaut
	 * Défini le type de bean de l'entité
	*/
	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		this.entityBean = (Class<E>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	  
	}
	public GenericDAOImpl(final Class<E> entityBean) {
		super();
		this.entityBean = entityBean;
	}
	

	//============= IMPLEMENTATION
	@Override
	public E rechercheEntiteParId(final Long id) {
		
		if (LOGGER.isDebugEnabled())
		      LOGGER.debug("Recherche de l'entité {} " , entityBean.getSimpleName() + " avec l'identifiant {} " ,id);
		
		if(null == id)
			throw new DAOException("id de l'objet à inserer ne doit pas être null"); 
		 
		    return entityManager.find(entityBean, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> listerToutesEntite() {
		if (LOGGER.isDebugEnabled())
		      LOGGER.debug("Recherche de toutes les entités {} " , entityBean.getSimpleName());
		 
		    final String SQL = "SELECT e FROM "+ this.entityBean.getName() + " e ORDER by e.id";
		    Query query = entityManager.createQuery(SQL);
		 
		    return (List<E>)query.getResultList();
	}

	@Override
	public void insererEntite(final E entity) {
		if (LOGGER.isDebugEnabled())
		      LOGGER.debug("Insertion de l'entité {} " , entity);
		
		if (null == entity) 
			throw new DAOException("L'objet à inserer de doit pas être null"); 
		    
		entityManager.persist(entity);

	}

	@Override
	public E miseAJourEntite(E entity) {
		 if (LOGGER.isDebugEnabled())
		      LOGGER.debug("Mise à jour de l'entité {} " , entity);
		 
		 if (null == entity) 
			 throw new DAOException("L'objet à inserer de doit pas être null");  
		 
		    return entityManager.merge(entity);

	}

	@Override
	public void supprimerEntite(E entity) {
		if (LOGGER.isDebugEnabled())
		      LOGGER.debug("Suppression de l'entité {} " , entity);
		 
		//Rechercher d'abord l'entité 
//		E entityRechercher = entityManager.find(entityBean, primaryKey)
		    entityManager.remove(entity);

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<E> findByNamedQuery(String queryName, String[] params) {
		if (LOGGER.isDebugEnabled())
	      LOGGER.debug("Recherche de toutes les entités avec la requene nommé {} " , queryName);
		
		//Execution de la requête
		Query query = entityManager.createNamedQuery(queryName);
		LOGGER.debug("REQUETE : {}",query);
		
		if(params != null){
			for (int i = 0; i < params.length; i++) {
				LOGGER.debug("i+1 : {}" ,i + 1);
//				query.setParameter(params[i].toString(), params[i]);
				query.setParameter(i + 1 , params[i]);
			}
			
			LOGGER.debug("REQUETE : {}",query.toString());
		}

		//Execution de la requête
		final List<E> result = (List<E>) query.getResultList();
		LOGGER.debug("RESULTAT : {}" ,result.size());
		
		return result;
	}
	
	// GETTERS et SETTERS
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
