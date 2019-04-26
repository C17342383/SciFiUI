package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;
import processing.core.*;
import processing.*;
import java.util.ArrayList;
import processing.data.Table;
import processing.data.TableRow;
import javax.swing.*;

public class SpeedCircle
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private String text;
    private PVector pos;
    private float rotation;
    public float change;

    public SpeedCircle(UI ui, float x, float y, float width, float height, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        pos = new PVector(x, y);
    }
    float move = x-80;
    float radius = 100;
    //float xr = pos.x - 40;
    //float yr = pos.y +100;
    int arcAngle = 180;

    public void render()
    {
        ui.noFill();
        ui.stroke(255);
        ui.ellipse(pos.x, pos.y, width, height );
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(text, pos.x +5 , pos.y + height -130);
        ui.line(pos.x - 86 , pos.y + 50 , pos.x + 86, pos.y +50);
        ui.pushMatrix();
        change = pos.x-80;
        ui.line(change, pos.y+10, pos.x  , pos.y+50);
        ui.translate(pos.x, pos.y);
        //ui.rotate(rotation);
        ui.rotate(arcAngle);
        ui.line(0 , 0 ,x+40, y+60);
        ui.popMatrix();


        ui.rect(pos.x - 105, pos.y - 105, width + 10, height + 10);
        int startAngle = 0;
    
        //ui.arc(pos.x + 100, pos.y+100, 50, 50, startAngle, ui.PI/2);
        ui.arc(pos.x , pos.y, 150, 150, ui.radians(180), ui.radians(360));

        
    }

    public void update()
    {
        this.x=(int) Math.sin(rotation);
        this.y = (int) -(float) Math.cos(rotation);
        rotation += 0.000000000000001f;

        while(arcAngle != 300)
        {
            arcAngle = arcAngle + 1;
        }

        for (int i=0; i< 33; i++) {
            change = change + 5;
        }
        ui.line(change, pos.y+10, pos.x  , pos.y+50);
    }

    
}