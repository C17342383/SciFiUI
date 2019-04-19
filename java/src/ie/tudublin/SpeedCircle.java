package ie.tudublin;

import processing.core.PApplet;

public class SpeedCircle
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private String text;

    public SpeedCircle(UI ui, float x, float y, float width, float height, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }
    float move = x-80;

    public void render()
    {
        ui.noFill();
        ui.stroke(255);
        ui.ellipse(x, y, width, height );
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(text, x +5 , y + height -130);
        ui.line(x - 86 , y + 50 , x + 86, y +50);
        ui.line(x-80, y-50, x  , y+50);
        ui.rect(x - 105, y - 105, width +10, height + 10);
    }

   /* public void update()
    {   
        int r; 
        double x1;

        // insert random numbers between 0 and 99 into heap
        for(int i = 1; i <= 10; ++i)  {
           x1 =  (Math.random()*250.0);
           r = (int) x1 /100; 
           System.out.println("Inserting " + r);
           move = move + r;
           move = x-80;
        }

    }
    */
}