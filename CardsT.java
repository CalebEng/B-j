import java.util.ArrayList;
public class CardsT {
   
  public static void main(String[]args){
    ArrayList<Cards> arrayOfCards = new ArrayList<Cards>();
    
    for (int i = 1; i <=4; i++){
      for (int j = 1; j<=13; j++){
        arrayOfCards.add(new Cards(i,j));
      }
    } 
    for(int i=0;i<52;i++){
    System.out.println(arrayOfCards.get(i));
    }
    
  }
}

