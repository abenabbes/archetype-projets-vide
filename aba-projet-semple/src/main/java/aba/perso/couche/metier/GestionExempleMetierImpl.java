/**
 * 
 */
package aba.perso.couche.metier;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import aba.perso.couche.dao.IGestionExempleDao;
import aba.perso.couche.entites.ExempleEntite;
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
	private static Logger log = LoggerFactory.getLogger(GestionExempleMetierImpl.class);
	
	/** Appel à la couche DAO*/
	@Autowired
	private IGestionExempleDao gestionExempleDao;
	
	/** Dozer.*/
	@Autowired
	private Mapper dozerMapper;
	
	//============= METHODES
	@Override
	public ExempleVo miseAJourExemple(ExempleVo exempleVo) {
		
		log.debug("DEBUT de metier [miseAJourExemple] - parametre d'entres un objet d'id = {}", exempleVo.getId());
		//Verification des paramétres obligatoires 
		Assert.notNull(exempleVo, "L'objet ne doit pas être null");
		//Tronsformation de l'objet valeur en entité avec dozer
		ExempleEntite entiteAMJ = new ExempleEntite();
		dozerMapper = new DozerBeanMapper();
		 try {
			 entiteAMJ = (ExempleEntite) dozerMapper.map(exempleVo, ExempleEntite.class);

		    } catch(Exception e) {
		        log.error("Exception : Probleme de mapping de Vo vers Entity");
		        e.printStackTrace();
		    }
		
		 gestionExempleDao.miseAJourEntiteGen(entiteAMJ, exempleVo.getId());
		
		log.debug("FIN de metier [miseAJourExemple]");
		return exempleVo;
	}

	@Override
	public List<ExempleVo> listerTousExemple() {
		log.debug("DEBUT de metier [listerTousExemple]");
		//Retour
		List<ExempleVo> listeExempleVo = new ArrayList<>(); 
		//Appel de la DAO
		List<ExempleEntite> listeExemplResult = gestionExempleDao.listerEntitesSansParamsGen();
		
		if(CollectionUtils.isNotEmpty(listeExemplResult)){
			//Tronsformation de l'objet valeur en entité avec dozer
			ExempleVo exempleVo = new ExempleVo();
			dozerMapper = new DozerBeanMapper();
			for (ExempleEntite exempleEntite : listeExemplResult) {
				 try {
					 exempleVo = (ExempleVo) dozerMapper.map(exempleEntite, ExempleVo.class);

				 } catch(Exception e) {
				        log.error("Exception : Probleme de mapping de Vo vers Entity");
				        e.printStackTrace();
				 }
				 
				//Ajout dans la liste
				 listeExempleVo.add(exempleVo);
			}
		}
		
		log.debug("FIN de metier [listerTousExemple]");
		
		return listeExempleVo;
	}

	@Override
	public void ajouterExemple(ExempleVo exempleVo) {
		log.debug("DEBUT de metier [ajouterExemple] - parametre d'entres un objet d'id = {}", exempleVo.getId());
		//Verification des paramétres obligatoires 
		Assert.notNull(exempleVo, "L'objet ne doit pas être null");
		
		//Tronsformation de l'objet valeur en entité avec dozer
		ExempleEntite entiteAjouter = new ExempleEntite();
		dozerMapper = new DozerBeanMapper();
		 try {
			 entiteAjouter = (ExempleEntite) dozerMapper.map(exempleVo, ExempleEntite.class);
	    } catch(Exception e) {
	        log.error("Exception : Probleme de mapping de Vo vers Entity");
	        e.printStackTrace();
	    }
		//appel a la DAO
		gestionExempleDao.ajouterEntiteGen(entiteAjouter);
	}

	//================= GETTER && SETTER
	public void setGestionExempleDao(IGestionExempleDao gestionExempleDao) {
		this.gestionExempleDao = gestionExempleDao;
	}

	public void setDozerMapper(Mapper dozerMapper) {
		this.dozerMapper = dozerMapper;
	}

}
