import random

# Define card values
card_values = {
    'Ace': 11,
    '2': 2,
    '3': 3,
    '4': 4,
    '5': 5,
    '6': 6,
    '7': 7,
    '8': 8,
    '9': 9,
    '10': 10,
    'Jack': 10,
    'Queen': 10,
    'King': 10
}

# Define deck of cards
deck = list(card_values.keys()) * 4

# Define function to calculate hand value
def calculate_hand(hand):
    value = sum(card_values[card] for card in hand)
    if value > 21 and 'Ace' in hand:
        value -= 10
    return value

# Shuffle deck
random.shuffle(deck)

# Deal initial hands
player_hand = [deck.pop(), deck.pop()]
dealer_hand = [deck.pop(), deck.pop()]

# Display initial hands
print("Player's hand:", player_hand)
print("Dealer's hand:", [dealer_hand[0], '???'])

# Player's turn
while True:
    choice = input("Hit or stand? ")
    if choice.lower() == 'hit':
        player_hand.append(deck.pop())
        print("Player's hand:", player_hand)
        if calculate_hand(player_hand) > 21:
            print("Bust! Dealer wins.")
            break
    elif choice.lower() == 'stand':
        break

# Dealer's turn
if calculate_hand(player_hand) <= 21:
    print("Dealer's hand:", dealer_hand)
    while calculate_hand(dealer_hand) < 17:
        dealer_hand.append(deck.pop())
        print("Dealer's hand:", dealer_hand)
        if calculate_hand(dealer_hand) > 21:
            print("Dealer busts! Player wins.")
            break

# Determine winner
if calculate_hand(player_hand) <= 21 and calculate_hand(dealer_hand) <= 21:
    if calculate_hand(player_hand) > calculate_hand(dealer_hand):
        print("Player wins!")
    elif calculate_hand(player_hand) < calculate_hand(dealer_hand):
        print("Dealer wins!")
    else:
        print("It's a tie!")