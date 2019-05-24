package adt.graph.undirected;


import java.util.*;

public class Graph {
  Set<GraphNode> nodes = new HashSet<>();

  public List<GraphNode> findPath(GraphNode src, GraphNode dest) {

    if( !nodes.contains(src) || !nodes.contains(dest) ) {
      System.out.println("Some of the nodes is NOT in the graph");
      return new ArrayList<>();
    }
    Set<GraphNode> visited = new HashSet<>();
    Queue<GraphNode> queue = new LinkedList<>();
    return this.findPath(src, dest, visited, queue);

  }

  private List<GraphNode> findPath(GraphNode src, GraphNode dest, Set<GraphNode> visited, Queue<GraphNode> queue) {
    List<GraphNode> path = new ArrayList<>();
    if( src.equals(dest) ) {
      path.add(src);
      return path;
    }
    queue.add(src);
    while( !queue.isEmpty() ) {
      GraphNode current = queue.poll();
      if( !visited.contains(current) ) {
        visited.add(current);
        queue.addAll(current.getConnections());
        List<GraphNode> pathRet = this.findPath(current, dest, visited, queue);
        if( !pathRet.isEmpty() ) {
          path.addAll(pathRet);
          if( !current.equals(dest) ) {
            path.add(current);
          }
        }
      }
    }
    return path;
  }

  public Graph() {
  }

  public Graph(Set<GraphNode> nodeSet) {
    this.nodes = nodeSet;
  }

  public Set<GraphNode> getNodes() {
    return nodes;
  }

  public void setNodes(Set<GraphNode> nodeSet) {
    this.nodes = nodeSet;
  }
}
