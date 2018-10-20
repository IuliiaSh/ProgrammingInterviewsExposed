package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SixDegreesOfKevinBacon {
    public static int getDegree(Graph g, int first, int second) {
        Queue<Integer> toBeVisited = new LinkedList();
        toBeVisited.offer(first);
        int[] degree = new int[g.size];
        int currentVertex;
        ArrayList<Integer> nextVertices;
        int nextVertex;
        while (!toBeVisited.isEmpty()) {
            currentVertex = toBeVisited.poll();
            if (currentVertex == second) {
                return degree[currentVertex];
            }

            nextVertices = g.adjacencyList[currentVertex];
            for (int i = 0; i < nextVertices.size(); i++) {
                nextVertex = nextVertices.get(i);
                if (degree[nextVertex] == 0) {
                    toBeVisited.offer(nextVertex);
                    degree[nextVertex] = degree[currentVertex] + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 7);
        g.addEdge(2, 4);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 6);
        g.addEdge(3, 6);
        g.addEdge(7, 8);
        g.addEdge(8, 9);

        System.out.println(getDegree(g, 1, 6));
    }
}

class Graph {
    int size;
    ArrayList<Integer>[] adjacencyList;

    public Graph(int size) {
        this.size = size;
        adjacencyList = (ArrayList<Integer>[]) new ArrayList[size];
        for (int i = 0; i < size; i++) {
            adjacencyList[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int first, int second) {
        adjacencyList[first].add(second);
        adjacencyList[second].add(first);
    }
}
