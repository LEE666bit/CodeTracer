package codetracerPack;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CodeTracerPanel extends JPanel implements ActionListener{
	public int noteR, note3, note5, note7;
	int _4beat = 1;
	int nowPlaying = 1;
	int time_tick;
	
	JButton startButton = new JButton("в║");
	JButton stopButton = new JButton("бс");
	JTextField BPM_Box = new JTextField("120");
	ArrayList<JTextField> nodes_16 = new ArrayList<>();
	
	Timer timer = new Timer();
	
	CodeTracerPanel() {
		setLayout(null);
		
		startButton.setBounds(200,50,100,50);
		stopButton.setBounds(350,50,100,50);
		this.add(startButton);
		this.add(stopButton);
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		
		JLabel bpmName = new JLabel("BPM");
		bpmName.setFont(new Font("Serif", Font.BOLD, 50));
		bpmName.setBounds(550, 0, 150, 150);
		this.add(bpmName);
		
		
		
		BPM_Box.setBounds(700,50,100,50);
		this.add(BPM_Box);
		
		JTextField node1 = new JTextField("Eb-7");
		nodes_16.add(node1);
		node1.setBounds(150,200,80,50);
		this.add(node1);
		JTextField node2 = new JTextField("Cb");
		nodes_16.add(node2);
		node2.setBounds(350,200,80,50);
		this.add(node2);
		JTextField node3 = new JTextField("Gb");
		nodes_16.add(node3);
		node3.setBounds(550,200,80,50);
		this.add(node3);
		JTextField node4 = new JTextField("Db7");
		nodes_16.add(node4);
		node4.setBounds(750,200,80,50);
		this.add(node4);
		JTextField node5 = new JTextField("Eb-7");
		nodes_16.add(node5);
		node5.setBounds(150,300,80,50);
		this.add(node5);
		JTextField node6 = new JTextField("Cb");
		nodes_16.add(node6);
		node6.setBounds(350,300,80,50);
		this.add(node6);
		JTextField node7 = new JTextField("Gb");
		nodes_16.add(node7);
		node7.setBounds(550,300,80,50);
		this.add(node7);
		JTextField node8 = new JTextField("Db7");
		nodes_16.add(node8);
		node8.setBounds(750,300,80,50);
		this.add(node8);
		JTextField node9 = new JTextField("Eb-7");
		nodes_16.add(node9);
		node9.setBounds(150,400,80,50);
		this.add(node9);
		JTextField node10 = new JTextField("Cb");
		nodes_16.add(node10);
		node10.setBounds(350,400,80,50);
		this.add(node10);
		JTextField node11 = new JTextField("Gb");
		nodes_16.add(node11);
		node11.setBounds(550,400,80,50);
		this.add(node11);
		JTextField node12 = new JTextField("Db7");
		nodes_16.add(node12);
		node12.setBounds(750,400,80,50);
		this.add(node12);
		JTextField node13 = new JTextField("Eb-7");
		nodes_16.add(node13);
		node13.setBounds(150,500,80,50);
		this.add(node13);
		JTextField node14 = new JTextField("Cb");
		nodes_16.add(node14);
		node14.setBounds(350,500,80,50);
		this.add(node14);
		JTextField node15 = new JTextField("Gb");
		nodes_16.add(node15);
		node15.setBounds(550,500,80,50);
		this.add(node15);
		JTextField node16 = new JTextField("Db7");
		nodes_16.add(node16);
		node16.setBounds(750,500,80,50);
		this.add(node16);
		
		setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		int oneBeat = 60000/(Integer.parseInt(BPM_Box.getText()));
		time_tick = 1000;
		taskAdder Tadder = null;
		
		if(source == startButton) {
			for(nowPlaying = 1; nowPlaying < 17; nowPlaying++) {
				CodeSetter codeSetter = new CodeSetter(nodes_16.get(nowPlaying-1));
				ArrayList<Integer> PianoSounds = new ArrayList<Integer>();
				String codeName = nodes_16.get(nowPlaying-1).getText();
				noteR = codeSetter.setRoot();
				codeSetter.harmonizer(codeName, noteR);
				note3 = codeSetter.note3;
				note5 = codeSetter.note5;
				note7 = codeSetter.note7;
				PianoSounds.add(noteR);
				PianoSounds.add(note3);
				PianoSounds.add(note5);
				PianoSounds.add(note7);
				Collections.sort(PianoSounds);
				
				for(_4beat = 1; _4beat < 5; _4beat++) {
					for(int harmonys = 0; harmonys < 4; harmonys++) {
						Tadder = new taskAdder(PianoSounds.get(harmonys));
						if(nowPlaying == 16) {
							timer.schedule(Tadder.getTasks(), time_tick+(oneBeat/4*harmonys));
						} else {
							timer.schedule(Tadder.getTasks(), time_tick+harmonys);
						}
					}
					if(nowPlaying == 16) break;
					time_tick += oneBeat;
				}
			}
			
		} else if(source == stopButton) {
			timer.cancel();
			timer = new Timer();
		}
	}
}
