import java.io.*;
import java.util.*;

public class ilindm2Proj6
{

    public static void main (String[] args)
    {
        BufferedReader userInput = new BufferedReader (new InputStreamReader (System.in));
        Proj6Base airportData = new Proj6Base();
        List[] Airports = new List[10];
        for(int i = 0; i < 10 ; i++){
            Airports[i] = new List();
        }
        airportData.processCommandLoop (userInput, Airports);

        System.out.println ("Goodbye");
    }


    public void processCommandLoop (BufferedReader userInput, List[] Airports)
    {
        try {  
            String inline = userInput.readLine();  
            Scanner sc;
            
            while (inline != null)
            {
                sc = new Scanner (inline);   
                String command = sc.next();
                System.out.println ("*" + command + "*");

                if (command.equals("q") == true)
                    System.exit(1);

                else if (command.equals("?") == true)
                    showCommands();

                else if (command.equals("t") == true)
                    doTravel(sc, Airports);

                else if (command.equals("r") == true)
                    doResize(sc, Airports);

                else if (command.equals("i") == true)
                    doInsert(sc, Airports);

                else if (command.equals("d") == true)
                    doDelete(sc, Airports);

                else if (command.equals("l") == true)
                    doList(sc, Airports);

                else if (command.equals("#") == true)
                    ;

                else
                    System.out.println ("Command is not known: " + command);

                inline = userInput.readLine();   

            }
        }
        catch (IOException ioe)
        {
            System.out.println ("Error in Reading - Assuming End of File");
        }
    }

    public void showCommands()
    {
        System.out.println ("The commands are:");
        System.out.println ("  q ");
        System.out.println ("  ? ");
        System.out.println ("  # ");
        System.out.println ("  t <int1> <int2> ");
        System.out.println ("  r <int> ");
        System.out.println ("  i <int1> <int2> ");
        System.out.println ("  d <int1> <int2> ");
        System.out.println ("  l ");

    }

    public void doTravel(Scanner sc, List[] Airports)
    {
        int fromAirport = 0;
        int toAirport = 0;

        if ( sc.hasNextInt() == true )
            fromAirport = sc.nextInt();
        else
        {
            System.out.println ("Integer value expected");
            return;
        }

        if ( sc.hasNextInt() == true )
            toAirport = sc.nextInt();
        else
        {
            System.out.println ("Integer value expected");
            return;
        }

        System.out.println ("Performing the Travel Command from " + fromAirport +
                " to " + toAirport);


        Airports[fromAirport-1].depthFirstSearchHelper(fromAirport,toAirport,Airports);

    }

    public List[] doResize(Scanner sc, List[] Airports)
    {
        int fromAirport = 0;

        if ( sc.hasNextInt() == true )
            fromAirport = sc.nextInt();
        else
        {
            System.out.println ("Integer value expected");
            return Airports;
        }

        System.out.println ("Performing the Resize Command with " + fromAirport );

        if(fromAirport < Airports.length){
            System.out.println(" Value is smaller! No need to resize.");
        }
        else { //value is larger, therefore you should reszize

            List[] temp = new List[fromAirport];
            for(int i = 0; i < temp.length ; i++){
                Airports[i] = new List();
            }

            Airports = temp;
        }


        return Airports;
    }

    public void doInsert(Scanner sc, List[] Airports)
    {
        int fromAirport = 0;
        int flight = 0;

        if ( sc.hasNextInt() == true )
            fromAirport = sc.nextInt();
        else
        {
            System.out.println ("Integer value expected");
            return;
        }

        if ( sc.hasNextInt() == true )
            flight = sc.nextInt();
        else
        {
            System.out.println ("Integer value expected");
            return;
        }

        System.out.println ("Adding flight " + flight + " to airport " + fromAirport );

        if(Airports != null){
            if (fromAirport > Airports.length){
                System.out.println ("Trying to insert to nonexistent airport!!");
            }
            else {
                Airports[fromAirport-1].insert(flight);
            }
        }
    }

    public void doDelete(Scanner sc, List[] Airports)
    {
        int fromAirport = 0;
        int toAirport = 0;

        if ( sc.hasNextInt() == true )
            fromAirport = sc.nextInt();
        else
        {
            System.out.println ("Integer value expected");
            return;
        }

        if ( sc.hasNextInt() == true )
            toAirport = sc.nextInt();
        else
        {
            System.out.println ("Integer value expected");
            return;
        }

        System.out.println ("Performing the delete Command from " + fromAirport + " to " + toAirport);

        Airports[fromAirport-1].remove(toAirport);
    }

    public void doList(Scanner sc, List[] Airports)
    {
        int fromAirport = 0;

        if ( sc.hasNextInt() == true )
            fromAirport = sc.nextInt();
        else
        {
            System.out.println ("Integer value expected");
            return;
        }

        System.out.println ("Performing the list Command with " + fromAirport );
        for(int i = 0; i < Airports.length ; i++){
            Airports[i].show();
        }
    }

}
