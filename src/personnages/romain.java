package personnages;

public class romain {
	private String nom;
	private int force;
	private int stockageForce;

	public romain(String nom, int force) {
		this.nom = nom;
		assert forceRomainPositive(force);
		this.force = force;
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
	}
}