package ie.tudublin;

import processing.core.PApplet;

public class DecayWarning 
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private String text;
    private String text2;

    public DecayWarning(UI ui, float x, float y, float width, float height, String text, String text2)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.text2 = text2;
    }

    public void render()
    {
        ui.noFill();
        ui.stroke(255, 69, 0);
        ui.fill(22, 22, 22);
        ui.rect(x - (width/2), y -(height/2), width, height);
        ui.fill(255, 69, 0);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(text , x + width * 0.02f, y - height * 0.1f);
        ui.text(text2 , x + width * 0.02f, y + height * 0.2f);
    }
}