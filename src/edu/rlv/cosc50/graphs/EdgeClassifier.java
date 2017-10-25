package edu.rlv.cosc50.graphs;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author russel
 */
public class EdgeClassifier<T> {    
    private final Map<Pair<T>,EdgeType> classification;
    private final Map<T,Integer> discoveryTime;
    private final Map<T,Integer> explorationTime;
    private int time;
    
    public EdgeClassifier(Graph<T> g){
        this.time = 0;
        this.discoveryTime = new HashMap<>();
        this.classification = new HashMap<>();
        this.explorationTime = new HashMap<>();
        
        for(T u:g.vertices()){
            if(!discoveryTime.containsKey(u)){
                classify(g, u);
            }
        }
    }
    
    public EdgeType getClassification(T u, T v){
        return classification.get(new Pair(u,v));
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        
        for(Pair<T> p:classification.keySet()){
            s.append(p)
             .append(" => ")
             .append(classification.get(p))
             .append(", ");
        }
        
        if(s.length() > 1){
            s.delete(s.length()-2, s.length());
        }
        
        return s.append("]").toString();
    }
    
    
    
    private void classify(Graph<T> g, T u){
        time++;
        discoveryTime.put(u, time);
        
        for(T v:g.neighbors(u)){
            if(discoveryTime.containsKey(v)){
                if(explorationTime.containsKey(v)){
                    if(discoveryTime.get(u)<explorationTime.get(v)){
                        classification.put(new Pair<>(u,v), EdgeType.ForwardEdge);
                    }else{
                        classification.put(new Pair<>(u,v), EdgeType.CrossEdge);                        
                    }
                }else{
                    classification.put(new Pair<>(u,v), EdgeType.BackEdge);
                }
            }else{
                classification.put(new Pair<>(u,v), EdgeType.TreeEdge);
                classify(g, v);
            }
        }
        time++;
        explorationTime.put(u, time);        
    }
}
