package models.cartes;

import java.util.Set;

import controller.Capacite;
import models.joueur.Joueur;

public class Croyant extends Religion{
	
	private Guide_Spirituel guide;
	
	public Croyant(String nom,String capaciteDesc,Origine origine,Integer nombre,Set<Dogme> sesDogmes){
		super(nom,capaciteDesc,origine,nombre,sesDogmes);
		guide = null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buf = new StringBuffer();
		buf.append("CROYANT : ").append(this.nom).append("\n").append(this.capaciteDesc).append("\n Origine : ").append(this.origine).append("\n Dogmes : ").append(this.sesDogmes.toString());
		return buf.toString();
	}

}
