package edu.rlv.cosc50.graphs.applications;

import edu.rlv.cosc50.graphs.DirectedGraph;
import edu.rlv.cosc50.graphs.Graph;

/**
 *
 * @author russel
 */
public class DirectedGraphSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph<String> g1 = new DirectedGraph<>();
        
        g1.addVertex("A")
          .addVertex("B")
          .addVertex("C")
          .addEdge("A", "B")
          .addEdge("B", "C")
          .addEdge("C", "B")                
          .addEdge("C", "A");
        
        System.out.println(g1);
        System.out.println(g1.order());
        System.out.println(g1.size());
        System.out.println(g1.neighbors("A"));
        System.out.println(g1.neighbors("B"));
        System.out.println(g1.neighbors("C"));
        
        System.out.println(g1.reverse());
    }
    
}
