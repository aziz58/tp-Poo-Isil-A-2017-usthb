import java.awt.TextArea;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;
import java.util.ArrayList;
/**
 * cette porjet a ete realiser par 
 * @author ALOUANI Abdelaziz : ISIL A groupe 1
 *remarque : j'utilise une package extern s'appel : GraphStream 
 */
public class Application {
	private Graph initGraph() {
		System.setProperty("gs.ui.renderer",
				"org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		Graph graph = new SingleGraph("Reseau Routiere");
		graph.addAttribute("ui.stylesheet", "node { shape:rounded-box;"
				+ "stroke-width: 1px;" + "stroke-color: #558;"
				+ "size-mode: fit;" + "fill-color: #ffffff;"
				+ "text-size:15px; " + "stroke-mode: plain; "
				+ "stroke-color: #333;" + "text-padding: 5px;"
				+ "padding: 5px;" + "text-style:bold;" + "}"
				+ "edge { size:2px;" + "arrow-shape: arrow;"
				+ "arrow-size: 20px, 5px; }");
		return graph;
	}

	private Graph creerNodeVille(Graph gravill, ArrayList<Ville> vi) {
		for (int i = 0; i < vi.size(); i++) {
			Node n = gravill.addNode(vi.get(i).getNom());
			n.addAttribute("ui.label", vi.get(i).getNom());
		}
		return gravill;
	}

	private Graph AddEdgeBetweenVille(Graph gravill, ArrayList<Ville> vi) {
		for (int i = 0; i < vi.size(); i++)
			for (int j = 0; j < vi.get(i).getVilleVoisin().length; j++)
				gravill.addEdge(vi.get(i).getNom()
						+ vi.get(i).getVilleVoisin()[j].getNom(), vi.get(i)
						.getNom(), vi.get(i).getVilleVoisin()[j].getNom(), true);
		return gravill;
	}

	/**
	 * question 12
	 * 
	 * @param listeville
	 *            : la liste des villes
	 */
	public void dessinerReseauGraph(ArrayList<Ville> listeville) {
		Graph reseau = initGraph();
		reseau = creerNodeVille(reseau, listeville);
		reseau = AddEdgeBetweenVille(reseau, listeville);
		reseau.display();
	}

	/**
	 * question n : 10
	 * 
	 * @param newname
	 *            : le nom qu'on veut attribuer
	 * @param oldname
	 *            : le nom de la ville
	 * @param nombreHabitant
	 *            : le nombre des habitants
	 * @param classement
	 *            : nombre de fleurs
	 * @return vrai, si la ville existe
	 */
	public boolean changeInfoVille(ArrayList<Ville> tabVille, String newname,
			String oldname, int nombreHabitant, Ville.nbfleur classement) {
		Ville v = existeVille(oldname, tabVille);
		if (v == null)
			return false;
		v.setNom(newname);
		v.setClassement(classement);
		v.setNombreHabitant(nombreHabitant);
		return true;
	}

	public Ville existeVille(String oldname, ArrayList<Ville> tabVille) {
		for (Ville city : tabVille) {
			if (city.getNom().equalsIgnoreCase(oldname))
				return city;
		}
		return null;
	}

	/**
	 * method de la question 13
	 * 
	 * @param city
	 */
	public void AfficheVilleByColor(ArrayList<Ville> city) {
		TextArea[] listeVille = new TextArea[3];
		Fenetre f = new Fenetre(
				"regroupement des villes depend de leurs couleurs",
				300 + city.size());
		for (int i = 0; i < listeVille.length; i++) {
			listeVille[i].append("la liste des Villes "
					+ Ville.Couleur.values()[i].toString().toLowerCase()
					+ "es : \n");
			f.add(listeVille[i]);
		}
		for (int i = 0; i < city.size(); i++) {
			listeVille[city.get(i).attribuerCouleur().ordinal()].append(city
					.get(i).getNom());
			f.setVisible(true);
		}
	}

	public void RegroupVilleFortementConnexe(ArrayList<Ville> city) {

	}

	public static void main(String[] args) {
	}

}
