package ie.tudublin;

import processing.core.PApplet;

public class CircleButton
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private String text;

    public CircleButton(UI ui, float x, float y, float width, float height, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public void render()
    {
        ui.noFill();
        ui.stroke(255);
        ui.ellipse(x, y, width, height);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(text, x + width * 0.5f, y + height * 0.5f);
    }
}