//First Letter Subroutines - Peter Varsos - April 2013

//Helper methods for the string handling


package Current;
import java.io.*;

public class firstLetter{
	

static String format(String s){
	String temp = s;
	
	temp = temp.replaceAll("\\s+", " ");
	temp = temp.replaceAll("(\\r|\\n)", "");
	temp = temp.replaceAll("[^A-Za-z0-9 ]", "");
	temp = temp.trim();
	return temp;
	
	}

static int countWords(String s){
	
	
   String trim = s.trim();
		   if (trim.isEmpty()) return 0;
		   return trim.split("\\s+").length; //separate string around spaces
		
	
}




static String toString(BufferedReader file) throws IOException{
		
	String s = "default";
	
	
	StringBuilder builder = new StringBuilder();
	

	while ((s = file.readLine()) != null) {
    builder.append(s);
    builder.append(" ");
	}

	s = builder.toString();
	return s.toUpperCase();
		
	
}


static String takeFirstLetters(String s) throws IOException{
	
	BufferedOutputStream RPTOut = null;
	RPTOut = new BufferedOutputStream(new FileOutputStream("RPT.txt"));
	String temp ="";
	
	s=format(s);
	String initial ="";
    String[] split = s.split(" ");

    for(String value : split){
         initial += value.substring(0,1);
     }

    temp = initial.toUpperCase()+"\\n";
    
    RPTOut.write(temp.getBytes());
    RPTOut.flush();
	RPTOut.close();
	letterMatcherDriver.keyBufferL();
	letterMatcherDriver.printStatus();
	Runtime.getRuntime().exec("notepad "+"RPT");
	
     return initial.toUpperCase();
	
	
}


static void freqAnalysis(){
	
	System.out.println("Not implemented yet!");
	/*	
	 boolean Finished = false;
	    while(!Finished) {
			try {
		    	int letter = file.read();
		    	switch(letter){
		    	case 'a': case 'A':
					arr[0]++;
					//System.out.println("A");
					break;
		    	case 'b': case 'B':
					arr[1]++;
					//System.out.println("B");
				break;
		    	case 'c': case 'C':
					arr[2]++;
					//System.out.println("C");
					break;
		   		case 'd': case 'D':
					arr[3]++;
					//System.out.println("D");
					break;
		    	case 'e': case 'E':
					arr[4]++;
					//System.out.println("E");
					break;
		    	case 'f': case 'F':
					arr[5]++;
					//System.out.println("F");
					break;
		    	case 'g': case 'G':
					arr[6]++;
					//System.out.println("G");
					break;
			    case 'h': case 'H':
					arr[7]++;
					//System.out.println("H");
					break;
			    case 'i': case 'I':
					arr[8]++;
					//System.out.println("I");
					break;
		    	case 'j': case 'J':
					arr[9]++;
					//System.out.println("J");
					break;
		    	case 'k': case 'K':
					arr[10]++;
					//System.out.println("K");
					break;
		 		case 'l': case 'L':
					arr[11]++;
					//System.out.println("L");
					break;
		   		case 'm': case 'M':
					arr[12]++;
					//System.out.println("M");
					break;
		    	case 'n': case 'N':
					arr[13]++;
					//System.out.println("N");
					break;
		    	case 'o': case 'O':
					arr[14]++;
					//System.out.println("O");
					break;
		    	case 'p': case 'P':
					arr[15]++;
					//System.out.println("P");
					break;
		    	case 'q': case 'Q':
					arr[16]++;
					//System.out.println("Q");
					break;
			    case 'r': case 'R':
					arr[17]++;
					//System.out.println("R");
					break;
		    	case 's': case 'S':
					arr[18]++;
					//System.out.println("S");
					break;
		    	case 't': case 'T':
					arr[19]++;
					//System.out.println("T");
					break;
		    	case 'u': case 'U':
					arr[20]++;
					//System.out.println("U");
					break;
		    	case 'v': case 'V':
					arr[21]++;
					//System.out.println("V");
					break;
		    	case 'w': case 'W':
					arr[22]++;
					//System.out.println("W");
					break;
		    	case 'x': case 'X':
					arr[23]++;
					//System.out.println("X");
					break;
			    case 'y': case 'Y':
					arr[24]++;
					//System.out.println("Y");
					break;
		    	case 'z': case 'Z':
					arr[25]++;
					//System.out.println("Z");
					break;
			    case -1:
			
				    }
					
					Finished = true;
		    	default: 
					break;	
*/
}






}

