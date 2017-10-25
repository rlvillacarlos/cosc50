package edu.rlv.cosc50.graphs.applications;

import edu.rlv.cosc50.graphs.BFSSearcher;
import edu.rlv.cosc50.graphs.DirectedGraph;
import edu.rlv.cosc50.graphs.Graph;
import edu.rlv.cosc50.graphs.Path;
import edu.rlv.cosc50.graphs.UndirectedGraph;

/**
 *
 * @author russel
 */
public class BFSSample {

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
        BFSSearcher searcher = new BFSSearcher(g1,"A");
        Path<String> p = searcher.getPath("C");
        System.out.println(p);
        p = searcher.getPath("B");
        System.out.println(p);
        
    }
    
}
