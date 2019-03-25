package ie.tudublin;

import processing.data.TableRow;

public class Planets 
{
    private String name;
    private int diameter;
    private float distance;
    private float OuterOrbit;

    public void setname(String name)
    {
        this.name = name;
    }

    public String getname()
    {
        return name;
    }

    public void setdiameter(int diameter)
    {
        this.diameter = diameter;
    }

    public int getdiameter()
    {
        return diameter;
    }

    public void setdistance(float distance)
    {
        this.distance = distance;
    }

    public float getdistance()
    {
        return distance;
    }

    public void setOuterOrbit(float OuterOrbit)
    {
        this.OuterOrbit = OuterOrbit;
    }

    public float getOuterOrbit()
    {
        return OuterOrbit;
    }

    public String toString()
    {
        return name + "\t" + diameter + "\t" + distance;  
    }

    public Planets(TableRow row)
    {
        name = row.getString("name");
        diameter = row.getInt("diameter");
        distance = row.getFloat("distance");
        OuterOrbit = row.getFloat("Oorbit");

    }

    public Planets()
    {
        
    }
}
