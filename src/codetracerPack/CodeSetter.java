package codetracerPack;

import javax.swing.*;

public class CodeSetter {
	private static int _C = 0;
	private static int _D = 2;
	private static int _E = 4;
	private static int _F = 5;
	private static int _G = 7;
	private static int _A = 9;
	private static int _B = 11;
	
	private static char sharp = '#';
	private static char flat = 'b';
	private static String _7code = "7";
	private static String m7code = "-7";
	private static String M7code = "M7";
	private static String dim7code = "dim7";
	
	int noteR, note3, note5, note7;
	int index = 0;
	JTextField node = null;
	
	public CodeSetter(JTextField newnode) {
		node = newnode;
	}
	
	public int setRoot() {
		
		String Code = node.getText();
		
		if (Code.charAt(index) == 'C')
        {
			noteR = _C;
        }
		if (Code.charAt(index) == 'D')
        {
			noteR = _D;
        }
		if (Code.charAt(index) == 'E')
        {
			noteR = _E;
        }
		if (Code.charAt(index) == 'F')
        {
			noteR = _F;
        }
		if (Code.charAt(index) == 'G')
        {
			noteR = _G;
        }
		if (Code.charAt(index) == 'A')
        {
			noteR = _A;
        }
		if (Code.charAt(index) == 'B')
        {
			noteR = _B;
        }
        if (Code.charAt(index+1)==sharp)
        {
        	index++;
            noteR++;
        }
        if (Code.charAt(index+1)==flat)
        {
        	index++;
            noteR--;
        }
        if(noteR < 0) noteR = noteR + 12; 
        //harmonizer()
		return noteR;
	}
	
	public void harmonizer(String codeName, int rootNote) {
		note3 = (rootNote + 4) % 12;
        note5 = (rootNote + 7) % 12;
        note7 = 13;
        if(codeName.indexOf(m7code)==index+1) {
        	note3 = (rootNote + 3) % 12;
            note7 = (rootNote + 10) % 12;
		}
        if(codeName.indexOf(M7code)==index+1) {
            note7 = (rootNote + 11) % 12;
		}
		if(codeName.indexOf(_7code)==index+1) {
			note3 = (rootNote + 4) % 12;
            note5 = (rootNote + 7) % 12;
            note7 = (rootNote + 10) % 12;
		}
		if(codeName.indexOf(dim7code)==index+1) {
			note3 = (rootNote + 3) % 12;
            note5 = (rootNote + 6) % 12;
            note7 = (rootNote + 9) % 12;
		}
		return;
	}
}
