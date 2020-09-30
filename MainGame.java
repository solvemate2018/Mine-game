import java.util.*;
public class MainGame{
   public static void main(String[] args){   
   
      Scanner sc = new Scanner(System.in);
      int input = 0;
      
      int[] gameValues = startGame();
      Game game = new Game(gameValues[0], gameValues[1], gameValues[2]);
      
      play(game);
      
      boolean contGame = true;
      
      while(contGame){
         System.out.println("If you want to try again press 'R'. If you want to change dificulty press 'C'. If you want to quit press 'Q'");
         
         String strInput = sc.next();
            
         switch(strInput){
            case "R":
               game.restartGame();
               play(game);
               break;
            case "C":
               gameValues = startGame();
               game = new Game(gameValues[0], gameValues[1], gameValues[2]);
               play(game);
               break;
            case "Q":
               contGame = false;
               break;
            default:
               System.out.println("Ivalid input!");
               break;
         }
      }
   }
   
   private static int[] startGame(){
   
      int hight = 0;
      int width = 0;
      int difficulty = 0;
      int[] gameSettings = new int[3];
      Scanner sc = new Scanner(System.in);
   
   
      while(true){
         System.out.println("Please choose a width of the game:");
         width = sc.nextInt();
         
         if(width > 3){
            break;
         }
         else{
            sc.nextLine();
            System.out.println("It must be bigger than 3");
         }
         
      }
      
      gameSettings[0] = width;
      
      while(true){
         System.out.println("Please choose a hight of the game:");
         hight = sc.nextInt();
         
         if(hight > 3){
            break;
         }
         else{
            sc.nextLine();
            System.out.println("It must be bigger than 3");
         }
         
      }
      
      gameSettings[1] = hight;
      
      while(true){
         System.out.println("Please choose a difficulty of the game:");
         difficulty = sc.nextInt();
         
         if(difficulty <= 6 && difficulty >= 1){
            break;
         }
         else{
            sc.nextLine();
            System.out.println("It should be between 1 and 6");
         }
         
      }
      
      gameSettings[2] = difficulty;
      
      return gameSettings;
   }
   
   private static void play(Game game){
      Scanner sc = new Scanner(System.in);
      int input = 0;
      
      while(true){
         input = sc.nextInt();
         if(input == 5 || !game.Move(input)){
            break;
         }
      }
      
   }
}