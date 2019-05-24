package granxa;

import java.util.ArrayList;

public class Galinheiro<T extends Galiforme & HumanoRoubaOvos> {

  private String name;

  private ArrayList<T> members = new ArrayList<>();

  public ArrayList<T> getMembers(){
    return members;
  }

  public T getMember(String name){
    return members.get(members.indexOf(name));
  }
}
