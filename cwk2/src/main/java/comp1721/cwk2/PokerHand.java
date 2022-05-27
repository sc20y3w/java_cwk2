package comp1721.cwk2;
import java.util.ArrayList;
import java.util.Arrays;

// Implement PokerHand class here
public class PokerHand extends CardCollection{
    int size;
    ArrayList<String> hand=new ArrayList<String>();
    ArrayList<String> hand1=new ArrayList<String>();
    public PokerHand(){}

    //Initialize the hand
    public PokerHand(String card)throws CardException{
        int num;
        String[] parts = card.split(" ");
        if(parts.length > 5){
            throw new CardException("Too many cards.\n");
        }
        for (int i = 0; i<parts.length;i++){
            num = hand.indexOf(parts[i]);
            if(num == -1) {
                hand.add(parts[i]);
            }else{
                System.out.printf("The type %s card repeats.\n",parts[i]);
                throw new CardException("Error.\n");
            }
        }
        for (int i = 0; i<parts.length;i++){
            num = hand1.indexOf(parts[i]);
            if(num == -1) {
                hand1.add(parts[i]);
            }else{
                System.out.printf("The type %s card repeats.\n",parts[i]);
                throw new CardException("Error.\n");
            }
        }
        String sub2,f,f1;
        Object[] arr = hand1.toArray();
        for (int i = 0; i<hand1.size();i++){
            sub2 = (String) arr[i];
            f = sub2.substring(1,2);
            if(f.equals("C")){
                f1 = sub2.substring(0,1) + "\u2663";
                hand1.set(i,f1);
            }else {
                if(f.equals("D")) {
                    f1 = sub2.substring(0, 1) + "\u2666";
                    hand1.set(i, f1);
                }else {
                    if(f.equals("H")) {
                        f1 = sub2.substring(0, 1) + "\u2665";
                        hand1.set(i, f1);
                    }else {
                        if(f.equals("S")) {
                            f1 = sub2.substring(0, 1) + "\u2660";
                            hand1.set(i, f1);
                        }
                    }
                }
            }
        }
    }

    //Converts hand cards to strings
    public String toString(){
        String h = "";
        Object[] arr = hand1.toArray();
        for (int i = 0; i<hand1.size();i++){
            h = h +arr[i];
            if(i<(hand1.size()-1)){
                h = h+" ";
            }
        }
        return h;
    }

    //Returns the number of cards in a hand
    public int size(){
        Object[] arr = hand.toArray();
        size = arr.length;
        return size;
    }

    //Empty hand
    public void discard() throws CardException{
        int x = size();
        if(x == 0){
            throw new CardException("Hand is empty.");
        }else {hand.clear();}
    }

    //Empty your hand and return it to your deck
    public void discardTo(Deck deck) throws CardException{
        int w = size();
        if(w == 0){
            throw new CardException("Hand is empty.");}
        String a;
        int zero=0;
        int j = 0;
        Object[] arr = hand.toArray();
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 13; y++) {
                if(deck.deck[x][y] == ""){
                    zero++;
                }
            }
        }
        if(zero>=hand.size()) {
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 13; y++) {
                    if (deck.deck[x][y] == "") {
                        while(j< hand.size()){
                            a = (String) arr[j];
                            deck.deck[x][y] = a;
                            j++;
                            break;
                        }
                    }
                }
            }
        }else{
            throw new CardException("Error, the number of hands should be less than or equal to the number of vacant cards.");
        }
        hand.clear();
    }

    //Check for pairs
    public boolean isPair(){
        if(hand.size()<5){
            return false;
        }
        boolean flag;
        boolean f;
        int count;
        int num = 0;
        int bum = 0;
        String sub1,sub2;
        Object[] arr = hand.toArray();
        for(int i=0;i< hand.size();i++){
            count = 0;
            for(int j=0;j<hand.size();j++){
                sub1 = (String) arr[i];
                sub2 = (String) arr[j];
                f = sub1.substring(0,1).equals(sub2.substring(0,1));
                if(f==true){
                    count++;
                }
            }
            if(count==2 && bum == 0){
                num++;
            }else{
                if(count == 3 && num ==0){
                    bum++;
                }else {
                    if(count == 3 && num !=0){
                        num = 0;
                    }else {}
                }
            }
        }
        if(num == 2){
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

    public boolean isTwoPairs(){
        if(hand.size()!=5){
            return false;
        }
        boolean flag;
        boolean f;
        int count=0;
        int num = 0;
        String sub1,sub2;
        Object[] arr = hand.toArray();
        for(int i=0;i< hand.size();i++){
            count = 0;
            for(int j=0;j<hand.size();j++){
                sub1 = (String) arr[i];
                sub2 = (String) arr[j];
                f = sub1.substring(0,1).equals(sub2.substring(0,1));
                if(f==true){
                    count++;
                }
            }
            if(count==2){
                num++;
            }else{
            }
        }
        if(num == 4){
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

    public boolean isThreeOfAKind(){
        if(hand.size()!=5){
            return false;
        }
        boolean flag;
        boolean f;
        int count;
        int num = 0;
        int bum = 0;
        String sub1,sub2;
        Object[] arr = hand.toArray();
        for(int i=0;i< hand.size();i++){
            count = 0;
            for(int j=0;j<hand.size();j++){
                sub1 = (String) arr[i];
                sub2 = (String) arr[j];
                f = sub1.substring(0,1).equals(sub2.substring(0,1));
                if(f==true){
                    count++;
                }
            }
            if(count==3 && bum == 0){
                num++;
            }else{
                if(count == 2 && num ==0){
                    bum++;
                }else {
                    if(count == 2 && num !=0){
                        num = 0;
                    }else {}
                }
            }
        }
        if(num == 3){
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

    public boolean isFourOfAKind(){
        if(hand.size()!=5){
            return false;
        }
        boolean flag;
        boolean f;
        int count;
        int num = 0;
        int bum = 0;
        String sub1,sub2;
        Object[] arr = hand.toArray();
        for(int i=0;i< hand.size();i++){
            count = 0;
            for(int j=0;j<hand.size();j++){
                sub1 = (String) arr[i];
                sub2 = (String) arr[j];
                f = sub1.substring(0,1).equals(sub2.substring(0,1));
                if(f==true){
                    count++;
                }
            }
            if(count==4){
                num++;
            }else{}
        }
        if(num == 4){
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

    public boolean isFullHouse(){
        if(hand.size()!=5){
            return false;
        }
        boolean flag;
        boolean f;
        int count;
        int num = 0;
        int bum = 0;
        String sub1,sub2;
        Object[] arr = hand.toArray();
        for(int i=0;i< hand.size();i++){
            count = 0;
            for(int j=0;j<hand.size();j++){
                sub1 = (String) arr[i];
                sub2 = (String) arr[j];
                f = sub1.substring(0,1).equals(sub2.substring(0,1));
                if(f==true){
                    count++;
                }
            }
            if(count==2){
                num++;
            }else{
                if(count == 3){
                    bum++;
                }else {}
            }
        }
        if(num == 2 && bum == 3){
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

    public boolean isFlush(){
        if(hand.size()!=5){
            return false;
        }
        boolean flag;
        boolean f;
        int count;
        int num = 0;
        String sub1,sub2;
        Object[] arr = hand.toArray();
        for(int i=0;i< hand.size();i++){
            count = 0;
            for(int j=0;j<hand.size();j++){
                sub1 = (String) arr[i];
                sub2 = (String) arr[j];
                f = sub1.substring(1,2).equals(sub2.substring(1,2));
                if(f==true){
                    count++;
                }
            }
            if(count==5){
                num++;
            }else{}
        }
        if(num == 5){
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

    public boolean isStraight(){
        if(hand.size()<5){
            return false;
        }
        int count;
        String sub1,f;
        Object[] arr = hand.toArray();
        String[] h2 = new String[5];
        int[] h3 = new int[5];
        ArrayList<String> h1=new ArrayList<String>();
        for(int i = 0; i< hand.size();i++){
            sub1 = (String) arr[i];
            f = sub1.substring(0,1);
            h1.add(f);
            h2[i] = f;
        }
        for(int i=0;i< hand.size();i++){
            count = 0;
            for(int j=0;j<hand.size();j++) {
                if(h2[i]==h2[j]){
                    count++;
                }
            }
            if(count >= 2){
                return false;
            }
        }
        for(int i=0;i< hand.size();i++){
            if(h2[i].equals("A")){
                h2[i] = "1";
            }else {
                if(h2[i].equals("J")){
                    h2[i] = "11";
                }else {
                    if(h2[i].equals("Q")){
                        h2[i] = "12";
                    }else {
                        if(h2[i].equals("K")){
                            h2[i] = "13";
                        }else {
                            if(h2[i].equals("T")){
                                h2[i] = "10";
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < h2.length; i++) {
            if(h2[i] !=null && !h2[i] .equals("")) {
                h3[i] = Integer.parseInt(h2[i]);
            }
        }
        int num = h1.indexOf("A");
        if(num == -1){
            Arrays.sort(h3);
            if((h3[4]-h3[0])==4){
                return true;
            }else {return false;}
        }else {
            Arrays.sort(h3);
            int h4[] = {1,2,3,4,5};
            int num1 = h1.indexOf("K");
            if(num1 == -1) {
                for (int i = 0; i < h3.length; i++) {
                    if (h3[i] != h4[i]) {
                        return false;
                    }
                }
                return true;
            }else {
                Arrays.sort(h3);
                h3[0] = 14;
                Arrays.sort(h3);
                int h5[] = {10, 11, 12, 13, 14};
                for (int i = 0; i < h3.length; i++) {
                    if (h3[i] != h5[i]) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    @Override
    public void add(Card card) throws CardException{
        String c = card.toString();
        Object[] arr = hand.toArray();
        int num = hand.indexOf(card.toString());
//        System.out.println(arr.length);
        if(arr.length >= 5 || num != -1){
            throw new CardException("Error");
        }else {
            hand.add(c);
        }
    }
}