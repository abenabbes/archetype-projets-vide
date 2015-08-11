/**
 * 
 */
package test.aba.perso.couche.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import test.aba.perso.couche.utils.AbstractTest;
import aba.perso.couche.dao.GestionExempleDaoImpl;
import aba.perso.couche.dao.IGestionExempleDao;
import aba.perso.couche.entites.ExempleEntite;
import aba.perso.couche.vo.ExempleVo;

/**
 * @author ali
 *
 */
@ContextConfiguration(locations={ "classpath*:springTest/test-application-context.xml" }) 
public class GestionExempleDaoTest extends AbstractTest{

	//============= ATTRIBUTS
	/** Logger */
	private static Logger LOGGER = LoggerFactory.getLogger(GestionExempleDaoImpl.class);
	
	/** Appel à la couche DAO.*/
	@Autowired
	private IGestionExempleDao gestionExempleDao; 
	
	@Test
	public void testAjouterExempleCasNominal(){
		LOGGER.debug("Debut de test de la methode persistance jouterExemple");
		
		ExempleEntite exempleResult = gestionExempleDao.ajouterExemple(getExempleVo());
		
		LOGGER.debug("Fin de test de la methode persistance jouterExemple");
		
	}
	
	
	@Test
	public void testListerTous(){
		LOGGER.debug("Debut de test de la methode persistance rechercherTous");
		
		List<ExempleEntite> result = gestionExempleDao.rechercherTous();
		
		LOGGER.debug("Fin de test de la methode persistance rechercherTous");
		
	}
	
	private ExempleVo getExempleVo(){
		ExempleVo bouchon = new ExempleVo();
		bouchon.setNom("Exemple_Test_1");
		bouchon.setDate(new Date());
//		bouchon.setId(111111111L);
		return bouchon;
	}
	
	//
	
	private ExempleEntite getExempleEntite(){
		ExempleEntite bouchon = new ExempleEntite();
		bouchon.setNom("Exemple_Test_1");
		bouchon.setDate(new Date());
//		bouchon.setId(111111111L);
		return bouchon;
	}
}
