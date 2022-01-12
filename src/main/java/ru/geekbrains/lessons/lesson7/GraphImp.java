package ru.geekbrains.lessons.lesson7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GraphImp implements Graph {
    private final List<Vertex> vertexList;

    public int[][] getAdjMatrixInt() {
        return adjMatrixInt;
    }

    private final int[][] adjMatrixInt;
    private final boolean[][] adjMatrix;

    public GraphImp(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrixInt = new int[maxVertexCount][maxVertexCount];
        this.adjMatrix = new boolean[maxVertexCount][maxVertexCount];

    }


    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }


    @Override
    public boolean addEdge(String startLabel, String secondLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);
        if (startIndex == -1 || endIndex == -1) return false;
        adjMatrix[startIndex][endIndex] = true;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) return i;
        }
        return -1;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... otherLabel) {
        boolean result = addEdge(startLabel, secondLabel);
        for (String other : otherLabel) {
            result &= addEdge(startLabel, other);
        }
        return result;
    }


    public boolean addEdge(String startLabel, String secondLabel, int weight) {
        int v1 = indexOf(startLabel);
        int v2 = indexOf(secondLabel);
        if (v1 == -1 || v2 == -1) return false;
        adjMatrixInt[v1][v2] = weight;
        //   adjMatrixInt[v2][v1] = weight;
        return true;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public void dfs(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Error");
        }
        resetVertexVisited();

        Stack<Vertex> stack = new Stack<>();
        int minLong = 100000;
        int distance = 0;
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(stack, vertex);

        Vertex endVertex = vertexList.get(indexOf(endLabel));
          StringBuilder sb = new StringBuilder(startLabel);
        while (!stack.isEmpty()) {
            vertex = getNearUnVisitedVertex(stack.peek());

            if (vertex != null) {
                endVertex.setVisited(false);
                int index = indexOf(vertex.getLabel());
                int weight = adjMatrixInt[startIndex][index];
                sb.append(" -> ").append(vertex.getLabel());
                startIndex = index;
                distance += weight;
                if (vertex.getLabel().equals(endLabel)) {
                    System.out.println(sb.toString());
                    System.out.println("distance : " + distance);
                    if (minLong > distance) {
                        minLong = distance;
                    }
                    distance = 0;
                    startIndex = indexOf(startLabel);
                    sb = new StringBuilder(startLabel);
                }
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }

        System.out.println("Минимальное расстояние : " + minLong);
    }

    private Vertex getNearUnVisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrixInt[currentIndex][i] > 0 && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        stack.add(vertex);
        vertex.setVisited(true);
    }

    private void resetVertexVisited() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    @Override
    public void bfs(String startLabel) {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrixInt[i][j] > 0) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
