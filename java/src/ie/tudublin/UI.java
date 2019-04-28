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
    public Thruster th1;
    public Thruster th2;
    public Thruster th3;
    public Thruster th4;

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
        loadAlien();
    }

    public void setup()
    {
        Alien a = new Alien();
        b = new Button(this, width /2 +50, 180, 60, 50, "Station");
        b2 = new Button(this, width/2 + 50, 410, 60, 50, "Thrusters");
        b3 = new Button(this, width/2 +50, 640 ,60, 50, "Orbit");
        buttonE1 = new Button(this, 960, 300, 150, 50, "Launch Thruster I");
        buttonE2 = new Button(this, 1265, 300, 150, 50, "Launch Thruster II");
        buttonE3 = new Button(this, 960, 650, 150, 50, "Launch Thruster III");
        buttonE4 = new Button(this, 1265, 650, 150, 50, "Launch Thruster IV");
        mc = new MovingCircle(this, width / 2, height / 2, 50);
        r = new Radar(this, 200, 600, 200);
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
       cf = new CriticalFuel(this, 400, 800/2, 500, 150, "Critical Low Fuel", "-- CODE : 818 --");
       th1 = new Thruster(this, 170, 50, 100, 200, "Fuel % : ");
       th2 = new Thruster(this, 550, 50, 100, 200, "Fuel % : ");
       th3 = new Thruster(this, 170, 410, 100, 200, "Fuel % : ");
       th4 = new Thruster(this, 550, 410, 100, 200, "Fuel % : ");

       thc1 = new CircleButton(this, 1160, 240, 40, 40, " TI");
       thc2 = new CircleButton(this, 1160, 360, 40, 40, " TII");
       thc3 = new CircleButton(this, 1160, 480, 40, 40, " TIII");
       thc4 = new CircleButton(this, 1160, 600, 40, 40, " TIV");


    
    }

    public void draw()
    {

        background(0);
        //Panel Design
        p.render();
        //Panel Buttons
        b.render();
        b2.render();
        b3.render();
        //Dial Interface
        sp.render();
        sp2.render();
        sp3.render();
        sp4.render();
        //Launch Thruster Buttons
        buttonE1.render();
        buttonE2.render();
        buttonE3.render();
        buttonE4.render();
        //Stop Thruster Buttons
        thc1.render();
        thc2.render();
        thc3.render();
        thc4.render();

        //c1.render();
        //c2.render();
        //c3.render();
        //c4.render();
        //c5.render();
        //t1.render();
        //t2.render();
        //t3.render();
        //t4.render();
        //t5.render();
        //cf.render();
       // mc.update();
       // mc.render();

       if(choose == 0)
       {
            r.render();
            r.update();

       }
       if(choose == 1)
       {
            th1.render();
            th2.render();
            th3.render();
            th4.render(); 
       }
       if(choose == 2)
       {
           
       }

       if(ch == 1)
       {
           //System.out.println("in if ch = 1");
           cf.render();
       }
       //int count = 0;
       while(count ==0)
       {
            x =  (Math.random()*4.0);
            rr = (int) x; 
            System.out.println("Inserting " + rr); 
            count = 1;
       }

       
       if(rr == 0)
       {
        for (Alien a : variabletemp)
        {
           over =  a.getTemp();
           sp.alien(over);
        }
       }
       if(rr == 1)
       {
        for (Alien a : variabletemp)
        {
           over =  a.getTemp();
           sp2.alien(over);
        }
       }
       if(rr == 2)
       {
        for (Alien a : variabletemp)
        {
           over =  a.getTemp();
           sp3.alien(over);
        }
       }
       if(rr == 3)
       {
        for (Alien a : variabletemp)
        {
           over =  a.getTemp();
           sp4.alien(over);
        }
       }

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }

    int choose;
    int ch = 0;
    int rr; 
    double x;
    int count = 0;
    float over;

    float thborder = 300;
    float inborder = 960;
    float ininborder = 1265;
    float buttonWidth = 150;
    float buttonHeight = 50;
    float gap = 300;

    float pborder = 815;
    float pborder2 = 180;
    float pgap = 180;
    float pbuttonWidth = 60;

    float xborder = 1160;
    float yborder = 240 ; 
    float stopbuttonWidth = 40;
    float stopbuttonHeight = 40;
    float stopgap = 80;

    public void mouseClicked()
    {
        //System.out.println("in load Aline");
        //printAlien();
        
        //Panel buttons
        int which1 = -1;
        
        if ((mouseX > pborder && mouseX < pborder + pbuttonWidth))
        {
            if (((mouseY - pborder2) % (buttonHeight + pgap)) < buttonHeight)
            {
                //System.out.println("YY Mouse X : "+ mouseX);
                //System.out.println("YY Mouse Y : "+ mouseY);
                 which1 = (int) ((mouseY - pborder2) / (buttonHeight + pgap));
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
                choose = 0;
            }
        
            if(which1 == 1)
            {
                System.out.println("Thrusters");
                choose = 1;
            }
            if(which1 == 2)
            {
                System.out.println("Orbit");
                choose = 2;
            }
                    
        }

        //Thruster Stop Buttons
        int stop = -1;
        int s = 0;

        if ((mouseX > xborder && mouseX < xborder + stopbuttonWidth))
        {
            if ((mouseY - yborder) % (stopbuttonHeight + stopgap) < stopbuttonHeight)
            {
                //System.out.println("Mouse X : "+ mouseX);
                //System.out.println("Mouse Y : "+ mouseY);
                stop = (int) ((mouseY - yborder) / (stopbuttonHeight + stopgap));
                //System.out.println("stop : " + stop);
            }
        }

        if (stop != -1 )
        {
            if(stop == 0 )
            {
                s  = 1;
                System.out.println("Stop TI");
                sp.stop(s);
                //th1.update();
            }
            if(stop == 1)
            {
                s  = 1;
                System.out.println("Stop TII");
                sp2.stop(s);
                //th2.update();
            }
            if(stop == 2)
            {
                s  = 1;
                System.out.println("Stop TIII");
                sp3.stop(s);
                //th3.update();
            }
            if(stop == 3)
            {
                s  = 1;
                System.out.println("Stop TIV");
                sp4.stop(s);
                //th3.update();
            }
                    
        }

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
                sp.update();
                th1.update();
                ch =th1.check();
            }

            if(which == 1 && mouseX <= 1110)
            {
                System.out.println("Thruster 3");
                sp3.update();
                th3.update();
                ch =th3.check();
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
                sp2.update();
                th2.update();
                ch = th2.check();
            }

            if(which == 1 && mouseX >=1265)
            {
                System.out.println("Thruster 4");
                sp4.update();
                th4.update();
                ch = th4.check();
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

