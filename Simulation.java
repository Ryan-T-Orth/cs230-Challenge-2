import java.util.Random;

public class Simulation {

    public static String usage() {
        String s = "Usage: java Simulation [population size] [percentage of theives] [t | f]";
        return s;
    }

    

    public static void main(String[] args) {
          
        int pop = 0;
        int thieves = 0;
        boolean kantianism = false;
        Random rand = new Random();


        if (args.length != 3) {
            System.out.println(usage());
            System.exit(-1);
        }

        if (Integer.parseInt(args[0]) < 1) {System.out.println(usage());}
        else {pop = Integer.parseInt(args[0]);}

        if (Integer.parseInt(args[1]) > 100 || Integer.parseInt(args[1]) < 0) {
            System.out.println(usage());
            System.exit(-1);
        } else {thieves = (Integer.parseInt(args[1]) * pop) / 100;}

        if (args[2].equals("t")) {kantianism = true;}
        else if (args[2].equals("f")) {kantianism = false;}
        else {
            System.out.println(usage());
            System.exit(-1);
        }


        Person[] society = new Person[pop];

        for (int i = 0; i < (society.length / 10); i++) {society[i] = new Person(100);}
        for (int i = 1 * (society.length / 10); i < 3 * (society.length / 10); i++) {society[i] = new Person(80);}
        for (int i = 3 * (society.length / 10); i < 8 * (society.length / 10); i++) {society[i] = new Person(50);}
        for (int i = 8 * (society.length / 10); i < 9 * (society.length / 10); i++) {society[i] = new Person(30);}
        for (int i = 9 * (society.length / 10); i < society.length; i++) {society[i] = new Person(10);}

        int count = 0;
        int temp = 0;
        while (count < thieves) {
            temp = rand.nextInt(society.length);
            if (!society[temp].isThief()) {
                society[temp].setThief();
                count++;
            }
        }


        int years = 10;

        int citizenAveragesSum = 0;
        int thiefAveragesSum = 0;
        for (int i = 0; i < years; i++) {

            int citizenSum = 0;
            int thiefSum = 0;

            for (int k = 0; k < 52; k++) {
                for (Person p : society) {p.chaseTheBag();}
                
                for (int j = 0; j < society.length; j++) {

                    int victim = rand.nextInt(society.length);
                    while (victim == j) {victim = rand.nextInt(society.length);}

                    if (!kantianism && !society[j].isThief()) {}
                    else {society[j].steal(society[victim]);}
                }
            }

            for (Person p : society) {
                if (p.isThief()) {thiefSum += p.getWealth();} 
                else if (!p.isThief()) {citizenSum += p.getWealth();}
            }

            if (thieves != 0) {thiefAveragesSum += (thiefSum / thieves);}
            if (thieves - pop != 0) {citizenAveragesSum += (citizenSum / (pop - thieves));}

        }

        System.out.println("\nCITIZENS\nAvg Wealth per year / " + years + " years : " + (citizenAveragesSum / years));
        System.out.println("\nTHIEVES\nAvg Wealth per year / " + years + " years : " + (thiefAveragesSum / years) + "\n");

    }
}