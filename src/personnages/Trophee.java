package personnages;

public class Trophee {
	private Gaulois gaulois;
	private Equipement[] equipement;

	public Gaulois getGaulois() {
		return gaulois;
	}

	public Equipement[] getEquipement() {
		return equipement;
	}
	
	public String donnerNom() {
		return gaulois.getNom();
	}
}
