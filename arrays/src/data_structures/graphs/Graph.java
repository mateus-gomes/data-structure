package data_structures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    private int numberOfNodes;
    private HashMap<String, List<String>> adjacentList;

    public Graph() {
        this.numberOfNodes = 0;
        this.adjacentList = new HashMap();
    }

    public void addVertex(String value){
        ArrayList arrayList = new ArrayList<>();
        adjacentList.put(value, arrayList);
        numberOfNodes++;
    }

    public void addEdge(String node1, String node2){
        List<String> connections = adjacentList.get(node1);
        connections.add(node2);
        List<String> connections2 = adjacentList.get(node2);
        connections2.add(node1);
    }

    public void showNodes(){
        Object[] keys = adjacentList.keySet().toArray();

        for(int i = 0; i < keys.length; i++){
            System.out.println(keys[i] + "->" + adjacentList.get(keys[i]));
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("0");
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");
        graph.addEdge("3", "1");
        graph.addEdge("3", "4");
        graph.addEdge("4", "2");
        graph.addEdge("4", "5");
        graph.addEdge("1", "2");
        graph.addEdge("1", "0");
        graph.addEdge("0", "2");
        graph.addEdge("6", "5");

        graph.showNodes();
    }
}
