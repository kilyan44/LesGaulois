package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	private Random random = new Random();

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le Druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin +

				" à "

				+ effetPotionMax + ".");

	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le Druide " + nom + " : ";
	}

	public void preparerPotion() {
		forcePotion = random.nextInt(effetPotionMin, effetPotionMax);
		if (forcePotion > 7) {
			System.out.println(prendreParole() + "« J'ai préparé une super potion de force " + forcePotion + "»");
		} else {
			System.out.println(
					prendreParole() + "« Je n'ai pas trouvé tous les ingrédients, ma potion seulement de force "

							+ forcePotion + "»");
		}
	}

	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() != null && gaulois.getNom().equals("Obélix")) {
			System.out.println(prendreParole() + "« Non, Obélix !... Tu n’auras pas de potion magique !»");
		} else {
			gaulois.boirePotion(forcePotion);
		}
	}

	public static void main(String[] args) {
		Druide druide = new Druide("panoramix", 5, 10);
		druide.preparerPotion();
	}
}