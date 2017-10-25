package edu.rlv.cosc50.graphs.applications;

import edu.rlv.cosc50.graphs.DirectedGraph;
import edu.rlv.cosc50.graphs.TopologicalSorter;

/**
 *
 * @author russel
 */
public class TopologicalSortSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DirectedGraph<String> g = new DirectedGraph<>();
        
        g.addEdge("A", "B")
         .addEdge("B", "C")
         .addEdge("B", "D")
         .addEdge("C", "E")
         .addEdge("D", "G")
         .addEdge("F", "D")
         .addEdge("G", "E")
         .addEdge("G", "H");
        
        System.out.println(new TopologicalSorter<>(g));
                
    }
    
}
