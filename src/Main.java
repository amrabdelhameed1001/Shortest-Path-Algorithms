import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the path of the file: ");
            String filePath = scanner.nextLine();
            Graph graph = new Graph(filePath);
            boolean running = true;
            while (running) {
                System.out.println("Main Menu:");
                System.out.println("1. Find shortest paths from a source node");
                System.out.println("2. Check if the graph contains a negative cycle");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline character
                switch (choice) {
                    case 1:
                        System.out.print("Enter the source node: ");
                        int sourceNode = scanner.nextInt();
                        scanner.nextLine(); // consume newline character
                        System.out.println("Choose an algorithm:");
                        System.out.println("1. Dijkstra");
                        System.out.println("2. Bellman-Ford");
                        System.out.println("3. Floyd-Warshall");
                        System.out.print("Enter your choice: ");
                        int algorithm = scanner.nextInt();
                        scanner.nextLine(); // consume newline character
                        switch (algorithm) {
                            case 1:
                                int[] dijkstraCosts = new int[graph.size()];
                                int[] dijkstraParents = new int[graph.size()];
                                graph.dijkstra(sourceNode, dijkstraCosts, dijkstraParents);
                                boolean runningDijkstra = true;
                                while (runningDijkstra) {
                                    System.out.println("Dijkstra Menu:");
                                    System.out.println("1. Get cost of a path from a specific node");
                                    System.out.println("2. Get the path from a specific node");
                                    System.out.println("3. Exit");
                                    System.out.print("Enter your choice: ");
                                    int dijkstraChoice = scanner.nextInt();
                                    scanner.nextLine(); // consume newline character
                                    switch (dijkstraChoice) {
                                        case 1:
                                            System.out.print("Enter the target node: ");
                                            int targetNode = scanner.nextInt();
                                            scanner.nextLine(); // consume newline character
                                            System.out.println("Cost of the path: " + dijkstraCosts[targetNode]);
                                            break;
                                        case 2:
                                            System.out.print("Enter the target node: ");
                                            int targetNode2 = scanner.nextInt();
                                            scanner.nextLine(); // consume newline character
                                            System.out.print("Path: ");
                                            int currentNode = targetNode2;
                                            while (currentNode != sourceNode) {
                                                System.out.print(currentNode + " ");
                                                currentNode = dijkstraParents[currentNode];
                                            }
                                            System.out.print(sourceNode);
                                            System.out.println();
                                            break;
                                        case 3:
                                            runningDijkstra = false;
                                            break;
                                        default:
                                            System.out.println("Invalid choice");
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                int[] bellmanFordCosts = new int[graph.size()];
                                int[] bellmanFordParents = new int[graph.size()];
                                boolean hasNegativeCycle = graph.bellmanFord(sourceNode, bellmanFordCosts, bellmanFordParents);
                                System.out.println("Has negative cycle: " + !hasNegativeCycle);
                                break;
                            case 3:
                                int[][] floydWarshallCosts = new int[graph.size()][graph.size()];
                                int[][] floydWarshallPredecessors = new int[graph.size()][graph.size()];
                                boolean hasNegativeCycle2 = graph.floydWarshall(floydWarshallCosts, floydWarshallPredecessors);
                                System.out.println("Has negative cycle: " + !hasNegativeCycle2);
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Choose an algorithm:");
                        System.out.println("1. Bellman-Ford");
                        System.out.println("2. Floyd-Warshall");
                        System.out.print("Enter your choice: ");
                        int algorithm2 = scanner.nextInt();
                        scanner.nextLine(); // consume newline character
                        switch (algorithm2) {
                            case 1:
                                int[] bellmanFordCosts = new int[graph.size()];
                                int[] bellmanFordParents = new int[graph.size()];
                                boolean hasNegativeCycle = graph.bellmanFord(0, bellmanFordCosts, bellmanFordParents);
                                System.out.println("Has negative cycle: " + hasNegativeCycle);
                                break;
                            case 2:
                                int[][] floydWarshallCosts = new int[graph.size()][graph.size()];
                                int[][] floydWarshallPredecessors = new int[graph.size()][graph.size()];
                                boolean hasNegativeCycle2 = graph.floydWarshall(floydWarshallCosts, floydWarshallPredecessors);
                                System.out.println("Has negative cycle: " + hasNegativeCycle2);
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                        break;
                    case 3:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }


    }
}
