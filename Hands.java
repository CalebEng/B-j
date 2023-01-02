
import java.util.ArrayList;
class Hands{
  protected int totalValue;
  protected boolean isDealer;
  protected ArrayList<Cards> hand;
  
  //temp values for the card and suit
  protected int temp;
  protected int tempC;
  
  //creating hand
  public Hands(boolean who){
    isDealer = who;
    hand = new ArrayList<Cards>();
  }

  //adding cards
  public void addCard(Cards newC){
    this.hand.add(newC);
    this.totalValue += newC.getValue();
    
    //if plyaer new card make them over 21 & they have an ace to make 1 not 11
    if(this.totalValue>21){
      for(int i =0;i<this.hand.size();i++){
        if((hand.get(i).getValue())==11){
          this.hand.get(i).setValue(1);
          this.totalValue -=10;
          i=this.hand.size();
        }
      }
    }
  }
  //gets score
  public int getTV(){
    return totalValue;
  }
  public Cards getICard(){
  return hand.get(0);
  }
  //printing out hand statements
  public String toString(){
    if(this.isDealer==false){
      return "Players Hands:\n"+hand+" \nCurrent Total: "+totalValue;
    }
    if(this.isDealer==true){
      System.out.println("Dealers Hands:");
      for(int i =0; i<hand.size();i++){
        if(i==0){
          System.out.print("[|Cards: ???, "+"Suit: ???| ");
        }
        else{
          System.out.print(hand.get(i));
        }
      }
      return "]\nCurrent Total: ???";
    }
    return"";
  }
}