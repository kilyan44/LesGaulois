package histoire;
import personnages.gaulois;
import personnages.romain;

public class scenario {
public static void main(String[] args) {
gaulois gaulois = new gaulois("Asterix", 8);
romain romain = new romain("Minus", 6);
gaulois.parler("Bonjour à tous");
romain.parler("UN GAU UN GAUGAU ...");
gaulois.frapper(romain);
gaulois.frapper(romain);
gaulois.frapper(romain);
}
}