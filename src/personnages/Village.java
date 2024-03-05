package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;

	public Village(String nom, int nbVillageoisMax) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMax];
	}

	public void ajouterHabitant(Gaulois Gaulois) {
		villageois[nbVillageois] = Gaulois;
		nbVillageois++;
	}

	public Gaulois trouverHabitant(int numeroHabitant) {
		return villageois[numeroHabitant];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void afficherVillage() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vient les légendaires Gaulois : \n");
		for (int i=0; i<nbVillageois;i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}

	public String getNom() {
		return nom;
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
//		Gaulois Gaulois=Village.trouverHabitant(30);
//		On obtient une erreur car le tableau va de 0 à 29 et non 30.
		Chef abraracourcix = new Chef("Abraracourcix", 6,village);
        village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 6);
		village.ajouterHabitant(asterix);
//		Gaulois Gaulois = Village.trouverHabitant(1);
//		System.out.println(Gaulois);
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillage();
	}
}
