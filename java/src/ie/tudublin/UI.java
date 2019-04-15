package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    Button b;
    Button b2;
    Button b3;
    MovingCircle mc;
    Radar r;
    PanelDesign p;
    SpeedCircle sp;

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
        size(1500, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
    }

    public void setup()
    {
        b = new Button(this, 150, 460, 100, 50, "I am a button");
        b2 = new Button(this, 350, 460, 100, 50, "I am a button");
        b3 = new Button(this, 550, 460, 100, 50, "I am a button");
        mc = new MovingCircle(this, width / 2, height / 2, 50);
        r = new Radar(this, 200, 650, 200);
        p = new PanelDesign(this, 1500, 800);
       sp = new SpeedCircle(this, 0, 0, 200, 200, "Engine 1");

    }

    public void draw()
    {
        background(0);

        //sp.render();

        p.render();
        b.render();
        b2.render();
        b3.render();

       // mc.update();
       // mc.render();

        r.render();
        r.update();


        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }
}

