package edu.rlv.cosc50.graphs;

/**
 *
 * @author russel
 */
public class UndirectedGraph<T> extends DirectedGraph<T>{

    public UndirectedGraph() {
        super();
        this.self = this;
    }

    @Override
    public Graph<T> addEdge(T u, T v) {        
        super.addEdge(u, v);
        super.addEdge(v, u);        
        
        return self;
    }

    @Override
    public Graph<T> removeEdge(T u, T v) {
        super.removeEdge(u, v);
        super.removeEdge(v, u);
        
        return self;
    }

    @Override
    public Graph<T> reverse() {
        Graph<T> rev = new UndirectedGraph<>();
        
        for(T u:vertices()){
            for(T v:neighbors(u)){
                rev.addEdge(v, u);
            }
        }
        
        return rev;
    }
    
    
    
}
