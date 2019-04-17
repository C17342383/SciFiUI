package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    Button b;
    Button b2;
    Button b3;
    Button buttonE1;
    Button buttonE2;
    Button buttonE3;
    Button buttonE4;
    MovingCircle mc;
    Radar r;
    PanelDesign p;
    SpeedCircle sp;
    SpeedCircle sp2;
    SpeedCircle sp3;
    SpeedCircle sp4;
    TankVolume t1;
    TankVolume t2;
    TankVolume t3;
    TankVolume t4;
    TankVolume t5;
    CircleButton c1;
    CircleButton c2;
    CircleButton c3;
    CircleButton c4;
    CircleButton c5;
    CriticalFuel cf;
    Thruster th1;

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
       // fullScreen(); 
    }

    public void setup()
    {
        b = new Button(this, 150, 460, 100, 50, "Station");
        b2 = new Button(this, 350, 460, 100, 50, "Thrusters");
        b3 = new Button(this, 550, 460, 100, 50, "Orbit");
        buttonE1 = new Button(this, 925, 285, 150, 50, "Launch Thruster I");
        buttonE2 = new Button(this, 1225, 285, 150, 50, "Launch Thruster II");
        buttonE3 = new Button(this, 925, 635, 150, 50, "Launch Thruster III");
        buttonE4 = new Button(this, 1225, 635, 150, 50, "Launch Thruster IV");
        mc = new MovingCircle(this, width / 2, height / 2, 50);
        r = new Radar(this, 200, 650, 200);
        p = new PanelDesign(this, 1500, 800);
       sp = new SpeedCircle(this, 1000, 150, 200, 200, "Thruster I");
       sp2 = new SpeedCircle(this, 1300, 150, 200, 200, "Thruster II");
       sp3 = new SpeedCircle(this, 1000, 500, 200, 200, "Thruster III");
       sp4 = new SpeedCircle(this, 1300, 500, 200, 200, "Thruster IV");
       t1 = new TankVolume(this, 400, 550, 50, 200, "Tank 1");
       t2 = new TankVolume(this, 500, 550, 50, 200, "Tank 2");
       t3 = new TankVolume(this, 600, 550, 50, 200, "Tank 3");
       t4 = new TankVolume(this, 700, 550, 50, 200, "Tank 4");
       t5 = new TankVolume(this, 800, 550, 50, 200, "Tank 5");
       c1 = new CircleButton(this, 840, 70, 40, 40, "CB1");
       c2 = new CircleButton(this, 840, 150, 40, 40, "CB2");
       c3 = new CircleButton(this, 840, 230, 40, 40, "CB3");
       c4 = new CircleButton(this, 840, 310, 40, 40, "CB4");
       c5 = new CircleButton(this, 840, 390, 40, 40, "CB5");
       cf = new CriticalFuel(this, 1500/2, 800/2, 500, 150, "Critical Low Fuel", "-- CODE : 818 --");
       th1 = new Thruster(this, 120, 120, 100, 200, "Fuel % : ");
    
    }

    public void draw()
    {
        background(0);

        sp.render();
        sp2.render();
        sp3.render();
        sp4.render();

        p.render();
        b.render();
        b2.render();
        b3.render();
        buttonE1.render();
        buttonE2.render();
        buttonE3.render();
        buttonE4.render();
        //t1.render();
        //t2.render();
        //t3.render();
        //t4.render();
        //t5.render();
        c1.render();
        c2.render();
        c3.render();
        c4.render();
        c5.render();
        th1.render();
        //cf.render();
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

