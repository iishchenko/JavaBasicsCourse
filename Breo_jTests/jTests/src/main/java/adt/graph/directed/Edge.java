package adt.graph.directed;

public class Edge {
  private Node start, end;
  private double weight;

  public Node getStart() {
    return start;
  }

  public void setStart(Node start) {
    this.start = start;
  }

  public Node getEnd() {
    return end;
  }

  public void setEnd(Node end) {
    this.end = end;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }
}
