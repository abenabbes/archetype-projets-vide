/**
 * 
 */
package aba.perso.couche.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Un objet valeur (VO) pour les tests.<br>
 * -------------------------------------<br>
 * @author ali
 *
 */
public class ExempleVo implements Serializable {

	//=============== ATTRIBUTS
	/** Serializable. */
	private static final long serialVersionUID = -393441468393654330L;
	
	/** Identifiant technique de l'objet.*/
	private Long id;
	
	/** Nom de l'objet.*/
	private String nom;
	
	/** Date de l'objet.*/
	private Date date;

	//=============== GETTERS && SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	//=============== ToString/HashCode/Equals
	@Override
	public String toString() {
		return "ExempleVo [id=" + id + ", nom=" + nom + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExempleVo other = (ExempleVo) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

}
