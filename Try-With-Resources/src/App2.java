import java.io.*;

public class App2 {

  public static void main(String[] args) {
    File file = new File ( "test.txt" );

    try(BufferedReader br = new BufferedReader(new FileReader (file))) {

    }catch ( FileNotFoundException e) {
      System.out.println ( "Can not find file " + file.toString ( ) );
    }catch ( IOException e) {
      System.out.println ( "Unable to read file " + file.toString ());

    }
  }
}
