# Card Game Lab

## Model a game of Highest Card Wins

This lab is to model a basic card game and implement the rules.

We are **not** looking for a running, playable game, just good TDD to demonstrate that the game Objects and the logic in their methods works as it should.

####  Highest Card
Build a simple card game that deals one card to every player and the player with the highest card value in their hand wins.

#### Extension
Extend to now deal 2 cards to every player and the player with the highest combination of card values in their hand wins.

#### Advanced Extension.

In the event you are totally finished with your TDDed classes, and want to push on with this idea, consider implementing a runner file.
Allow the users to play the game via the command line. (Print out what cards are dealt to each player, print out the totals for each player, print out the name of the winner).

## Considerations / Restrictions.

1. Think about how to model a deck of cards. What are the constituent parts?
 - A deck which contains 52 cards in a certain order. (What kind of data structure best models this?).
 - A card with a suit and a value. (Given the suits and number of cards is fixed, this could be a job for Enums).
 - Can you think of a way to 'populate' the deck with cards? (A nested loop?).

2. Model the game.
 - Think about how to implement the logistics of the game (dealer deals, player guesses, etc).
 - Think about how to model the rules of the game (determine which hand wins etc).

3. Use test driven development. Fully test your model.
