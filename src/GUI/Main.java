package GUI;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class Main extends StateBasedGame {
    private static final String appName="Sorting Algorithms Visualiser";


    private Main(String appName) throws SlickException {
        super(appName);
        this.addState(new bubble(1));
        this.addState(new Play(0));
        this.addState(new selection(2));
        this.addState(new insertion(3));
        this.enterState(3);
    }

    public void initStatesList(GameContainer gc )throws SlickException {
        this.getState(0).init(gc,this);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer appc = new AppGameContainer(new Main(appName));

            appc.setDisplayMode(1280, 720, false);
            appc.start();
            appc.setTargetFrameRate(30);
            appc.setShowFPS(false);


        } catch (SlickException e) {
            System.out.println("Slick Exception Found");
        }

    }
    
}