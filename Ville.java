import java.awt.TextArea;

public class Ville {
	enum Couleur {
		VERT, ORANGE, ROUGE
	}

	enum secteur {
		AGRICOLE, TOURISTIQUE, INDUSTRIELLE, ORDINAIRE
	}

	enum nbfleur {
		PAS_DES_TOUT_FLEURIE, PEU_FLEURIE, ASSEZ_FLEURIE, BIEN_FLEURIE, TRES_FLEURIE
	}

	public static int num_ville;
	private String nom;
	private int wilaya;
	private int NombreHabitant;
	private secteur type;
	private nbfleur classement;
	private Ville[] VilleVoisin;
	

	public Ville(String nom, int wilaya, nbfleur classement, secteur type,
			int NombreHabitant) {
		this.nom = nom;
		this.type = type;
		this.classement = classement;
		this.wilaya = wilaya;
		this.NombreHabitant = NombreHabitant;
		num_ville++;
	}

	public Ville(String nom, int wilaya) {
		this.nom = nom;
		this.wilaya = wilaya;
	}

	public Ville[] getVilleVoisin() {
		return VilleVoisin;
	}

	public int getNum_ville() {
		return num_ville;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getWilaya() {
		return wilaya;
	}

	public void setWilaya(int wilaya) {
		this.wilaya = wilaya;
	}

	public int getNombreHabitant() {
		return NombreHabitant;
	}

	public void setNombreHabitant(int nombreHabitant) {
		NombreHabitant = nombreHabitant;
	}

	public nbfleur getClassement() {
		return classement;
	}

	public void setClassement(nbfleur classement) {
		this.classement = classement;
	}

	public secteur getType() {
		return type;
	}

	/**
	 * 
	 * @return une couleur qui depend du type et du classement
	 */
	public Couleur attribuerCouleur() {
		if (type == secteur.ORDINAIRE && classement.ordinal() < 2)
			return Couleur.ROUGE;
		if (type == secteur.ORDINAIRE && classement.ordinal() > 0
				|| type != secteur.ORDINAIRE && classement.ordinal() < 2)
			return Couleur.ORANGE;
		return Couleur.VERT;
	}

	public Couleur couleurAffiche() {
		Fenetre affInfoVille = new Fenetre("les informations de " + nom,
				350 + VilleVoisin.length);
		affInfoVille.add(new TextArea("Nom de ville : " + nom
				+ "\n Code De Ville : " + wilaya
				+ "\n Nombre Des Habitants De se Ville : " + NombreHabitant
				+ "\n Classement : " + classement.toString() + "\n Type : "
				+ type.toString() + "\n Liste des Ville Voisins : "));
		String listeVille = "\n";
		for (int i = 0; i < VilleVoisin.length; i++) {
			listeVille = listeVille + "\t" + VilleVoisin[i].nom + "\n";
		}
		affInfoVille.add(new TextArea(listeVille));
		affInfoVille.setVisible(true);
		return attribuerCouleur();
	}

	/**
	 * question n:4
	 * 
	 * @return vrai, si la Ville courante ne mène directement à aucun ville
	 *        en d'autres termes si la ville n'a aucune ville voisine
	 */
	public boolean IsvilleIsole() {
		return VilleVoisin.length == 0;
	}

	/**
	 * question n:5
	 * 
	 * @return vrai, si la ville à exactement 3 Villes Voisines
	 */
	public boolean IsvilleAreVoiEq3() {
		return VilleVoisin.length == 3;
	}

	/**
	 * 
	 * @return vrai si les villes voisines sont de type defferent
	 * @return faux si c'est  le cas contraire
	 */
	public boolean IsvilleVoiDefType() {
		if (VilleVoisin.length > 4)
			return false;
		switch (VilleVoisin.length) {
		case 0:
		case 1:
			return true;
		case 2:
			return VilleVoisin[0] != VilleVoisin[1];
		case 3:
			return VilleVoisin[0].getType() != VilleVoisin[1].getType()
					&& VilleVoisin[1].getType() != VilleVoisin[2].getType()
					&& VilleVoisin[0].getType() != VilleVoisin[2].getType();

		case 4:
			// un autre solution on peut verifier si transporter.value()
			for (int i = 1; i < 4; i++)
				for (int j = i - 1; j >= 0; j--)
					if (VilleVoisin[i].getType() == VilleVoisin[j].getType())
						return false;
			return true;
		}
		return false;
	}

	/**
	 * <strong>question 7 </strong>
	 * 
	 * @return vrai si la ville courante est plus fleurie que les autre,faux
	 *         dans le cas contraire
	 */
	public boolean IsPlusFleurieQueVilVoi() {
		int max = classement.ordinal();
		if (classement == nbfleur.TRES_FLEURIE)
			return true;
		for (int i = 0; i < VilleVoisin.length; i++)
			if (VilleVoisin[i].classement.ordinal() > max)
				return false;
		return true;
	}

	/**
	 * @return Si la ville est vert et pas rdinaire alors retourner vrai;
	 * 
	 */
	public boolean IsVilleVertNonOrd() {
		for (int i = 0; i < VilleVoisin.length; i++)
			if (VilleVoisin[i].attribuerCouleur() != Couleur.ROUGE)
				return false;
		return attribuerCouleur() == Couleur.VERT && type != secteur.ORDINAIRE;
	}

	/**
	 * question n :10
	 * 
	 * @param un
	 *            objet de la class ville
	 * @return vrai, si il existe un chemin entre les deux ville fausse dans le
	 *         cas contraire
	 */
	public boolean existenceChemin(Ville v) {
		if (v.getNum_ville() == num_ville)
			return true;
		if (v.IsvilleIsole())
			return false;
		boolean exist = false;
		for (int i = 0; i < VilleVoisin.length; i++) {
			exist = exist || existenceChemin(v.VilleVoisin[i]);
			if (exist)
				return true;
		}
		return false;

	}

	/**
	 * question n: 9
	 * 
	 * @param ensemble
	 *            de Ville
	 * @return Vrai, s'il existe un chemin direct entre ces villes
	 */
	public static boolean existCheminEntrEnsVille(Ville[] listVille) {
		for (int i = 0; i < listVille.length - 1; i++) {
			boolean exist = false;
			for (int j = 0; j < listVille[i].VilleVoisin.length; j++)
				if (listVille[i + 1] == listVille[i].VilleVoisin[j]) {
					exist = true;
					break;
				}
			if (!exist)
				return false;
		}
		return true;
	}

}
