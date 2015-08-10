/**
 * 
 */
package aba.perso.couche.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aba.perso.couche.dao.IGestionExempleDao;
import aba.perso.couche.vo.ExempleVo;


/**
 * Implémentation de lacouche service.<br>
 * ----------------------------------------<br>
 * @author ali
 *
 */
public class GestionExempleServiceImpl implements IGestionExempleService {

	//============= ATTRIBUTS
	/** Logger */
	private static Logger LOGGER = LoggerFactory.getLogger(GestionExempleServiceImpl.class);
	
	/** Appel à la couche DAO*/
	private IGestionExempleDao gestionExempleDao;

	//============= METHODES
	@Override
	public ExempleVo ajouterExemple(ExempleVo exemple) {
		LOGGER.debug("DEBUT sercive [ajouterExemple]");
		return gestionExempleDao.ajouterExemple(exemple);
	}
	

}
