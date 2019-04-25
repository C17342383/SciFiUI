package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class SpeedCircle
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private String text;
    private PVector pos;
    private float rotation;

    public SpeedCircle(UI ui, float x, float y, float width, float height, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        pos = new PVector(x, y);
    }
    float move = x-80;

    public void render()
    {
        ui.noFill();
        ui.stroke(255);
        ui.ellipse(pos.x, pos.y, width, height );
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(text, pos.x +5 , pos.y + height -130);
        ui.line(pos.x - 86 , pos.y + 50 , pos.x + 86, pos.y +50);
        ui.pushMatrix();
        ui.translate(pos.x, pos.y);
        ui.rotate(rotation);
        ui.line(x-80, y-50, x  , y+50);
        ui.popMatrix();
        ui.rect(pos.x - 105, pos.y - 105, width + 10, height + 10);
    }

    public void update()
    {
        this.x=(int) Math.sin(rotation);
        this.y = (int) -(float) Math.cos(rotation);
        rotation += 0.0039f;
    }
    
}