package personnages;

public class Musee {
	private Equipement[] trophees = new Equipement[200];
	private int nbTrophees = 0;
	
	public void donnerTrophees(Equipement trophee) {
		trophees[nbTrophees] = trophee;
		nbTrophees++;
	}
}
