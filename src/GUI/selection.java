package GUI;

import implementations.selectionClass;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class selection extends BasicGameState {

    public selectionClass x=new selectionClass();


    public selection(int state) throws SlickException {

    }

    public void init(GameContainer gc, StateBasedGame sbg )throws SlickException {

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setAntiAlias(true);
        x.renderer(g);
        g.drawString(x.comp+" comparisons",1000,50);
    }



    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        x.timeAdder(delta);

    }

    public void window(String window, int delta, StateBasedGame sbg) {}

    public int getID() {return 2;}

}
