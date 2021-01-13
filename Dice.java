
import java.util.*;
import java.io.*;

public class Dice{

    private char showing;
    private char[] letters;

    public static char[][] diceConfigs =  new char[26][6];
    public Dice(int dieNum){
        if(dieNum>25){
            dieNum = dieNum % 25;
        }
        this.letters = Dice.diceConfigs[dieNum];

    }

    public char getShowing(){
        return this.showing;
    }

    private void setShowing(char letter){
        this.showing = letter;
    }

    public void rollDie(){
        Random rand = new Random();

        int lettersSize = this.letters.length;
        int rand_int = rand.nextInt(lettersSize);

        char letter = this.letters[rand_int];
        this.setShowing(letter);

    }

    public static void initializeDiceConfigsNew(){
        int nextConfig = 0;
        try{
            File configs = new File("diceConfigs.txt");
            Scanner myReader = new Scanner(configs);

            while(myReader.hasNextLine()){
                String data = myReader.nextLine();

                Dice.parseConfig(data, nextConfig);
                nextConfig++;
            }
            myReader.close();
        }catch(FileNotFoundException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }


        
    }

    private static void parseConfig(String data, int nextConfig){
        char[] config = new char[data.length()];
        for(int i=0; i<data.length();i++){
            char letter = data.charAt(i);
            config[i] = letter;
        }

        Dice.diceConfigs[nextConfig] = config;
    }


}