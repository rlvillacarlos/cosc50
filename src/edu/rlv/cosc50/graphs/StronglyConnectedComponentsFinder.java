package edu.rlv.cosc50.graphs;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author russel
 */
public class StronglyConnectedComponentsFinder<T> {
    private final Map<Integer,Set<T>> components;
    private final Map<T,Integer> componentLabels;
    private final Set<T> visited;
    private final List<T> order;
    private final DirectedGraph<T> g;    
    private final DirectedGraph<T> gRev;    

    public StronglyConnectedComponentsFinder(DirectedGraph<T> g) {
        this.g = g;
        this.gRev = (DirectedGraph<T>)g.reverse();
        this.components = new HashMap<>();
        this.componentLabels = new HashMap<>();
        this.visited = new HashSet<>();
        this.order = new LinkedList<>();
        
        for(T u:g.vertices()){
            if(!visited.contains(u)){
                visit(u);
            }
        }

        
        for(T u:order){
            if(!componentLabels.containsKey(u)){
                Set<T> component = new HashSet<>();
                int componentLabel = components.size();
                fillComponent(u,component,componentLabel);
                components.put(componentLabel,component);
            }
        }        
    }
    
    public Set<T> getComponent(T u){        
        if(g.hasVertex(u)){
            int i = componentLabels.get(u);
            return components.get(i);
        }
        
        return Collections.EMPTY_SET;
    }
    
    public Collection<Set<T>> getComponents(){
        return Collections.unmodifiableCollection(components.values());
    }
    
    private void visit(T u){               
        visited.add(u);
        
        for(T v: g.neighbors(u)){
            if(!visited.contains(v)){
                visit(v);
            }
        }
        order.add(0,u);
    }
    
    
    private void fillComponent(T u,Set<T> component, int componentLabel ){
        componentLabels.put(u, componentLabel);
        component.add(u);
        fill(u, component, componentLabel);         
    }
    
    private void fill(T u, Set<T> component, int componentLabel){               
        
        for(T v: gRev.neighbors(u)){
            if(!componentLabels.containsKey(v)){
                componentLabels.put(v, componentLabel);
                component.add(v);
                fill(v,component, componentLabel);
            }
        }
    }
    
}
