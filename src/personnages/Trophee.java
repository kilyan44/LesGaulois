package personnages;

public class Trophee {
	private Gaulois gaulois;
	private Equipement[] equipement;
	private int nbTrophees = 0;

	public Trophee(Gaulois gaulois2, Equipement trophees2) {
		this.gaulois = gaulois2;
		for (int i = 0; i < nbTrophees; i++) {
			this.equipement[i] = trophees2;
		}
		nbTrophees++;
	}

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
