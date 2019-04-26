package ie.tudublin;

import processing.core.PApplet;
import java.util.ArrayList;
import processing.data.Table;
import processing.data.TableRow;

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
    CircleButton thc1;
    CircleButton thc2;
    CircleButton thc3;
    CircleButton thc4;
    CriticalFuel cf;
    Thruster th1;
    Thruster th2;
    Thruster th3;
    Thruster th4;

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

        size(1530, 850);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
        float height = 850;
        float width = 1530;
    }

    public void setup()
    {
        b = new Button(this, width /2 +50, 180, 60, 50, "Station");
        b2 = new Button(this, width/2 + 50, 360, 60, 50, "Thrusters");
        b3 = new Button(this, width/2 +50, 540 ,60, 50, "Orbit");
        buttonE1 = new Button(this, 960, 300, 150, 50, "Launch Thruster I");
        buttonE2 = new Button(this, 1265, 300, 150, 50, "Launch Thruster II");
        buttonE3 = new Button(this, 960, 650, 150, 50, "Launch Thruster III");
        buttonE4 = new Button(this, 1265, 650, 150, 50, "Launch Thruster IV");
        mc = new MovingCircle(this, width / 2, height / 2, 50);
        r = new Radar(this, 200, 650, 200);
        p = new PanelDesign(this, 1530, 850);
       sp = new SpeedCircle(this, width - 500, height - 700, 200, 200, "Thruster I");
       sp2 = new SpeedCircle(this, width - 200, height - 700, 200, 200, "Thruster II");
       sp3 = new SpeedCircle(this, width - 500, height - 350, 200, 200, "Thruster III");
       sp4 = new SpeedCircle(this, width - 200, height - 350, 200, 200, "Thruster IV");
       t1 = new TankVolume(this, 400, 550, 50, 200, "Tank 1");
       t2 = new TankVolume(this, 500, 550, 50, 200, "Tank 2");
       t3 = new TankVolume(this, 600, 550, 50, 200, "Tank 3");
       t4 = new TankVolume(this, 700, 550, 50, 200, "Tank 4");
       t5 = new TankVolume(this, 800, 550, 50, 200, "Tank 5");

       c1 = new CircleButton(this, 840, 79, 40, 40, "CB1");
       c2 = new CircleButton(this, 840, 159, 40, 40, "CB2");
       c3 = new CircleButton(this, 840, 240, 40, 40, "CB3");
       c4 = new CircleButton(this, 840, 329, 40, 40, "CB4");
       c5 = new CircleButton(this, 840, 410, 40, 40, "CB5");
       cf = new CriticalFuel(this, 1500/2, 800/2, 500, 150, "Critical Low Fuel", "-- CODE : 818 --");
       th1 = new Thruster(this, 170, 50, 100, 200, "Fuel % : ");
       th2 = new Thruster(this, 550, 50, 100, 200, "Fuel % : ");
       th3 = new Thruster(this, 170, 410, 100, 200, "Fuel % : ");
       th4 = new Thruster(this, 550, 410, 100, 200, "Fuel % : ");

       thc1 = new CircleButton(this, 1160, 240, 40, 40, " TI");
       thc2 = new CircleButton(this, 1160, 320, 40, 40, " TII");
       thc3 = new CircleButton(this, 1160, 400, 40, 40, " TIII");
       thc4 = new CircleButton(this, 1160, 480, 40, 40, " TIV");


    
    }

    public void draw()
    {

        background(0);

        sp.render();
        //sp.update();
        sp2.render();
        sp3.render();
        sp4.render();
        //c1.render();
        //c2.render();
        //c3.render();
        //c4.render();
        //c5.render();
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

        th1.render();
        th2.render();
        th3.render();
        th4.render();
        //cf.render();
       // mc.update();
       // mc.render();

       thc1.render();
       thc2.render();
       thc3.render();
       thc4.render();

       r.render();
       r.update();


        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }

    float thborder = 300;
    float inborder = 960;
    float ininborder = 1265;
    float buttonWidth = 150;
    float buttonHeight = 50;
    float gap = 300;

    public void mouseClicked()
    {
        System.out.println("in load Aline");
        loadAlien();
        //printAlien();
        
        //Thruster Buttons
        int which = -1;

        if ((mouseX > inborder && mouseX < inborder + buttonWidth))
        {
            if ((mouseY - thborder) % (buttonHeight + gap) < buttonHeight)
            {
                //System.out.println("Mouse X : "+ mouseX);
                //System.out.println("Mouse Y : "+ mouseY);
                which = (int) ((mouseY - thborder) / (buttonHeight + gap));
                System.out.println("which : "+ which);
            }
        }

        if (which != -1)
        {
            if(which == 0 && mouseX <= 1110)
            {
                System.out.println("Thruster 1");
            }

            if(which == 1 && mouseX <= 1110)
            {
                System.out.println("Thruster 3");
            }
            
        }

        if ((mouseX > ininborder && mouseX < ininborder + buttonWidth))
        {
            if ((mouseY - thborder) % (buttonHeight + gap) < buttonHeight)
            {
                //System.out.println("Mouse X : "+ mouseX);
                //System.out.println("Mouse Y : "+ mouseY);
                which = (int) ((mouseY - thborder) / (buttonHeight + gap));
                System.out.println("which : "+ which);
            }
        }

        if (which != -1 )
        {
            if(which == 0 && mouseX >=1265)
            {
                System.out.println("Thruster 2");
            }

            if(which == 1 && mouseX >=1265)
            {
                System.out.println("Thruster 4");
            }
            
        }


        //Panel buttons
        int which1 = -1;
        float pborder = 815;
        float pborder2 = 180;
        gap = 180;
        buttonWidth = 60;
        //double add = 0.4;
        
        if ((mouseX > pborder && mouseX < pborder + buttonWidth))
        {
                    //System.out.println("First if");
                    //System.out.println("Mouse X : "+ mouseX);
                    //System.out.println("Mouse Y : "+ mouseY);
                    float check1 = mouseY - pborder2;
                    float check2 = buttonHeight + gap;
                    float check3 = check1 % check2;
                    System.out.println("Mouse Y - pborder : "+  check1);
                    System.out.println("check2 - pborder : "+  check2);
                    System.out.println("check3 : "+  check3);
                    System.out.println("Mouse X : "+ mouseX);
                    System.out.println("Mouse Y : "+ mouseY);
            if ((mouseY - pborder2) % (buttonHeight + gap) < buttonHeight)
            {
                System.out.println("Mouse X : "+ mouseX);
                System.out.println("Mouse Y : "+ mouseY);
                 which1 = (int) ((mouseX - pborder) / (buttonHeight + gap));
                System.out.println(" which1 : " + which1);
            }
        }
            
        
                //which1 = (int) (which1 + add);
                //System.out.println("which1 : " + which1);
        if (which1 != -1 )
        {
            if(which1 == 0 )
            {
                System.out.println("Station");
            }
        
            if(which1 == 1)
            {
                System.out.println("Thrusters");
            }
            if(which1 == 2)
            {
                System.out.println("Orbit");
            }
                    
        }


        int stop = -1;
        float xborder = 1160;
        float yborder = 240 ; 
        float stopbuttonWidth = 40;
        float stopbuttonHeight = 40;
        float stopgap = 180;
        //Thruster Stop Buttons
        if ((mouseX > xborder && mouseX < xborder + stopbuttonWidth))
        {
            if ((mouseY - xborder) % (stopbuttonHeight + stopgap) < stopbuttonHeight)
            {
                System.out.println("Mouse X : "+ mouseX);
                System.out.println("Mouse Y : "+ mouseY);
                stop = (int) ((mouseY - xborder) / (stopbuttonHeight + stopgap));
            }
        }



    }
    ArrayList<Alien> variabletemp = new ArrayList<Alien>();

    public void loadAlien()
    {
        Table table = loadTable("Alien.csv", "header");
        for(TableRow tabler:table.rows())
        {
            Alien a = new Alien(tabler);
            variabletemp.add(a);
            
        }        
    }

    void printAlien()
    {
        for (Alien a : variabletemp) {
            System.out.println(a);
        }
    }

}

