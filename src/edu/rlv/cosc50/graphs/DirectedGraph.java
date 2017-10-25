package edu.rlv.cosc50.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author russel
 */
public class DirectedGraph<T> implements Graph<T>{
    private final Map<T,Set<T>> adjList;
    private int m; 
    protected Graph<T> self;
    
    public DirectedGraph() {
        this.adjList = new HashMap<>();
        this.self = this;
    }
    
    @Override
    public Graph<T> addVertex(T u) {
        if(!hasVertex(u)){
            adjList.put(u, new HashSet<>());            
        }
        return self;
    }

    @Override
    public Graph<T> removeVertex(T u) {
        if(hasVertex(u)){
            adjList.remove(u);
        }
        return self;
    }

    @Override
    public boolean hasVertex(T u) {
        return adjList.containsKey(u);
    }

    @Override
    public Set<T> vertices() {
        return Collections.unmodifiableSet(adjList.keySet());
    }

    @Override
    public Graph<T> reverse() {
        Graph<T> rev = new DirectedGraph();
        
        for(T u:vertices()){
            for(T v:neighbors(u)){
                rev.addEdge(v, u);
            }
        }
        
        return rev;
    }

    
    
    @Override
    public Graph<T> addEdge(T u, T v) {
        addVertex(u);
        addVertex(v);        
        m++;        
        adjList.get(u).add(v);        
        return self;
    }

    @Override
    public Graph<T> removeEdge(T u, T v) {
        if(hasEdge(u, v)){
            adjList.get(u).remove(v);
        }   
        return self;
    }

    @Override
    public boolean hasEdge(T u, T v) {
        return hasVertex(u) && hasVertex(v) &&  adjList.get(u).contains(v);        
    }

    @Override
    public int order() {
       return adjList.size();
    }

    @Override
    public int size() {
        return m;
    }

    @Override
    public List<T> neighbors(T u) {
        if(hasVertex(u)){
            return Collections.unmodifiableList(new ArrayList(adjList.get(u)));            
        }
        return Collections.unmodifiableList(new ArrayList());
    }

    @Override
    public String toString() {
        StringBuilder s= new StringBuilder("[");
        for(T u:adjList.keySet()){
            s.append(u).append(": {");
            for(T v:adjList.get(u)){
                s.append(v).append(" ,");
            }    
            if(s.charAt(s.length()-1)!='{'){
                s.delete(s.length()-2, s.length());               
            }
            s.append("}, "); 
        }
        if(s.length()>1){
            s.delete(s.length()-2, s.length());
        }
        
        return s.append("]").toString(); 
    }
    
}
