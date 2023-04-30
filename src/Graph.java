import java.util.*;
import java.io.*;

public class Graph {
    private int V; // number of vertices
    private LinkedList<Edge>[] adj; // adjacency list representation

    // Edge class to represent weighted edges in the graph
    private class Edge {
        int dest;
        int weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Initialize the graph from a file
    public Graph(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        this.V = scanner.nextInt();
        this.adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Edge>();
        }
        scanner.nextInt();
        while (scanner.hasNextInt()) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            addEdge(u, v, w);
        }
        scanner.close();
    }

    // Add an edge to the graph
    public void addEdge(int u, int v, int w) {
        adj[u].add(new Edge(v, w));
        adj[v].add(new Edge(u, w));
    }

    // Returns the number of nodes in the graph
    public int size() {
        return V;
    }

    // Dijkstra's shortest path algorithm
    public void dijkstra(int source, int[] costs, int[] parents) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>((a, b) -> a.weight - b.weight);
        pq.offer(new Edge(source, 0));
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[source] = 0;
        Arrays.fill(parents, -1);
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int u = cur.dest;
            int w = cur.weight;
            if (w > costs[u]) continue;
            for (Edge e : adj[u]) {
                int v = e.dest;
                int newCost = costs[u] + e.weight;
                if (newCost < costs[v]) {
                    costs[v] = newCost;
                    parents[v] = u;
                    pq.offer(new Edge(v, newCost));
                }
            }
        }
    }

    // Bellman-Ford shortest path algorithm
    public boolean bellmanFord(int source, int[] costs, int[] parents) {
        Arrays.fill(costs, Integer.MAX_VALUE);
        Arrays.fill(parents, -1);
        costs[source] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (int u = 0; u < V; u++) {
                for (Edge e : adj[u]) {
                    int v = e.dest;
                    int w = e.weight;
                    if (costs[u] != Integer.MAX_VALUE && costs[u] + w < costs[v]) {
                        costs[v] = costs[u] + w;
                        parents[v] = u;
                    }
                }
            }
        }
        // check for negative cycles
        for (int u = 0; u < V; u++) {
            for (Edge e : adj[u]) {
                int v = e.dest;
                int w = e.weight;
                if (costs[u] != Integer.MAX_VALUE && costs[u] + w < costs[v]) {
                    return false; // negative cycle found
                }
            }
        }
        return true;
    }

    // Floyd-Warshall shortest path algorithm
    public boolean floydWarshall(int[][] costs, int[][] predecessors) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    costs[i][j] = 0;
                    predecessors[i][j] = -1;
                } else {
                    costs[i][j] = Integer.MAX_VALUE;
                    predecessors[i][j] = -1;
                }
            }
            for (Edge e : adj[i]) {
                int j = e.dest;
                int w = e.weight;
                costs[i][j] = w;
                predecessors[i][j] = i;
            }
        }
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (costs[i][k] != Integer.MAX_VALUE && costs[k][j] != Integer.MAX_VALUE &&
                            costs[i][k] + costs[k][j] < costs[i][j]) {
                        costs[i][j] = costs[i][k] + costs[k][j];
                        predecessors[i][j] = predecessors[k][j];
                    }
                }
            }
        }
        // check for negative cycles
        for (int i = 0; i < V; i++) {
            if (costs[i][i] < 0) {
                return false; // negative cycle found
            }
        }
        return true;
    }
}
