/**
 * 
 */
package aba.perso.couche.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import aba.perso.couche.entites.ExempleEntite;
import aba.perso.couche.vo.ExempleVo;

/**
 * Implémentation de la couche persistance.<br>
 * ---------------------------------------------<br>
 * @since 2015
 * 
 * @author ali
 *
 */
@Repository
public class GestionExempleDaoImpl implements IGestionExempleDao {

	//============= ATTRIBUTS
	/** Logger */
	private static Logger LOGGER = LoggerFactory.getLogger(GestionExempleDaoImpl.class);
			
	/** Définition du gestionnaire d'entités */
	@PersistenceContext
	private EntityManager entityManager;

	//============= METHODES
	@Override
	public ExempleEntite ajouterExemple(ExempleVo exemple) {
		LOGGER.debug("DEBUT persistance [ajouterExemple]");
		
		//Objet Retourner
		ExempleEntite exempleRetour = new ExempleEntite();
		
		//Objet Merger
		ExempleEntite exempleMerger = new ExempleEntite();
		
		exempleMerger.setNom(exemple.getNom());
		exempleMerger.setDate(exemple.getDate());
		
		
		exempleRetour = entityManager.merge(exempleMerger);
		
		LOGGER.debug("FIN persistance [ajouterExemple] - parametres de sortie l'objet d'ID = {}", exempleRetour.getId());
		return exempleRetour;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExempleEntite> rechercherTous() {
		LOGGER.debug("DEBUT persistance [rechercherTous]");
		//Retour 
		List<ExempleEntite> retour = new ArrayList<ExempleEntite>();
		
		//Req
		Query query = entityManager.createQuery("SELECT exemple FROM ExempleEntite exemple");
		
		try {
			//Resultat de requête
			retour = query.getResultList();
		
		} catch (Exception e) {
			e.getStackTrace();
			LOGGER.debug("Exception dans la persistance");
		}
		
		LOGGER.debug("FIN persistance [rechercherTous] - parametres de sortie une liste de {} elements", retour.size());
		return retour;
	}

	//============= GETTER && SETTER
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
