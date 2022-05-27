package comp1721.cwk2;

// Implement Deck class here
public class Deck extends CardCollection{
    public String[][] deck = new String[4][13];

    //Initialize a sequence of 52 playing cards.
    public Deck() throws CardException{
        int i = 0;
        int j = 0;
        String[] n = new String[13];
        String[] m = new String[4];
        for (Card.Suit suit : Card.Suit.values()) {
            j = 0;
            for (Card.Rank rank : Card.Rank.values()) {
                n[j] = String.valueOf(rank.getSymbol());
                m[i] = String.valueOf(suit.getSymbol());
                deck[i][j] = n[j] + m[i];
                j++;
            }
            i++;
        }
    }

    //The number of cards in a deck.
    public int size(){
        int x;
        int y;
        int size = 0;
        for (x = 0; x < 4; x++) {
            for (y = 0; y < 13; y++) {
                if(!deck[x][y].equals("")){
                    size++;
                }
            }
        }
        return size;
    }

    //Whether the deck is empty.
    public boolean isEmpty(){
        if (size() == 0) {
            return true;
        }
        return false;

    }

    //Whether the deck contains the specified cards.
    public boolean contains(Card card){
        int x;
        int y;
        for (x = 0; x < 4; x++) {
            for (y = 0; y < 13; y++) {
                if(deck[x][y].equals(card.toString())){
                    return deck[x][y].equals(card.toString());
                }
            }
        }
        return false;
    }

    //Clear the deck
    public void discard(){
        int x;
        int y;
        for (x = 0; x < 4; x++) {
            for (y = 0; y < 13; y++) {
                deck[x][y] = "";
            }
        }
    }

    //Take the first card from the deck and return
    public Card deal() throws CardException {
        if (isEmpty() == true) {
            throw new CardException("The deck is empty.");
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                if (deck[i][j] != "") {
                    Card de = new Card(deck[i][j]);
                    deck[i][j] = "";
                    return de;
                }
            }
        }
        return null;
    }

    //Shuffle the deck
    public void shuffle(){
        for(int i=3;i>0;i--) {
            for(int j=12;j>0;j--) {
                int x=(int)(Math.random()*(i+1));
                int y=(int)(Math.random()*(j+1));
                String temp=deck[i][j];
                deck[i][j]=deck[x][y];
                deck[x][y]=temp;
            }
        }
    }

    //Adds the specified card
    @Override
    public void add(Card card) throws CardException {
        int zero = 0;
        String c = card.toString();
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 13; y++) {
                if (deck[x][y].equals("")) {
                    zero++;
                }
            }
        }
        if (zero <= 0) {
            throw new CardException("Can not add.");
        } else {
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 13; y++) {
                    if (deck[x][y].equals("")) {
                        deck[x][y] = c;
                        return;
                    }
                }
            }
        }
    }
}