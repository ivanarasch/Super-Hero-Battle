import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.PrintWriter;

public class BattleRoyale {
    public static void main(String[] args) throws IOException {
        ArrayList<SuperHero> heroes = DataReader.readDataFileAndClassify("SuperheroDataset.csv");
//        System.out.println(heroes.get(0).getCombat());
        for (int i = 0; i < heroes.size(); i++)
        {
            for(int j = 1; j < heroes.size() - 1; j++)
            {
                int result = heroes.get(i).combat(heroes.get(j));

                if(result>0)
                {
                   heroes.get(i).won();
                   heroes.get(j).lost();
                }

                else if(result<0)
                {
                    heroes.get(j).won();
                    heroes.get(i).lost();
                }

                else
                {
                    heroes.get(i).tie();
                    heroes.get(j).tie();
                }
            }
        }

        Collections.sort(heroes);

        PrintWriter file = new PrintWriter("results.txt"); // creating an object

        file.println("The Fast Heroes won: " + FastHeroes.getWins() + " times. The Fast Heroes lost: " + FastHeroes.getLosses() + " times. The Fast Heroes tied: " + FastHeroes.getTies() + " times.");
        file.println("The Female Heroes won: " + FemaleHeroes.getWins() + " times. The Female Heroes lost: " + FemaleHeroes.getLosses() + " times. The Female Heroes tied: " + FemaleHeroes.getTies() + " times.");
        file.println("The Male Heroes won: " + MaleHeroes.getWins() + " times. The Male Heroes lost: " + MaleHeroes.getLosses() + " times. The Male Heroes tied: " + MaleHeroes.getTies()+ " times.");
        file.println("The Smart Villans  won: " + SmartVillans.getWins() + " times. The Smart Villans lost: " + SmartVillans.getLosses() + " times. The Smart Villans tied: " + SmartVillans.getTies() + "times" );
        file.println("The Super Strong Females  won: " + SuperStrongFemale.getWins() + " times. The Super Strong Females lost: " + SuperStrongFemale.getLosses() + " times. The Super Strong Females tied: " + SuperStrongFemale.getTies() + " times.");
        file.println("The Villans won: " + Villans.getWins() + " times. The Villans lost: " + Villans.getLosses() + " times. The fast Heroes tied:" + Villans.getTies() + " times.");
        file.println("The Super Heroes won: " + SuperHero.getWins() + " times. The Super Heroes lost: " + SuperHero.getLosses() + " times. The Super Heroes tied: " + SuperHero.getTies() + " times.");

        int max = 0;
        String maxclass = " ";

        if (FastHeroes.getWins()>max)
        {
            max = FastHeroes.getWins();
            maxclass = "Fast Heroes";

        }
        if (FemaleHeroes.getWins()>max)
        {
            max = FemaleHeroes.getWins();
            maxclass = "Female Heroes";
        }
        if (FemaleHeroes.getWins()>max)
        {
            max = MaleHeroes.getWins();
            maxclass = "Male Heroes";
        }
        if (SmartVillans.getWins()>max)
        {
            max = SmartVillans.getWins();
            maxclass = "Smart Villans";
        }
        if (SuperStrongFemale.getWins()>max)
        {
            max = SuperStrongFemale.getWins();
            maxclass = " Super Strong Female";
        }
        if (Villans.getWins()>max)
        {
            max = Villans.getWins();
            maxclass = "Villans";
        }

        file.println("The class of Super Heroes that won the most is: " + maxclass+".");



        for (int i = 0; i < heroes.size(); i++)
        {
            file.println("The hero the " + heroes.get(i).getName()+ " won " + heroes.get(i).getWinsNonStatic() +
                    " times, and lost " + heroes.get(i).getLossesNonStatic() + " times but also tied " + heroes.get(i).getTiesNonStatic()+ " times.");

        }

        file.close();












    }

    // call combat method and make nested for loops for each super hereo it should be inside the
}
