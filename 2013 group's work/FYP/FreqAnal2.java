//Thomas Stratfold - 1192953
import java.io.*;
import java.util.Scanner;

public class FreqAnal2 {
	public BufferedReader ReadFile(String FileName) {
		String inFile = FileName+".txt";
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader file = null;
		
		try {
			file = new BufferedReader(new FileReader(inFile));
		} catch (Exception e) {
			System.err.println("Error: File "+inFile+" Not Found");
		}
		
		return file;
	}
	
	public int[] FreqAnal(BufferedReader file) { // Changed 'FreqAnal' to 'FreqAnal2'????
	    int[] arr = new int[26];
	    int sum = 0;
	    for(int i = 0;i< 26;i++) {
	 		arr[i]=0;
	    }
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
					/*for(int j =0; j<26; j++) {
						int letter2 = 'A'+j;
						System.out.println((char)letter2+": "+arr[j]);
						sum += arr[j];				
				    }
					System.out.println("Total no. chars: "+sum); */
					Finished = true;
		    	default: /*System.out.print((char) letter+" "+letter+";")*/;
					break;
		    }
		}
		catch(IOException io)
		    {
			System.err.println("IO Exception "+io); 
			}
			}
		return arr;	    
	}
	
	public void OutputFile(String File, int[] Array) {	
	try {
		String outFile = "FA_"+File+".txt";
		FileOutputStream FOS = new FileOutputStream(outFile);
		ObjectOutputStream OOS = new ObjectOutputStream(FOS);
		OOS.writeObject(" "+outFile+"\n");
		for(int i = 0; i <26; i++) {
			int alpha = 'A'+i;
			OOS.writeObject(" "+(char)alpha+": "+Array[i]+"\n");
		}
		FOS.close();
	} catch(Exception e) {
		System.err.println("Error: "+e.getMessage());
	}
	}	
}