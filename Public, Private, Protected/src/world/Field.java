import world.Plant;

public class Field {

  private Plant plant = new Plant();

  public Field() {
    //size is protect; Field is in the same package
    System.out.println(plant.size);

  }

}
