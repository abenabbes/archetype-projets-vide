/**
 * 
 */
package test.aba.perso.couche.utils;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author ali
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@TestExecutionListeners(value = DependencyInjectionTestExecutionListener.class)
@TransactionConfiguration(defaultRollback = true, transactionManager="transactionManager")
@Transactional
public abstract class AbstractTest {
	
	/**Logger de la classe.*/
	protected static final Logger log = Logger.getLogger(AbstractTest.class);
	
	/** Message qui concatène l'ensemble des résultats des tests. A afficher à la fin des tests. */
	protected static String resultatsGeneralTests = "";

    /**
     * @param resultatsGeneralTests
     *            the resultatsGeneralTests to set
     */
	protected static final void setResultatsGeneralTests(final String resultatsTests) {
        resultatsGeneralTests += resultatsTests + "\n";
    }
	/**
	 * Méthode lancé avant les tests de la classe.
	 */
	@BeforeClass
	public static void setUp() {
		log.debug("---------------------------------------\n");
		log.debug("---------- DEBUT DES TEST JUNIT ---------\n");
		log.debug("---------------------------------------\n");
		
	}
	   
	 
	/**
	 * Méthode lancé après les tests de la classe.
	 */
	@AfterClass
	public static void tearDown() {
		log.debug("---------------------------------------------------------------\n");
		log.debug("------------ Résultat : \n" + resultatsGeneralTests+  "--------\n");
		log.debug("---------------------------------------------------------------\n");
	}
	   

}
