package world;

public class Oak extends Plant {

  public Oak() {
    //Won t work -- type is private
    //type = "tree";

    //this work -- size is protected
    this.size = "large";

    this.height = 10;

  }
}
