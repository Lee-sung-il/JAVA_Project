package Week05.src;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyEventEx extends JFrame implements KeyListener {
	
	private JPanel p = new JPanel();
	private JLabel[] KeyMsg;
	
	KeyEventEx() {
		this.setTitle("Mouse Adapter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		this.formDesign();
		this.eventHandler();
		
		this.setSize(350,150);
		this.setVisible(true);
		
		p.setFocusable(true);
		p.requestFocus();
	}
	
	public void formDesign() {
		this.add(p);
		KeyMsg = new JLabel[3];
		
		KeyMsg[0] = new JLabel("  getKeyCode()  ");
		KeyMsg[1] = new JLabel("  getKeyChar()  ");
		KeyMsg[2] = new JLabel("  getKeyText()  ");
		
		for( int i = 0; i < 3; i++ ) {
			p.add(KeyMsg[i]);
			KeyMsg[i].setOpaque(true);
			KeyMsg[i].setBackground(Color.YELLOW);
		}
	}
	
	public void eventHandler() {
		p.addKeyListener(this);
	}

	public static void main(String[] args) {		
		new KeyEventEx();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("key typed");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int KeyCode = e.getKeyCode();
		char KeyChar = e.getKeyChar();
		
		KeyMsg[0].setText(Integer.toString(KeyCode));
		KeyMsg[1].setText(Character.toString(KeyChar));
		KeyMsg[2].setText(KeyEvent.getKeyText(KeyCode));
		
		System.out.println("key pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("key released");
		
	}
	
}