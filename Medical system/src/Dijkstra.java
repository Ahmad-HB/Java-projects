//import java.util.*;
//public class Dijkstra {
//    private final int[][] graph;
//
//    public Dijkstra(int[][] graph) {
//        this.graph = graph;
//    }
//
//    public int[] shortestPath(int source) {
//        int vertices = graph.length;
//        int[] distances = new int[vertices];
//        boolean[] visited = new boolean[vertices];
//
//        Arrays.fill(distances, Integer.MAX_VALUE);
//        distances[source] = 0;
//
//        for (int i = 0; i < vertices - 1; i++) {
//            int u = selectMinVertex(distances, visited);
//            visited[u] = true;
//
//            for (int v = 0; v < vertices; v++) {
//                if (!visited[v] && graph[u][v] != 0 && distances[u] != Integer.MAX_VALUE &&
//                        distances[u] + graph[u][v] < distances[v]) {
//                    distances[v] = distances[u] + graph[u][v];
//                }
//            }
//        }
//
//        return distances;
//    }
//
//    private int selectMinVertex(int[] distances, boolean[] visited) {
//        int min = Integer.MAX_VALUE;
//        int minIndex = -1;
//
//        for (int i = 0; i < distances.length; i++) {
//            if (!visited[i] && distances[i] < min) {
//                min = distances[i];
//                minIndex = i;
//            }
//        }
//
//        return minIndex;
//    }
//}
import java.util.*;

public class Dijkstra {
    private final int[][] graph;

    public Dijkstra(int[][] graph) {
        this.graph = graph;
    }

    public Result shortestPath(int source) {
        int vertices = graph.length;
        int[] distances = new int[vertices];
        int[] parents = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(parents, -1);
        distances[source] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            int u = selectMinVertex(distances, visited);
            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && graph[u][v] != 0 && distances[u] != Integer.MAX_VALUE &&
                        distances[u] + graph[u][v] < distances[v]) {
                    distances[v] = distances[u] + graph[u][v];
                    parents[v] = u;
                }
            }
        }

        return new Result(distances, parents);
    }

    private int selectMinVertex(int[] distances, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] < min) {
                min = distances[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static class Result {
        public final int[] distances;
        public final int[] parents;

        public Result(int[] distances, int[] parents) {
            this.distances = distances;
            this.parents = parents;
        }
    }
}
