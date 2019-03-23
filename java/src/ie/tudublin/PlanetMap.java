package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;


public class PlanetMap extends PApplet
{

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
            ellipse(distance, distance, realDiameter, realDiameter);
            distance = distance + radius;
            System.out.println("distance is " + distance);
            
        }
    }

    private ArrayList<Planets> planets = new ArrayList<Planets>();

    public void draw() {
        background(0);
        drawPlanets();
    }
}