package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophees = 0;

	public void donnerTrophees(Gaulois gaulois,Equipement trophees2) {
		Trophee tropheeAjout = new Trophee(gaulois,trophees2);
		trophees[nbTrophees]= tropheeAjout;
		nbTrophees++;
	}
	
	public void extraireInstructionsOCaml() {
		System.out.println("let musee = [");
		for (int i = 0; i < nbTrophees; i++) {
			System.out.println("      " + trophees[i].donnerNom() + ", " + trophees[i].getEquipement()+ ";");
		}
		System.out.println("]\n");
	}
}
