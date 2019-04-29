package ie.tudublin;

import processing.core.PVector;
import processing.core.*;
import processing.*;

public class DecayingOrbit
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private String text;
    private PVector pos;
    private float rotation;
 

    public DecayingOrbit(UI ui, float x, float y, float width, float height, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        pos = new PVector(x, y);
    }


    public void render()
    {  
        float gap = width /2;
        float gap2 = width/4;
        ui.noFill();
        ui.stroke(255);
        ui.ellipse(pos.x, pos.y, width, height ); 
        ui.ellipse(pos.x, pos.y, width + gap, height + height/2);
        ui.ellipse(pos.x, pos.y, width *2 - gap2, height*2 - gap2);
        ui.ellipse(pos.x, pos.y, width *2 +gap2, height*2 + gap2);

        //Ship line
        ui.ellipse(pos.x, pos.y, width*2, height*2);
        ui.translate(pos.x, pos.y);
        ui.rotate(rotation);
        ui.ellipse(x + width , y , 20, 20);
    }

    public void update()
    {
        this.x=(int) Math.sin(rotation);
        this.y = (int) -(float) Math.cos(rotation);
        rotation += 0.001f;
    }
}