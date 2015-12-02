/**
 * 
 */
package aba.perso.couche.utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.junit.internal.runners.model.EachTestNotifier;

/**
 * @author ali
 *
 */
public class Transformeur<E , V> implements Serializable{

	
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Entite typé */
	private Class<E> entityBean;
	
	/** VO typé */
	private Class<E> voBean;
	
	/**
	 * Constructeur.
	 */
	@SuppressWarnings("unchecked")
	public Transformeur() {
		this.entityBean = (Class<E>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.voBean = (Class<E>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public Transformeur(final Class<E> entityBean, final Class<E> voBean) {
		super();
		this.entityBean = entityBean;
		this.voBean = entityBean;
	}


	public E copierVoVersEntite(){
		E retour = null;
		return retour;
	}
}
