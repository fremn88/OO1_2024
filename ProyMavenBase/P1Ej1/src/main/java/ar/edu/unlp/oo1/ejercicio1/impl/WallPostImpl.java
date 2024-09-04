package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;

/**
 * Completar esta clase de acuerdo a lo especificado en el cuadernillo
 *
 */
public class WallPostImpl implements WallPost {

	/**
	 * Complete con su implementación
	 */
	private String texto;

	private Integer cantidadLikes;

	private boolean destacado;

	public WallPostImpl() {
		this.texto = "Undefined post";
		this.cantidadLikes = 0;
		this.destacado = false;
	}

	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de
	 * forma adecuada
	 */
	@Override
	public String toString() {
		return "WallPost {" + "text: " + getText() + ", likes: '" + getLikes() + "'" + ", featured: '" + isFeatured()
				+ "'" + "}";
	}

	@Override
	public String getText() {
		return this.texto;
	}

	@Override
	public void setText(String text) {
		this.texto = text;

	}

	@Override
	public int getLikes() {
		return this.cantidadLikes;
	}

	@Override
	public void like() {
		this.cantidadLikes++;

	}

	@Override
	public void dislike() {
		if (this.cantidadLikes > 0) {
			this.cantidadLikes--;
		}
	}

	@Override
	public boolean isFeatured() {
		return this.destacado;
	}

	@Override
	public void toggleFeatured() {
		this.destacado = !this.destacado;
	}

}
