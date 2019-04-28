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
    public float down;
    public float downgap;
    public float downx;
    public float downy;
    public float temp;

    public Thruster(UI ui, float x, float y, float width, float height, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        down = height /2;
        downgap = ((height/2)/6)/2;
        downx = x + height -(width/4) ;
        downy =  y + (height/2);
        temp = y + (height/2);
    }
    //float down = x + height + width/4;

    public void render()
    {
        //System.out.println("Down : " + down);
        float halfW = width/2;
        float halfH = height/2;
        float smallbox = 20;
        ui.noFill();
        ui.stroke(255);
        ui.rect(x, y, width, height/2);
        ui.rect(x + halfW - smallbox/2, y - smallbox/2, smallbox, smallbox);
        float distin = width/4;
        ui.line(x + distin , y + halfH, x - distin , y + height );
        ui.line(x - distin , y + height, x + halfW - smallbox/2, y + height );
        ui.rect(x + halfW - smallbox/2, y + height - smallbox/2, smallbox, smallbox);
        ui.line(x + halfW +smallbox/2, y + height,x + halfW +smallbox/2 + halfW + distin , y+height );
        ui.line(x + halfW +smallbox/2 + halfW + distin , y+height, x + distin*3, y + halfH);
        
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(text, x + width * 1.4f, y + height * 1.07f);

        ui.line(x + width + halfW + distin*2 , y+height,x + width + halfW + distin*2, y + halfH );
        //ui.line( y + halfH - distin, x + width + halfW + distin*2, y + halfH, x + width + halfW + distin*2);
        //ui.line(y,x + halfH, y -distin, x + halfH);
        //ui.line(  x + width + halfW + distin*2,y + halfH , x+ height - distin, y + halfH); //y - halfH - distin, x + height + distin );


        ui.rect(x - distin*2, y+height + 30, height + distin, 20);
        ui.rect(x - distin*2, y+height + 60, height + distin, 20);
        ui.rect(x - distin*2, y+height + 90, height + distin, 20);

        int numLines = 3;
        float gap =halfH/ numLines;
        float x1 =y + halfH ;
		for(int l = 0 ; l <= numLines; l ++)
		{
            //ui.line(x + height, x1, y + 180, x1);
            ui.line(  x + width + halfW + distin*2,x1 , x+ height - distin, x1);
            x1 = x1+gap;
        }
        numLines = 6;
        gap = (halfH/numLines)/2;
        x1 =y + halfH + gap;
        for(int l = 0 ; l < numLines *2; l ++)
		{
            //ui.line(x + height, x1, y + 180, x1);
            ui.line(x+height - distin /2, x1,  x+height   , x1);
            x1 = x1+gap;
        }

        ui.pushMatrix();
        //float down = x+ height - distin;
        ui.rect(downx , downy,distin, down);
        ui.popMatrix();
    }
    

    public void update()
    {
        down = down - downgap;
        //downx = downx + downgap;
        downy = downy + downgap;

    }

    public int check()
    {
        System.out.println("downy orig : "+ temp );
        System.out.println("downy each after : "+ downy);
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
        //if(ch == 1)
        {
            //System.out.println("YAY");
            //ui.cf.render();
            return 1;
        }
        else{
            return 0;
        }


    }
}