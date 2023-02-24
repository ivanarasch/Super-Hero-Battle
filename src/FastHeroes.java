import java.util.ArrayList;

class FastHeroes extends SuperHero
{

    public FastHeroes(String [] fields)
    {
        super(fields);
    }
    public static boolean meetsConditions(String[] fields)
    {
        if (Integer.parseInt(fields[3]) == 100)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    public int attack(SuperHero oHero)
    {
        int damage = super.attack(oHero);

        if (oHero.getIntelligence() > 50)
        {
            damage+=15;

        }

        return damage;
    }

    public int defend(int damage)
    {
        damage = super.defend(damage);

        return damage/7;

    }

    private int winsHero = 0;
    private int lossesHero = 0;
    private int tiesHero = 0;
    private static int wins = 0;
    private static int losses = 0;
    private static int ties = 0;
    @Override
    public void won()
    {
        FastHeroes.wins++;
        this.winsHero++;
    }

    @Override
    public void lost()
    {
        FastHeroes.losses++;
        this.lossesHero++;
    }

    @Override
    public void tie()
    {
        FastHeroes.ties++;
        this.tiesHero++;
    }

    public static int getTies()
    {
        return ties;
    }

    public static int getWins()
    {
        return wins;
    }

    public static int getLosses()
    {
        return losses;
    }

    @Override
    public int getWinsNonStatic()
    {
        return this.winsHero;
    }

    @Override
    public int getLossesNonStatic()
    {
        return this.lossesHero;
    }

    @Override
    public int getTiesNonStatic()
    {
        return this.tiesHero;
    }
}
