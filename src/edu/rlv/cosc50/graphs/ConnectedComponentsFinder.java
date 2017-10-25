package edu.rlv.cosc50.graphs;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author russel
 */
public class ConnectedComponentsFinder<T> {
    private final Map<Integer,Set<T>> components;
    private final Map<T,Integer> componentLabels;
    private final UndirectedGraph<T> g;    

    public ConnectedComponentsFinder(UndirectedGraph<T> g) {
        this.g = g;
        this.components = new HashMap<>();
        this.componentLabels = new HashMap<>();
        
        for(T u:g.vertices()){
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
    
    private void fillComponent(T u,Set<T> component, int componentLabel ){
        componentLabels.put(u, componentLabel);   
        component.add(u);
        fill(u, component, componentLabel);         
    }
    
    private void fill(T u, Set<T> component, int componentLabel){               
        
        for(T v: g.neighbors(u)){
            if(!componentLabels.containsKey(v)){
                component.add(v);
                componentLabels.put(v, componentLabel);
                fill(v,component, componentLabel);
            }
        }
    }
    
}
