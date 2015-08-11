/**
 * 
 */
package aba.perso.couche.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aba.perso.couche.dao.IGestionExempleDao;
import aba.perso.couche.entites.ExempleEntite;
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
	private static Logger LOGGER = LoggerFactory.getLogger(GestionExempleServiceImpl.class);
	
	/** Appel à la couche DAO*/
	@Autowired
	private IGestionExempleDao gestionExempleDao;

	//============= METHODES
	@Override
	@Transactional
	public ExempleEntite ajouterExemple(ExempleVo exemple) {
		LOGGER.debug("DEBUT sercive [ajouterExemple]");
		return gestionExempleDao.ajouterExemple(exemple);
	}

	@Override
	public List<ExempleEntite> rechercherTous() {
		LOGGER.debug("DEBUT sercive [rechercherTous]");
		return gestionExempleDao.rechercherTous();
	}
	

}
