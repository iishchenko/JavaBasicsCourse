import java.util.HashSet;

public class App {

  public static void main(String[] args) {

    Set<String> set1 = new HashSet<String> ();

    if(set1.isEmpty()) {
      System.out.println("Set is empty");
    }

    set1.add("dog");
    set1.add("cat");
    set1.add("mouse");
    set1.add("snake");
    set1.add("bear");

    // Adding duplication items does nothing

    set1.add("mouse");

    if(set1.isEmpty()) {
      System.out.println ("Set is empty after adding (no!)");
    }

    System.out.println(set1);

    for(String element: set1) {
      System.out.println(element);

    }

    if(set1.contains("aadvark")) {
      System.out.println ("Contains aardvark");
    }

    if(set1.contains("cat")) {
      System.out.println("Contains cat");
    }

    Set<String> set2 = new TreeSet<String>;

    set2.add("dog");
    set2.add("cat");
    set2.add("giraffe");
    set2.add("monkey");
    set2.add("ant");

    Set<String> intersection = new HashSet<String>(set1);

    System.out.println(intersection);

    intersection.retainAll(arg0);

    intersection.retainAll(set2);

    System.out.println (intersection);

    Set<String> difference = new HashSet<String>(set1);

    difference.removeAll(set1);
    System.out.println(difference);





  }

}
