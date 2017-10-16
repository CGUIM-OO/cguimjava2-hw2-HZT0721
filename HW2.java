import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here
 * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards �������
	 * @param nDeck 蝮賢��嗾����
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description:deck:
 * 			   the first  layer for loop: get nDeck to know how many decks of card we need to make
 * 			   the second layer for loop: make poker rank ace to king(1~13)
 *   		   the third  layer for loop: make the four different kinds of card's unit
 *             it means that we can get [nDeck*13(ace to king)*4(unit)] cards
 *             
 *              printDeck: print all the cards
 *              getAllCards: get all cards and it can  put in an array list
 */
class Deck{
	private ArrayList<Card> cards;
	
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
	for(int n=1;n<=nDeck;n++ )
	{for(int i=1;i<=13;i++)
		{for (int j=1;j<=4;j++)
		 {Card card=new Card(j,i);
		  cards.add(card);
		  
		 }
		}
	}
			
		
	}	
	
	public void printDeck(){
		
		for(Card a: cards)
			System.out.println(a);
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: card constructor : suit and rank
 *              printCard : print suit and rank in the same time  
 *              getSuit:get suit
 *            	getRank:get rank
 */
class Card{
	private int suit; 
	private int rank;
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	
	public void printCard(){
		
		System.out.println(suit+","+rank);
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
