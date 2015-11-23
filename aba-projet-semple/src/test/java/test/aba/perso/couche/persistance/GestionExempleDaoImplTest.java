/**
 * 
 */
package test.aba.perso.couche.persistance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import test.aba.perso.couche.utils.AbstractTest;
import test.aba.perso.couche.utils.ConstantesTest;
import aba.perso.couche.dao.GestionExempleDaoImpl;
import aba.perso.couche.dao.IGestionExempleDao;
import aba.perso.couche.entites.ExempleEntite;
import aba.perso.couche.exceptions.DAOException;
import aba.perso.couche.vo.ExempleVo;

/**
 * Classe de test de la couche persistance.<br>
 * -------------------------------------<br>
 * @author ali
 *
 */
@ContextConfiguration(locations={ "classpath*:springTest/test-application-context.xml" }) 
public class GestionExempleDaoImplTest extends AbstractTest{

	//============= ATTRIBUTS
	/** Logger */
	private static Logger LOGGER = LoggerFactory.getLogger(GestionExempleDaoImpl.class);
	
	/** Message qui concatène l'ensemble des résultats des tests. A afficher à la fin des tests. */
    private static String resultatsGeneralTests = "";

    /**
     * @param resultatsGeneralTests
     *            the resultatsGeneralTests to set
     */
    public static final void setResultatsGeneralTests(final String resultatsTests) {
        resultatsGeneralTests += resultatsTests + "\n";
    }
	
	/** Appel à la couche DAO.*/
	@Autowired
	private IGestionExempleDao gestionExempleDao;

//	@Before
	public void avantMethode() {
		log.debug("---------------------------------------\n");
		log.debug("---------- DEBUT ---------\n");
		log.debug("---------------------------------------\n");
		
	}
	   
	 
	/**
	 * Méthode lancé après les tests de la classe.
	 */
//	@After
	public void apresMethode() {
		log.debug("---------------------------------------\n");
		log.debug("------------ resultatsGeneralTests -----------\n");
		log.debug("---------------------------------------\n");
	}

	/**
	 * CAS NOMINAL.<br>
	 * Test du service d'ajout d'un objet exemple dans la base de données.<br>
	 * RESULTAT : En retour un objet non null.
	 */
	@Test
	public void testListerEntitesSansParamsGenCasNominal(){
		String nomMethode = "listerEntitesSansParamsGen";
        log.debug("\n\n---------- ### Test Debut : " + nomMethode + "  \n");
		try {
			
			List<ExempleEntite> listeRetour = gestionExempleDao.listerEntitesSansParamsGen();
			assertNotNull("Ajout de l'objet en success", listeRetour);
			assertEquals(listeRetour.size(), ConstantesTest.VALEUR_3);
			setResultatsGeneralTests(resultatsGeneralTests + "\n   # Test :" + nomMethode + "\t OK ");
		} catch (DAOException e) {
			setResultatsGeneralTests(resultatsGeneralTests + "\n   # Test : " + nomMethode + " \t FAILED ");
			fail("DAOException" +e.getMessage());
		}
		LOGGER.debug("Fin de test de la methode persistance listerEntitesSansParamsGen");
	}
	
	/**
	 * CAS NOMINAL.<br>
	 * Test du service de recherche de l'entite par ID.<br>
	 * RESULTAT : une liste non null.
	 */
	@Test
	public void testRechercheEntiteExempleParIdCasNominal(){
		String nomMethode = "rechercheEntiteParIdGen";
        log.debug("\n\n---------- ### Test Debut : " + nomMethode + "  \n");
        
        try {
			ExempleEntite  resultat = gestionExempleDao.rechercheEntiteParIdGen(ConstantesTest.ID_888111);
			assertNotNull("Ajout de l'objet avec success", resultat);
			assertEquals(ConstantesTest.ID_888111, resultat.getId());
			setResultatsGeneralTests(resultatsGeneralTests + "\n   # Test :" + nomMethode + "\t OK ");
		} catch (DAOException e) {
			setResultatsGeneralTests(resultatsGeneralTests + "\n   # Test : " + nomMethode + " \t FAILED ");
			fail("DAOException" +e.getMessage());
		}
		
		LOGGER.debug("Fin de test de la methode persistance rechercheEntiteParIdGen");
	}
	
	/**
	 * CAS ERREUR.<br>
	 * Test du service de recherche de l'entite par ID.<br>
	 * RESULTAT : une exception levé.
	 */
	@Test
	public void testRechercheEntiteExempleParIdCasErreur(){
		String nomMethode = "rechercheEntiteParIdGen";
        log.debug("\n\n---------- ### Test Debut : " + nomMethode + "  \n");
        
		//Retour
		ExempleEntite  resultat = null;
		try {
			resultat = gestionExempleDao.rechercheEntiteParIdGen(null);
			fail("L'identifiant de recherche est NULL");
			setResultatsGeneralTests(resultatsGeneralTests + "\n   # Test :" + nomMethode + "\t OK ");
		} catch (DAOException e) {
			assertNull("Aucun élément trouvé dans la base", resultat);
			LOGGER.debug("Resultat Null a cause de ID = Null");
			assert(e.getMessage().contains("null"));
			setResultatsGeneralTests(resultatsGeneralTests + "\n   # Test : " + nomMethode + " \t FAILED ");
			
		}
		
		LOGGER.debug("Fin de test de la methode persistance rechercheEntiteParIdGen");
	}
	
	/**
	 * CAS NOMINAL.<br>
	 * Test du service de recherche de l'entite par ID.<br>
	 * RESULTAT : une liste non null.
	 */
	@Test
	public void testAjouterEntiteCasNominal(){
		LOGGER.debug("Debut de test de la methode persistance ajouterEntiteGen");
		try {
			ExempleEntite  resultat = gestionExempleDao.ajouterEntiteGen(getExempleEntite());
			assertNotNull("Ajout de l'objet avec success", resultat);
		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}
		
		LOGGER.debug("Fin de test de la methode persistance ajouterEntiteGen");
	}
	
	/**
	 * CAS ERREUR.<br>
	 * Test du service de recherche de l'entite par ID.<br>
	 * RESULTAT : une liste non null.
	 */
	@Test
	public void testAjouterEntiteCasErreur(){
		LOGGER.debug("Debut de test de la methode persistance ajouterEntiteGen");
		ExempleEntite  resultat = null;
		try {
		    resultat = gestionExempleDao.ajouterEntiteGen(null);
		    fail("Probléme de persistance de l'objet");
		} catch (DAOException e) {
			LOGGER.debug("Resultat Null a cause de ID = Null");
			assertNull("Ajout de l'objet avec success", resultat);
			assert(e.getMessage().contains("null"));
		}
		
		LOGGER.debug("Fin de test de la methode persistance ajouterEntiteGen");
	}
	
	//================== BOUCHON
	private ExempleEntite getExempleEntite(){
		ExempleEntite bouchon =  new ExempleEntite();
		bouchon.setDate(new Date());
		bouchon.setNom("Nom_test");
		
		return bouchon;
	}
	
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
