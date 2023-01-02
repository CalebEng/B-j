class Cards{
    protected  int suit;
    protected  int card;
    protected  int value;
    
    //creating the card
    public Cards(int suitN, int cardN){
      this.suit = suitN;
      this.card = cardN;
      if(cardN==1){
      this.value=11; 
      }
      if(cardN>10){
        this.value=10;
      }
      else{
      this.value=cardN;
      }
    }
    public int getValue(){
      return value;
    }
    public int getSuit(){
    return suit;
    }
    public int getCard(){
    return card;
    }
      //to string method to turn the data values into strings
      public String toString(){
      if(suit==1){
        if(card==1){
          return "Card: Ace, "+"Suit: Spade";
        }
        if(card==11){
          return "Card: Jack, "+"Suit: Spade";
        }
        if(card==12){
          return "Card: Queen, "+"Suit: Spade";
        }
        if(card==13){
          return "Card: King, "+"Suit: Spade";
        }
        else{
          return "Card: "+ Integer.toString(card)+", Suit: Spade";
        }
      }
      //
      if(suit==2){
        if(card==1){
          return "Card: Ace, "+ "Suit: Heart";
        }
        if(card==11){
          return "Card: Jack, "+"Suit: Heart";
        }
        if(card==12){
          return "Card: Queen, "+ "Suit: Heart";
        }
        if(card==13){
          return "Card: King, "+ "Suit: Heart";
        }
        else{
          return "Card: "+ Integer.toString(card)+", Suit: Heart";
        }
      }
      //
      if(suit==3){
        if(card==1){
          return "Card: Ace, "+"Suit: Club";
        }
        if(card==11){
          return "Card: Jack, "+"Suit: Club";
        }
        if(card==12){
          return "Card: Queen, "+"Suit: Club";
        }
        if(card==13){
          return "Card: King, "+"Suit: Club";
        }
        else{
          return "Card: "+ Integer.toString(card)+", Suit: Club";
        }
      }
      //
      if(suit==4){
        if(card==1){
          return "Card: Ace, "+"Suit: Diamond";
        }
        if(card==11){
          return "Card: Jack, "+"Suit: Diamond";
        }
        if(card==12){
          return "Card: Queen, "+"Suit: Diamond";
        }
        if(card==13){
          return "Card: King, "+"Suit: Diamond";
        }
        else{
          return "Card: "+ Integer.toString(card)+", Suit: Diamond";
        }
      }
      return "";
    }
    public void setValue(int i) {
    }
    
  }

