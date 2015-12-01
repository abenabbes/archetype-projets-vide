/**
 * 
 */
package test.aba.perso.couche.persistance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import aba.perso.couche.utils.Constantes;

/**
 * Classe de test de la couche persistance.<br>
 * --------------------------------------------<br>
 * @author ali
 *
 */
@ContextConfiguration(locations={ "classpath*:springTest/test-application-context.xml" }) 
public class GestionExempleDaoImplTest extends AbstractTest{

	//============= ATTRIBUTS
	/** Logger */
	private static Logger LOGGER = LoggerFactory.getLogger(GestionExempleDaoImpl.class);
	
	/** Appel à la couche DAO.*/
	@Autowired
	private IGestionExempleDao gestionExempleDao;

	/**
	 * CAS NOMINAL.<br>
	 * Test du service d'ajout d'un objet exemple dans la base de données.<br>
	 * RESULTAT : En retour un objet non null.
	 */
	@Test
	public void testListerEntitesSansParamsGenCasNominal(){
		String nomMethode = "testListerEntitesSansParamsGenCasNominal";
        log.debug("\n\n---------- ### Test Debut : " + nomMethode + "  \n");
		try {
			
			List<ExempleEntite> listeRetour = gestionExempleDao.listerEntitesSansParamsGen();
			assertNotNull("Récupération d'une liste de taille : ", listeRetour);
			assertEquals(listeRetour.size(), ConstantesTest.VALEUR_5);
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
		String nomMethode = "testRechercheEntiteExempleParIdCasNominal";
        log.debug("\n\n---------- ### Test Debut : " + nomMethode + "  \n");
        
        try {
			ExempleEntite  resultat = gestionExempleDao.rechercheEntiteParIdGen(ConstantesTest.ID_888115);
			assertNotNull("Recherche de l'entité est terminer avec success", resultat);
			assertEquals(ConstantesTest.ID_888115, resultat.getId());
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
		String nomMethode = "testRechercheEntiteExempleParIdCasErreur";
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
		String nomMethode = "testAjouterEntiteCasNominal()";
        log.debug("\n\n---------- ### Test Debut : " + nomMethode + "  \n");
        
		try {
			gestionExempleDao.ajouterEntiteGen(getExempleEntite());
			setResultatsGeneralTests(resultatsGeneralTests + "\n   # Test :" + nomMethode + "\t OK ");
		} catch (DAOException e) {
			fail(e.getMessage());
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
		String nomMethode = "testAjouterEntiteCasErreur()";
        log.debug("\n\n---------- ### Test Debut : " + nomMethode + "  \n");
        
		try {
		     gestionExempleDao.ajouterEntiteGen(null);
		    fail("Probléme de persistance de l'objet");
		    setResultatsGeneralTests(resultatsGeneralTests + "\n   # Test :" + nomMethode + "\t OK ");
		} catch (DAOException e) {
			LOGGER.debug("Resultat Null a cause de ID = Null");
			assert(e.getMessage().contains("null"));
		}
		
		LOGGER.debug("Fin de test de la methode persistance ajouterEntiteGen");
	}
	
	/**
	 * CAS NOMINAL.<br>
	 * Test du service de recherche de l'entite par ID.<br>
	 * RESULTAT : une liste non null.
	 */
	@Test
	public void testMiseAjourCasNominal(){
		String nomMethode = "testMiseAjourCasNominal()";
	    log.debug("\n\n---------- ### Test Debut : " + nomMethode + "  \n");
	    
	    //Resultat 
	    ExempleEntite resultat = null;
		try {
			resultat = gestionExempleDao.miseAJourEntiteGen(getExempleEntiteMAJ(), getExempleEntiteMAJ().getId());
		    assertNotNull(resultat);
		    setResultatsGeneralTests(resultatsGeneralTests + "\n   # Test :" + nomMethode + "\t OK ");
		} catch (DAOException e) {
			fail(e.getMessage());
			setResultatsGeneralTests(resultatsGeneralTests + "\n   # Test :" + nomMethode + "\t Fail ");
		}
		
		LOGGER.debug("Fin de test de la methode persistance ajouterEntiteGen");
	}
	/**
	 * CAS NOMINAL.<br>
	 * Test du service de supprimer de l'entite par ID.<br>
	 * RESULTAT : TRUE.
	 */
	@Test
	public void testSupprimerCasNominal(){
		String nomMethode = "testSupprimerCasNominal()";
        log.debug("\n\n---------- ### Test Debut : " + nomMethode + "  \n");
        
        try {
			Boolean resultat = gestionExempleDao.supprimerEntite(ConstantesTest.ID_888111);
			assertEquals(Boolean.TRUE, resultat);
			setResultatsGeneralTests(resultatsGeneralTests + "\n   # Test :" + nomMethode + "\t OK ");
		} catch (DAOException e) {
			setResultatsGeneralTests(resultatsGeneralTests + "\n   # Test : " + nomMethode + " \t FAILED ");
			fail("DAOException" +e.getMessage());
		}
		
		LOGGER.debug("Fin de test de la methode persistance rechercheEntiteParIdGen");
	}

	/**
	 * CAS ERROR.<br>
	 * Test du service de supprimer de l'entite par ID.<br>
	 * RESULTAT : FALSE.
	 */
	@Test
	public void testSupprimerCasErreur(){
		String nomMethode = "testSupprimerCasErreur()";
        log.debug("\n\n---------- ### Test Debut : " + nomMethode + "  \n");
        
        try {
			Boolean resultat = gestionExempleDao.supprimerEntite(null);
			assertEquals(Boolean.FALSE, resultat);
			fail("Probléme de persistance de l'objet");
			setResultatsGeneralTests(resultatsGeneralTests + "\n   # Test :" + nomMethode + "\t OK ");
		} catch (DAOException e) {
			LOGGER.debug("Resultat FALSE a cause de ID = Null");
			assert(e.getMessage().contains("null"));
			setResultatsGeneralTests(resultatsGeneralTests + "\n   # Test : " + nomMethode + " \t FAILED ");
		}
		
		LOGGER.debug("Fin de test de la methode persistance rechercheEntiteParIdGen");
	}
	
	@Test
	public void testRechercheEntiteParNamedQueryEtParIdGen(){
		String nomMethode = "testRechercheEntiteParNamedQueryEtParIdGen()";
        log.debug("\n\n---------- ### Test Debut : " + nomMethode + "  \n");
        Map<String, Object> parametres = new HashMap<>();
        parametres.put("id", ConstantesTest.ID_888111);
        
        try {
			ExempleEntite resultat = gestionExempleDao.rechercheEntiteParNamedQueryEtParIdGen(Constantes.QUERY_FIND_ONE_ENTITY, parametres);
			assertNotNull(resultat);
			assertEquals(ConstantesTest.ID_888111, resultat.getId());
			setResultatsGeneralTests(resultatsGeneralTests + "\n   # Test :" + nomMethode + "\t OK ");
		} catch (DAOException e) {
			LOGGER.debug("Resultat FALSE a cause de ID = Null");
			fail("Probléme de persistance de l'objet");
			assert(e.getMessage().contains("null"));
			setResultatsGeneralTests(resultatsGeneralTests + "\n   # Test : " + nomMethode + " \t FAILED ");
		}
		
		LOGGER.debug("Fin de test de la methode persistance rechercheEntiteParIdGen");
	}
	
	//================== BOUCHON
	
	/**
	 * Bouchon de l'entité ExempleEntite.
	 * @return {@link ExempleEntite}
	 */
	private ExempleEntite getExempleEntite(){
		ExempleEntite bouchon =  new ExempleEntite();
		bouchon.setDate(new Date());
		bouchon.setNom("Nom_test");
		return bouchon;
	}
	
	/**
	 * Bouchon de l'entité ExempleEntite.
	 * @return {@link ExempleEntite}
	 */
	private ExempleEntite getExempleEntiteMAJ(){
		ExempleEntite bouchon =  new ExempleEntite();
		bouchon.setId(ConstantesTest.ID_888114);
		bouchon.setDate(new Date());
		bouchon.setNom("Nom_test");
		return bouchon;
	}

}
