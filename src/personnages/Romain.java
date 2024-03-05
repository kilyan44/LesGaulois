package personnages;

public class Romain {
	private String nom;
	private int force;
//	private int stockageForce;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	private boolean vainqueur = true;

	public Romain(String nom, int force) {
		this.nom = nom;
		if (forceRomainPositive(force)) {
			throw new IllegalArgumentException("La force du romain n'est pas positive !");
		}
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
		equipements[nbEquipement] = equipement;
		System.out.println("s'équipe avec un " + equipement + ".");
		nbEquipement++;
	}

	public void sEquiper(Equipement equipement) {
		System.out.print("Le soldat " + nom + " ");
		switch (nbEquipement) {
		case 0:
			ajouterEquipement(equipement);
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("possède déjà un " + equipement + " .");
			} else {
				ajouterEquipement(equipement);
			}
			break;
		case 2:
			System.out.println("est déjà bien protégé !");
			break;
		default:
			break;
		}
	}

	private boolean forceRomainPositive(int force) {
		return force <= 0;
	}

//	private boolean forceRomainDiminuer(int forceAvant, int forceApres) {
//		return forceAvant >= forceApres;
//	}

	public int getForce() {
		return force;
	}

	public boolean isVainqueur() {
		return vainqueur;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte2 = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			if (resistanceEquipement > forceCoup) {
				resistanceEquipement -= forceCoup;
			}
			texte2 += "\nMais heureusement, grace à mon équipement sa force est diminué de " + resistanceEquipement
					+ "!";
		}
		parler(texte2);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert forceRomainPositive(force);
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe, ma force  est passée de " + oldForce + " à " + force + " !" );
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			vainqueur = false;
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

//	public void recevoirCoup(int forceCoup) {
//		assert forceRomainPositive(force);
//		stockageForce = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert forceRomainDiminuer(stockageForce, force);
//	}

	public static void main(String[] args) {
		Romain romain = new Romain("minus", 6);
		System.out.println(romain);
		romain.parler("Bonjour");
		romain.recevoirCoup(1);
		romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.BOUCLIER);
		romain.sEquiper(Equipement.CASQUE);
	}
}