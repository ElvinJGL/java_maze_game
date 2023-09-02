package Main;
import java.util.Scanner;
import Components.Statics;
import Objects.Point;
// import java.io.Console;

public class MainGame {

    private static int currLevel = 0;
    public static boolean running = true;


    public static void chekcStatus(){
        if(
            Statics.PLAYER.x == Statics.FINISH.x &&
            Statics.PLAYER.y == Statics.FINISH.y
        ){
            MainGame.waitInput("LEVEL COMPLETE!");
            MainGame.levelUp();
            MainGame.prepareMap();
        }
    }

    public static void executeMovement(){
        System.out.println("Level: " + (MainGame.currLevel + 1));
        //MainGame.printPromt();
        char nextMove = MainGame.inChar("Enter Move: ");
        if(nextMove == 'w'){
            Statics.PLAYER.y --;
            if(Statics.PLAYER.y < 0) Statics.PLAYER.y = 0;
            if(Statics.LEVELS[MainGame.currLevel].getBlock(Statics.U_BLOCK) == '*') 
                Statics.PLAYER.y++;
        }else if(nextMove == 's'){
            Statics.PLAYER.y ++;
            if(Statics.PLAYER.y > Statics.MAP_DIMENSION.y) Statics.PLAYER.y = Statics.MAP_DIMENSION.y;
            if(Statics.LEVELS[MainGame.currLevel].getBlock(Statics.D_BLOCK) == '*') 
                Statics.PLAYER.y--;
        }else if(nextMove == 'a'){
            Statics.PLAYER.x --;
            if(Statics.PLAYER.x < 0) Statics.PLAYER.x = 0;
            if(Statics.LEVELS[MainGame.currLevel].getBlock(Statics.L_BLOCK) == '*') 
                Statics.PLAYER.x++;
        }else if(nextMove == 'd'){
            Statics.PLAYER.x ++;
            if(Statics.PLAYER.x > Statics.MAP_DIMENSION.x) Statics.PLAYER.x = Statics.MAP_DIMENSION.x;
            if(Statics.LEVELS[MainGame.currLevel].getBlock(Statics.R_BLOCK) == '*') 
                Statics.PLAYER.x--;
        }else if(nextMove == '0'){
            MainGame.running = false;
        }

        Statics.U_BLOCK.setPos(Statics.PLAYER.x, Statics.PLAYER.y-1);
        Statics.D_BLOCK.setPos(Statics.PLAYER.x, Statics.PLAYER.y+1);
        Statics.L_BLOCK.setPos(Statics.PLAYER.x-1, Statics.PLAYER.y);
        Statics.R_BLOCK.setPos(Statics.PLAYER.x+1, Statics.PLAYER.y);
    }

    public static void clearScreen(){
        for(int i = 0; i < 20; i++) System.out.println();
    }

    public static void prepareMap(){
        Statics.START.setPos(Statics.LEVELS[MainGame.currLevel].getPos('S'));
        Statics.PLAYER.setPos(Statics.START);
        Statics.FINISH.setPos(Statics.LEVELS[MainGame.currLevel].getPos('F'));
        Statics.MAP_DIMENSION.x = Statics.LEVELS[MainGame.currLevel].getWidth() - 1;
        Statics.MAP_DIMENSION.y = Statics.LEVELS[MainGame.currLevel].getHeight() - 1;
    }

    public static void drawMap(){
        Point start = new Point(Statics.PLAYER.x - 1, Statics.PLAYER.y - 1);
        Point end = new Point(Statics.PLAYER.x + 2, Statics.PLAYER.y + 2);

        for(int r = start.y; r < end.y; r++){
            for(int c = start.x; c < end.x; c++){
                if(r == Statics.PLAYER.y && c == Statics.PLAYER.x){
                    System.out.print(Statics.PLAYER.getValue());
                    continue;
                }
                System.out.print(Statics.LEVELS[MainGame.currLevel].getBlock(new Point(c, r)));
            }
            System.out.println();
        }
    }




    private static void waitInput(String msg){
        System.out.println(msg);
        System.console().readLine();
    }

    private static void levelUp(){
        MainGame.currLevel ++;
    }

    private static void printPromt(){
        System.out.println(
            "Movements: \n(w) = UP \n(s) = DOWN \n(a) = LEFT \n(d) = RIGHT"
        );
    }

    private static char inChar(String msg){
        Scanner in = new Scanner(System.in);
        System.out.print(msg);
        String val = in.nextLine();
        // in.close();
        return  (val.length() > 0) ? val.toLowerCase().charAt(0) : ' ' ;
    }

    private MainGame() {}
}
