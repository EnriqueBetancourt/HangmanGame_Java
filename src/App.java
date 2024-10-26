import java.util.Scanner;

public class App {

    private static String[] names = {"Luis","Enrique","Betancourt", "Rodriguez"};

    public static void main(String[] args) throws Exception {
        boolean found = false;
        Scanner input = new Scanner(System.in);
        while(true){
            int lifes = 7;

            int randomNumber = (int) (Math.random() * 3);
            String[] wordGame = names[randomNumber].split("");

            String[] letterGuessed = new String[wordGame.length];
            for(int i = 0; i < letterGuessed.length; i++)
                letterGuessed[i] = "_";
            System.out.println("The word have " + wordGame.length + " letters");
            
            while(lifes >= 1){
                found = false;
                System.out.println("You have " + lifes + " lifes");
                for (String letters : letterGuessed)
                    System.out.print(letters + " ");

                System.out.println("\nType a letter to guess the word");
                String letter = input.next();

                for(int i = 0; i < wordGame.length; i++){
                    if (wordGame[i].equalsIgnoreCase(letter)) {
                        letterGuessed[i] = wordGame[i];
                        found = true;
                    } 
                }
                
                if (found){
                    System.out.println("Letter Guessed");
                } else {
                    System.out.println("Fail gueesing the Letter!");
                    lifes--;
                }
                if (String.join("", letterGuessed).equals(String.join("", wordGame))){
                    for (String letters : letterGuessed)
                    System.out.print(letters + " ");
                    System.out.println("\nHas ganado");
                    break;
                }
            }
            input.close();
            break;
        }
    }
}
