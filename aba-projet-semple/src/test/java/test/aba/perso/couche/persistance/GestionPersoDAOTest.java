/**
 * 
 */
package test.aba.perso.couche.persistance;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import test.aba.perso.couche.utils.AbstractTest;
import aba.perso.couche.dao.GestionExempleDaoImpl;
import aba.perso.couche.dao.IGestionPersoDao;
import aba.perso.couche.entites.ExempleEntite;
import aba.perso.couche.vo.ExempleVo;

/**
 * Classe de test de la couche service.<br>
 * -------------------------------------<br>
 * @author ali
 *
 */
@ContextConfiguration(locations={ "classpath*:springTest/test-application-context.xml" }) 
public class GestionPersoDAOTest extends AbstractTest{

	//============= ATTRIBUTS
	/** Logger */
	private static Logger LOGGER = LoggerFactory.getLogger(GestionExempleDaoImpl.class);
	
	/** Appel à la couche DAO.*/
	@Autowired
	private IGestionPersoDao gestionPersoDao; 
	
	
	//============= TESTS
	
	/**
	 * CAS NOMINAL.<br>
	 * Test du service d'ajout d'un objet exemple dans la base de données.<br>
	 * RESULTAT : En retour un objet non null.
	 */
	@Test
	public void testRechercherToutesEntitesCasNominal(){
		LOGGER.debug("Debut de test de la methode persistance jouterExemple");
		List<ExempleEntite> listeRetour = gestionPersoDao.listerEntitesSansParamsGen();
		assertNotNull("Ajout de l'objet en success", listeRetour);
		assertEquals(listeRetour.size(), 3);
		LOGGER.debug("Fin de test de la methode persistance jouterExemple");
		
	}
	
	/**
	 * CAS NOMINAL.<br>
	 * Test du service de recherche de l'entite par ID.<br>
	 * RESULTAT : une liste non null.
	 */
	@Test
	public void testRechercheListeExempleById(){
		LOGGER.debug("Debut de test de la methode persistance jouterExemple");
		final Long id = 888111L;
		List<ExempleEntite>  resultat = gestionPersoDao.rechercherListeExempleById(id);
		assertNotNull("Ajout de l'objet en success", resultat);
		assertEquals(resultat.size(), 1);
		LOGGER.debug("Fin de test de la methode persistance jouterExemple");
	}
	
	/**
	 * CAS NOMINAL.<br>
	 * Test du service de recherche de l'entite par ID.<br>
	 * RESULTAT : une liste non null.
	 */
	@Test
	public void testRechercheExempleById(){
		LOGGER.debug("Debut de test de la methode persistance jouterExemple");
		final Long id = 888111L;
		ExempleEntite resultat = gestionPersoDao.rechercherExempleParId(id);
		assertNotNull("Ajout de l'objet en success", resultat);
		LOGGER.debug("Fin de test de la methode persistance jouterExemple");
	}
	
	/**
	 * CAS NOMINAL.<br>
	 * Test du service de recherche de l'entite par ID.<br>
	 * RESULTAT : une liste non null.
	 */
	@Test
	public void testRechercheListeExempleByIdEtNom(){
		LOGGER.debug("Debut de test de la methode persistance jouterExemple");
		final Long id = 888111L;
		final String nom = "EXEMPLE_888111";
		
		List<ExempleEntite>  resultat = gestionPersoDao.rechercherListeExempleByIdEtNom(id, nom);
		assertNotNull("Ajout de l'objet en success", resultat);
		assertEquals(resultat.size(), 1);
		
		LOGGER.debug("Fin de test de la methode persistance jouterExemple");
	}
	
	//=============== Bouchons
	
	/**
	 * Un objet valeur Exemple.
	 * @return l'objet Exemple
	 */
	private ExempleVo getExempleVo(){
		ExempleVo bouchon = new ExempleVo();
		bouchon.setNom("Exemple_Test_1");
		bouchon.setDate(new Date());
		return bouchon;
	}
	
}
