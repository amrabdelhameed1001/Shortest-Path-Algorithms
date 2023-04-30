import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String clear = new String(new char[50]).replace("\0", "\r\n");
            Scanner scanner = new Scanner(System.in);
            Graph graph;
            while(true){
                try {
                    System.out.println("Enter the path of the file: ");
                    String filePath = scanner.nextLine();
                    graph = new Graph(filePath);
                    break;
                }catch (Exception e){
                    System.out.println(clear);
                    System.out.println("Can't Find Path!!");
                }
            }
            boolean running = true;
            System.out.println(clear);
            while (running) {
                System.out.println("Main Menu:");
                System.out.println("1. Find shortest paths from a source node");
                System.out.println("2. Check if the graph contains a negative cycle");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline character
                System.out.println(clear);
                switch (choice) {
                    case 1:
                        System.out.print("Enter the source node: ");
                        int sourceNode = scanner.nextInt();
                        scanner.nextLine(); // consume newline character
                        System.out.println(clear);
                        System.out.println("Choose an algorithm:");
                        System.out.println("1. Dijkstra");
                        System.out.println("2. Bellman-Ford");
                        System.out.println("3. Floyd-Warshall");
                        System.out.print("Enter your choice: ");
                        int algorithm = scanner.nextInt();
                        System.out.println(clear);
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
                                    System.out.println(clear);
                                    switch (dijkstraChoice) {
                                        case 1:
                                            System.out.print("Enter the target node: ");
                                            int targetNode = scanner.nextInt();
                                            scanner.nextLine(); // consume newline character
                                            System.out.println(clear);
                                            if(targetNode >= dijkstraCosts.length){
                                                System.out.println(clear);
                                                System.out.println("No Such Node!!");
                                                break;
                                            }
                                            System.out.println(clear);
                                            System.out.println("Cost of the path: " + dijkstraCosts[targetNode]);
                                            break;
                                        case 2:
                                            System.out.print("Enter the target node: ");
                                            int targetNode2 = scanner.nextInt();
                                            scanner.nextLine(); // consume newline character
                                            System.out.println(clear);
                                            if(targetNode2 >= dijkstraParents.length){
                                                System.out.println(clear);
                                                System.out.println("No Such Node!!");
                                                break;
                                            }
                                            System.out.println(clear);
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
                                            System.out.println(clear);
                                            System.out.println("Invalid choice");
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                int[] bellmanFordCosts = new int[graph.size()];
                                int[] bellmanFordParents = new int[graph.size()];
                                boolean hasNegativeCycle = graph.bellmanFord(sourceNode, bellmanFordCosts, bellmanFordParents);
                                boolean runningBellman_Ford = true;
                                while (runningBellman_Ford) {
                                    System.out.println("Bellman-Ford Menu:");
                                    System.out.println("1. Get cost of a path from a specific node");
                                    System.out.println("2. Get the path from a specific node");
                                    System.out.println("3. Exit");
                                    System.out.print("Enter your choice: ");
                                    int bellmanChoice = scanner.nextInt();
                                    scanner.nextLine(); // consume newline character
                                    System.out.println(clear);
                                    switch (bellmanChoice) {
                                        case 1:
                                            System.out.print("Enter the target node: ");
                                            int targetNode = scanner.nextInt();
                                            scanner.nextLine(); // consume newline character
                                            System.out.println(clear);
                                            if(targetNode >= bellmanFordCosts.length){
                                                System.out.println(clear);
                                                System.out.println("No Such Node!!");
                                                break;
                                            }
                                            System.out.println(clear);
                                            System.out.println("Cost of the path: " + bellmanFordCosts[targetNode]);
                                            break;
                                        case 2:
                                            System.out.print("Enter the target node: ");
                                            int targetNode2 = scanner.nextInt();
                                            scanner.nextLine(); // consume newline character
                                            System.out.println(clear);
                                            if(targetNode2 >= bellmanFordParents.length){
                                                System.out.println(clear);
                                                System.out.println("No Such Node!!");
                                                break;
                                            }
                                            System.out.println(clear);
                                            System.out.print("Path: ");
                                            int currentNode = targetNode2;
                                            while (currentNode != sourceNode) {
                                                System.out.print(currentNode + " ");
                                                currentNode = bellmanFordParents[currentNode];
                                            }
                                            System.out.print(sourceNode);
                                            System.out.println();
                                            break;
                                        case 3:
                                            runningBellman_Ford = false;
                                            break;
                                        default:
                                            System.out.println(clear);
                                            System.out.println("Invalid choice");
                                            break;
                                    }
                                }
                                break;
                            case 3:
                                int[][] floydWarshallCosts = new int[graph.size()][graph.size()];
                                int[][] floydWarshallPredecessors = new int[graph.size()][graph.size()];
                                boolean hasNegativeCycle2 = graph.floydWarshall(floydWarshallCosts, floydWarshallPredecessors);
                                boolean runningFloyd_Warshall = true;
                                while (runningFloyd_Warshall) {
                                    System.out.println("Floyd-Warshall Menu:");
                                    System.out.println("1. Get cost of a path from a specific node");
                                    System.out.println("2. Get the path from a specific node");
                                    System.out.println("3. Exit");
                                    System.out.print("Enter your choice: ");
                                    int floydChoice = scanner.nextInt();
                                    scanner.nextLine(); // consume newline character
                                    System.out.println(clear);
                                    switch (floydChoice) {
                                        case 1:
                                            System.out.print("Enter the target node: ");
                                            int targetNode = scanner.nextInt();
                                            scanner.nextLine(); // consume newline character
                                            System.out.println(clear);
                                            if(targetNode >= floydWarshallCosts.length){
                                                System.out.println(clear);
                                                System.out.println("No Such Node!!");
                                                break;
                                            }
                                            System.out.println(clear);
                                            System.out.println("Cost of the path: " + floydWarshallCosts[sourceNode][targetNode]);
                                            break;
                                        case 2:
                                            System.out.print("Enter the target node: ");
                                            int targetNode2 = scanner.nextInt();
                                            scanner.nextLine(); // consume newline character
                                            System.out.println(clear);
                                            if(targetNode2 >= floydWarshallPredecessors.length){
                                                System.out.println(clear);
                                                System.out.println("No Such Node!!");
                                                break;
                                            }
                                            System.out.println(clear);
                                            System.out.print("Path: ");
                                            if(targetNode2 == sourceNode){
                                                System.out.print(" " + sourceNode);
                                                System.out.println();
                                                break;
                                            }
                                            int currentNode = targetNode2;
                                            while (currentNode != sourceNode) {
                                                System.out.print(currentNode + " ");
                                                currentNode = floydWarshallPredecessors[sourceNode][currentNode];
                                            }
                                            System.out.print(sourceNode);
                                            System.out.println();
                                            break;
                                        case 3:
                                            runningFloyd_Warshall = false;
                                            break;
                                        default:
                                            System.out.println(clear);
                                            System.out.println("Invalid choice");
                                            break;
                                    }
                                }
                                break;
                            default:
                                System.out.println(clear);
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
                        System.out.println(clear);
                        switch (algorithm2) {
                            case 1:
                                int[] bellmanFordCosts = new int[graph.size()];
                                int[] bellmanFordParents = new int[graph.size()];
                                boolean hasNegativeCycle = graph.bellmanFord(0, bellmanFordCosts, bellmanFordParents);
                                System.out.println(clear);
                                System.out.println("Has negative cycle: " + hasNegativeCycle);
                                break;
                            case 2:
                                int[][] floydWarshallCosts = new int[graph.size()][graph.size()];
                                int[][] floydWarshallPredecessors = new int[graph.size()][graph.size()];
                                boolean hasNegativeCycle2 = graph.floydWarshall(floydWarshallCosts, floydWarshallPredecessors);
                                System.out.println(clear);
                                System.out.println("Has negative cycle: " + hasNegativeCycle2);
                                break;
                            default:
                                System.out.println(clear);
                                System.out.println("Invalid choice");
                                break;
                        }
                        break;
                    case 3:
                        running = false;
                        break;
                    default:
                        System.out.println(clear);
                        System.out.println("Invalid choice");
                        break;
                }
            }


    }
}
