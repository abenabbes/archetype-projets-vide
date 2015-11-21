/**
 * 
 */
package aba.perso.couche.generic;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aba.perso.couche.entites.ExempleEntite;
import aba.perso.couche.exceptions.DAOException;

/**
 * Implémentation JPA de l'interface générique DAO.<br>
 * @author ali
 *
 */
public class GenericPersoDAOImpl<E, K> implements IGenericPersoDAO<E, K> {

	//============= ATTRIBUTS
	/** Logger */
	private static Logger LOGGER = LoggerFactory.getLogger(GenericPersoDAOImpl.class);
	
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
	public GenericPersoDAOImpl() {
		this.entityBean = (Class<E>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	  
	}
	public GenericPersoDAOImpl(final Class<E> entityBean) {
		super();
		this.entityBean = entityBean;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<E> listerEntitesSansParamsGen() throws DAOException {

		//Retour 
		List<E> listeEntiteRetour = null;
		
		//Requete
		final String SQL = "SELECT e FROM "+ this.entityBean.getName() + " e ORDER by e.id";
	    
		TypedQuery<E> query = (TypedQuery<E>) this.entityManager.createQuery(SQL);
		
	    //Execution de la requête
	    listeEntiteRetour = (List<E>)query.getResultList();
	    
	    //Traitement de retour
	    if(CollectionUtils.isEmpty(listeEntiteRetour) && listeEntiteRetour.size()==0){
	    	LOGGER.debug("Aucun élément trouver dans la base");
	    	return listeEntiteRetour;
	    }
	    return listeEntiteRetour;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<E> listerEntitesAvecParamsGen(String requete, Map<String, Object> parametres) throws DAOException {

		//Requête
		Query query = this.entityManager.createQuery(requete);
		
		//Parcourir le map de parametre pour setter les valeurs.
		for (String param : parametres.keySet()) {
			query.setParameter(param, parametres.get(param));
		}
		 
	    return (List<E>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E rechercheEntiteParIdGen(K id) throws DAOException {
		//Requete
		final String SQL = "SELECT e FROM "+ this.entityBean.getName() + " e ORDER by e.id";
		//Requête
		Query query = this.entityManager.createQuery(SQL);
		
		//Retour
		List<E> results = query.getResultList();
		
        if (results.isEmpty()) 
        	return null;
        else if (results.size() == 1) 
        	return (E) results.get(0);
            throw new NonUniqueResultException();
	}
	
	// ============== GETTERS et SETTERS
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
