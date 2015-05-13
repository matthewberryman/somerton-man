// Thomas Stratfold - 1192953
import java.io.*;
import java.util.Scanner;

public class FreqAnal2Driver {
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
		FreqAnal2 FA = new FreqAnal2();
		BufferedReader file = null;
		int[] array = null;
		
		for(int i=0; i <Names.length; i++) {
				file = FA.ReadFile(Names[i]);
				array = FA.FreqAnal(file);
				FA.OutputFile(Names[i], array);
		}
	}
}