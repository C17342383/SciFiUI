package ie.tudublin;

import processing.core.PVector;

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
    private float decay;
 

    public DecayingOrbit(UI ui, float x, float y, float width, float height, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        pos = new PVector(x, y);
        decay = x - 100;
    }


    public void render()
    {  
        float gap = width /2;
        float gap2 = width/4;
        ui.fill(15, 31, 61);
        //Outer
        ui.ellipse(pos.x, pos.y, width *2 +gap2, height*2 + gap2);

        //Ship line
        ui.fill(20, 42, 82);
        ui.ellipse(pos.x, pos.y, width*2, height*2);
        ui.pushMatrix();
        ui.translate(pos.x, pos.y);
        ui.rotate(rotation);
        ui.fill(0);
        ui.ellipse(decay , y , 20, 20);
        ui.popMatrix();


        ui.fill(25, 52, 103);
        ui.ellipse(pos.x, pos.y, width *2 - gap2, height*2 - gap2);

        ui.fill(35, 73, 144);
        ui.ellipse(pos.x, pos.y, width + gap, height + height/2);

        //Earth 
        ui.fill(0, 128, 43);
        ui.stroke(0);
        ui.ellipse(pos.x, pos.y, width, height ); 
    }

    public void update()
    {
        this.x=(int) Math.sin(rotation);
        this.y = (int) -(float) Math.cos(rotation);
        rotation += 0.001f;

    }

    public int decay()
    {
        decay = decay -1;

        if(decay <= x - 110)
        {
            return 1;
        }
        else{
            return 0;
        }
    }
}