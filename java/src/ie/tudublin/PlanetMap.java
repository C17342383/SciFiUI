package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import processing.core.PVector;


public class PlanetMap extends PApplet
{

    UI ui;
    private float x1;
    private float y1;
    private PVector pos;
    private float rotation;
    private int diameter;

    /*public PlanetMap(UI ui, int x1, int y1, int diameter)
    {
        this.ui = ui;
        this.x1 = x1;
        this.y1 = y1;
        this.diameter = diameter;
    }*/
    public void settings()
    {
        size(800, 800);
    }

    float border;


    public void setup()
    {
        loadData();
        printPlanets();
        border = width * 0.05f;
    }

    public void loadData()
    {
        Table table = loadTable("Planets.csv", "header");

        for (TableRow row : table.rows()) {
            Planets planet = new Planets(row);
            planets.add(planet);
        }

    }

    public void printPlanets() {
        for (Planets planet : planets) {
            System.out.println(planet);
        }
    }

    public void drawPlanets() 
    {
        float width1 = 200;
        float realDiameter = 0;
        float divide = 1391000;
        float distance  = 200;
        float dis = 400;
        float radius  = 0;

        for (Planets planet : planets) {
            float diameter  = planet.getdiameter();
            realDiameter = diameter/divide* width1;
            System.out.println("realdiameter is " + realDiameter);
            radius = realDiameter/2;
            distance = distance + planet.getdistance()*10 + radius;
            stroke(255, 255, 0);
            noFill();
            //translate(distance, distance);
            rotate(rotation);
            ellipse(distance, distance, realDiameter, realDiameter);
            distance = distance + radius;
            System.out.println("distance is " + distance);
            
        }
    }

    public void update()
    {       
        this.x1=(int) Math.sin(rotation);
        this.y1 = (int) -(float) Math.cos(rotation);
        for (Planets planet : planets)
        {
            //float start = 0.1;
            //float start2 = 87.9;
            float orbit = planet.getOuterOrbit();
            float orbitcalc = (float) ((0.01 * 87.97) / orbit);
            rotation += orbitcalc; 
            System.out.println("orbit calc is "+orbitcalc);
        }

    }

    private ArrayList<Planets> planets = new ArrayList<Planets>();

    public void draw()
    {
        background(0);
        drawPlanets();
        update();
    }
}