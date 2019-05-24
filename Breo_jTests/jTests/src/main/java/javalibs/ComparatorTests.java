package javalibs;

public class ComparatorTests<T extends Comparable<T>> {
  private T small;
  private T big;
  private T equalSmall;

  public ComparatorTests(T small, T big) {
    this.small = small;
    this.big = big;
    this.equalSmall = small;
  }

  public void compareToTests(){
    System.out.println("Small " + small + " Big " + big);
    System.out.println("Comparing small " + small + " to " + equalSmall
            + ", its  equal. small.compareTo(equalSmall): " + small.compareTo(equalSmall));
    System.out.println("Comparing small " + small + " to " + big
            + ", big. small.compareTo(big): " + small.compareTo(big));
    System.out.println("Comparing big   " + big + " to " + small
            + ", small. big.compareTo(small): " + big.compareTo(small));
  }
}
