# JAVA-CODES-6

# Card and Deck Java Implementation

This Java code provides implementations for two classes: `Card` and `Deck`. These classes are designed to represent a standard playing card and a deck of playing cards, respectively. The code also includes a `Main` class to test the functionality of the `Deck` class through a simple console-based menu-driven program.

## Card Class

### Properties
- `rank`: Represents the rank of the card (1 to 13).
- `suit`: Represents the suit of the card (1 to 4).

### Constructors
- `Card()`: Default constructor that initializes a card with rank 1 (Ace) and suit 1 (Clubs).
- `Card(int rank, int suit)`: Parameterized constructor that allows setting the rank and suit of the card.

### Methods
- `getRank()`: Returns the rank of the card.
- `getSuit()`: Returns the suit of the card.
- `setRank(int rank)`: Sets the rank of the card.
- `setSuit(int suit)`: Sets the suit of the card.
- `printCard()`: Prints the card in a human-readable format.
- `sameCard(Card c)`: Checks if two cards are the same (have the same rank and suit).
- `compareCard(Card c)`: Compares two cards based on their rank and suit.

## Deck Class

### Properties
- `cards`: A vector (Java `Vector` class) to store instances of `Card`.

### Constructors
- `Deck()`: Default constructor that initializes an empty deck and creates a standard deck of 52 cards using the `createDeck()` method.

### Methods
- `createDeck()`: Populates the deck with 52 standard playing cards (13 ranks, 4 suits).
- `printDeck()`: Prints all cards in the deck.
- `shuffleDeck()`: Shuffles the cards in the deck randomly.
- `sortDeck()`: Sorts the cards in the deck in ascending order based on their ranks and suits.
- `findCard(Card c)`: Checks if a specific card is present in the deck.
- `dealCards()`: Deals 5 random cards from the deck.
