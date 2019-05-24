import java.util.Objects;

class Person {
  private int id;
  private String name;
  public Person(int id, String name) {
    this.id=id;
    this.name = name;
  }

  @Override
  public String toString() {
    return "Person [id=" + id + ", name=" + name + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass ( ) != o.getClass ( )) return false;
    Person person = (Person) o;
    return id == person.id &&
            Objects.equals ( name, person.name );
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((name == null)?0: name.hashCode ());
    return result;
  }
}



public class App {
  public static void main(String[] args) {

    Person person1 = new Person(5, "Bob");
    Person person2 = new Person(8, "Sue");

    person2 = person1;

    System.out.println (person1.equals(person2));

    Double value1 = 7.2;
    Double value2 = 7.2;

    System.out.println (value1.equals(value2));

    Integer number1 = 6;
    Integer number2 = 6;

    System.out.println(number1 == number2);

    String text1 = "Hello";
    String text2 = "Hellofodf".substring (0, 5);

    System.out.println (text2);

    System.out.println(text1.equals(text2));
  }
}
