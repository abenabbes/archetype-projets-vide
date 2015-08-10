package aba.perso.couche.dao;

import org.springframework.stereotype.Repository;

import aba.perso.couche.vo.ExempleVo;

/**
 * Interface de la couche persistance.<br>
 * -------------------------------------<br>
 * @author ali
 *
 */
@Repository
public interface IGestionExempleDao {

	/**
	 * Methode persistance d'ajout d'un objet dans la base de données.<br>
	 * Cette methode utilise la methode merge de l'entity manager.<br>
	 * @param exemple l'objet
	 * @return un objet exemple
	 */
	ExempleVo ajouterExemple(ExempleVo exemple);
}
