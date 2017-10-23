import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *  
 * B0544238黃子滔
 * their are 3 class here: HW2,DECK,Card 
 * 
 * HW2 can get how many decks of cards we need and print them all 
 * 
 * DECK make an ArrayList to put all all decks of cards in it .
 * Moreover, Deck include "printDeck" and"getAllCards" .  
 *
 * Card define what a "Card" is (card made with suits and ranks)    
 * Moreover, Card include "getSuit,getRank,printCard"				
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn = sc.nextLine();

		int nDeck = Integer.parseInt(testn);
		Deck deck = new Deck(nDeck);
		
		deck.printDeck();

		if (isAllCardsCorrect(deck.getAllCards(), nDeck)) {
			System.out.println("Well done!");
		} else {
			System.out.println("Error, please check your sourse code");
		}
	}

	/**
	 * This method is used for checking your result, not a part of your HW2
	 * 
	 * @param allCards
	 *            �������
	 * @param nDeck
	 *            蝮賢��嗾����
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards, int nDeck) {
		// check the output
		boolean isCorrect = true;
		;
		HashMap<String, Integer> checkHash = new HashMap<String, Integer>();
		for (Card card : allCards) {
			int suit = card.getSuit();
			int rank = card.getRank();
			if (suit > 4 || suit < 1 || rank > 13 || rank < 1) {
				isCorrect = false;
				break;
			}
			if (checkHash.containsKey(suit + "," + rank)) {
				checkHash.put(suit + "," + rank,
						checkHash.get(suit + "," + rank) + 1);
			} else {
				checkHash.put(suit + "," + rank, 1);
			}

		}
		if (checkHash.keySet().size() == 52) {
			for (int value : checkHash.values()) {
				if (value != nDeck) {
					isCorrect = false;
					break;
				}
			}
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}

}

/**
 * Description:
 * deck: 
 * the first layer for loop: get nDeck to know how many decks
 * of card we need to make 
 * the second layer for loop: make poker rank ace to
 * king(1~13) 
 * the third layer for loop: make the four different kinds of card's unit 
 * it means that we can get [nDeck*13(ace to king)*4(unit)] cards
 * 
 * printDeck: print all the cards by using instance for loop(keep using printCard until all cards be printed)
 * getAllCards: get all cards and it can put in an array list
 */
class Deck {
	private ArrayList<Card> cards;

	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		for (int n = 1; n <= nDeck; n++) 
		{
			for (int i = 1; i <= 13; i++) 
			{
				for (int j = 1; j <= 4; j++) 
				{
					Card card = new Card(j, i);
					cards.add(card);

				}
			}
		}

	}

	public void printDeck() {
		
		//System.out.println(cards.get(0));
		
		for (Card a : cards)
			a.printCard();
	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}

/**
 * Description: 
 * card constructor : suit and rank 
 * printCard : print suit and rank in the same time 
 * getSuit:get suit 
 * getRank:get rank
 */
class Card {
	private int suit;
	private int rank;

	/**
	 * @param s
	 *            suit
	 * @param r
	 *            rank
	 */
	public Card(int s, int r) {
		suit = s;
		rank = r;
	}

	public void printCard() {
		if(rank<10&&rank!=1)
		{
		if(suit==1)
			System.out.println("Clubs" + "," + rank);
		if(suit==2)
			System.out.println("Diamonds" + "," + rank);
		if(suit==3)
			System.out.println("Hearts" + "," + rank);
		if(suit==4)
			System.out.println("Spades" + "," + rank);
		}
		else if(rank==1)
		{
			if(suit==1)
				System.out.println("Clubs" + "," + "A");
			if(suit==2)
				System.out.println("Diamonds" + "," + "A");
			if(suit==3)
				System.out.println("Hearts" + "," + "A");
			if(suit==4)
				System.out.println("Spades" + "," + "A");	
		}
		else if(rank==11)
		{
			if(suit==1)
				System.out.println("Clubs" + "," + "J");
			if(suit==2)
				System.out.println("Diamonds" + "," + "J");
			if(suit==3)
				System.out.println("Hearts" + "," + "J");
			if(suit==4)
				System.out.println("Spades" + "," + "J");	
		}
		else if(rank==12)
		{
			if(suit==1)
				System.out.println("Clubs" + "," + "Q");
			if(suit==2)
				System.out.println("Diamonds" + "," + "Q");
			if(suit==3)
				System.out.println("Hearts" + "," +"Q");
			if(suit==4)
				System.out.println("Spades" + "," + "Q");	
		}
		else if(rank==13)
		{
			if(suit==1)
				System.out.println("Clubs" + "," + "K");
			if(suit==2)
				System.out.println("Diamonds" + "," +"K");
			if(suit==3)
				System.out.println("Hearts" + "," + "K");
			if(suit==4)
				System.out.println("Spades" + "," + "K");
		}
		
	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}
