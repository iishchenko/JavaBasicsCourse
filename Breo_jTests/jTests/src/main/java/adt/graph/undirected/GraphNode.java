package adt.graph.undirected;

import java.util.List;

public class GraphNode {
  public int nodeId;
  public List<GraphNode> connections;

  public GraphNode(int nodeId, List<GraphNode> connections) {
    this.nodeId = nodeId;
    this.connections = connections;
  }

  public int getNodeId() {
    return nodeId;
  }

  public void setNodeId(int nodeId) {
    this.nodeId = nodeId;
  }

  public List<GraphNode> getConnections() {
    return connections;
  }

  public void setConnections(List<GraphNode> connections) {
    this.connections = connections;
  }
}
