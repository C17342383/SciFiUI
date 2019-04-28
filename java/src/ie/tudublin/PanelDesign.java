package ie.tudublin;

import processing.core.PApplet;

public class PanelDesign
{
    UI ui;
    private int width;
    private int height;
    private String Text;
    private String text2;

    public PanelDesign(UI ui, int width, int height, String Text, String text2)
    {
        this.ui = ui;
        this.width = width;
        this.height = height;
        this.Text = Text;
        this.text2 = text2;
    }

	public void render()
    {
        float halfW = width /2;
        float halfH = height /2;
        ui.noFill();
        ui.stroke(255);
        //ui.fill(29, 28, 40);
        ui.rect(20, 20 , width -40, height - 40 );
        //ui.noFill();
        ui.rect(30, 30, halfW , halfH +halfH/2 + halfH/6);

        int numLines = 10;
        float gap = halfW / numLines;
        float x =30;
		for(int l = 0 ; l < numLines; l ++)
		{
			x = x + gap;
			ui.line(x, 30, x, halfH  +halfH/2 + halfH/6 + 30);
        }
        
        numLines = 8;
        gap = (halfH  +halfH/2 + halfH/6) / numLines;
        x = 30;
        for(int l = 0 ; l < numLines; l ++)
		{
			x = x + gap;
			ui.line(30, x,halfW + 30 ,x);
        }

       // ui.rect(600, 600, width -25, height -25);
       ui.rect(halfW + gap + gap/2, 40, 590, height - 80);
       ui.ellipse(halfW + gap + gap/2 + 13, 53, 10, 10);
       ui.ellipse(halfW + gap + gap/2 + 13, height -53, 10, 10);
       ui.ellipse(halfW + gap + gap/2 + 590 - 13, height -53, 10, 10);
       ui.ellipse(halfW + gap + gap/2 + 590 - 13, 53, 10, 10);
    


       ui.ellipse(13, 13, 10, 10);
       ui.ellipse(width - 13, 13, 10, 10);
       ui.ellipse(width - 13, height -13, 10, 10);
       ui.ellipse(13, height -13, 10, 10);

       ui.rect(1045, 730, 300, 50);
       ui.textAlign(PApplet.CENTER, PApplet.CENTER);
       ui.text(Text, 1200 , 745);
       ui.text(text2, 1200 , 765);
    }
}