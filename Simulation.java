public class Simulation {

    public static String usage() {
        String s = "Usage: java Simulation [population size] [percentage of theives] [t | f]";
        return s;
    }

    public static void main(String[] args) {
        int pop = 0;
        int thieves = 0;
        boolean kantianism;


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
        else {System.out.println(usage());}

    }
}