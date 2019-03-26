package translatorGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Button;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

public class GUI {

	private JFrame frmMenu;
	private JTextField inputtxtTranslatepan;
	private JTextField outputTextTranslatePan;
	private JTextField language1AddInput;
	private JTextField language2AddInput;
	private JTextField language1EditBox;
	private JTextField language2EditBox;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 833, 527);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmMenu.getContentPane().add(tabbedPane);
		
		JPanel transLatePanel = new JPanel();
		transLatePanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Translate a word or phrase", null, transLatePanel, null);
		transLatePanel.setLayout(null);
		String[] temp = new String[2];
		temp[0] = "ENglish";
		temp[1]="SPanish";
		JComboBox lang1addDropdown = new JComboBox(temp);
		lang1addDropdown.setBounds(112, 50, 162, 37);
		transLatePanel.add(lang1addDropdown);
		
		JComboBox lang2AddDropDown = new JComboBox();
		lang2AddDropDown.setBounds(564, 50, 162, 37);
		transLatePanel.add(lang2AddDropDown);
		
		inputtxtTranslatepan = new JTextField();
		inputtxtTranslatepan.setDragEnabled(true);
		inputtxtTranslatepan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = inputtxtTranslatepan.getText();
				
			}
		});
		inputtxtTranslatepan.setBounds(227, 117, 345, 107);
		transLatePanel.add(inputtxtTranslatepan);
		inputtxtTranslatepan.setColumns(10);
		
		outputTextTranslatePan = new JTextField();
		outputTextTranslatePan.setEditable(false);
		outputTextTranslatePan.setColumns(10);
		outputTextTranslatePan.setBounds(227, 269, 345, 107);
		transLatePanel.add(outputTextTranslatePan);
		
		JLabel lblNewLabel = new JLabel("Language 1");
		lblNewLabel.setBounds(15, 50, 82, 37);
		transLatePanel.add(lblNewLabel);
		
		JLabel lblLanguage = new JLabel("Language 2");
		lblLanguage.setBounds(458, 50, 82, 37);
		transLatePanel.add(lblLanguage);
		
		JLabel lblLanguageInput = new JLabel("Language 1 Input");
		lblLanguageInput.setBounds(74, 141, 138, 58);
		transLatePanel.add(lblLanguageInput);
		
		JLabel lblLanguageOutput = new JLabel("Language 2 Output");
		lblLanguageOutput.setBounds(74, 293, 138, 58);
		transLatePanel.add(lblLanguageOutput);
		
		JButton translateBtn = new JButton("Translate");
		translateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		translateBtn.setBounds(611, 156, 115, 29);
		transLatePanel.add(translateBtn);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Translate a file", null, panel, null);
		panel.setLayout(null);
		
		JComboBox comboBox_1 = new JComboBox(new Object[]{});
		comboBox_1.setBounds(112, 73, 162, 37);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(new Object[]{});
		comboBox_2.setBounds(548, 73, 162, 37);
		panel.add(comboBox_2);
		
		textField = new JTextField();
		textField.setBounds(251, 131, 306, 37);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		textArea.setBounds(97, 208, 613, 190);
		panel.add(textArea);
		
		JLabel label_7 = new JLabel("Language 1");
		label_7.setBounds(15, 73, 82, 37);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Language 2");
		label_8.setBounds(451, 73, 82, 37);
		panel.add(label_8);
		
		JLabel lblPleaseEntherThe = new JLabel("Please enter the file path");
		lblPleaseEntherThe.setBounds(25, 131, 194, 37);
		panel.add(lblPleaseEntherThe);
		
		JButton btnT = new JButton("Translate");
		btnT.setBounds(603, 139, 115, 29);
		panel.add(btnT);
		
		JPanel addPanel = new JPanel();
		addPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Add", null, addPanel, null);
		addPanel.setLayout(null);
		
		JComboBox AddComboBox1 = new JComboBox();
		AddComboBox1.setBounds(109, 62, 162, 37);
		addPanel.add(AddComboBox1);
		
		JComboBox addComboBox2 = new JComboBox();
		addComboBox2.setBounds(571, 62, 162, 37);
		addPanel.add(addComboBox2);
		
		language1AddInput = new JTextField();
		language1AddInput.setColumns(10);
		language1AddInput.setBounds(223, 135, 345, 107);
		addPanel.add(language1AddInput);
		
		language2AddInput = new JTextField();
		language2AddInput.setColumns(10);
		language2AddInput.setBounds(223, 265, 345, 107);
		addPanel.add(language2AddInput);
		
		JLabel label = new JLabel("Language 1");
		label.setBounds(15, 62, 82, 37);
		addPanel.add(label);
		
		JLabel label_1 = new JLabel("Language 2");
		label_1.setBounds(466, 62, 82, 37);
		addPanel.add(label_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(335, 388, 115, 29);
		addPanel.add(btnAdd);
		
		JLabel label_4 = new JLabel("Language 1");
		label_4.setBounds(62, 178, 82, 37);
		addPanel.add(label_4);
		
		JLabel label_5 = new JLabel("Language 2");
		label_5.setBounds(62, 308, 82, 37);
		addPanel.add(label_5);
		
		JPanel editPanel = new JPanel();
		editPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Edit", null, editPanel, null);
		editPanel.setLayout(null);
		
		JComboBox editSearch = new JComboBox();
		editSearch.setEditable(true);
		editSearch.setBounds(289, 126, 203, 47);
		editPanel.add(editSearch);
		
		JComboBox editLang1 = new JComboBox();
		editLang1.setBounds(104, 64, 162, 37);
		editPanel.add(editLang1);
		
		JComboBox editLang2 = new JComboBox();
		editLang2.setBounds(552, 64, 162, 37);
		editPanel.add(editLang2);
		
		JButton button = new JButton("Edit");
		button.setBounds(331, 349, 115, 29);
		editPanel.add(button);
		
		language1EditBox = new JTextField();
		language1EditBox.setColumns(10);
		language1EditBox.setBounds(34, 203, 345, 107);
		editPanel.add(language1EditBox);
		
		language2EditBox = new JTextField();
		language2EditBox.setColumns(10);
		language2EditBox.setBounds(446, 203, 345, 107);
		editPanel.add(language2EditBox);
		
		JLabel label_2 = new JLabel("Language 1");
		label_2.setBounds(7, 64, 82, 37);
		editPanel.add(label_2);
		
		JLabel label_3 = new JLabel("Language 2");
		label_3.setBounds(455, 64, 82, 37);
		editPanel.add(label_3);
		
		JLabel lblWordphraseSearch = new JLabel("Word/Phrase search");
		lblWordphraseSearch.setBounds(118, 131, 156, 37);
		editPanel.add(lblWordphraseSearch);
		
		JPanel deletePanel = new JPanel();
		deletePanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Delete", null, deletePanel, null);
		deletePanel.setLayout(null);
		
		JComboBox language1DeleteSearch = new JComboBox();
		language1DeleteSearch.setEditable(true);
		language1DeleteSearch.setBounds(113, 72, 203, 47);
		deletePanel.add(language1DeleteSearch);
		
		JComboBox language2DeleteSearch = new JComboBox();
		language2DeleteSearch.setEditable(true);
		language2DeleteSearch.setBounds(493, 72, 203, 47);
		deletePanel.add(language2DeleteSearch);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(289, 188, 241, 47);
		deletePanel.add(comboBox);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(340, 318, 115, 29);
		deletePanel.add(btnDelete);
		
		JLabel label_6 = new JLabel("Language 1");
		label_6.setBounds(16, 82, 82, 37);
		deletePanel.add(label_6);
		
		JLabel lblLanguage_1 = new JLabel("Language 2");
		lblLanguage_1.setBounds(393, 82, 82, 37);
		deletePanel.add(lblLanguage_1);
		
		JLabel lblPleaseSelectThe = new JLabel("<html>Please Select the word/phrase <br> you would like to delete");
		lblPleaseSelectThe.setBounds(58, 180, 216, 83);
		deletePanel.add(lblPleaseSelectThe);
	}
}
