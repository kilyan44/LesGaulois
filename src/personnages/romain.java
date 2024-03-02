package personnages;

public class romain {
	private String nom;
	private int force;
	private int stockageForce;
	private Equipement[] equipements;
	private int nbEquipements = 0;

	public romain(String nom, int force) {
		this.nom = nom;
		assert forceRomainPositive(force);
		this.force = force;
		this.equipements = new Equipement[2];
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipements] = equipement;
		nbEquipements++;
	}

	public void sEquiper(Equipement equipement) {
		System.out.print("Le soldat " + nom + " ");
		switch (nbEquipements) {
		case 0:
			ajouterEquipement(equipement);
			System.out.println("s'équipe avec un " + equipement + ".");
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("possède déjà un " + equipement + " .");
			} else {
				ajouterEquipement(equipement);
				System.out.println("s'équipe avec un " + equipement + ".");
			}
			break;
		case 2:
			System.out.println("est déjà bien protégé !");
			break;
		}
	}

	private boolean forceRomainPositive(int force) {
		if (force <= 0) {
			return false;
		} else {
			return true;
		}
	}

	private boolean forceRomainDiminuer(int forceAvant, int forceApres) {
		if (forceAvant < forceApres) {
			return false;
		} else {
			return true;
		}
	}

	public void recevoirCoup(int forceCoup) {
		assert forceRomainPositive(force);
		stockageForce = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert forceRomainDiminuer(stockageForce, force);
	}

	public static void main(String[] args) {
		romain romain = new romain("minus", 6);
		System.out.println(romain);
		romain.parler("Bonjour");
		romain.recevoirCoup(1);
		romain.sEquiper(Equipement.CASQUE);
        romain.sEquiper(Equipement.CASQUE);
        romain.sEquiper(Equipement.BOUCLIER);
        romain.sEquiper(Equipement.CASQUE);
	}
}