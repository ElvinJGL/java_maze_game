package Main;

public class GameEngine{
    public static void main(String[] args){
        
        MainGame.prepareMap();

        while(MainGame.running){
            MainGame.clearScreen();
            MainGame.drawMap();
            MainGame.executeMovement();
            MainGame.chekcStatus();
        }

    }

    private GameEngine() {}
}