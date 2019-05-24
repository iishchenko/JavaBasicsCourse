public class Application {
  public static void main(String[] args){
    boolean loop1 = 4 < 5;

    boolean loop2 = 6 < 1;

    int value = 0;

    boolean loop3 = value < 20;

    System.out.println(loop1);
    System.out.println(loop2);
    System.out.println(loop3);

    while(value < 10)
    {

      System.out.println("Hello " + value);

      value = value + 1;

    }
   }
  }
