/**
 * 
 */
package aba.perso.couche.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * l'entite du projet pour les tests.<br>
 * -----------------------------------<br>
 * @author ali
 *
 */
@Entity
@Table(name="EXEMPLE")
public class ExempleEntite implements Serializable {

	//=============== ATTRIBUTS
	/** Serializable. */
	private static final long serialVersionUID = -393441468393654330L;
	
	/** Identifiant technique de l'objet.*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique=true , nullable = false, updatable = false)
	private Long id;
	
	/** Nom de l'objet.*/
	@Column(name = "NOM")
	private String nom;
	
	/** Date de l'objet.*/
	@Column(name = "DATE_OBJET")
	@Temporal(TemporalType.DATE)
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
		ExempleEntite other = (ExempleEntite) obj;
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
