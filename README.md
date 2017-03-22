# AirportTravel

Java program for airports.

  Utilizes an array of linked lists, i.e an adjacency list. Each airport has it's own index within the array and all airports that are connected to the originating one are put into a linked list. When determining if an aiport is connected to another, a recursive depth-first-search algorithim is applied.

# Commands

q - quits the program <br>
? - displays a list of commands
t <airport1> <airport2> - display a message stating whether a person can travel from aiport1 to aiport2 in one or more flights.
r <int> - resizes the array to contain the number of aiports given by int
i <aiport1> <airport2> - insert the edge to indicate a plane flies from aiport1 to airport2
d <airport1> <airport2> - deletes the edge that indicates a plane flies from airport1 to airport2
l - list all the airports in the network with all their connecting flights
