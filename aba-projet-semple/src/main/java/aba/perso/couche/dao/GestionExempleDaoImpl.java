/**
 * 
 */
package aba.perso.couche.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aba.perso.couche.vo.ExempleVo;

/**
 * Implémentation de la couche persistance.<br>
 * ---------------------------------------------<br>
 * @author ali
 *
 */
public class GestionExempleDaoImpl implements IGestionExempleDao {

	//============= ATTRIBUTS
	/** Logger */
	private static Logger LOGGER = LoggerFactory.getLogger(GestionExempleDaoImpl.class);
			
	/** Définition du gestionnaire d'entités */
	@PersistenceContext
	private EntityManager em;

	//============= METHODES
	@Override
	public ExempleVo ajouterExemple(ExempleVo exemple) {
		LOGGER.debug("DEBUT persistance [ajouterExemple]");
		ExempleVo exempleRetour = new ExempleVo();
		
		exempleRetour = em.merge(exemple);
		
		LOGGER.debug("FIN persistance [ajouterExemple] - parametres de sortie l'objet d'ID = {}", exempleRetour.getId());
		return exempleRetour;
	}
		

}
