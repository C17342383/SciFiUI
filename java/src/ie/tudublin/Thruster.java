package ie.tudublin;

import processing.core.PApplet;

public class Thruster
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private String text;

    public Thruster(UI ui, float x, float y, float width, float height, String text)
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
        ui.rect(x, y, width, height/2);
        ui.rect(x + (width/2)-10, y  -10, 20, 20);
        ui.line(x-(width/6),x + height,y + 20, x +height/2 );
        ui.line(x-(width/6),x +height,y + 40, y + height);
        ui.line(x-(width/6) + 78,x +height,y + 115, y + height);
        ui.line(x + width+17,x + height,y + 80, x +width );
        ui.rect(x + (width/2)-10, y + height -10, 20, 20);
        ui.line(x + height, y+ height, y+height, x+ width);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(text, x + width * 1.4f, y + height * 1.07f);

        int numLines = 3;
        float gap =width/ numLines;
        float x1 =y + width ;
		for(int l = 0 ; l <= numLines; l ++)
		{
            //ui.line(x + height, x1, y + 180, x1);
            ui.line(x+height, x1, y + 170 , x1);
            x1 = x1+gap;
        }
        numLines = 6;
        gap = (width/numLines)/2;
        x1 =y+width + gap;
        for(int l = 0 ; l < numLines *2; l ++)
		{
            //ui.line(x + height, x1, y + 180, x1);
            ui.line(x+height, x1, y + 190 , x1);
            x1 = x1+gap;
        }
    }
}