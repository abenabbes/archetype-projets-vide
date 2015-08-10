package aba.perso.couche.service;

import org.springframework.stereotype.Service;

import aba.perso.couche.vo.ExempleVo;

/**
 * Interface de la couche service.<br>
 * ----------------------------------<br>
 * @author ali
 *
 */
@Service
public interface IGestionExempleService {

	/**
	 * Methode service d'ajout d'un objet.<br>
	 * @param exemple l'objet
	 * @return un objet exemple
	 */
	ExempleVo ajouterExemple(ExempleVo exemple);
}
