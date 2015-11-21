/**
 * 
 */
package aba.perso.couche.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import aba.perso.couche.entites.ExempleEntite;
import aba.perso.couche.exceptions.DAOException;
import aba.perso.couche.generic.GenericPersoDAOImpl;
import aba.perso.couche.utils.Constantes;

/**
 * Implémentation de la couche persistance.<br>
 * ---------------------------------------------<br>
 * @since 2015
 * 
 * @author ali
 *
 */
@Repository
public class GestionPersoDaoImpl extends GenericPersoDAOImpl<ExempleEntite, Long> implements IGestionPersoDao {

	//============= ATTRIBUTS
	/** Logger */
	private static Logger LOGGER = LoggerFactory.getLogger(GestionPersoDaoImpl.class);

	//============= METHODES
	public List<ExempleEntite> rechercherListeExempleById(Long id) throws DAOException {
		LOGGER.debug("DEBUT de persistance rechercherExempleEntiteAvecParam");
		//Requête
		StringBuilder nomRequete = new StringBuilder();
		nomRequete.append("SELECT ex FROM ExempleEntite ex WHERE ex.id = :");
		nomRequete.append(Constantes.PARAM_ID);
		
		//Parametre de la requete
		Map<String, Object> parametres = new HashMap<String, Object>();
		parametres.put(Constantes.PARAM_ID, id);
		
		//Resultat
		List<ExempleEntite> resultat = super.listerEntitesAvecParamsGen(nomRequete.toString(), parametres);
		return resultat;
	}
	
	public List<ExempleEntite> rechercherListeExempleByIdEtNom(Long id, String nom) throws DAOException {
		LOGGER.debug("DEBUT de persistance rechercherExempleEntiteAvecParam");
		//Requête
		StringBuilder nomRequete = new StringBuilder();
		nomRequete.append("SELECT ex FROM ExempleEntite ex WHERE ex.id = :");
		nomRequete.append(Constantes.PARAM_ID);
		nomRequete.append(" AND ex.nom = :");
		nomRequete.append(Constantes.PARAM_NOM);
		
		//Parametre de la requete
		Map<String, Object> parametres = new HashMap<String, Object>();
		parametres.put(Constantes.PARAM_ID, id);
		parametres.put(Constantes.PARAM_NOM, nom);
		
		//Resultat
		List<ExempleEntite> resultat = super.listerEntitesAvecParamsGen(nomRequete.toString(), parametres);
		return resultat;
		
	}

	@Override
	public ExempleEntite rechercherExempleParId(Long id) throws DAOException {
		LOGGER.debug("DEBUT de persistance rechercherExempleEntiteAvecParam");
		//Requête
		StringBuilder nomRequete = new StringBuilder();
		nomRequete.append("SELECT ex FROM ExempleEntite ex WHERE ex.id = :");
		nomRequete.append(Constantes.PARAM_ID);
		
		//Parametre de la requete
		Map<String, Object> parametres = new HashMap<String, Object>();
		parametres.put(Constantes.PARAM_ID, id);
			
		//Resultat
		ExempleEntite resultat = super.rechercheEntiteParIdGen(id);
		return resultat;
	}

	//============= GETTER && SETTER
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
