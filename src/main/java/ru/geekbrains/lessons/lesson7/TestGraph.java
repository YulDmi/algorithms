package ru.geekbrains.lessons.lesson7;

public class TestGraph {
    public static void main(String[] args) {
        //   testGraph();
        testGraph2();
    }

    private static void testGraph2() {

        String[] cities = {"Москва", "Тула", "Липецк", "Рязань", "Тамбов", "Воронеж", "Саратов", "Калуга", "Орел", "Курск"};
        GraphImp graph = new GraphImp(cities.length);
        for (String city : cities) {
            graph.addVertex(city);
        }
        graph.addEdge("Москва", "Тула", 5);
        graph.addEdge("Тула", "Липецк", 4);
        graph.addEdge("Липецк", "Воронеж", 6);
        graph.addEdge("Москва", "Рязань", 3);
        graph.addEdge("Рязань", "Тамбов", 2);
        graph.addEdge("Тамбов", "Саратов", 4);
        graph.addEdge("Саратов", "Воронеж", 8);
        graph.addEdge("Москва", "Калуга", 7);
        graph.addEdge("Калуга", "Орел", 2);
        graph.addEdge("Орел", "Курск", 5);
        graph.addEdge("Курск", "Воронеж", 9);
//        int[][] array = graph.getAdjMatrixInt();
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                System.out.print(array[i][j] + "\t");
//            }
//            System.out.println();
//        }

//
        graph.dfs("Москва", "Воронеж");
     //   graph.display();
    }

    private static void testGraph() {
        Graph graph = new GraphImp(7);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B", "C");

        graph.addEdge("B", "C", "D");
        graph.addEdge("C", "A", "B", "D");
        graph.addEdge("D", "B", "C");

        System.out.println("Size " + graph.getSize());

        graph.display();
    }

}
