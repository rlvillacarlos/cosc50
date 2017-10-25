package edu.rlv.cosc50.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author russel
 */
public class Path<T> {
    private Graph<T> g;
    private List<T> p;

    
    public Path(Graph<T> g) {
        this.g = g;
        p = new ArrayList<>();
    }
    
    public Path(Graph<T> g, T ... vs) {
        this(g);
        
        if(vs.length>0){
            p.add(vs[0]);
            T prev = vs[0];
            for(int i=1;i<vs.length;i++){
                if(!g.hasEdge(prev, vs[i])){
                    throw new IllegalArgumentException(
                        String.format("Invalid sequence of vertices: (%s,%s) is not an edge.", 
                                        prev.toString(),vs[i].toString()));
                }
                p.add(vs[i]);
                prev = vs[i];
            }            
        }
    }
    
    public Path add(T v){
        if(p.isEmpty()){
            p.add(v);
        }else{
            T last = p.get(p.size()-1);
            
            if(g.hasEdge(last, v)){
                p.add(v);
            }
        }
        
        return this;
    }
    
    public int length(){
        return p.size()-1;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        
        for(T u:p){
            s.append(u).append(", ");
        }
        
        if(s.length() > 1){
            s.delete(s.length()-2, s.length());
        }
        
        return s.append("]").toString();
    }
    
    
}
