package org.linaide.main;

import org.linaide.ui.LIDEui;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		JFrame jfr = new JFrame("Lina IDE 1.0");
		jfr.setContentPane(new LIDEui());
		jfr.setFocusable(true);
		jfr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jfr.setVisible(true);
		jfr.setSize(600, 400);
		jfr.setMinimumSize(jfr.getContentPane().getMinimumSize());
	}
}
