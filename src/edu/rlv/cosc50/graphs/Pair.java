package edu.rlv.cosc50.graphs;

import java.util.Objects;

/**
 *
 * @author russel
 */
public class Pair<T> {
    private T u;
    private T v;

    public Pair(T u, T v) {
        this.u = u;
        this.v = v;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", u,v);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.u);
        hash = 89 * hash + Objects.hashCode(this.v);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair<?> other = (Pair<?>) obj;
        if (!Objects.equals(this.u, other.u)) {
            return false;
        }
        if (!Objects.equals(this.v, other.v)) {
            return false;
        }
        return true;
    }
    
    
    
}
