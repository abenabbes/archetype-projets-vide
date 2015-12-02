/**
 * 
 */
package aba.perso.couche.service;

import java.util.List;

import org.apache.log4j.pattern.LogEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aba.perso.couche.entites.ExempleEntite;
import aba.perso.couche.metier.IGestionExempleMetier;
import aba.perso.couche.vo.ExempleVo;


/**
 * Implémentation de lacouche service.<br>
 * ----------------------------------------<br>
 * @author ali
 *
 */
@Service
public class GestionExempleServiceImpl implements IGestionExempleService {

	//============= ATTRIBUTS
	/** Logger */
	private static Logger log = LoggerFactory.getLogger(GestionExempleServiceImpl.class);
	
	/** Appel à la couche DAO*/
	@Autowired
	private IGestionExempleMetier gestionExempleMetier;

	public void setGestionExempleMetier(IGestionExempleMetier gestionExempleMetier) {
		this.gestionExempleMetier = gestionExempleMetier;
	}

	@Override
	public void ajouterExemple(ExempleVo exemple) {
		log.debug("Début de service [ajouterExemple]");
		gestionExempleMetier.ajouterExemple(exemple);
	}

	@Override
	public List<ExempleVo> rechercherTous() {
		log.debug("Début de service [rechercherTous]");
		return gestionExempleMetier.listerTousExemple();
	}

	@Override
	public ExempleVo miseAJourExemple(ExempleVo exempleVo) {
		log.debug("Début de service [miseAJourExemple]");
		return gestionExempleMetier.miseAJourExemple(exempleVo);
	}
	

}
