package ie.tudublin;

import processing.core.PApplet;

public class TankVolume
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private String text;

    public TankVolume(UI ui, float x, float y, float width, float height, String text)
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
        ui.rect(x, y, width, height);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(text, x + width * 0.55f, y + height * 1.08f);


        int numLines = 10;
        float gap = height / numLines;
        float x1 =y;
		for(int l = 0 ; l < numLines; l ++)
		{
            ui.line(x, x1, x+width, x1);
            x1 = x1+gap;
        }
        x1 =0;
    }
}