/**
 * 
 */
package aba.perso.couche.dao;

import org.springframework.stereotype.Repository;

import aba.perso.couche.entites.ExempleEntite;
import aba.perso.couche.generic.GenericPersoDAOImpl;

/**
 * Implémentation de la couche persistance.<br>
 * ---------------------------------------------<br>
 * @since 2015
 * 
 * @author ali
 *
 */
@Repository
public class GestionExempleDaoImpl extends GenericPersoDAOImpl<ExempleEntite, Long> implements IGestionExempleDao {

}
