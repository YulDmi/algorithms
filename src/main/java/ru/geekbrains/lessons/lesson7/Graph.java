package ru.geekbrains.lessons.lesson7;

public interface Graph {
    void addVertex(String label);
    boolean addEdge(String startLabel, String secondLabel, String ... otherLabel);
    boolean addEdge(String startLabel, String secondLabel);
    boolean addEdge(String startLabel, String secondLabel, int weight);
    int getSize();
    void display();
    void dfs(String startLabel, String endLabel);
    void bfs(String startLabel);

}
