package codetracerPack;

import java.util.TimerTask;

public class taskAdder {
	TimerTask task = null;
	public taskAdder(int har) {
		task = new TimerTask() {
			public void run() {
				notePlayer soundR = new notePlayer(har);
				soundR.note_run();
			}
		};
	}
	
	public TimerTask getTasks() {
		return task;
	}
}
