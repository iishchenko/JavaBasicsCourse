package adt;

import java.util.Map;
import java.util.Set;

abstract class UnionFind<T extends Comparable<T>> {

  private Map<String, Set<T>> group;
  private Map<T,T> edges;

  public void union(T node1, T node2){

  }

  public String find(T node){
    return "to be done";
  }

  public void sortNodes(){

  }
}
