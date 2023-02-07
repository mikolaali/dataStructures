package nik.graph;

public class Vertex {
    public boolean wasVisited;
    private char data;

    public Vertex(char data) {
        this.data = data;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }
}
