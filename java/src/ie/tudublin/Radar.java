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

    private PVector pos;
    private PVector forward;
    private float rotation;


	public Radar(UI ui, int x, int y, int diameter)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        radius = (diameter / 2) - 30;
        pos = new PVector(x, y);
        forward = new PVector(0, -1);
    }
    
    public void render()
    {
        ui.stroke(255);
        ui.noFill();
        ui.ellipse(x, y, diameter, diameter);
        ui.fill(255);
        // Static field
        ui.line(x, y,x - radius, y -radius);
        System.out.println("x is" + x + "y is"+y + "diameter is " + diameter + "rad is"+radius);
        

    }

    public void update()
    {       
        forward.x = (float) Math.sin(rotation);
        forward.y = - (float) Math.cos(rotation);
        pos.x += forward.x;
        pos.y += forward.y;
        rotation = 0.5f;
    }
}