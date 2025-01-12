import java.util.*;
public class Graph {

	private final int nodes;
	private final int[][] adjacencyMatrix;

	public Graph(int nodes) {
		this.nodes = nodes;
		this.adjacencyMatrix = new int[nodes][nodes];
	}

	public void addEdge(int from, int to, int weight) {
		adjacencyMatrix[from][to] = weight;
	}

	public int[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public int getNodes() {
		return nodes;
	}

//	public void printGraph() {
//		System.out.println("Adjacency Matrix:");
//		for (int[] row : adjacencyMatrix) {
//			System.out.println(Arrays.toString(row));
//		}
//	}

	public void printGraph() {
		System.out.println("Adjacency Matrix:");

		System.out.print("\t");
		for (int i = 0; i < nodes; i++) {
			if (i < HospitalManagementSystem.ROOMS) {
				System.out.print("R" + i + "\t");
			} else {
				System.out.print("E" + (i - HospitalManagementSystem.ROOMS) + "\t");
			}
		}
		System.out.println();

		for (int i = 0; i < nodes; i++) {
			if (i < HospitalManagementSystem.ROOMS) {
				System.out.print("R" + i + "\t");
			} else {
				System.out.print("E" + (i - HospitalManagementSystem.ROOMS) + "\t");
			}

			for (int j = 0; j < nodes; j++) {
				System.out.print(adjacencyMatrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
