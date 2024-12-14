import java.io.*;
import java.util.*;

public class reachableroads {
    public static ArrayList<Integer> visited;

    public static void dfs(ArrayList<ArrayList<Integer>> graph, int curr){
        if(visited.get(curr) == 1) return;
        visited.set(curr, 1);
        for(int neightbor : graph.get(curr)) dfs(graph, neightbor);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        while(n>0){
            int v = scanner.nextInt();//num of nodes
            int e = scanner.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int i=0; i< v; i++) {
                graph.add(new ArrayList<>());//add in edges (0,1,2,3,4)
            }

            for(int i =0; i<e; i++){
                int from = scanner.nextInt();
                int to = scanner.nextInt();
                graph.get(from).add(to);
                graph.get(to).add(from);
            }
            int cc =0;
            visited =new ArrayList<>();
            for(int i=0;i<v;i++){
                visited.add(0); //visited = 1 unvisited = 0
            }
            for(int i =0; i < v; i++){
                if(visited.get(i) == 0){ // if unvisited
                    cc++;
                    dfs(graph, i);
                }
            }
            System.out.println(cc-1);
            n--;
        }
    }

}
