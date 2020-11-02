package codetracerPack;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class notePlayer {
	private File sound = null;
	private AudioInputStream stream = null;
	int noteInt = 0;
	String noteS = "";
	
	
	public notePlayer(int notePosition) {
		this.sound = sound;
		this.stream = stream;
		try {
			noteInt = notePosition;
			noteS = Integer.toString(notePosition);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void note_run() {
		try {
			sound = new File(".\\src\\Piano\\" + noteS + ".wav");
			stream = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void close() {
		//this.interrupt();
	}
}
