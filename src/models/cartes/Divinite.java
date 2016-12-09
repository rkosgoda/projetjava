package models.cartes;

import java.util.Set;

import controller.Capacite;
import models.enums.Dogme;
import models.enums.Origine;

public class Divinite extends Carte{
	private String carteDesc;
	private Set<Dogme> sesDogmes;
	
	public Divinite(String nom, String carteDesc,String capaciteDesc, Origine origine,Set<Dogme> sesDogmes,Capacite capacite) {
		super(nom, capaciteDesc, origine,capacite);
		// TODO Auto-generated constructor stub
		this.carteDesc = carteDesc;
		this.sesDogmes = sesDogmes;
	}
	
	public Set<Dogme> getSesDogmes() {
		return sesDogmes;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buf = new StringBuffer();
		buf.append(this.nom).append("\n").append(carteDesc).append("\n").append(this.capaciteDesc).append("\n Origine : ").append(this.origine).append("\n Dogmes : ").append(this.sesDogmes.toString());
		return buf.toString();
	}
}
