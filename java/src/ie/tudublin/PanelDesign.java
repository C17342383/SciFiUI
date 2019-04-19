package ie.tudublin;


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
        float halfW = width /2;
        float halfH = height /2;
        ui.noFill();
        ui.stroke(255);
        ui.rect(20, 20 , width -40, height - 40 );
        ui.rect(30, 30, halfW , halfH );

        int numLines = 10;
        float gap = halfW / numLines;
        float x =30;
		for(int l = 0 ; l < numLines; l ++)
		{
			x = x + gap;
			ui.line(x, 30, x, halfH + 30);
        }
        
        numLines = 5;
        gap = halfH / numLines;
        x = 30;
        for(int l = 0 ; l < numLines; l ++)
		{
			x = x + gap;
			ui.line(30, x,halfW + 30 ,x);
        }

       // ui.rect(600, 600, width -25, height -25);
       ui.rect(halfW + gap + gap/2, 40, 590, height - 80);
    }
}