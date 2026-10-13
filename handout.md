# Your first poker bot

Choose Python, JavaScript, or Java. Work alone or with a partner. Pseudocode is welcome if setup takes too long.

## Poker reminders

Hold'em gives each player two private cards and up to five shared cards. Select your best five-card hand from the available cards. You can use zero, one, or two private cards. A remaining player wins when everyone else folds.

Checking means staying in without paying more when legal. Calling pays the additional amount needed to match a wager. Folding gives up your claim to the pot.

References: [Hold'em rules](https://www.pokerstars.com/poker/games/texas-holdem/) and [poker actions](https://www.pokerstars.com/poker/games/rules/).

## Hand-ranking reference

| Strongest first | Meaning |
|---|---|
| Royal flush | A, K, Q, J, T of one suit |
| Straight flush | Five consecutive ranks of one suit |
| Four of a kind | Four cards of one rank |
| Full house | Three of one rank and two of another |
| Flush | Five cards of one suit |
| Straight | Five consecutive ranks |
| Three of a kind | Three cards of one rank |
| Two pair | Two cards of each of two ranks |
| One pair | Two cards of one rank |
| High card | None of the combinations above |

Compare the complete best five cards to settle equal categories. Suits do not outrank each other. An ace can be low in A-2-3-4-5 or high in T-J-Q-K-A, but a straight cannot wrap around.

Reference: [PokerStars hand rankings](https://www.pokerstars.com/poker/games/rules/hand-rankings/).

## Observation fields

These are workshop-only examples.

| Field in Python / JS | Java field | Meaning |
|---|---|---|
| street | street | preflop, flop, turn, or river |
| hole_cards | holeCards | Your two private cards |
| board | board | Shared cards currently visible |
| pot | pot | Chips already in the pot |
| to_call | toCall | Additional chips needed to call |
| big_blind | bigBlind | Size of one big blind |
| stack | stack | Your chips remaining outside the pot |
| legal_actions | legalActions | Currently available action names |

Card ranks are integers: 2–10, J = 11, Q = 12, K = 13, A = 14. Suits are S, H, D, C.

Your function returns an action with the name check, call, or fold. The exercise does not handle bet/raise sizing.

## First task

Open python/starter.py, javascript/starter.mjs, or java/StarterBot.java.

The starter checks when possible and otherwise folds. Add this rule before folding:

Call when calling is legal and the price is at most two big blinds.

Run the edited starter against the baseline reference using your language's command from README.md.

## Second task

Choose one improvement:

- Use a preflop pair to change your call limit.
- Limit spending to a fraction of your remaining stack.
- Use different rules before and after the flop.

The improved example combines these ideas with deliberately simple thresholds. It is a learning example, not a proven strategy.

After changing your rule, verify that responses are still legal. You do not need to match the baseline's choices.

## Explain your strategy

Write three short answers:

1. What rule did you add?
2. Which input changed the decision?
3. Give one situation where your bot could make a bad decision.

The next workshop is October 20. Engine, tournament starter bots, and submission instructions will follow separately.
