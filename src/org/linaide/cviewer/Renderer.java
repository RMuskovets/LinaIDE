package org.linaide.cviewer;

import javax.swing.*;
import java.awt.*;

public class Renderer extends JLabel implements ListCellRenderer {

	public Renderer() {
		setOpaque(true);
		setIconTextGap(12);
	}

	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

	public Component getListCellRendererComponent(JList list, Object value,
	                                              int index, boolean isSelected, boolean cellHasFocus) {
		Entry entry = (Entry) value;
		setText(entry.getTitle());
		setIcon(entry.getImage());
		if (isSelected) {
			setBackground(HIGHLIGHT_COLOR);
			setForeground(Color.white);
		} else {
			setBackground(Color.white);
			setForeground(Color.black);
		}
		return this;
	}
}
