package world;

class Something{

}

public class Plant {
  //Bad practice
  public String name;

  //Accepatable practice ---- it is final.
  public final static int ID = 8;

  private String type;

  public String size;

  public int height;

  public Plant() {
    this.name = "Freddy";
    this.type = "plant";
    this.size = "large";
    this.height = 10;
  }
}