package edu.rlv.cosc50.graphs.applications;

import edu.rlv.cosc50.graphs.ConnectedComponentsFinder;
import edu.rlv.cosc50.graphs.UndirectedGraph;
import java.util.Set;

/**
 *
 * @author russel
 */
public class ConnectedComponentSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UndirectedGraph<String> g = new UndirectedGraph<>();
        
        g.addEdge("A", "B")
         .addEdge("A", "C")
         .addEdge("B", "D")
         .addEdge("E", "G")
         .addEdge("E", "F")
         .addEdge("G", "H")
         .addEdge("I", "J");
        ConnectedComponentsFinder<String> ccfinder = new ConnectedComponentsFinder<>(g);
        
        int i = 0;
        for(Set<String> c: ccfinder.getComponents()){
            System.out.printf("Component %d: %s%n",i,c);            
            i++;
        }
        
        for(String s: g.vertices()){
            System.out.printf("Component containing %s: %s%n",s,ccfinder.getComponent(s));
        }
        
    }
    
}
