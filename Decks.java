

import java.util.ArrayList;
import java.util.Random;

class Decks {
  Random random = new Random();
  protected ArrayList<Cards> arrayOfCards = new ArrayList<Cards>();
  private int top =52;
  private int sa;
  private Cards temp;
  
  //creating a deck
  public Decks(){ 
    for (int j = 1; j<=13; j++){
      for (int i = 1; i <=4; i++){
        arrayOfCards.add(new Cards(i,j));
      }
    } 
  }
  
  //shuffle
  public void shuffle(){
    for(int i =0;i<arrayOfCards.size();i++){
      sa = random.nextInt(arrayOfCards.size());
      temp =arrayOfCards.get(i);
      arrayOfCards.set(i,arrayOfCards.get(sa));
      arrayOfCards.set(sa,temp);
    }
  }
  //draws top card
  public Cards draw(){
    top--;
    return(arrayOfCards.get(top));
  }
}
