import java.util.*;

public class Game{
   private int width;
   private int hight;
   private int currentWidth;
   private int currentHight;
   private List<Coordinate> mines;
   private Random random;
   
   public Game(int width, int hight, int difficulty){
   
      this.width = width - 1;
      this.hight = hight - 1;
      this.currentWidth = 1;
      this.currentHight = 1;
      StartTheGame();
      this.mines = new ArrayList<Coordinate>();
      this.random = new Random();
      int numberOfMines = 0;
      
      switch(difficulty){
         case 1:
            numberOfMines = ((this.width + this.hight)) * 2 / 5;
            break;
         case 2:
            numberOfMines = (this.width + this.hight) * 2 / 4;
            break;
         case 3:
            numberOfMines = (this.width + this.hight) * 2 / 3;
            break;
         case 4:
            numberOfMines = (this.width + this.hight) * 2 / 2;
            break;
         case 5:
            numberOfMines = (this.width + this.hight) * 2;
            break;
         case 6:
            numberOfMines = (this.width + this.hight) * 3;
            break;
         default:
            break;
      }
      
      for(int i = 1; i <= numberOfMines; i++){
         int x = random.nextInt(this.hight - 2) + 2;
         int y = random.nextInt(this.width - 2) + 2;
         mines.add(new Coordinate(x, y, -1));
      }
   }
   
   private void StartTheGame(){
      for(int h = 1; h <= hight; h++){
         for(int w = 1; w <= width; w++){
            if(w == currentWidth && h == currentHight){
               System.out.print("Y  ");
               w++;
            }
            System.out.print("#  ");
         }
         System.out.println();
      }
   }
   
   public boolean Move(int dir){
      
      switch(dir){
         case 2:
            if(currentHight == hight){
               WriteMessage();
               return true;
            }
            else{
               currentHight++;
               
               if(isGameEnded()){
                  return false;
               }
               return true;
            }
         case 4:
            if(currentWidth == 1){
               WriteMessage();
            }
            else{
               currentWidth--;
               if(isGameEnded()){
                  return false;
               }
               return true;
            }
         case 5:
            System.out.println("You have quited!");
            return false;
         case 6:
            if(currentWidth == width){
               WriteMessage();
               return true;
            }
            else{
               currentWidth++;
               if(isGameEnded()){
                  return false;
               }
               return true;
            }
         case 8:
            if(currentHight == 1){
               WriteMessage();
               return true;
            }
            else{
               currentHight--;
               if(isGameEnded()){
                  return false;
               }
               return true;
            }
         default:
            System.out.println("Incorrect input!");
            return true;
      }
      
   }
   
   private boolean CheckForMines(){
      
      boolean thereIsMine = false;
      
      for(Coordinate co : mines){
      
         if(co.getX() == currentHight && co.getY() == currentWidth){
            WriteLoosingMessage();
            thereIsMine = true;
            return true;
         }
         else if(((co.getX() == currentHight) && (co.getY() == currentWidth + 1 || co.getY() == currentWidth -1)) ||
         ((co.getY() == currentWidth) && 
         (co.getX() == currentHight + 1 || co.getX() == currentHight - 1))){
            thereIsMine = true;
         }
      }
      if(!thereIsMine){
         WriteNoMines();
         return false;
      }
      else{
         WriteMineMessage();
         return false;
      }
   }
   
   private boolean CheckIfWin(){
      if(currentWidth == width && currentHight == hight){
         WriteEndGameMessage();
         return true;
      }
      else 
         return false;
   }
   
   private void PrintGame(){
      for(int h = 1; h <= hight; h++){
         for(int w = 1; w <= width; w++){
            if(w == currentWidth && h == currentHight){
               System.out.print("Y  ");
               continue;
            }
            
            System.out.print("#  ");
         }
         System.out.println(" ");
      }
   }
   
   private void WriteMessage(){
      System.out.println("You can't do that!");
   }
   
   private void WriteMineMessage(){
      System.out.println("You are near mine be carefull!");
   }
   
   public void WriteEndGameMessage(){
      System.out.println("Congratulations you won!");
   }
   
   public void WriteLoosingMessage(){
      System.out.println("You stepped on mine you lose(looser haha).");
   }
   public void WriteNoMines(){
      System.out.println("No mines around you. You are lucky.");
   }
   
   private boolean isGameEnded(){
      PrintGame();
      if(CheckIfWin() || CheckForMines()){
         return true;
      }
      return false;
   }
   
   public void restartGame(){
      this.currentWidth = 1;
      this.currentHight = 1;
      
      StartTheGame();
   }
}


