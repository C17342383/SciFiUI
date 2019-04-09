package ie.tudublin;

import processing.core.PApplet;

public class PanelDesign
{
    UI ui;
    private int width;
    private int height;

    public PanelDesign(UI ui, int width, int height)
    {
        this.ui = ui;
        this.width = width;
        this.height = height;
    }

	public void render()
    {
        ui.noFill();
        ui.stroke(255);
        ui.rect(10, 10 , width -20, height - 20 );
        ui.rect(600, 600, width -25, height -25);
    }
}