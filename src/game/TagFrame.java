package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class TagFrame extends JFrame {

	private JPanel contentPane;
	private DisplayComponent display;
	private It itplayer;
	private NotIt player2;
	private NotIt player3;
	private NotIt player4;
	private Timer starttimer;
	private JPanel displayPanel;

	
	private class doArrows implements KeyListener{
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyPressed(KeyEvent e) {
			int boundaryheight = displayPanel.getHeight();
			int boundarywidth = displayPanel.getWidth();
			
			int ID = e.getKeyCode();
			
			
			
			if(ID == KeyEvent.VK_DOWN) {
				itplayer.move(101, boundaryheight, boundarywidth);
			}
			if(ID == KeyEvent.VK_UP) {
				itplayer.move(100, boundaryheight, boundarywidth);
			}
			if(ID == KeyEvent.VK_LEFT) {
				itplayer.move(102, boundaryheight, boundarywidth);
			}
			if(ID == KeyEvent.VK_RIGHT) {
				itplayer.move(103, boundaryheight, boundarywidth);
			}
			
			repaint();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class startTimer implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			starttimer.start();
		}
	}
	
	private class doButtons implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int boundaryheight = displayPanel.getHeight();
			int boundarywidth = displayPanel.getWidth();
			player2.moveAway(boundaryheight, boundarywidth);
			player3.moveAway(boundaryheight, boundarywidth);
			player4.moveAway(boundaryheight, boundarywidth);
			repaint();
		}
	}

	/**
	 * Create the frame.
	 */
	public TagFrame() {
		display = new DisplayComponent();
		itplayer = new It();
		player2 = new NotIt(325,25, itplayer);
		player3 = new NotIt(220,200, itplayer);
		player4 = new NotIt(99, 176, itplayer);
		display.addPlayer(itplayer);
		display.addPlayer(player2);
		display.addPlayer(player3);
		display.addPlayer(player4);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel scorePanel = new JPanel();
		contentPane.add(scorePanel, BorderLayout.NORTH);
		scorePanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton startButton = new JButton("Start");
		startButton.setHorizontalAlignment(SwingConstants.LEFT);
		scorePanel.add(startButton);
		startButton.addActionListener(new startTimer());
		startButton.setFocusable(false);

		
		JLabel player1Label = new JLabel("Player 1");
		scorePanel.add(player1Label);
		
		JLabel player2Label = new JLabel("Player 2");
		scorePanel.add(player2Label);
		
		JLabel player3Label = new JLabel("Player 3");
		scorePanel.add(player3Label);
		
		JLabel player4Label = new JLabel("Player 4");
		scorePanel.add(player4Label);
		
		displayPanel = new JPanel();
		displayPanel.setLayout(new BorderLayout());
		displayPanel.add(display, BorderLayout.CENTER);
		contentPane.add(displayPanel, BorderLayout.CENTER);
		displayPanel.setFocusable(true);
		displayPanel.addKeyListener(new doArrows());
		
		
		starttimer = new Timer(50, new doButtons());

	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TagFrame frame = new TagFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
