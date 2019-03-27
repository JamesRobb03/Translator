
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
import java.awt.ComponentOrientation;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class GUI {

	Menu gibberish = new Menu();
	public String translateInput = "hello world";
	private JFrame frmMenu;
	private JTextField language1AddInput;
	private JTextField language2AddInput;
	private JTextField language1EditBox;
	private JTextField language2EditBox;
	private JTextField filepathIn;

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
		frmMenu.setTitle("Translator");
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
		temp[0] = "English";
		temp[1] = "Spanish";
		JComboBox lang1addDropdown = new JComboBox(temp);
		lang1addDropdown.setBounds(112, 50, 162, 37);
		transLatePanel.add(lang1addDropdown);
		temp[0] = "Spanish";
		temp[1] ="English";
		JComboBox lang2AddDropDown = new JComboBox(temp);
		lang2AddDropDown.setBounds(564, 50, 162, 37);
		transLatePanel.add(lang2AddDropDown);
		
		
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
		JTextArea outputTextTranslatePan = new JTextArea();
		outputTextTranslatePan.setLineWrap(true);
		outputTextTranslatePan.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		outputTextTranslatePan.setBounds(227, 243, 345, 108);
		transLatePanel.add(outputTextTranslatePan);
		
		JTextArea inputtxtTranslatepan = new JTextArea();
		inputtxtTranslatepan.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		inputtxtTranslatepan.setLineWrap(true);
		inputtxtTranslatepan.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
			}
		});
		inputtxtTranslatepan.setBackground(Color.WHITE);
		inputtxtTranslatepan.setBounds(227, 120, 345, 107);
		transLatePanel.add(inputtxtTranslatepan);
		
		JButton translateBtn = new JButton("Translate");
		translateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gibberish.init();
				if((lang1addDropdown.getSelectedItem().toString().equals("English")&&
						(lang2AddDropDown.getSelectedItem().toString().equals("Spanish")))) 
				{
				//gibberish.runTest(inputtxtTranslatepan.getText());
				outputTextTranslatePan.setText(gibberish.englishToSpanish(inputtxtTranslatepan.getText()));
				}
				else if((lang1addDropdown.getSelectedItem().equals("Spanish")&&(lang2AddDropDown.getSelectedItem().equals("English"))))
				{
			    outputTextTranslatePan.setText(gibberish.spanishToEnglish(inputtxtTranslatepan.getText()));
				}
				
			}
		});
		translateBtn.setBounds(611, 156, 115, 29);
		transLatePanel.add(translateBtn);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Translate a file", null, panel, null);
		panel.setLayout(null);
		JLabel speedyBoi = new JLabel("");
		speedyBoi.setBounds(47, 16, 269, 20);
		panel.add(speedyBoi);
		JComboBox comboBox_1 = new JComboBox(temp);
		comboBox_1.setBounds(112, 73, 162, 37);
		panel.add(comboBox_1);
		JComboBox comboBox_2 = new JComboBox(temp);
		comboBox_2.setBounds(548, 73, 162, 37);
		panel.add(comboBox_2);
		
		filepathIn = new JTextField();
		filepathIn.setBounds(251, 131, 306, 37);
		panel.add(filepathIn);
		filepathIn.setColumns(10);
		
		JTextArea fileTxtArea = new JTextArea();
		fileTxtArea.setAutoscrolls(false);
		fileTxtArea.setLineWrap(true);
		fileTxtArea.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		fileTxtArea.setBounds(83, 193, 649, 213);
		panel.add(fileTxtArea);
		
		JLabel label_7 = new JLabel("Language 1");
		label_7.setBounds(15, 73, 82, 37);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Language 2");
		label_8.setBounds(451, 73, 82, 37);
		panel.add(label_8);
		JLabel lblPleaseEntherThe = new JLabel("Please enter the file path");
		lblPleaseEntherThe.setBounds(25, 131, 194, 37);
		panel.add(lblPleaseEntherThe);
		
		JButton filePAthbtn = new JButton("Translate");
		filePAthbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gibberish.init();
				gibberish.englishToSpanish("hello");
				gibberish.spanishToEnglish("hola");
				if((comboBox_1.getSelectedItem().toString().equals("English")&&
						(comboBox_2.getSelectedItem().toString().equals("Spanish")))) 
				{
				//gibberish.runTest(inputtxtTranslatepan.getText());
					
					double startTime = System.nanoTime();
					String tempVal = gibberish.readFile(filepathIn.getText(),"english");
					double amountOfWords = gibberish.howManyWords(tempVal);
					fileTxtArea.setText(tempVal);
					double endTime = System.nanoTime();
					double duration = (endTime - startTime)/1000000;
					duration = duration/1000;
					System.out.println(amountOfWords + " " +duration);
					double wps = amountOfWords / duration;
					String roundWps = String.format("%.2f", wps);
					speedyBoi.setText("Words per second:"+roundWps);
					//fileTxtArea.setText(gibberish.readFile(filepathIn.getText(),"english"));
				}
				else if((comboBox_1.getSelectedItem().equals("Spanish")&&(comboBox_2.getSelectedItem().equals("English"))))
				{
				fileTxtArea.setText(gibberish.readFile(filepathIn.getText(),"spanish"));
			}
			}
		});	
		filePAthbtn.setBounds(603, 139, 115, 29);
		panel.add(filePAthbtn);
		
		JScrollPane scrollPane = new JScrollPane(fileTxtArea);
		scrollPane.setBounds(83, 193, 649, 213);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
		
		
		
		JPanel addPanel = new JPanel();
		addPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Add", null, addPanel, null);
		addPanel.setLayout(null);
		temp[0] = "English";
		temp[1] = "Spanish";
		JComboBox AddComboBox1 = new JComboBox(temp);
		AddComboBox1.setBounds(109, 62, 162, 37);
		addPanel.add(AddComboBox1);
		temp[0] = "Spanish";
		temp[1] = "English";
		JComboBox addComboBox2 = new JComboBox(temp);
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
		btnAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				gibberish.addToFile(language1AddInput.getText(), language2AddInput.getText());
			}
		});
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
		temp[0] = "English";
		temp[1] = "Spanish";
		temp[1] = "English";
		temp[0] = "Spanish";
			}	
}
		
