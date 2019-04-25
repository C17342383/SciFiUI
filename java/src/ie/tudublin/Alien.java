package ie.tudublin;

import processing.data.*;

public class Alien
{
    private float temp;

    public Alien(float temp)
    {
        this.temp = temp;
    }

    public String toString()
    {
        return temp + "\t" ;
    }

    public Alien(TableRow tabler)
    {
        this(tabler.getFloat("Alien"));
    }



    /**
     * @return the temp
     */
    public float getTemp() {
        return temp;
    }

    /**
     * @param temp the temp to set
     */
    public void setTemp(float temp) {
        this.temp = temp;
    }
    
}