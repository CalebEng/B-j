
import java.util.Scanner;
public class BlackJackG{
  public static void main(String[]args){
    //variables to play
    int amount =1000;
    int bet =0;
    String winner= "";
    while(amount>0){
      //creating and shuffling deck
      Decks deck=new Decks();
      deck.shuffle();
      //making hands for player and dealer
      Hands playerHand = new Hands(false);
      Hands dealerHand= new Hands(true);
      
      bet = getBet(amount);
      //getting player starting hand
      playerHand.addCard(deck.draw());
      playerHand.addCard(deck.draw());
      
      //getting dealers starting hand
      dealerHand.addCard(deck.draw());
      dealerHand.addCard(deck.draw());
      
      System.out.println(playerHand);
      System.out.println();
      System.out.println(dealerHand);

      //player turn
      playerTurn(playerHand,deck);

      //dealer turn
      if(playerHand.getTV()<=21){
        System.out.println("Dealer's turn\n");
        dealerTurn(dealerHand,playerHand,deck);
      }

      //player win
      if(playerHand.getTV()<=21&& (playerHand.getTV()>dealerHand.getTV() || dealerHand.getTV()>21)){
        winner = "Player";
        amount += bet;
        System.out.println("Dealers total: "+dealerHand.getTV());
        System.out.println("Dealers last card: "+dealerHand.getICard());

      }
//        tie
      if((playerHand.getTV()<=21&&dealerHand.getTV()<=21)&&playerHand.getTV()==dealerHand.getTV()){
        System.out.println("Dealers total: "+dealerHand.getTV());
        winner = "Dealer";
        System.out.println("Dealers last card: "+dealerHand.getICard());
      }

      //dealer win
      else if(dealerHand.getTV()<=21){
        winner ="Dealer";
        amount -=bet;
        System.out.println("Dealers total: "+dealerHand.getTV());
        System.out.println("Dealers last card: "+dealerHand.getICard());
      }
      System.out.println(winner+" Wins");
    }
    System.out.println("\nThank You for playing BlackJack! \nYou're out of money \nBetter luck next time!");
  }
  
  //betting method
  private static int getBet(int total){
    Scanner betAmount = new Scanner(System.in);
    int totalC =0;
    int x=0;

    for(int i =0;i<1;){
      System.out.println("You have $"+total+"\nhow much you would like to bet \n(ONLY ENTER IN THE NUMBER)");
      String temp = betAmount.nextLine();
      Scanner check = new Scanner(temp);

      //making sure its a int not a string
      while(check.hasNext()){
        if(check.hasNextInt()){
          if(totalC<temp.length()){
          totalC++;
          }
          if(totalC==temp.length()){
            break;
          }
        }
        else{
          break;
        }
      }

      if(totalC==temp.length()){
        x = Integer.parseInt(temp);
      }

      //making sure its valid
      if(x<1 || x>total||totalC<temp.length()){
        System.out.println("Invalid try again");
      }

      //if valid
      if(x<=total && x>0&&totalC==temp.length()){
        total -= x;
        i++;
        check.close();
      }
    }
    
    //betAmount.close();
    return x;
  }

  //player turn
  private static void playerTurn(Hands hand, Decks deck){
    Scanner hit_stand = new Scanner(System.in);

    //for stand if stand this is equal to 1
    int i =0;
    while(hand.getTV()<=21&&i==0){
      System.out.println("Would you like to hit or stand");
      String a = hit_stand.nextLine();
      String ans = a.toLowerCase();
      
      //if invalid
      if(!ans.equals("hit") && !ans.equals("stand")){
        System.out.println("Invalid try again");
      }
      //if stand
      if(ans.equals("stand")){
        i++;
      }
      //if hit
      if(ans.equals("hit")){
        hand.addCard(deck.draw());
        System.out.println(hand);
      }
    }
    //bust
    if(hand.getTV()>21){
      System.out.println("BUST");
    }
  }

  //dealers turn
  private static void dealerTurn(Hands hand,Hands pHand, Decks deck){
    while(hand.getTV()<pHand.getTV()){
      hand.addCard(deck.draw());
      System.out.println(hand+"\n");
    }
    if(hand.getTV()>21){
      System.out.println("BUST");
    }
  }
}
