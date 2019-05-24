import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObjects {

  public static void main(String[] args) {
    System.out.println ( "WriteObjects..." );

    try (ObjectOutputStream os = new ObjectOutputStream ( new FileOutputStream ( "test.ser" ) )) {

      Person person = new Person ( 7, "Bob" );
      person.setCount (88);
      os.writeObject ( person );


    } catch ( FileNotFoundException e ) {
      e.printStackTrace ( );
    } catch ( IOException e ) {
      e.printStackTrace ( );

    }
  }
}