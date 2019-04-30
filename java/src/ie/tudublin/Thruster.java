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
    private String text2;
    private String text3;
    private String text4;
    public float down;
    public float downgap;
    public float downx;
    public float downy;
    public float temp;
    public float fuel;

    public Thruster(UI ui, float x, float y, float width, float height, String text, String text2, String text3, String text4)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
        down = height /2;
        downgap = ((height/2)/6)/2;
        downx = x + height -(width/4) ;
        downy =  y + (height/2);
        temp = y + (height/2);
        fuel = 100;
    }

    public void render()
    {
        float halfW = width/2;
        float halfH = height/2;
        float smallbox = 20;
        float distin = width/4;
        ui.fill(13, 13, 13);
        ui.rect(x - width +15, y -10, 300, 335);
        ui.fill(21, 21, 21);
        ui.stroke(255);
        ui.rect(x, y, width, height/2);
        ui.fill(255, 102, 0);
        ui.rect(x + halfW - smallbox/2, y - smallbox/2, smallbox, smallbox);
        ui.line(x + distin , y + halfH, x - distin , y + height );
        ui.line(x - distin , y + height, x + halfW - smallbox/2, y + height );
        ui.rect(x + halfW - smallbox/2, y + height - smallbox/2, smallbox, smallbox);
        ui.line(x + halfW +smallbox/2, y + height,x + halfW +smallbox/2 + halfW + distin , y+height );
        ui.line(x + halfW +smallbox/2 + halfW + distin , y+height, x + distin*3, y + halfH);

        ui.line(x + width + halfW + distin*2 , y+height,x + width + halfW + distin*2, y + halfH );

        ui.fill(32, 32,32);
        ui.rect(x - distin*2, y+height + 30, height + distin, 20);
        ui.rect(x - distin*2, y+height + 60, height + distin, 20);
        ui.rect(x - distin*2, y+height + 90, height + distin, 20);

        ui.fill(255, 102, 0);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(text, x + width * 1.4f, y + height * 1.07f);
        ui.text(text2, x + 60, y+height + 37 * 1.07f);
        ui.text(text3, x + 60 , y + height + 64* 1.07f);
        ui.text(text4, x + 60  , y + height + 92 * 1.07f);

        ui.stroke(0);
        ui.pushMatrix();
        ui.rect(downx , downy,distin, down);
        ui.text(fuel, x + width + width/2 + distin * 1.4f, y + height * 1.07f);
        ui.popMatrix();

        ui.noFill();
        ui.stroke(0);
        int numLines = 3;
        float gap =halfH/ numLines;
        float x1 =y + halfH ;
		for(int l = 0 ; l <= numLines; l ++)
		{
            ui.stroke(0);
            ui.line(  x + width + halfW + distin*2,x1 , x+ height - distin, x1);
            x1 = x1+gap;
        }
        numLines = 6;
        gap = (halfH/numLines)/2;
        x1 =y + halfH + gap;
        for(int l = 0 ; l < numLines *2; l ++)
		{
            ui.stroke(0);
            ui.line(x+height - distin /2, x1,  x+height   , x1);
            x1 = x1+gap;
        }
    }
    

    public void update()
    {
        down = down - downgap;
        downy = downy + downgap;
        fuel = fuel - downgap;
    }

    public int check()
    {
        //System.out.println("downy orig : "+ temp );
        //System.out.println("downy each after : "+ downy);
        float ch = 241;
        float ch1 = 601;
        float ch2 = 249;
        float ch3 = 609;
        if((int)downy >= ch2 && downy <509 )
        {
            downy = 0;
            downgap = 0;

        }
        if((int)downy >= ch3 )
        {
            downy = 0;
            downgap = 0;

        }
        if((int)downy == ch || (int)downy == ch1)
        {
            //System.out.println("YAY");
            return 1;
        }
        else{
            return 0;
        }
    }
}