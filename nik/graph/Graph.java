package nik.graph;

import nik.queue.Queue;
import nik.stack.Stack;

public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertex[];
    private int adjMat[][];
    private int nVerts;

    public Graph() {
        vertex = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char lab){
        vertex[nVerts++] = new Vertex(lab);
    }
    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
    public void displayVertex(int v){
        System.out.print(vertex[v].getData());
    }

    public int getAdjUnvisitedVertex(int v){
        for(int j = 0; j < nVerts; j++)
            if(adjMat[v][j] == 1 && vertex[j].wasVisited == false)
                return j;
        return -1;
    }
    public void dfs(){ // обход в глубину
        vertex[0].wasVisited = true;
        displayVertex(0);
        Stack<Integer> stack = new Stack<>(50);
        stack.push(0);
        while (!stack.isEmpty()){
            int v = getAdjUnvisitedVertex(stack.peek());
            if(v == -1)
                stack.pop();
            else
            {
                vertex[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        for (int j = 0; j < nVerts; j++) {
            vertex[j].wasVisited = false;
        }
    }  // поиск в глубину через стэк
    public void bfs(){
        Queue<Integer> queue = new Queue<>(50);
        vertex[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);
        int v2;
        while(!queue.isEmpty()){
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertex[v2].wasVisited = true;
                displayVertex(v2);
                queue.insert(v2);
            }
        }
        for (int j = 0; j < nVerts; j++) {
            vertex[j].wasVisited = false;
        }
    }   // поиск в ширину через очередь

    public void mst(){ // минимальное оставное дерево (600 страница)
        Stack<Integer> stack = new Stack<>(30);
        stack.push(0);
        vertex[0].wasVisited = true;
        while (!stack.isEmpty()){
            int curVertex = stack.peek();
            int v = getAdjUnvisitedVertex(curVertex);
            if(v == -1)
                stack.pop();
            else {
                vertex[v].wasVisited = true;
                stack.push(v);
                displayVertex(curVertex);
                displayVertex(v);
                System.out.print(" ");
            }
        }
        for (int i = 0; i < nVerts; i++) {
            vertex[i].wasVisited = false;
        }
    }


}
