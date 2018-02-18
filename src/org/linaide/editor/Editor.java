package org.linaide.editor;

import org.fife.ui.rsyntaxtextarea.*;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;

public class Editor extends JPanel {

	private RSyntaxTextArea ta;

	public static final int TYPE_NEW_FILE = 0;
	public static final int TYPE_NEW_CLASS = 1;
	public static final int TYPE_NEW_INTERFACE = 2;
	public static final int TYPE_NEW_ENUM = 3;

	public Editor() {
		ta = new RSyntaxTextArea(25, 80);
		ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		RTextScrollPane rtsp = new RTextScrollPane(ta);
		add(rtsp);
	}

	public void save(String fileName) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		bw.write(ta.getText());
		bw.close();
	}

	public void read(String fileName) throws IOException {
		ta.setText(String.join("\n", Files.readAllLines(new File(fileName).toPath())));
	}

	public void _new(int type) {
		switch (type) {
			case TYPE_NEW_FILE: ta.setText(""); break;
			case TYPE_NEW_CLASS:
				ta.setText("public class  {\n" +
						   "}");
				ta.setCaretPosition(13);
				break;
			case TYPE_NEW_INTERFACE:
				ta.setText("public interface  {\n" +
						"}");
				ta.setCaretPosition(17);
				break;
			case TYPE_NEW_ENUM:
				ta.setText("public enum  {\n" +
						"}");
				ta.setCaretPosition(12);
				break;
			default: throw new IllegalArgumentException("type");
		}
	}

	public static void main(String[] args) {
		new Editor();
	}
}
