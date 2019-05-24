package babylonhealtexample;/*
babylon health
It compiles, but find the problems
*/

import java.util.ArrayList;
import java.util.List;

public class App
{
  static class Word {
    public String text;
    public int count;
    public Word(String text, int count) {
      this.text = text;
      this.count = count;
    }
  }

  static String str = "I like to eat bananas. Bananas, they are cool. I like apples too";

  static List<Word> f(String text) {
    List<Word> result = new ArrayList<>();
    for (String w : text.split("\\s")) {
      int existing = -1;
      for (int i = 0; i < result.size(); i++) {
        if (result.get(i).text.equals(w)) {
          existing = i;
          break;
        }
      }
      if (existing >= 0) {
        int count = result.get(existing).count;
        result.remove(existing);
        result.add(new Word(w, count + 1));
      } else {
        result.add(new Word(w, 1));
      }
    }
    return result;
  }

  public static void main(String[] args) {
    for (Word w : f(str))
      System.out.println(w.text + " " + w.count);
  }
}
