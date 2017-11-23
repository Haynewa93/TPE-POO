/* TP de Haynewa Firmin Paulin Lambert
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author M FIRMIN
 */
abstract class Employe {
	private String nom;
	private String prenom;
	private int age;
	private String date;
	private String matricule;
	public int SalaireBase=110000;
	public Employe(String prenom, String nom, int age, String date, String matricule) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.date = date;
		this.matricule = matricule;
	}

	public abstract double calculerSalaire();

	public String getTitre()
		{
			return "L'employé" ;
		}
	
	public String getNom() {
		return getTitre() + prenom + " " + nom +" "+ matricule+" "+date;
	}
}


abstract class Commercial extends Employe {
	final double chiffreAffaire;

	public Commercial(String prenom, String nom, int age, String date, String matricule,double chiffreAffaire) {
		super(prenom, nom, age, date, matricule);
		this.chiffreAffaire = chiffreAffaire;
	}

	public double getChiffreAffaire()
		{
			return chiffreAffaire;
		}
	
}


class Vendeur extends Commercial {
	private final static double POURCENT_VENDEUR = 0.2;
	private final static int BONUS_VENDEUR = 100;
	public Vendeur(String prenom, String nom, int age, String date,String matricule,double chiffreAffaire) {
		super(prenom, nom, age, date, matricule,chiffreAffaire);
	}

	public double calculerSalaire() {
		return (POURCENT_VENDEUR * getChiffreAffaire()) + BONUS_VENDEUR +SalaireBase;
	}

	public String getTitre()
		{
			return "Le vendeur ";
		}

}


class Representant extends Commercial {
    private final static double POURCENT_REPRESENTANT = 0.2;
	private final static int BONUS_REPRESENTANT = 200;
	public Representant(String prenom, String nom, int age, String date, String matricule, double chiffreAffaire) {
		super(prenom, nom, age , date, matricule, chiffreAffaire );
	}

	public double calculerSalaire() {
		return (POURCENT_REPRESENTANT * getChiffreAffaire()) + BONUS_REPRESENTANT + SalaireBase ;
	}

	public String getTitre()
		{
			return "Le représentant ";
		}
}


class Technicien extends Employe {
	private final static double FACTEUR_UNITE = 5.0;
	

	private int unites;

	public Technicien(String prenom, String nom, int age, String date, String matricule, int unites) {
		super(prenom, nom, age, date,matricule);
		this.unites = unites;
	}

	public double calculerSalaire() {
		return FACTEUR_UNITE * unites + SalaireBase;
	}

	public String getTitre()
		{
			return "Le technicien ";
		}
}


class Manutentionnaire extends Employe {
	private final static double SALAIRE_HORAIRE = 65.0;
	private int heures;

	public Manutentionnaire(String prenom, String nom, int age, String date,String matricule, int heures) {
		super(prenom, nom, age, date, matricule);
		this.heures = heures;
	}

	public double calculerSalaire() {
		return SALAIRE_HORAIRE * heures + SalaireBase;
	}

	public String getTitre()
		{
			return "Le manut. " ;
		}
}


interface ARisque {
	int PRIME = 25000;
}


class TechnARisque extends Technicien implements ARisque {

	public TechnARisque(String prenom, String nom, int age, String date, String matricule, int unites) {
		super(prenom, nom, age, date, matricule, unites);
	}

	public double calculerSalaire() {
		return super.calculerSalaire() + PRIME;
	}
}


class ManutARisque extends Manutentionnaire implements ARisque {
	
	public ManutARisque(String prenom, String nom, int age, String date, String matricule, int heures) {
		super(prenom, nom, age, date, matricule, heures);
	}

	public double calculerSalaire() {
		return super.calculerSalaire() + PRIME;
	}
}


class Personnel {
	private Employe[] staff;
	private int nbreEmploye;
	private final static int MAXEMPLOYE = 400;

	public Personnel() {
		staff = new Employe[MAXEMPLOYE];
		nbreEmploye = 0;
	}

	public void ajouterEmploye(Employe e) {
		++nbreEmploye;
		if (nbreEmploye <= MAXEMPLOYE) {
			staff[nbreEmploye - 1] = e;
		} else {
			System.out.println("Pas plus de " + MAXEMPLOYE + " employés");
		}
	}

	public double salaireMoyen() {
		double somme = 0.0;
		for (int i = 0; i < nbreEmploye; i++) {
			somme += staff[i].calculerSalaire();
		}
		return somme / nbreEmploye;
	}

	public void afficherSalaires() {
		for (int i = 0; i < nbreEmploye; i++) {
			System.out.println(staff[i].getNom() + " gagne le mois "
					+ staff[i].calculerSalaire() + " francs.");
		}
	}
}


class Salary {
    
	public static void main(String[] args) {
		Personnel p = new Personnel();
		p.ajouterEmploye(new Vendeur("Janvier", "Mbombai",45, "entre en service le 19 janvier 1995","de matricule AC95",30000));		
		p.ajouterEmploye(new Representant("Adrian", "Ngomako", 25, "entre en service le 14 mars 2000","de matricuele AC00",20000));
		p.ajouterEmploye(new Technicien("Alexandre", "Santiago", 28, "entre en service le 28 novembre 1996", "de matricule AC96", 1000));
		p.ajouterEmploye(new Manutentionnaire("Jérémie", "Mango", 32, "entre en service le 2 mais 1998","de matricle AC98", 45));
		p.ajouterEmploye(new TechnARisque("Alphone", "Bota", 28, "entre en service le 7 septembre 2001","de matricule AC01", 1000));
		p.ajouterEmploye(new ManutARisque("Joseph", "Mendo",30, "entre en service le 23 avril 2007","de matricule AC07", 45));

		p.afficherSalaires();
		System.out.println("Le salaire moyen dans l'entreprise est de " + p.salaireMoyen() + " francs.");

	}

}

