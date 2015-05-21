import java.util.ArrayList;
/**
 * Write a description of class Civ here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Civ
{
    private String name;
    private ArrayList<Civ> enemies;
    private ArrayList<Civ> allies;
    private int pop;            //The Civilization's population
    private int food;           //The Civ's food
    private int gold;           //The Civ's gold
    private int iron;           //The civ's Iron
    private int tax;            //The tax rate 
    private double farm;        //The percentage of the population producing food
    private double labor;       //The percentage of the population producing iron
    private double growth;      //The percentage of the population re-producing ;-)
    private int fLevel;         //Improvement level of farmers
    private int lLevel;         //Improvement level of labor
    private int military;       //The Civ's number of soldiers
    private int mLevel;         //Military improvement level
    private double happiness;   //1 is normal, <1 is unhappy, >1 is happy
    
    public Civ(String name1)
    {
        name = name1;
        pop = 100;
        food = 125;
        gold = 50;
        iron = 30;
        tax = 5;
        farm = .6;
        labor = .3;
        growth = .1;
        fLevel = 1;
        lLevel = 1;
        military = 20;
        mLevel = 1;
        happiness = 1.0;
    }
    
    /**
     * Simulates a Turn, Currently just resource consumption and population growth
     *
     * @return The return value
     */
    public int[] sim()
    {
        int[] turn = new int[4]; //Array that tracks turn changes
        int initialFood = food;
        int initialIron = iron;
        int initialGold = gold;
        int initialPop = pop;

        food += ((pop * farm) * fLevel); //calculate food grown
        food -= (pop / 3); //deduct consumed food
        
        turn[2] = (int)((pop * labor) * lLevel); //calculate Iron
        iron += ((pop * labor) * lLevel);
        
                //Calculate Tax
        gold += pop / tax;
        
        //Calculate population growth
        int foodReq = (int)((pop * growth) * 2);
        if(foodReq > food)
        {;
            pop += (food / 2);
            food = 1;
        }
        else
        {
            pop += ((pop * growth) / 2);
            food -= foodReq;
        }
        
        //return array of Changes
        turn[0] = pop - initialPop;
        turn[1] = gold - initialGold;
        turn[2] = food - initialFood;
        turn[3] = iron - initialIron;
        return turn;
    }
    
    public boolean setPop(int x, int y, int z)
    {
        farm = x / 100;
        //èéêëēėęÿûüùúūîïíīįìôöòóœøōõàáâäæãåāßśšłžźżçćčñń
    }
}