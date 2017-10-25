package edu.rlv.cosc50.graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author russel
 */
public final class DFSSearcher<T> {
    private final Graph<T> g;
    private final T source;
    private final Map<T,T> parent;

    public DFSSearcher(Graph<T> g, T source){
        this.g = g;
        this.source = source;
        this.parent = new HashMap<>();
        dfs();
    }
    
    public Path<T> getPathTo(T target){
        Path<T> p = new Path(g);
        
        if(this. source.equals(target)){
            return p.add(source);
        }

        Stack<T> s = new Stack<>();
        
        T cur =  target;
        
        while(cur !=null){
            s.push(cur);                    
            cur = parent.get(cur);
        }       
        
        while(!s.empty()){
            p.add(s.pop());
        }
        
        return p; 
    }

    private void dfs(){
        parent.put(source, null);        
        visit(source); 
    }
    
    private void visit(T u){                
        
        for(T v: g.neighbors(u)){
            if(!parent.containsKey(v)){
                parent.put(v, u);
                visit(v);
            }
        }
    }
    
}
