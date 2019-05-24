package adt.graph.directed;

import java.util.List;

public class Node {
  private String nodeName;
  private List<Edge> connections;

  public String getNodeName() {
    return nodeName;
  }

  public void setNodeName(String nodeName) {
    this.nodeName = nodeName;
  }

  public List<Edge> getConnections() {
    return connections;
  }

  public void setConnections(List<Edge> connections) {
    this.connections = connections;
  }
}
