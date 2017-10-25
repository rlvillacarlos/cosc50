package edu.rlv.cosc50.graphs.applications;

import edu.rlv.cosc50.graphs.DirectedGraph;
import edu.rlv.cosc50.graphs.StronglyConnectedComponentsFinder;
import java.util.Set;

/**
 *
 * @author russel
 */
public class StronglyConnectedComponentSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DirectedGraph<String> g = new DirectedGraph<>();
        
        g.addEdge("A", "B")
         .addEdge("B", "C")
         .addEdge("B", "D")
         .addEdge("C", "A")
         .addEdge("D", "E")
         .addEdge("E", "D")
         .addEdge("F", "E");
        
        StronglyConnectedComponentsFinder<String> sccfinder = 
                new StronglyConnectedComponentsFinder<>(g);
        
        int i = 0;
        
        for(Set<String> c: sccfinder.getComponents()){
            System.out.printf("Component %d: %s%n",i,c);            
            i++;
        }
        
        for(String s: g.vertices()){
            System.out.printf("Component containing %s: %s%n",s,sccfinder.getComponent(s));
        }
        
    }
    
}
