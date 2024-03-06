package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private int nbTrophees = 0;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	private String prendreParole() {
		return "Le Gaulois " + nom + " : ";
	}

//	public void frapper(Romain Romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + Romain.getNom());
//		Romain.recevoirCoup(force / 3 * effetPotion);
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesEjectes = romain.recevoirCoup((force / 3) * effetPotion);
		if (tropheesEjectes != null) {
			for (int i = 0; i < tropheesEjectes.length; i++, nbTrophees++) {
				this.trophees[nbTrophees] = tropheesEjectes[i];
			}
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		System.out.println(prendreParole() + "« Merci Druide, je sens que ma force est " + forcePotion / force
				+ " fois décuplée. »");
	}

	public void faireUneDonnation(Musee musee) {
		if (nbTrophees != 0){
			System.out.println(prendreParole() + " « Je donne au musee tous mes trophees :");
			for (int i=0;i<nbTrophees;i++) {
				System.out.println("- " + trophees[i]);
				musee.donnerTrophees(trophees[i]);
			}
			nbTrophees = 0;
		}			
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		Musee musee = new Musee();
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
		System.out.println(asterix.prendreParole());
		asterix.parler("Bonjour");
		Romain romain = new Romain("obelix", 9);
		asterix.frapper(romain);
		asterix.boirePotion(16);
		asterix.faireUneDonnation(musee);
	}
}