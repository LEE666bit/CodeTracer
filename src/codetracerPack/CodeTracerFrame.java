package codetracerPack;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class CodeTracerFrame extends JFrame {
	
	CodeTracerFrame() {
		setTitle("ChordTracer");
		setSize(1000,700);
		Container contentPane = getContentPane();
	    contentPane.add(new CodeTracerPanel());
	    
		addWindowListener(new WindowAdapter()
        {  public void windowClosing(WindowEvent e)
           {  System.exit(0);
           }
        } );
	}
}
