package personnages;

public class village {
	private String nom;
	private chef chef;
	private int nbVillageois = 0;
	private gaulois[] villageois;

	public village(String nom, int nbVillageoisMax) {
		this.nom = nom;
		villageois = new gaulois[nbVillageoisMax];
	}

	public void ajouterHabitant(gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
	}

	public gaulois trouverHabitant(int numeroHabitant) {
		return villageois[numeroHabitant];
	}

	public void setChef(chef chef) {
		this.chef = chef;
	}
	
	public void afficherVillage() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vient les légendaires gaulois : \n");
		for (int i=0; i<nbVillageois;i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}

	public String getNom() {
		return nom;
	}

	public static void main(String[] args) {
		village village = new village("Village des Irréductibles", 30);
//		gaulois gaulois=village.trouverHabitant(30);
//		On obtient une erreur car le tableau va de 0 à 29 et non 30.
		chef abraracourcix = new chef("Abraracourcix", 6,village);
        village.setChef(abraracourcix);
		gaulois asterix = new gaulois("Astérix", 6);
		village.ajouterHabitant(asterix);
//		gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
		gaulois obelix = new gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillage();
	}
}
