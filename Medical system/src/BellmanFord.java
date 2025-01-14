import java.util.*;

public class BellmanFord {
    private final int[][] graph;

    public BellmanFord(int[][] graph) {
        this.graph = graph;
    }

    public Result shortestPath(int source) {
        int vertices = graph.length;
        int[] distances = new int[vertices];
        int[] parents = new int[vertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(parents, -1);
        distances[source] = 0;


        for (int i = 0; i < vertices - 1; i++) {
            for (int u = 0; u < vertices; u++) {
                for (int v = 0; v < vertices; v++) {
                    if (graph[u][v] != 0 && distances[u] != Integer.MAX_VALUE &&
                            distances[u] + graph[u][v] < distances[v]) {
                        distances[v] = distances[u] + graph[u][v];
                        parents[v] = u;
                    }
                }
            }
        }

        return new Result(distances, parents);
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
