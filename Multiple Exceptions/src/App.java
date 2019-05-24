import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class App {

  public static void main(String[] args) {
     Test test = new Test();

     /*
    try {
      test.run();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      System.out.println("Could not parse command file.");
    }
   */

     /*
    try {
      test.run( );
    } catch ( IOException e| ParseException e){
      e.printStackTrace ( );
    }
      */

    try {
      test.run();
    } catch ( Exception e ) {
      e.printStackTrace ( );
    }

  }

  try {
    test.input ( );
  } catch (IOException e)  {
    e.printStackTrace ();
  } catch (FileNotFoundException e) {
    e.printStackTrace ();

  }

}
