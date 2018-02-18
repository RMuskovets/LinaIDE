/*
 * Created by JFormDesigner on Sat Feb 17 19:52:23 EET 2018
 */

package org.linaide.ui;

import java.awt.event.*;
import org.linaide.cviewer.Viewer;
import org.linaide.editor.Editor;
import org.linaide.tree.FileTree;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.*;

/**
 * @author unknown
 */
public class LIDEui extends JPanel {

	private File aaa;

	public static File chooseFile(String title) {
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle(title);
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jfc.showOpenDialog(null);
		return jfc.getCurrentDirectory();
	}

	public LIDEui() {
		aaa = chooseFile("Enter path of the project");
		initComponents();
		editor = new Editor();
		add(editor, "Center");
		editor.setSize(575, 375);
		for (PropertyChangeListener pcl : getPropertyChangeListeners())
			removePropertyChangeListener(pcl);
		setBorder(null);
		setFocusable(true);
	}

	private void newFile(ActionEvent e) {
		((Editor) editor)._new(Editor.TYPE_NEW_FILE);
	}

	private void newClass(ActionEvent e) {
		((Editor) editor)._new(Editor.TYPE_NEW_CLASS);
	}

	private void newEnum(ActionEvent e) {
		((Editor) editor)._new(Editor.TYPE_NEW_ENUM);
	}

	private void newInterface(ActionEvent e) {
		((Editor) editor)._new(Editor.TYPE_NEW_INTERFACE);
	}

	private void keyRel(KeyEvent e) {
		if (e.isShiftDown() && e.isControlDown()) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_N: newFile(null); break;
				case KeyEvent.VK_C: newClass(null);break;
				case KeyEvent.VK_E: newEnum(null); break;
				case KeyEvent.VK_I: newInterface(null); break;
			}
		}
		if (e.isAltDown() || e.isAltGraphDown()) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_S: structView(); break;
				case KeyEvent.VK_T: right = new FileTree(aaa);
									add(right, "West"); break;
			}
		}
	}

	private void structView() {
		try {
			Class c = Class.forName(JOptionPane.showInputDialog("Name of the found class"));
			right = new Viewer(c);
			add(right, "West");
		} catch (ClassNotFoundException e) {
		}
	}

	private void structview(ActionEvent e) {
		structView();
	}

	private void treeView(ActionEvent e) {
		right = new FileTree(aaa);
		add(right, "West");
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - roma muj
		right = new JPanel();
		editor = new JPanel();
		menuBar1 = new JMenuBar();
		file = new JMenu();
		_new = new JMenu();
		newFile = new JMenuItem();
		clazz = new JMenuItem();
		enuum = new JMenuItem();
		interfaze = new JMenuItem();
		view = new JMenu();
		structView = new JMenuItem();
		treeView = new JMenuItem();

		//======== this ========
		setMinimumSize(new Dimension(600, 400));
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				keyRel(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				keyRel(e);
			}
		});

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

		setLayout(new BorderLayout());
		add(right, BorderLayout.WEST);
		add(editor, BorderLayout.CENTER);

		//======== menuBar1 ========
		{

			//======== file ========
			{
				file.setText("File");

				//======== _new ========
				{
					_new.setText("New");

					//---- newFile ----
					newFile.setText("File");
					newFile.addActionListener(e -> newFile(e));
					_new.add(newFile);

					//---- clazz ----
					clazz.setText("Class");
					clazz.addActionListener(e -> newClass(e));
					_new.add(clazz);

					//---- enuum ----
					enuum.setText("Enum");
					enuum.addActionListener(e -> newEnum(e));
					_new.add(enuum);

					//---- interfaze ----
					interfaze.setText("Interface");
					interfaze.addActionListener(e -> newInterface(e));
					_new.add(interfaze);
				}
				file.add(_new);
			}
			menuBar1.add(file);

			//======== view ========
			{
				view.setText("View");

				//---- structView ----
				structView.setText("Structure View");
				structView.addActionListener(e -> structview(e));
				view.add(structView);

				//---- treeView ----
				treeView.setText("Tree View");
				treeView.addActionListener(e -> treeView(e));
				view.add(treeView);
			}
			menuBar1.add(view);
		}
		add(menuBar1, BorderLayout.NORTH);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - roma muj
	private JPanel right;
	private JPanel editor;
	private JMenuBar menuBar1;
	private JMenu file;
	private JMenu _new;
	private JMenuItem newFile;
	private JMenuItem clazz;
	private JMenuItem enuum;
	private JMenuItem interfaze;
	private JMenu view;
	private JMenuItem structView;
	private JMenuItem treeView;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
