import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DoAllTheThing extends Component implements ActionListener {

	private static final long serialVersionUID = 1L;
	Soundfx sfx = new Soundfx();
	private boolean check = true;

	private  JButton button;
	private  JButton stop;

	private  JButton note[] = new JButton[16];
	private  JButton drum[] = new JButton[4];

	private JLabel say[] = new JLabel[3];
	
	private  JPanel panel = new JPanel();
	ArrayList<Integer> record = new ArrayList<Integer>();
	public DoAllTheThing(JFrame frame) {
		button= new JButton("Generate Music");
		stop = new JButton("Stop");
		for (int i=0; i<note.length; note[i++] = new JButton(""+i));
		for (int i =0; i<note.length; panel.add(note[i++]));
		for (int i =0; i<note.length; note[i++].setBounds(i*50-47, 500, 45, 200));
		
		for (int i=0; i<drum.length; drum[i++] = new JButton("d"+i));
		for (int i =0; i<drum.length; panel.add(drum[i++]));
		for (int i =0; i<drum.length; drum[i++].setBounds(i*100+100, 350, 100, 100));
		
		say[0] = new JLabel("Randomly generated music");
	

        say[1] = new JLabel("Play drum");
        say[2] = new JLabel("Play note");
		for (int i =0; i<say.length;say[i++].setForeground(Color.BLUE)) {}
		for (int i =0; i<say.length; panel.add(say[i++])) {}
        say[0].setBounds(320, 60, 200,20);
        say[1].setBounds(370, 300, 200,20);
        say[2].setBounds(370, 470, 200,20);

		panel.add(button);
		panel.add(stop);
		panel.setLayout(null);
		button.setBounds(250,100,300,100);
		stop.setBounds(250,100,300,100);
		stop.setVisible(false);
		button.addActionListener(this);
		stop.addActionListener(this);
		for (int i =0; i<note.length; note[i++].addActionListener(this)) {}
		
		for (int i =0; i<drum.length; drum[i++].addActionListener(this)) {}

		frame.add(panel);
		frame.setSize(800, 800); 
		frame.setResizable(false);
		frame.setFocusable(true); 
		frame.setLocationRelativeTo(null);
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public int random() {
		return (int)(Math.random() * ((16 - 1) + 1)) + 1;
	}

	public int anotherRan() {
		return  (int)(Math.random() * ((4 - 1) + 1)) + 1;
	}

	public void play() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		long tStart = System.currentTimeMillis();
		while (check) {
			long tEnd = System.currentTimeMillis();
			if ((tEnd - tStart)/1000.0 >= (30)) {
				check = false;
				stop.setVisible(false);
				button.setVisible(true);
			}
			sfx.sound(Integer.toString(random()));
			sfx.anothr(random());
			sfx.trya(anotherRan());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand(); 
		if (s.equals("Generate Music") ) {
			button.setVisible(false);
			stop.setVisible(true);
			check = true;
			new Thread(new Runnable() {
				public void run() {
					try {
						play();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
		if (s.equals("Stop") ) {
			check = false;
			stop.setVisible(false);
			button.setVisible(true);
		}

		for (int i=0; i< note.length+1;i++) {
			if (s.equals(""+i)) {

				try {
					sfx.anothr(i);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		for (int i=0; i< drum.length+1;i++) {
			if (s.equals("d"+i)) {
				try {
					sfx.trya(i);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		
	}
}
