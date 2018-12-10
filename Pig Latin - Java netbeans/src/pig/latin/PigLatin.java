
package pig.latin;

import java.util.Scanner;
//mack.vv march 27
public class PigLatin {

    public static void main(String[] args) {
       
       Scanner in = new Scanner(System.in);
       
       //counter
       int index = 0;
       //userInput
       String[] aryUserInput = new String[1000];
       //user input 
       String sUserInput; 
       //pig latin array length 
       int numWords = 0; 
       
       //gets userinput and puts into array
       do { 
           //get user word
            System.out.println("Please enter a word you would like to translate into pig latin, to stop entering words sumbit \"STOP\"" );
            sUserInput= in.nextLine();
            
            //exit if first word is stop
            checkSTOP(numWords, sUserInput);
            
                        //put user word into array if valid word
                        if (!sUserInput.equals("STOP")) 
                        {
                        //make valid word apart of index
                        aryUserInput[index] = sUserInput;
                        //increase index and word count
                        numWords++;
                        index++;
                        }
                
          //repeat while words are valid 
        } while (!sUserInput.equals("STOP"));   
       
       //create a pig latin array that is the length of numWords
       String[] aryPigLatin = new String[numWords];
       
       //reset counter
       index = 0;
       
       do {
          aryPigLatin[index] = convertToPig(aryUserInput[index]);
  
         //output
          print(aryPigLatin[index].length(), aryPigLatin[index]);
        
           //translate to pig latin 
          aryPigLatin[index] = convertToPig(aryUserInput[index]);
        
          //increase index
          index++;
          
       //repeat until the whole array is displayed
       } while (index < numWords);
        
    }
    
    //exit if first word entered is stop
    public static void checkSTOP(int wordCount, String word) {
         if (word.equals("STOP") && wordCount == 0) 
         {
                    System.exit(0);
         }
    }
    
    //convert to pig latin 
    public static String convertToPig(String convertThis) {
        String pigLatin;
        pigLatin = convertThis.substring(1) + convertThis.substring(0,1) + "ay";
        pigLatin = pigLatin.toLowerCase();
        return pigLatin;
    }
    
    //print 
    public static void print(int length, String pig) {
          printAss(length);
          System.out.println();
          
          System.out.println("* " + pig + " *");
          
          printAss(length);
          System.out.println();
          
    }
    
    //print the asses
    public static void printAss(int length) {
        int ass = 0;
      
        do {
              System.out.print("*");
              ass++;
          } while (ass != (length+4));
    }
    
}
