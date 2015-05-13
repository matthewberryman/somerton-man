//Letter Matcher - Peter Varsos - April 2013



package Current;

import java.io.*;


public class letterMatcherDriver
{
	
	//an OS neutral endline is needed so bufferd output works on unix too =3
	static String EL = System.getProperty("line.separator"); 
	
	
	//Changing this will change where the two bufferL methods get their text from.
	static String in1 = "Config Files/MSG.txt";
	static String in2 = "Config Files/RPT.txt";
	static String in3 = "Config Files/DEC.txt";
	
	static BufferedReader file = null;
	static BufferedReader file2 = null;
	static BufferedReader file3 = null;
	
	//These two strings contain the final version of whatever we will be parsing.
	static String flcode = "";
	static String flkey = "";

	//Output Stream Declaration
	static BufferedOutputStream bufferedOutput = null;
	
	public static void LetterMatcher()
	{
			
	
		//Reads the file into buffer readers, then makes it into a string.
		//All handling is done with the string from then on. These are recalled in the
		//sub methods if a new file is loaded.
		
		keyBufferL();
		codeBufferL();
		decBufferL(); 
		makeString();
		printStatus();
	}
	
	public static void keyBufferL(){
		try {			//load in Config Files/RPT.txt into file2
			file2 = new BufferedReader(new FileReader(in2));
		} catch (FileNotFoundException e) {
			Gui.consoleAppend("Error: Key file: "+in2+" not found.");
			
		}	
	
	}
	
	public static void codeBufferL(){
		try {			//load in Config Files/MSG.txt into file
			file = new BufferedReader(new FileReader(in1));
		} catch (FileNotFoundException e) {
			Gui.consoleAppend("Error: Code file: "+in1+" not found.");;
		
		}		
	
	}
	
	public static void decBufferL(){
		try {			//load in Config Files/DEC.txt into file
			file3 = new BufferedReader(new FileReader(in3));
		} catch (FileNotFoundException e) {
			Gui.consoleAppend("Error: Code file: "+in3+" not found.");;
		
		}		
		
		
	}

	public static void keyFirstLetter(){
	
		
		
		try {	
			flkey = firstLetter.takeFirstLetters(flkey);
		} catch (java.lang.StringIndexOutOfBoundsException e) {
			Gui.consoleAppend("Error! Make sure the key file does not contain empty lines, spaces at the end of lines, or inverted commas. Try running the format text function! ");
			} catch (IOException e) {
			Gui.consoleAppend("Error - I.O. exeption!");
		}
		
		}
		
	public static void codeFirstLetter(){
				
			try {
				flcode = firstLetter.takeFirstLetters(flcode);
			} catch (IOException e) {
				Gui.consoleAppend("error! IO exeption");
			}
		
	}
	
	public static void makeString(){

	
		try {	
			flcode = firstLetter.toString(file);
		} catch (IOException e) {

			Gui.consoleAppend("Error: Sorting code failed! ");
			System.exit(0);	}
		
		try {	
			flkey = firstLetter.toString(file2);
		} catch (IOException e) {

			Gui.consoleAppend("Error:Sorting key failed! ");
			System.exit(0);	}
		
		
		
	}
	
	public static void format() throws IOException{
	
		BufferedOutputStream RPTOut = null;
		RPTOut = new BufferedOutputStream(new FileOutputStream("Config Files/RPT.txt"));
		BufferedOutputStream MSGOut = null;
		MSGOut = new BufferedOutputStream(new FileOutputStream("Config Files/MSG.txt"));
		
		
		
		flkey = firstLetter.format(flkey);
		flcode = firstLetter.format(flcode);
	
		RPTOut.write(flkey.getBytes());
		MSGOut.write(flcode.getBytes());
	

		RPTOut.flush();
		RPTOut.close();	
		MSGOut.flush();
		MSGOut.close();	
		keyBufferL();
		codeBufferL();
		printStatus();
		Runtime.getRuntime().exec("notepad "+"MSG");	
		Runtime.getRuntime().exec("notepad "+"RPT");	
		
	}
	
	public static void match(String flkey, String flcode){
		//check for complete matches
		boolean matchFound;

		
		Gui.consoleAppend("Looking for exact matches: ");
		
		matchFound = flkey.contains(flcode);
		if(matchFound){Gui.consoleAppend("Found!: "+flcode);}else
		{Gui.consoleAppend("No Exact Match");};
		
	}

	public static void partialMatch(String flkey, String flcode){
		//check for partial matches. Iterates through the code and takes every substring possible, checks it.
		String temp = "";
		boolean matches = false;
		
		Gui.consoleAppend("Looking for partial matches above 3 letters long:");
		
		 for(int c=0;c<flcode.length();c++)
	      {
	         for(int i=0;i<=flcode.length()-c-1;i++)
	         {
	            temp = flcode.substring(c, c+i);
	            if(flkey.contains(temp)&&temp.length()>2){Gui.consoleAppend(temp); matches = true;
	         }
	      }
		}
		 if(!matches){Gui.consoleAppend("No Partial Matches Found");};
	}

	public static void wildcardMatch(String flkey, String flcode){
		//removes each letter iteratively and checks the two halves for matches
		
		Gui.consoleAppend("Looking for matches with each letter as a wildcard");
		
		boolean matches = false;
		String temp1 = "";
		String temp2 = "";
		
		for(int i=0;i<flcode.length();i++){
			if(i-1>=1 &&i+1<=flcode.length()){
				temp1 = flcode.substring(0,i-1);
				temp2 = flcode.substring(i);
					if(flkey.contains(temp1)&&temp1.length()>2){Gui.consoleAppend(temp1); matches = true;}
					if(flkey.contains(temp2)&&temp2.length()>2){Gui.consoleAppend(temp2); matches = true;}
				}
			}
		if(!matches){Gui.consoleAppend("No Wildcard Matches Found");};
		}
	
	
	
	public static void matchFrequency(){
	int total = 0;
	int freq[] = getMatchFreqArray(flkey,flcode);	
	
	
	
		if(!Gui.debug){
			Gui.consoleAppend("Match Frequency Array: " );
				for(int i=0;i<freq.length;i++)
				{Gui.consoleAppend(freq[i]+" ");};
			Gui.consoleAppend("");
	
		}
	
	}
	
	
	//returns an array of relative frequency of matches. index 0 contains the matches of string
	//of minmatch length. Index i is the max length of the code string.
	public static int[] getMatchFreqArray(String flkey, String flcode){


		int minmatch = 2; //the smallest length of WORD searched for. (how long the word searched for is)
		
		int maxarraylen =flcode.length()-minmatch;	//the length of the ARRAY of matches searched for. (how MANY letter matches)
		
		
		double[] relfreq = new double[maxarraylen];
		String temp = "";
		int results[] = new int[maxarraylen];
		int total =0;
		
		//get absolute frequencies
		 for(int c=0;c<flcode.length();c++)
	      {
	         for(int i=0;i<=flcode.length()-c-1;i++)
	         {
	            temp = flcode.substring(c, c+i);
	            if(flkey.contains(temp)&&temp.length()>=minmatch){
	            	
	            	
	            	
	            	if(Gui.debug){Gui.consoleAppend(temp+" ");}
	            	results[temp.length()-minmatch]++;	//-min because length min strings in 0th index
	            
	            }
	         }
	      }
		 
		 //total
		 if(Gui.debug){Gui.consoleAppend("Finding Matches with a min length of "+minmatch);}
		 for(int i = 0; i < maxarraylen; i += 1) {total = total + results[i];};
		 if(total == 0){Gui.consoleAppend("No matches above "+minmatch+" have been found!");};
		 
			//Calculate relative frequencies
			for(int i = 0; i < maxarraylen&&total!=0; i++) {   //total !=0 to prevent divide by zero if no matches presents
				relfreq[i] = 100*results[i]/total;
				
			}
			if(Gui.debug&&total!=0){Gui.consoleAppend("abs frequencies: ");};
			if(Gui.debug&&total!=0){for(int j=0;j<maxarraylen;j++){Gui.consoleAppend(results[j]+" ");};Gui.consoleAppend("");}
			if(Gui.debug&&total!=0){Gui.consoleAppend("relative frequencies: ");};
			if(Gui.debug&&total!=0){for(int i=0;i<relfreq.length;i++){Gui.consoleAppend(relfreq[i]+" ");};Gui.consoleAppend("");}
				
			
		 return results;
		 //return reflreq;
	}
	
	
	public static void LineLength() throws IOException{
		int maxlen = 15; //change if you want to support lines of a larget size
		keyBufferL();
		String s = file2.readLine();
		int length = 0;
		int[] lenArray = new int[maxlen];
		
		while(s!=null){
			
			length = firstLetter.countWords(s);
			lenArray[length]++;
			
			
			s=file2.readLine();
		}
		for(int i=0;i<maxlen;i++){Gui.consoleAppend(Integer.toString(lenArray[i]));}
		
		
		
	}
	
	
	public static void printStatus(){
		
		
		Gui.consolePrint("Code: "+flcode);
		Gui.consoleAppend("Key:  "+flkey);
	}
	

		
	public static void search(String in) throws IOException{
		
		in = in.toUpperCase();
		String s = "default";
		int line = 1;
		boolean matchFound = false;
		decBufferL();
		
		//check for complete matches
		Gui.consoleAppend("Looking for Exact Matches for '"+in+ "' in the decrypt file");
		
		
		
		while ((s = file3.readLine()) != null) {
		
		if(Gui.debug){Gui.consoleAppend(s);};			
		if(s.contains(in)){Gui.consoleAppend("Found!: "+s+" on line: "+ line); matchFound = true;}
		line++;
		}
		if(!matchFound){Gui.consoleAppend("No Exact Match");};
				
		
	}
	public static void search2(String in) throws IOException{
		
		in = in.toUpperCase();
		String s = "default";
		String temp ="";
		int line = 1;
		boolean matchFound = false;
		decBufferL();
		 
		//check for complete matches
		Gui.consoleAppend("Looking for Partial Matches above 3 Letters Long for '"+in+ "' in the decrypt file");
		
		
		
		while ((s = file3.readLine()) != null) {
		
		if(Gui.debug){Gui.consoleAppend(s);};			
		 for(int c=0;c<in.length();c++)
	      {
	         for(int i=1;i<=in.length()-c;i++)
	         {
	            temp = in.substring(c, c+i);
	            if(s.contains(temp)&&temp.length()>2){Gui.consoleAppend("Found: "+temp+" on line: "+line); matchFound = true;;
	         }
		
		}
		
	      }
		 line++;
		}
		if(!matchFound){Gui.consoleAppend("No Partial Matches");};
}
	
public static void search3(String in) throws IOException{
	
	
	int a=180;
	int b=140;
	String temp = null;
	 
	
	BufferedOutputStream dec2Out = null;
	dec2Out = new BufferedOutputStream(new FileOutputStream("Config Files/DEC2.txt"));
	BufferedReader file4 = null;
	file4 = new BufferedReader(new FileReader(in3));
	

	file4.mark(100);
	dec2Out.write("----====Very Strong Matches====----".getBytes());
	dec2Out.write(EL.getBytes());
	
	while ((temp = file4.readLine()) != null){
		if(engTest(temp)>a){dec2Out.write(temp.getBytes()); dec2Out.write(EL.getBytes());}
		}

	
	dec2Out.write("------====Strong Matches====------".getBytes());
	dec2Out.write(EL.getBytes());
	
	file4.close();
	file4 = new BufferedReader(new FileReader(in3));
	while ((temp = file4.readLine()) != null){
		if(engTest(temp)<a&&engTest(temp)>b){dec2Out.write(temp.getBytes()); dec2Out.write(EL.getBytes());}
		}
	
	dec2Out.write(EL.getBytes());	
	dec2Out.write("------====Weak Matches====------".getBytes());
	dec2Out.write(EL.getBytes());
	
	file4.close();
	file4 = new BufferedReader(new FileReader(in3));
	while ((temp = file4.readLine()) != null){
		if(engTest(temp)<b){dec2Out.write(temp.getBytes()); dec2Out.write(EL.getBytes());}
		}
	
	
	dec2Out.flush();
	dec2Out.close();	
	file4.close();
	Runtime.getRuntime().exec("notepad "+"Config Files/DEC2.txt");	
	}
	
	
	static void getDecrypts() throws IOException{
		boolean end = false;
		int i=0;
		int[] transform = new int[26];
		
		
		keyBufferL();
		
		bufferedOutput = new BufferedOutputStream(new FileOutputStream(in3));
		Gui.consoleAppend("Generating Decrpyts. Please wait!");

		
		while(!end){
		keyBufferL();
		file2.skip(i);
		transform = getTransform(i);
		decrypt(transform);
		//check for if first value of next translation is endoffile value -1
		//nb change this from 26 to 1 if you want the partial decrypts at the end for any reason
		keyBufferL();
		file2.skip(i+26);
		i++;
		if(file2.read()==-1){end = true;};
		}
		
		bufferedOutput.flush();
        bufferedOutput.close();
        Gui.consoleAppend("Decrypts saved in "+letterMatcherDriver.in3);
        Runtime.getRuntime().exec("notepad "+in3);

		
	}
	static int[] getTransform(int seed) throws IOException{
		
		int c;
		int[] transform = new int[26];
		int i=0;
		boolean[] used = new boolean[26];
		
		//Each time we run this we want the key to start 1 letter forward, run read() seed times.
		//when we go off the edge itll just give 0's
		keyBufferL();
		file2.skip(seed);
		
				//nb for later: read() returns char as an int, -1 if it has ended
				//ints are A=65 -> Z=90  !!and smalls are 97 - 122
				
				while ((c =file2.read()) != -1 && i<= 25) { 
				
					
				//0nly pass transform if c is valid and HAS NOT BEEN SENT BEFORE THIS ITERATION
				
				if(c>=91){c=c-(97-65);};	
				    
				if(c<=90&&c>=65|c==0&&used[c-65]==false){transform[i]=c;used[c-65]=true;i++;};	
				
				}
			
				if(Gui.debug){Gui.consoleAppend("Transform for seed "+seed);debugPrint(transform);};
				return transform;
							
	}
	
	static void decrypt(int[] transform) throws IOException{
		String s = "";
		boolean end = false;
		codeBufferL();
		int j = 0;
		int k = 0;
		int i=0;
		
		//code to use transform passed in to get a decrypt and print it
		

		
		while(!end){
			j=file.read();
	//		if(Gui.debug){Gui.consoleAppend("Character has been read in from code as: "+Character.toString ((char) j)+" ("+j+").");};
			
			if(j==-1|j==10|j==13){end = true;}else{
							k=OTP.trans(j,transform);
							if(k!=0){bufferedOutput.write(k);}else{bufferedOutput.write('*');};
							i++;
							
							//if(Gui.debug&&j!=-1){Gui.consoleAppend("Transformed "+Character.toString ((char) j)+" ("+j+")"+" to "+Character.toString ((char) k)+" ("+k+")");};
			}
			
		}

		//ends line with OS neutral endline
		bufferedOutput.write(EL.getBytes());
				
        
	}
	
	
	
	
	static void debugPrint(int[] transform){
		
		
		Gui.consoleAppend("A = "+Character.toString ((char) transform[0])+". B = "+Character.toString ((char) transform[1])+". C = "+Character.toString ((char) transform[2])+". D = "+Character.toString ((char) transform[3])+". E = "+Character.toString ((char) transform[4])+". F = "+Character.toString ((char) transform[5])+". G = "+Character.toString ((char) transform[6])+". H = "+Character.toString ((char) transform[7])+". I = "+Character.toString ((char) transform[8])+". J = "+Character.toString ((char) transform[9])+". K = "+Character.toString ((char) transform[10])+". L = "+Character.toString ((char) transform[11])+". M = "+Character.toString ((char) transform[12])+". N = "+Character.toString ((char) transform[13])+". O = "+Character.toString ((char) transform[14])+". P = "+Character.toString ((char) transform[15])+". Q = "+Character.toString ((char) transform[16])+". R = "+Character.toString ((char) transform[17])+". S = "+Character.toString ((char) transform[18])+". T = "+Character.toString ((char) transform[19])+". U = "+Character.toString ((char) transform[20])+". V = "+Character.toString ((char) transform[21])+". W = "+Character.toString ((char) transform[22])+". X = "+Character.toString ((char) transform[23])+". Y = "+Character.toString ((char) transform[24])+". Z = "+Character.toString ((char) transform[25]));
	}

	static int engTest(String temp){
	int rating = 0;	
	
	//expected words
	if(temp.contains("AND")){rating = rating +100;}
	if(temp.contains("THE")){rating = rating +100;}
	if(temp.contains("FOR")){rating = rating +100;}
	if(temp.contains("BUS")){rating = rating +100;}
	if(temp.contains("TRAM")){rating = rating +100;}
	if(temp.contains("THAT")){rating = rating +100;}
	if(temp.contains("HAVE")){rating = rating +100;}
	if(temp.contains("NOT")){rating = rating +100;}
	if(temp.contains("WITH")){rating = rating +100;}
	if(temp.contains("YOU")){rating = rating +100;}
	if(temp.contains("THIS")){rating = rating +100;}
	if(temp.contains("FROM")){rating = rating +100;}
	if(temp.contains("THEY")){rating = rating +100;}
	if(temp.contains("SAY")){rating = rating +100;}
	if(temp.contains("WHICH")){rating = rating +100;}
	if(temp.contains("ABOUT")){rating = rating +100;}
	if(temp.contains("WILL")){rating = rating +100;}
	if(temp.contains("MAKE")){rating = rating +100;}
	if(temp.contains("TIME")){rating = rating +100;}
	if(temp.contains("TAKE")){rating = rating +100;}
	if(temp.contains("ADELAIDE")){rating = rating +100;}
	if(temp.contains("BABY")){rating = rating +100;}
	if(temp.contains("SOMERTON")){rating = rating +100;}
	if(temp.contains("NUKE")){rating = rating +100;}
	if(temp.contains("FRIEND")){rating = rating +100;}
	if(temp.contains("AUSTRALIA")){rating = rating +100;}
	if(temp.contains("RUSSIA")){rating = rating +100;}
	if(temp.contains("COMRADE")){rating = rating +100;}
	
	//common short words
	if(temp.contains("BE")){rating = rating +40;}
	if(temp.contains("IF")){rating = rating +40;}
	if(temp.contains("AT")){rating = rating +40;}
	if(temp.contains("TO")){rating = rating +40;}
	if(temp.contains("ME")){rating = rating +40;}
	if(temp.contains("HE")){rating = rating +40;}
	if(temp.contains("SHE")){rating = rating +40;}
	if(temp.contains("TO")){rating = rating +40;}
	if(temp.contains("OF")){rating = rating +40;}
	if(temp.contains("IN")){rating = rating +40;}
	if(temp.contains("AN")){rating = rating +40;}
	if(temp.contains("WE")){rating = rating +40;}
	if(temp.contains("ON")){rating = rating +40;}
	
	//common bigrams
	if(temp.contains("TH")){rating = rating +20;}
	if(temp.contains("ER")){rating = rating +20;}
	if(temp.contains("QU")){rating = rating +20;}
	if(temp.contains("EE")){rating = rating +20;}
	if(temp.contains("SS")){rating = rating +20;}
	if(temp.contains("RE")){rating = rating +20;}
	if(temp.contains("ND")){rating = rating +20;}
	if(temp.contains("NT")){rating = rating +20;}
	if(temp.contains("ST")){rating = rating +20;}
	if(temp.contains("ES")){rating = rating +20;}
	if(temp.contains("HA")){rating = rating +20;}
	if(temp.contains("ST")){rating = rating +20;}
	if(temp.contains("EN")){rating = rating +20;}
	if(temp.contains("ED")){rating = rating +20;}
	if(temp.contains("OU")){rating = rating +20;}
	if(temp.contains("EA")){rating = rating +20;}
	if(temp.contains("HI")){rating = rating +20;}
	if(temp.contains("IS")){rating = rating +20;}
	if(temp.contains("OR")){rating = rating +20;}
	if(temp.contains("TI")){rating = rating +20;}
	if(temp.contains("AS")){rating = rating +20;}
	if(temp.contains("TE")){rating = rating +20;}
	if(temp.contains("ET")){rating = rating +20;}
	if(temp.contains("NG")){rating = rating +20;}
	if(temp.contains("AL")){rating = rating +20;}

	
	//common letters
	if(temp.contains("E")){rating = rating +10;}
	if(temp.contains("T")){rating = rating +10;}
	if(temp.contains("A")){rating = rating +5;}
	if(temp.contains("O")){rating = rating +5;}
	if(temp.contains("I")){rating = rating +5;}
	if(temp.contains("N")){rating = rating +5;}
	if(temp.contains("S")){rating = rating +5;}
	if(temp.contains("U")){rating = rating +5;}
	
	return rating;	
	}
	
	
}

