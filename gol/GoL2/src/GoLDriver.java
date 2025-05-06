import javax.swing.JFrame;

public class GoLDriver {

	public static void main(String[] args) {
		int rows = 15;
		int cols = 30;
		int size = 20;
		
		String title = " Bob's Game of Life";
		Conway game = new Conway(rows, cols, size);
		
		JFrame frame = new JFrame(title);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(game.getGrid());
		frame.pack();
		frame.setVisible(true);
		game.mainloop();

	}

}
