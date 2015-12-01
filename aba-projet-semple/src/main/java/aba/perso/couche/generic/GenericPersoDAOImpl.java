/**
 * 
 */
package aba.perso.couche.generic;

import java.io.Serializable;
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
import org.springframework.transaction.annotation.Transactional;

import aba.perso.couche.exceptions.DAOException;
import aba.perso.couche.utils.Constantes;

/**
 * Implémentation JPA de l'interface générique DAO de toutes les entités.<br>
 * @author ali
 *
 */
public class GenericPersoDAOImpl<E, K extends Serializable> implements IGenericPersoDAO<E, K> {

	//============= ATTRIBUTS
	/** Logger */
	private static Logger LOGGER = LoggerFactory.getLogger(GenericPersoDAOImpl.class);
	
	/** Définition du gestionnaire d'entités */
	@PersistenceContext
	protected EntityManager entityManager;
	
	/** Entite typé */
	protected Class<E> entityBean;
	 
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
		final String SQL = " SELECT entity FROM "+ this.entityBean.getName() + " AS entity ORDER by entity.id";
	    
		TypedQuery<E> query = (TypedQuery<E>) this.entityManager.createQuery(SQL);
		
	    //Execution de la requête
	    listeEntiteRetour = (List<E>)query.getResultList();
	    
	    //Traitement de retour
	    if(CollectionUtils.isEmpty(listeEntiteRetour) && listeEntiteRetour.size()==0){
	    	LOGGER.debug("Aucun élément trouver dans la base");
	    	return listeEntiteRetour;
	    }
	    LOGGER.debug("Récupération d'une liste de [{}] élément(s)", listeEntiteRetour != null ? listeEntiteRetour.size() : 0);
	    return listeEntiteRetour;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<E> listerEntitesAvecRequeteEtParamsGen(String requete, Map<String, Object> parametres) throws DAOException {

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
		
		//vérification des paramétres d'entrées
		if(id == null)
			throw new DAOException("L'identifiant ne doit pas étre null");
		
		//Requete
		final String SQL = "SELECT e FROM "+ this.entityBean.getName() + " AS e WHERE e.id = :id";
		
		//Requête typer JPA2
		TypedQuery<E> query = (TypedQuery<E>) this.entityManager.createQuery(SQL);
		query.setParameter(Constantes.PARAM_ID, id);
		
		//Retour && resultat de la requête
		List<E> results = query.getResultList();
		
        if (results.isEmpty()) 
        	return null;
        else if (results.size() == 1) 
        	return (E) results.get(0);
            throw new DAOException("Il existe plusqu'un seule élément dans la base");
         
	}
	
	@Override
	public void ajouterEntiteGen(E entity) throws DAOException {
		
		if(entity == null)
			throw new DAOException("L'objet en entré à persister ne doit pas être NULL");
		
		// persist
		this.entityManager.persist(entity);
		LOGGER.debug("Persistance de l'entité avec success");
		
	}
	@Override
	public E miseAJourEntiteGen(E entity, K id) {
		if(entity == null)
			throw new DAOException("L'objet en entré à modifier ne doit pas être NULL");

		//Verifier l'existance de l'entité dans la base
		final E isExiste = this.entityManager.find(entityBean, id);
		
		if(isExiste == null) 
			return null ;
		//Retour 
		E entityRetour = this.entityManager.merge(entity);
		return entityRetour;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Boolean supprimerEntite(K id) {
		// Retour
		Boolean isDelete = Boolean.TRUE;
		
		if(id == null)
			throw new DAOException("L'identifiant de l'entité est absent");
		
		//Vérifier si l'entité existe dans la base
		E isExist = rechercheEntiteParIdGen(id);
        
		if(isExist == null){
			isDelete = 	Boolean.FALSE;
			LOGGER.debug("Impossible de supprimé, l'entité n'exist pas dans la base");
		}
		
		//Requete 
		String SQL = "DELETE FROM "+ this.entityBean.getName() + " WHERE id=:id";
		TypedQuery<E> query = (TypedQuery<E>) this.entityManager.createQuery(SQL);
		query.setParameter(Constantes.PARAM_ID, id);
		
		int delete = query.executeUpdate();
		
		if(delete >= 1){
			isDelete = 	Boolean.TRUE;
		}
		return isDelete;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E rechercheEntiteParNamedQueryEtParIdGen(String NameQuery,
			Map<String, Object> parametres) throws DAOException {

		//Requête
		TypedQuery<E> query = (TypedQuery<E>) this.entityManager.createNamedQuery(NameQuery);
				
		//Parcourir le map de parametre pour setter les valeurs.
		for (String param : parametres.keySet()) {
			query.setParameter(param, parametres.get(param));
		}
		
		E rsultatnt = null;
		try {
			//Execute
			rsultatnt = query.getSingleResult();
		} catch (NonUniqueResultException e) {
			LOGGER.error("ERREOR : Il existe plusqu'un élément dans la base");
			LOGGER.error("ERREOR : " , e.getMessage());
		}
		
		return rsultatnt;
	}
	// ============== GETTERS et SETTERS
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
