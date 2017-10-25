package edu.rlv.cosc50.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author russel
 */
public final class BFSSearcher<T> {
    private final Graph<T> g;
    private final T source;
    private final Map<T,T> parent;
    
    public BFSSearcher(Graph<T> g, T source){
        this.g = g;
        this.source = source;
        this.parent = new HashMap<>();
        bfs();
    }
    
    public Path<T> getPath(T target){
        Path<T> p = new Path(g);
        
        if(source.equals(target)){
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
    
    private void bfs(){
        Queue<T> q = new LinkedList<>();
        
        parent.put(source, null);
        q.add(source);
        
        while(!q.isEmpty()){
            T u = q.remove();
            
            for(T v:g.neighbors(u)){
                if(!parent.containsKey(v)){
                    parent.put(v, u);
                    q.add(v);
                }
            }
        }        
    }
}
