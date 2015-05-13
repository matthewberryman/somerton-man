//The GUI for the Rubaiyat Matcher - Peter Varsos 2013


package Current;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;

public class Gui extends JFrame
{
	public static boolean debug = false;
	
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;
	
	
	private JLabel keyL, codeL, decL, otpL, flL, otherL, keywL;
	private JTextField keyTF, codeTF, decTF, keywTF; 
	private JButton FormatB, FirstLetterB, loadKeyB, loadCodeB, loadB,
					loadDecB, matchB,pmatchB,wmatchB,freqB,decB,serB,sB,matchfB,
					linlenB;
	private JMenuBar menubar;
	private static JTextArea textA;
	
	//Button handlers:
	private FormatButtonHandler fbHandler;
	private FirstLetterButtonHandler cbHandler;
	private ExitButtonHandler ebHandler;
	private LoadKeyHandler lkHandler;
	private LoadCodeHandler lcHandler;
	private LoadDecHandler ldHandler;
	private MatchButtonHandler mbHandler;
	private pMatchButtonHandler pmbHandler;
	private wMatchButtonHandler wmbHandler;
	private ResetButtonHandler rbHandler;
	private FreqButtonHandler freqHandler;
	private DecButtonHandler decHandler;
	private SerButtonHandler serHandler;
	private DebugButtonHandler dbHandler;
	private LoadButtonHandler lbHandler;
	private ShortListButtonHandler sHandler;
	private MatchFreqButtonHandler mfHandler;
	private LineLengthButtonHandler llHandler;
	private JScrollPane line1;
	
	public Gui()
	{
		keyL = new JLabel("Key Filename: ", SwingConstants.LEFT);
		codeL = new JLabel("Code Filename: ", SwingConstants.LEFT);
		decL = new JLabel("Decrypt Filename: ", SwingConstants.LEFT);
		keywL = new JLabel("Keyword to Search Decrypts: ", SwingConstants.LEFT);
		otpL = new JLabel("One Time Pad Tools", SwingConstants.CENTER);
		flL = new JLabel("Matching Tools", SwingConstants.CENTER);
		otherL = new JLabel("Misc Tools", SwingConstants.CENTER);
		
		
		keyTF = new JTextField(10);
		codeTF = new JTextField(10);
		decTF = new JTextField(10);
		keywTF = new JTextField(10);
		textA = new JTextArea(200,55);
		
		//Handlers + Action Listeners
		FormatB = new JButton("Format Texts");
		fbHandler = new FormatButtonHandler();
		FormatB.addActionListener(fbHandler);
		loadKeyB = new JButton("Open Key Text File");
		lkHandler = new LoadKeyHandler();
		loadKeyB.addActionListener(lkHandler);
		loadCodeB = new JButton("Open Code Text File");
		lcHandler = new LoadCodeHandler();
		loadCodeB.addActionListener(lcHandler);
		loadDecB = new JButton("Open Decrypts Text File");
		ldHandler = new LoadDecHandler();
		loadDecB.addActionListener(ldHandler);
		FirstLetterB = new JButton("Take First Letters of Key");
		cbHandler = new FirstLetterButtonHandler();
		FirstLetterB.addActionListener(cbHandler);	
		matchB = new JButton("Match");
		mbHandler = new MatchButtonHandler();
		matchB.addActionListener(mbHandler);
		pmatchB = new JButton("Partial Match");
		pmbHandler = new pMatchButtonHandler();
		pmatchB.addActionListener(pmbHandler);
		wmatchB = new JButton("Wildcard Match");
		wmbHandler = new wMatchButtonHandler();
		wmatchB.addActionListener(wmbHandler);
		freqB = new JButton("Frequency Analysis");
		freqHandler = new FreqButtonHandler();
		freqB.addActionListener(freqHandler);
		decB = new JButton("Get Decrypts");
		decHandler = new DecButtonHandler();
		decB.addActionListener(decHandler);
		serB = new JButton("Search Decrypts");
		serHandler = new SerButtonHandler();
		serB.addActionListener(serHandler);
		loadB = new JButton("Load Text Documents");
		lbHandler = new LoadButtonHandler();
		loadB.addActionListener(lbHandler);
		sB = new JButton("Create a Shortlist");
		sHandler = new ShortListButtonHandler();
		sB.addActionListener(sHandler);
		matchfB = new JButton("Match Frequency");
		mfHandler = new MatchFreqButtonHandler();
		matchfB.addActionListener(mfHandler);
		linlenB = new JButton("Line Length Freq");
		llHandler = new LineLengthButtonHandler();
		linlenB.addActionListener(llHandler);
		
		menubar = new JMenuBar(); 
		JMenu file = new JMenu("File");
		ebHandler = new ExitButtonHandler();
		rbHandler = new ResetButtonHandler();
		dbHandler = new DebugButtonHandler();
		
		//menu
		JMenuItem eMenuItem = new JMenuItem("Exit");
		eMenuItem.setToolTipText("Exit application");
		eMenuItem.addActionListener(ebHandler);
		JMenuItem fMenuItem = new JMenuItem("Reset");
		fMenuItem.setToolTipText("Resets the Fields to Default");
		fMenuItem.addActionListener(rbHandler);
		JMenuItem gMenuItem = new JMenuItem("Toggle Debug Mode");
		gMenuItem.setToolTipText("Turns on/off Debug mode, giving extra output");
		gMenuItem.addActionListener(dbHandler);
		
		//container
		setTitle("Decoding Toolkit v1.3");
		Container pane = getContentPane();
		
		
		//File Menu
		file.add(gMenuItem);
		file.add(fMenuItem);
		file.add(eMenuItem);
	
		menubar.add(file);
        setJMenuBar(menubar);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		
        
        
        
      //Add Buttons to Frames
        
        
        //Console for text
       
        line1 = new JScrollPane(textA);
    	textA.setEditable(false); 	
        	
        	
        JPanel line2 = new JPanel();       
        	line2.add(loadB);
        	
        JPanel line3 = new JPanel();	
			line3.add(keyL);
			line3.add(keyTF);
			line3.add(loadKeyB);
			keyTF.setText("Config Files/RPT.txt");
		
		JPanel line4 = new JPanel();       
        	line4.add(codeL);
        	line4.add(codeTF);
        	line4.add(loadCodeB);
        	codeTF.setText("Config Files/MSG.txt");
		
        JPanel line5 = new JPanel();       
        	line5.add(decL);
        	line5.add(decTF);
        	line5.add(loadDecB);
        	decTF.setText("Config Files/DEC.txt");
        	
        JPanel line6 = new JPanel();
       // 	line6.add(keywL);
    	   	line6.add(keywTF);
        	keywTF.setText("Search Here");
			line6.add(serB);
		
        JPanel line7 = new JPanel();
			line7.add(otherL);
			line7.add(FormatB);
			line7.add(FirstLetterB);
			line7.add(freqB);
		
		//matching

		JPanel line8 = new JPanel();	
			line8.add(flL);
			line8.add(matchB);
			line8.add(pmatchB);
			line8.add(wmatchB);
			line8.add(matchfB);
			line8.add(linlenB);

		//otp
		
		JPanel line9 = new JPanel();	
			line9.add(otpL);
			line9.add(decB);
			line9.add(sB);
		
		//place lines into pane
		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS)); 
		pane.add(line1, BorderLayout.NORTH);	
		pane.add(line2, BorderLayout.NORTH);	
		pane.add(line3, BorderLayout.NORTH);	
		pane.add(line4, BorderLayout.NORTH);	
		pane.add(line5, BorderLayout.NORTH);	
		pane.add(line7, BorderLayout.NORTH);	
		pane.add(line8, BorderLayout.NORTH);	
		pane.add(line9, BorderLayout.NORTH);	
		pane.add(line6, BorderLayout.NORTH);
		
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
public static void consolePrint(String s){
	textA.setText(s);	
		
		
	}

public static void consoleAppend(String s){
	textA.append("\n");
	textA.append(s);	
		
		
	}

	private class FirstLetterButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			
			letterMatcherDriver.keyFirstLetter();
			printStatus();

		}
	}
	
	

	private class FormatButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

		try {
			letterMatcherDriver.format();
		} catch (IOException e1) {
			consoleAppend("IOexeption");
		}
		
		}
	}
	
	private class LoadKeyHandler implements ActionListener

	{
		public void actionPerformed(ActionEvent e)
		{

			try {
				Runtime.getRuntime().exec("notepad "+letterMatcherDriver.in2);
			} catch (IOException e1) {
				consoleAppend("error loading, the document probably doesn't exist!");
			}

	
		}
	}
	
	private class LoadCodeHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			
			try {
				Runtime.getRuntime().exec("notepad "+letterMatcherDriver.in1);
			} catch (IOException e1) {
				consoleAppend("error loading, the document probably doesn't exist!");
			}



		}
	}
	
	private class LoadDecHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			try {
				Runtime.getRuntime().exec("notepad "+letterMatcherDriver.in3);
			} catch (IOException e1) {
				consoleAppend("error loading, the document probably doesn't exist!");
			}


		}
	}
	
	private class MatchButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			
			letterMatcherDriver.match(letterMatcherDriver.flkey, letterMatcherDriver.flcode);

		}
	}

	private class pMatchButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			
			letterMatcherDriver.partialMatch(letterMatcherDriver.flkey, letterMatcherDriver.flcode);

		}
	}
	
	private class wMatchButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			
			letterMatcherDriver.wildcardMatch(letterMatcherDriver.flkey, letterMatcherDriver.flcode);

		}
	}
		
	public static void printStatus(){
	letterMatcherDriver.printStatus();	
	}
	
	public class ExitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
	public class ResetButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			letterMatcherDriver.in1 = "Config Files/MSG.txt";
			letterMatcherDriver.in2 = "Config Files/RPT.txt";
			letterMatcherDriver.file = null;
			letterMatcherDriver.file2 = null;
			letterMatcherDriver.flcode = "";
			letterMatcherDriver.flkey = "";
			keyTF.setText("Config Files/RPT.txt");
			codeTF.setText("Config Files/MSG.txt");
			decTF.setText("Config Files/DEC.txt");
			keywTF.setText("Enter keyword to search OTP decrypts for here");
			letterMatcherDriver.keyBufferL();
			letterMatcherDriver.codeBufferL();
			letterMatcherDriver.makeString();
			
			printStatus();
			line1.getViewport().setViewPosition(new Point(0,0));
        	
			
		}
	}
	
	public class FreqButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			firstLetter.freqAnalysis();
		}
	}
	
	public class SerButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(debug){consoleAppend(keywTF.getText());}
			try {
				letterMatcherDriver.search(keywTF.getText());
				letterMatcherDriver.search2(keywTF.getText());
			} catch (IOException e1) {
				consoleAppend("i.o exeption while trying to search");
			}
		}
	}
	
	public class DecButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try {
				letterMatcherDriver.getDecrypts();
			} catch (IOException e1) {
				consoleAppend("Uh oh, something went wrong with I/O while generating decrypts!");
			}
		}
	}
	
	public class MatchFreqButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			letterMatcherDriver.matchFrequency();
		}
	}
	
	public class DebugButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			debug = !debug;
			consoleAppend("Debug Mode on: " + debug);
		}
	}
	
	public class ShortListButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(debug){consoleAppend(keywTF.getText());}
			try {
				letterMatcherDriver.search3(keywTF.getText());
			} catch (IOException e1) {
				consoleAppend("i.o exeption while trying to search");
			}
		}
	}
	
	public class LineLengthButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try {
				letterMatcherDriver.LineLength();
			} catch (IOException e1) {
				consoleAppend("I.o. Exeption while trying to find line lengths. Check that the files are in the correct place");
			}
		}
	}
	
	public class LoadButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			letterMatcherDriver.in2 = keyTF.getText();
			letterMatcherDriver.in1 = codeTF.getText();
			letterMatcherDriver.in3 = decTF.getText();
			letterMatcherDriver.keyBufferL();
			letterMatcherDriver.codeBufferL();
			letterMatcherDriver.decBufferL();
			letterMatcherDriver.makeString();
			letterMatcherDriver.printStatus();
			line1.getViewport().setViewPosition(new Point(0,0));
	}
	}
	
	public static void main(String[] args)
	{	
		
		Gui Window = new Gui();
		letterMatcherDriver.LetterMatcher();
		if(debug){consoleAppend("Debug Mode is set on default");};
		
	}
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
