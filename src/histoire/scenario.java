package histoire;

import personnages.druide;
import personnages.gaulois;
import personnages.romain;

public class scenario {
	public static void main(String[] args) {
		gaulois asterix = new gaulois("Asterix", 8);
		gaulois obelix = new gaulois("Obélix", 25);
		romain minus = new romain("Minus", 6);
		druide panoramix = new druide("Panoramix", 5, 10);
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		minus.parler("UN GAU UN GAUGAU ...");
		asterix.frapper(minus);
	}
}