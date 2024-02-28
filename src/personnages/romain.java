package personnages;

public class romain {
	private String nom;
	private int force;

	public romain(String nom, int force) {
		this.nom = nom;
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

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}

	public static void main(String[] args) {
		romain romain = new romain("obelix", 9);
		System.out.println(romain);
		System.out.println(romain.prendreParole());
		romain.parler("Bonjour");
		romain.recevoirCoup(1);
	}
}