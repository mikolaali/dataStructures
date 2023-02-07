package nik.graph;

public class GraphApp {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');

        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(5, 6);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        System.out.print("Visits: ");
        graph.dfs();             // Обход в глубину
        System.out.println();

        //  ostavnoe tree
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addEdge(0, 1);
        theGraph.addEdge(0, 2);
        theGraph.addEdge(0, 3);
        theGraph.addEdge(0, 4);
        theGraph.addEdge(1, 2);
        theGraph.addEdge(1, 3);
        theGraph.addEdge(1, 4);
        theGraph.addEdge(2, 3);
        theGraph.addEdge(2, 4);
        theGraph.addEdge(3, 4);

        theGraph.mst();
    }
}
