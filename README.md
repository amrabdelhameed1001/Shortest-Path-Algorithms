# Shortest-Path-Algorithms

##1 Introduction
In this assignment, you’re required to implement three shortest paths algorithms for directed weighted graphs which are Dijkstra, Bellman-Ford and Floyd-Warshall.
###1.1 Dijkstra Algorithm
###1.2 Bellman-Ford Algorithm
###1.3 Floyd-Warshall Algorithm
##1.4 Input Graph Structure
A Graph input file will contain several lines that describe a directed graph structure as follows. First line contains two integers V and E which determine number of vertices and edges respectively. This line is followed by E lines describing the edges in the graph. Each of the E lines contain 3 numbers: i, j, w separated by a single space, meaning that there is a weighted edge from vertex i to vertex j (0 ≤ i, j ≤ V − 1), and the weight of the edge is w, where w may be
negative or positive.

##2 Requirements
###2.1 Graph Algorithms
You are required to implement a Graph class that can encapsulate a graph structure and apply different shortest paths algorithms on it. You need to implement the following methods in this class:
1. Initialize (constructor): Takes a path to graph input file structured as described in section 1.4, reads it and initialize the graph structure.
2. Size: Returns the number of nodes in the graph.
3. Dijkestra: Takes 3 parameters which are the source node, the costs array and the parents array. Then applies dijkestra algorithm starting from the source node filling the costs
array with the cost of the shortest path to all other target nodes and the parents array with the parent of each node in the shortest paths tree.
4. Bellman-Ford: Takes 3 parameters which are the source node, the costs array and the parents array. Then applies bellman-ford algorithm starting from the source node filling
the costs array with the cost of the shortest path to all other target nodes and the parents array with the parent of each node in the shortest paths tree. Returns False if a negative cycle is found and True otherwise.
5. Floyd-Warshall: Takes 2 parameters which are the costs matrix and the predecessors matrix. Then applies floyd-warshall algorithm filling the costs matrix with the cost of the
shortest path between all pairs of nodes and the predecessors matrix with the appropriate values to reconstruct the paths. Returns False if a negative cycle is found and True
otherwise.

###2.2 Command Line Interface 

You should implement a command line interface that will enable us to deal with the implemented graph. This interface must take the path of the file describing the graph structure as an initial input then creates a graph object using it. The interface will be composed of a main menu and 2 sub-menus which allow the user to apply subsequent operations on the graph from the following list:
1. Finds the shortest paths from source node to all other nodes. You should ask for the source node and then allow the user to choose 1 of the 3 algorithms to run. Now, the 2
arrays sent to the algorithm are saved and the user can only ask for the cost of the path to a specific node or the path itself until he decides to exit this operation sub-menu and return to the main menu.

2. Finds the shortest paths between all the pairs of nodes. You should allow the user to choose 1 of the 3 algorithms to run. Now, all the arrays sent to the algorithm are saved
and the user can only ask for the cost of a path from a specific node to another one or the path itself until he decides to exit this operation sub-menu and return to the main
menu.
3. Check if the graph contains a negative cycle. You should allow the user to choose 1 of the 2 algorithms to run and show the result.
###2.3 Java Unit Testing
You should provide a set of 15-20 JUnit tests that test the correctness and effeciency of the different implemented parts. Also, these tests must show a comprehensive comparison between the 3 algorithms w.r.t time factor.
