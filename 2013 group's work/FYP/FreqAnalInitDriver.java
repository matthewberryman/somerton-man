// Thomas Stratfold - 1192953
import java.io.*;
import java.util.Scanner;

public class FreqAnalInitDriver {
	public static void main(String[] args) {
		String[] Names = {"Afrikaans","Alsatian","Anglo-Saxon","Aragonese","Aromanian","Asturian",
		"Azeri","Basque","Belarian_T","Bislama","Bosinian","Breton","Bunduliwan","Catalan","Cebuano",
		"Cecarakan_T","Cheyenne","Cornish","Cujoltha_T","Cymraeg","Dakota","Dutch","Esperanto",
		"Estonian","Fiji_Hindi","Finnish","Folkspraak","French","German","Greenlandic","Haitian","Hausa",
		"Hawaiian","Hungarian","Ido","Ilocano","Indonesian","Interglossa","Interlingua","Irish","Kam",
		"Kirundi","Klingon","Korean_T","Latin","Lingala","Lingua Franca Nova","Low_Saxon","Malagasy",
		"Maltese","Manx_Gaelic","Maori","Massachusett","Melayu","Ndebele","Norwegian","Nsotho",
		"Ojibwe","Paite","Papiamentu","Sami North","Sami South","Samoan","Scottish_Gaelic","Sesotho",
		"Shona","Somali","Sranan_Tongo","Swahili","Tagalog","Tamasheq","Thai_T","Toki Pona","Tsonga",
		"Tswana","Turkish","Uab_Meto","Viozian","White_Hmong","Wolof","Xhosa","Zarma","Zulu","English",
		"Danish"};
		FreqAnalInit FAI = new FreqAnalInit();
		BufferedReader file = null;
		int[] array = null;
		try{
		FileOutputStream FOS = new FileOutputStream("All_FAI.txt");
		ObjectOutputStream OOS = new ObjectOutputStream(FOS);
		//OOS.writeObject("                                   Frequency Analysis of Initial Letters For All Languages\n");		
		OOS.writeObject(" Blah\n");
		for(int i=0; i <Names.length; i++) {
				file = FAI.ReadFile(Names[i]);
				array = FAI.FreqAnal(file);
				OOS.writeObject("                           "+Names[i]+"\n");
				for(int j = 0; j <26; j++) {
					int alpha = 'A'+j;
					OOS.writeObject(" "+(char)alpha+": "+array[j]+"\n");
				}	
		}
		} catch (Exception e) {
		}
	}
}