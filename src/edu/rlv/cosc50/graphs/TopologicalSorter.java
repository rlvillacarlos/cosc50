package edu.rlv.cosc50.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author russel
 */
public class TopologicalSorter<T> {
    private final Graph<T> g;
    private final List<T> list;
    private final Set<T> visited;
    private final String order;
    
    public TopologicalSorter(Graph<T> g) {
        this.g = g;
        this.list = new LinkedList<>();
        this.visited = new HashSet<>();
        
        for(T u:g.vertices()){
            if(!visited.contains(u)){
                visit(u);
            }
        }   
        
        order = list.toString();
    }
    
    private void visit(T u){                
        visited.add(u);
        
        for(T v: g.neighbors(u)){
            if(!visited.contains(v)){
                visit(v);
            }
        }
        list.add(0,u);
    }

    @Override
    public String toString() {
        return order;
    }
}
