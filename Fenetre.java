import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Fenetre extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Fenetre(String title, int lar) {
		setTitle(title);
		setSize(100, lar);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
