import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter path of file: ");
        String path = sc.nextLine();
        Graph g = new Graph(path);
        int[] costs = new int[g.size()];
        int[] parents = new int[g.size()];
        boolean result;

        //Dijkstra
        g.dijkstra(0 , costs , parents);
        System.out.println(Arrays.toString(costs));
        System.out.println(Arrays.toString(parents));

        //Bellman-ford
        Arrays.fill(costs , Integer.MAX_VALUE);
        Arrays.fill(parents, -1);
        result = g.bellmanFord(0,costs , parents);
        if(result){
            System.out.println(Arrays.toString(costs));
            System.out.println(Arrays.toString(parents));

        }
        else{
            System.out.println("Negative cycle found");
        }


        //Floyd-warshal
        int[][] costsMatrix = new int[g.size()][g.size()];
        int[][] predecessorsMatrix = new int[g.size()][g.size()];
        g.floydWarshall(costsMatrix,predecessorsMatrix);

        for(int i = 0 ; i<g.size() ; i++){
            System.out.println(Arrays.toString(costsMatrix[i]));

        }
        for(int i = 0 ; i<g.size(); i++){
            System.out.println(Arrays.toString(predecessorsMatrix[i]));
        }
    }


}
