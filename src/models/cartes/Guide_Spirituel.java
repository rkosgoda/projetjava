package models.cartes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import controller.Capacite;
import controller.Gestionnaire_cartes_partie;

public class Guide_Spirituel extends Religion{
	private ArrayList<Croyant> sesCroyants;
	
	public Guide_Spirituel(String nom, String capaciteDesc, Origine origine, Integer nombre,
			Set<Dogme> sesDogmes) {
		super(nom, capaciteDesc, origine, nombre, sesDogmes);
		// TODO Auto-generated constructor stub
		sesCroyants = new ArrayList<Croyant>();
	}
	
	/**
	 * Permet d'obtenir les croyants qu'un guide ramm�ne � lui.
	 * Ajoute les premiers croyants � sa liste de Croyant.
	 * Pour l'instant on ne laisse pas le choix au joueur.
	 * @return La liste de croyants que le guide ramm�ne � lui. 
	 */
	public List<Croyant> ammenerCroyants(){
		//TODO Donner la possibilit�e au joueur de choisir dans la liste de croyant.
		List<Croyant> croyants = new ArrayList<Croyant>(this.croyantsDisponible().subList(0, this.nombre));
		for(int i=0;i<croyants.size();i++){
			croyants.get(i).setGuide(this);
		}
		this.sesCroyants.addAll(croyants);
		return croyants;
	}
	
	/**
	 * Permet d'obtenir la liste des croyants qu'un guide peut rammener � lui.
	 * @return La liste de croyant.
	 */
	public List<Croyant> croyantsDisponible(){
		List<Croyant> dispo = new ArrayList<Croyant>();
		for(int i=0;i<Gestionnaire_cartes_partie.getTable().size();i++){
			Iterator itCroyant = Gestionnaire_cartes_partie.getTable().get(i).sesDogmes.iterator();
			boolean possible = false;
			while(itCroyant.hasNext()){
				Dogme dogme = (Dogme)itCroyant.next();
				Iterator itGuide = this.sesDogmes.iterator();
				while(itGuide.hasNext()){
					if(dogme.equals((Dogme)itGuide.next())) possible = true;
				}
			}
			dispo.add(Gestionnaire_cartes_partie.getTable().get(i));
		}
		return dispo;
	}
	
	public ArrayList<Croyant> getSesCroyants() {
		return sesCroyants;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buf = new StringBuffer();
		buf.append("GUIDE : ").append(this.nom).append("\n").append(this.capaciteDesc).append("\n Origine : ").append(this.origine).append("\n Dogmes").append(this.sesDogmes.toString());
		return buf.toString();
	}

}
