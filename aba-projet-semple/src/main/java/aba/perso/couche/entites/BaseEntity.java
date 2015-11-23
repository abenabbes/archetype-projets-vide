/**
 * 
 */
package aba.perso.couche.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Classe abstraite de toutes les entités.
 * @author ali
 *
 */
@MappedSuperclass
public abstract class BaseEntity<ID> implements Serializable {

	//=============== ATTRIBUTS
	/** Serializable. */
	private static final long serialVersionUID = -393441468393654330L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique=true , nullable = false, updatable = false)
    private ID id;
 
    public ID getId() {
        return id;
    }
 
    public void setId(ID id) {
        this.id = id;
    }
}
