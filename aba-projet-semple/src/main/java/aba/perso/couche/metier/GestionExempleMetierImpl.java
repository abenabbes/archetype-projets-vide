/**
 * 
 */
package aba.perso.couche.metier;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import aba.perso.couche.dao.IGestionExempleDao;
import aba.perso.couche.entites.ExempleEntite;
import aba.perso.couche.service.GestionExempleServiceImpl;
import aba.perso.couche.vo.ExempleVo;

/**
 *  Implémentation de la couche metier.<br>
 * ----------------------------------------<br>
 * @author ali
 *
 */
@Component
public class GestionExempleMetierImpl implements IGestionExempleMetier {

	//============= ATTRIBUTS
	/** Logger */
	private static Logger LOGGER = LoggerFactory.getLogger(GestionExempleServiceImpl.class);
	
	/** Appel à la couche DAO*/
	@Autowired
	private IGestionExempleDao gestionExempleDao;
	
	@Override
	public ExempleEntite miseAJourExemple(ExempleVo exemple) {
		LOGGER.debug("DEBUT de metier [miseAJourExemple] - parametre d'entres un objet d'id = {}", exemple.getId());
		
		//Verification des paramétres obligatoir 
		Assert.notNull(exemple, "L'objet ne doit pas être null");
		
		//Transformation 
		ExempleEntite entiteAMJ = new ExempleEntite();
		entiteAMJ.setDate(exemple.getDate());
		entiteAMJ.setNom(exemple.getNom());
		
		//Retour 
		ExempleEntite entiteRetour = gestionExempleDao.miseAJourEntite(entiteAMJ);
		
		
		LOGGER.debug("FIN de metier [miseAJourExemple]");
		
		return entiteRetour;
	}

	@Override
	public List<ExempleEntite> rechercherTous() {
		LOGGER.debug("DEBUT de metier [rechercherTous]");
		
		LOGGER.debug("FIN de metier [rechercherTous]");
		return null;
	}

	@Override
	public ExempleEntite ajouterExemple(ExempleVo exemple) {
		return gestionExempleDao.ajouterExemple(exemple);
	}

	@Override
	public List<ExempleEntite> listerToutesEntite() {
		return gestionExempleDao.listerToutesEntite();
	}

	//GETTER && SETTER
	public void setGestionExempleDao(IGestionExempleDao gestionExempleDao) {
		this.gestionExempleDao = gestionExempleDao;
	}

}
