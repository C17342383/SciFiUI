package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    Button b;
    MovingCircle mc;
    Radar r;

    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = true;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {
        size(800, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
    }

    public void setup()
    {
        b = new Button(this, 50, 50, 100, 50, "I am a button");
        mc = new MovingCircle(this, width / 2, height / 2, 50);
        r = new Radar(this, width/2, height/2, 200);
    }

    public void draw()
    {
        background(0);
        b.render();

        mc.update();
        mc.render();

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }

        r.render();
        r.update();
    }

    /**
     * @return the b
     */
    public Button getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(Button b) {
        this.b = b;
    }

    /**
     * @return the mc
     */
    public MovingCircle getMc() {
        return mc;
    }

    /**
     * @param mc the mc to set
     */
    public void setMc(MovingCircle mc) {
        this.mc = mc;
    }

    /**
     * @return the r
     */
    public Radar getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(Radar r) {
        this.r = r;
    }

    /**
     * @return the keys
     */
    public boolean[] getKeys() {
        return keys;
    }

    /**
     * @param keys the keys to set
     */
    public void setKeys(boolean[] keys) {
        this.keys = keys;
    }

}

