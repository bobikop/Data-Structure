import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<List<Vertex>> adjList=new ArrayList<>();

    public Graph(List<Edge> edges) {
    // construct Adjacency List
        //create empty arraylists for each AdjList element
        for (int i = 0; i < edges.size(); i++) {
            adjList.add(i,new ArrayList<>());
        }
        // Add vertices connected to current vertex


        for (Edge edge : edges) {
            adjList.get(edge.from).add(new Vertex(edge.to,edge.weight));
        }
    }


    public static void printGraph(Graph graph){
        int fromVertex=0;
        System.out.println("Printing the relationships on the graph.....");
        while(fromVertex<graph.adjList.size()){
            for(Vertex v:graph.adjList.get(fromVertex)){
                System.out.println("Vertex"+fromVertex+" ==> "+v.value + " ("+ v.weight+ ")\t");

            }
            System.out.println();
            fromVertex++; // increase the vertex number
        }
    }
}