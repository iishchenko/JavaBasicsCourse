public class App {

  public static void main(String[] args) {
    /*
    try {
      Thread.sleep(111);
    } catch ( InterruptedException e ) {
      e.printStackTrace ( );
    }

     */

    /*
    int value = 7;

    value = value/0;

     */

    String[] texts = {"one","two","three"};

    try {
      System.out.println ( texts[3] );
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println (e.toString ());
    }
  }
}
