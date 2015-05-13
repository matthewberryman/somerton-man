//OTP Helper Peter Varsos - 2013

package Current;
import java.io.*;

public class OTP{
	



static int trans(int j, int[] transform){
int re = 0;

//to caps
if(j>=91){j=j-(97-65);};


//!!
for(int i=0;i<26;i++){
if(transform[i]==j){re=i+65;};	
	
}

if(Gui.debug&&j!=-1){Gui.consoleAppend("Transform step run. In: "+Character.toString ((char) j)+" ("+j+")"+" out: "+Character.toString ((char) re)+" ("+re+")"   );};



if(re>91|re<65&&re!=0){Gui.consoleAppend("There was an error in the logic in trans()");};
return re;


}

}



