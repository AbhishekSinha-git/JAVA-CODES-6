import java.util.*;

// A class to represent a card
class Card {
    // Data members
    private int rank; // 1 to 13, where 1 is Ace, 11 is Jack, 12 is Queen, 13 is King
    private int suit; // 1 to 4, where 1 is Clubs, 2 is Diamonds, 3 is Hearts, 4 is Spades

    // Default constructor
    public Card() {
        rank = 1;
        suit = 1;
    }

    // Parameterized constructor
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Getter methods
    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    // Setter methods
    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    // A method to print a card
    public void printCard() {
        // A string array to store the rank names
        String[] rankNames = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        // A string array to store the suit symbols
        String[] suitSymbols = {"\u2663", "\u2666", "\u2665", "\u2660"};
        // Print the card in the format of rank + suit symbol
        System.out.print(rankNames[rank - 1] + suitSymbols[suit - 1] + " ");
    }

    // A method to check if two cards are the same
    public boolean sameCard(Card c) {
        // Two cards are the same if they have the same rank and suit
        return this.rank == c.rank && this.suit == c.suit;
    }

    // A method to compare two cards
    public int compareCard(Card c) {
        // Compare the cards by their ranks first, then by their suits
        // Return 1 if this card is larger, -1 if this card is smaller, 0 if they are equal
        if (this.rank > c.rank) {
            return 1;
        } else if (this.rank < c.rank) {
            return -1;
        } else {
            if (this.suit > c.suit) {
                return 1;
            } else if (this.suit < c.suit) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

// A class to represent a deck of cards
class Deck {
    // Data member
    private Vector<Card> cards; // A vector to store the cards

    // Default constructor
    public Deck() {
        cards = new Vector<Card>();
        createDeck();
    }

    // A method to create a deck of 52 cards
    public void createDeck() {
        // Loop through all the ranks and suits and add a new card to the vector
        for (int rank = 1; rank <= 13; rank++) {
            for (int suit = 1; suit <= 4; suit++) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    // A method to print the deck
    public void printDeck() {
        // Loop through the vector and print each card
        for (Card c : cards) {
            c.printCard();
        }
        System.out.println();
    }

    // A method to shuffle the deck
    public void shuffleDeck() {
        // Use the Collections class to randomly permute the vector
        Collections.shuffle(cards);
    }

    // A method to sort the deck
    public void sortDeck() {
        // Use the Collections class to sort the vector using a custom comparator
        Collections.sort(cards, new Comparator<Card>() {
            // Override the compare method to compare two cards
            public int compare(Card c1, Card c2) {
                // Use the compareCard method of the Card class
                return c1.compareCard(c2);
            }
        });
    }

    // A method to find a card in the deck
    public boolean findCard(Card c) {
        // Loop through the vector and check if any card is the same as the given card
        for (Card d : cards) {
            if (d.sameCard(c)) {
                return true;
            }
        }
        return false;
    }

    // A method to deal 5 random cards from the deck
    public void dealCards() {
        // Create a random object
        Random rand = new Random();
        // Loop 5 times
        for (int i = 0; i < 5; i++) {
            // Generate a random index from 0 to the size of the vector - 1
            int index = rand.nextInt(cards.size());
            // Get the card at that index and print it
            Card c = cards.get(index);
            c.printCard();
            // Remove the card from the vector
            cards.remove(index);
        }
        System.out.println();
    }
}

// A class to test the program
class Main {
    // The main method
    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner sc = new Scanner(System.in);
        // Create a deck object
        Deck deck = new Deck();
        // A boolean variable to control the loop
        boolean exit = false;
        // A loop to display the menu and perform the operations
        while (!exit) {
            // Display the menu
            System.out.println("Menu:");
            System.out.println("1. Print the deck");
            System.out.println("2. Shuffle the deck");
            System.out.println("3. Sort the deck");
            System.out.println("4. Find a card in the deck");
            System.out.println("5. Deal 5 cards from the deck");
            System.out.println("6. Exit");
            // Prompt the user to enter a choice
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            // Perform the operation based on the choice
            switch (choice) {
                case 1:
                    // Print the deck
                    deck.printDeck();
                    break;
                case 2:
                    // Shuffle the deck
                    deck.shuffleDeck();
                    System.out.println("The deck is shuffled.");
                    break;
                case 3:
                    // Sort the deck
                    deck.sortDeck();
                    System.out.println("The deck is sorted.");
                    break;
                case 4:
                    // Find a card in the deck
                    // Prompt the user to enter the rank and suit of the card
                    System.out.print("Enter the rank of the card (1 to 13): ");
                    int rank = sc.nextInt();
                    System.out.print("Enter the suit of the card (1 to 4): ");
                    int suit = sc.nextInt();
                    // Create a card object with the given rank and suit
                    Card card = new Card(rank, suit);
                    // Check if the card is in the deck
                    boolean found = deck.findCard(card);
                    // Display the result
                    if (found) {
                        System.out.println("The card is in the deck.");
                    } else {
                        System.out.println("The card is not in the deck.");
                    }
                    break;
                case 5:
                    // Deal 5 cards from the deck
                    System.out.println("The 5 cards are:");
                    deck.dealCards();
                    break;
                case 6:
                    // Exit the loop
                    exit = true;
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        // Close the scanner
        sc.close();
    }
}
