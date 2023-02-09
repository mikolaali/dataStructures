package nik.graph;

public class OrientedGraph {
    private final int MAX_VERTS = 20;
    private Node[] vertex;
    private int[][] adjMat;
    private int nVerts;
    private char sortedArray[];

    public OrientedGraph() {
        nVerts = 0;
        vertex = new Node[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        for (int j = 0; j < MAX_VERTS; j++)
            for (int k = 0; k < MAX_VERTS; k++)
                adjMat[j][k] = 0;

        sortedArray = new char[MAX_VERTS];
    }

    public void addVertex(char lab){
        vertex[nVerts++] = new Node(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
    }

    public void displayVertex(int v){
        System.out.println(vertex[v].label);
    }

    public void topo() {
        int orig_nVerts = nVerts;
        while(nVerts > 0) {
            int currentVertex = noSuccessors();
            if(currentVertex == -1) {
                System.out.println("Graph has cycles");
                return;
            }
            sortedArray[nVerts - 1] = vertex[currentVertex].label;
            deleteVertex(currentVertex);
        }
        System.out.println("Topologically sorted order: ");
        for (int j = 0; j < orig_nVerts; j++)
            System.out.println(sortedArray[j]);
        System.out.println("");
    }

    public int noSuccessors(){
        boolean isEdge;
        for (int row = 0; row < nVerts; row++) {
            isEdge = false;
            for (int col = 0; col < nVerts; col++)
                if(adjMat[row][col] > 0){
                    isEdge = true;
                    break;
                }
            if (!isEdge)
                return row;
        }
        return -1;
    }

    public void deleteVertex(int delVert){
        if(delVert != nVerts - 1){
            for (int j = delVert; j < nVerts - 1; j++)
                vertex[j] = vertex[j + 1];
            for (int row = delVert; row < nVerts - 1; row++)
                moveRowUp(row, nVerts);
            for (int col = delVert; col < nVerts - 1; col++)
                moveColLeft(col, nVerts - 1);
        }
        nVerts--;
    }

    private void moveRowUp(int row, int length){
        for (int col = 0; col < length; col++) {
            adjMat[row][col] = adjMat[row + 1][col];
        }
    }

    private void moveColLeft(int col, int length){
        for (int row = 0; row < length; row++) {
            adjMat[row][col] = adjMat[row][col + 1];
        }
    }




    // Топологическая сортировка направленного графа

}
