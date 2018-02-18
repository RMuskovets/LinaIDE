package org.linaide.cviewer;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Viewer extends JPanel {
	private static final String METHOD = "img/method.png";
	private static final String FIELD  = "img/field.png";
	private static final String CLASS  = "img/class.png";
	private static final String CONSTR = METHOD;

	public Viewer() {}

	public Viewer(Class c) {
		setSize(300, getHeight());
		Method[] declMet = c.getDeclaredMethods();
		Field[]  declFie = c.getDeclaredFields();
		Class[] declCla  = c.getDeclaredClasses();
		Constructor[] constr = c.getConstructors();
		Entry[] entries = new Entry[declMet.length + declFie.length + declCla.length + constr.length];
		for (int i = 0; i < declMet.length; i ++) {
			entries[i] = new Entry(declMet[i].getName(), METHOD);
		}
		for (int i = 0; i < declFie.length; i ++) {
			entries[i+declMet.length] = new Entry(declFie[i].getName(), FIELD);
		}
		for (int i = 0; i < declCla.length; i ++) {
			entries[i+declMet.length+declFie.length] = new Entry(declCla[i].getName(), CLASS);
		}
		for (int i = 0; i < constr.length; i ++) {
			entries[i+declMet.length+declFie.length + declCla.length] = new Entry(constr[i].getName(), CONSTR);
		}
		JList list = new JList(entries);
		list.setCellRenderer(new Renderer());
		list.setVisibleRowCount(4);
		JScrollPane pane = new JScrollPane(list);
		add(pane);
	}

	public void setClass(Class c) {
		remove(0);
		add(new Viewer(c));
	}
}
