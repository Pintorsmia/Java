package amazon.java;

public interface ColisManagerInter {
	Colis findColis(long numero);
	Colis createColis(float poids, float valeur, String origine, String destination);
	Colis setCoord(float latitude, float longitude, String emplacement, String etat);
	
}
