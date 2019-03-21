package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Radar extends PApplet
{
    UI ui;
    private int x;
    private float dx = 1;
    private int y;
    private int diameter;
    private float radius;
    private float xr =0;
    private float yr = 0;

    private PVector pos;
    private float rotation;


	public Radar(UI ui, int x, int y, int diameter)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        radius = (diameter / 2) - 30;
        pos = new PVector(x, y);
        xr = x - radius-250;
        yr = y - radius-250;

    }
    
    public void render()
    {
        ui.stroke(255);
        ui.noFill();
        ui.ellipse(pos.x, pos.y, diameter, diameter);//radius *2 for last two arg
        ui.fill(255);
        // Static field
        ui.translate(pos.x, pos.y);
        ui.rotate(rotation);
        ui.line(x, y,xr, yr);

        //System.out.println("x is" + x + "y is"+y + "diameter is " + diameter + "rad is"+radius);
        //System.out.println("for x "+ this.x+"for y"+ this.y);
        

    }

    public void update()
    {       
        this.x=(int) Math.sin(rotation);
        this.y = (int) -(float) Math.cos(rotation);
        rotation += 0.0039f;

        System.out.println("pos x "+ pos.x+"pos y"+ pos.y);
        //System.out.println("rotation "+ rotation);
        //System.out.println("2Pi "+ TWO_PI);
    }
}