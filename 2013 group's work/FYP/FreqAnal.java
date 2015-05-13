import java.io.*;
import java.util.Scanner;

public class FreqAnal
{
	public static void main(String[] args)
	{
		boolean validFile = true;
		String inFile = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader file = null;
		while(validFile)
		{
			System.out.println("Please enter the name of the file to be analysed, then press enter: ");
			try
			{
				inFile = in.readLine();
			}catch(IOException io)
			{
				System.err.println("I/O Exception");
				validFile = false;
			}
			System.out.println("Input File: "+ inFile);
		
			try
			{
				file = new BufferedReader(new FileReader(inFile));
			}catch(FileNotFoundException fnf)
			{
				System.err.println("Error: File "+inFile+" Not Found");
				validFile = false;
			}
		}
		freqAnal(file);
	}
	
	private static void freqAnal(BufferedReader file)
	{
		int[] arr = new int[26];
		int sum = 0;
		for(int i=0;i<26;i++){
			arr[i]=0;
		}
		
		while(true)
		{
			try
			{
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
					throw new IOException("End of File");
					/*case ' ': case '\r': case '\t':
					System.out.println("Space");
					file.mark(limit);
					temp = file.read();
					if(Character.isWhitespace(temp))
					{
						//System.out.println("Two spaces in a row");
						throw new IOException("End of File");
					}
					else
					{
						file.reset();
					}
					break;*/
					default: /*System.out.print((char) letter+" "+letter+";")*/;
					break;
				}
			}
			catch(IOException io)
			{
				//System.err.println("IO Exception "+io); 
				for(int j =0; j<26; j++)
			{
				int letter = 'A'+j;
				System.out.println((char)letter+": "+arr[j]);
				sum += arr[j];				
			}
			System.out.println("Total no. chars: "+sum);
			System.exit(0);
			}
		}

	}
}