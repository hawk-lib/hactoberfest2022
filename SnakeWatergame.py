import random
lst = ['s','w','g']

print("Welcome to the Game!!!")
chance = int(input("How many times do you want to play?"))
no_of_chance = 0
computer_point = 0
human_point = 0

print(" \t \t \t \t Snake,Water,Gun Game\n \n")
print("s for Snake \nw for Water \ng for Gun \n")

# making the game in while
while no_of_chance < chance:
    _input = input('Snake,Water,Gun:')
    _random = random.choice(lst)

    if _input == _random:
        print("Tie Both get 0 point to each \n ")

    # if user enter s
    elif _input == "s" and _random == "g":
        computer_point = computer_point + 1
        print(f"Your guess {_input} and Computer guess is {_random} \n")
        print("Computer wins 1 point \n")
        print(f"Computer Point is {computer_point} and Your Point is {human_point} \n ")

    elif _input == "s" and _random == "w":
        human_point = human_point + 1
        print(f"Your guess {_input} and Computer guess is {_random} \n")
        print("Human wins 1 point \n")
        print(f"Computer Point is {computer_point} and Your Point is {human_point} \n")

    # if user enter w
    elif _input == "w" and _random == "s":
        computer_point = computer_point + 1
        print(f"Your guess {_input} and Computer guess is {_random} \n")
        print("Computer wins 1 point \n")
        print(f"Computer Point is {computer_point} and Your Point is {human_point} \n ")

    elif _input == "w" and _random == "g":
        human_point = human_point + 1
        print(f"Your guess {_input} and Computer guess is {_random} \n")
        print("Human wins 1 point \n")
        print(f"Computer Point is {computer_point} and Your Point is {human_point} \n")

    # if user enter g

    elif _input == "g" and _random == "s":
        human_point = human_point + 1
        print(f"Your guess {_input} and Computer guess is {_random} \n")
        print("Human wins 1 point \n")
        print(f"Computer point is {computer_point} and Your point is {human_point} \n")


    elif _input == "g" and _random == "w":
        computer_point = computer_point + 1
        print(f"your guess {_input} and computer guess is {_random} \n")
        print("Computer Wins 1 point \n")
        print(f"Computer Point is {computer_point} and Your Point is {human_point} \n ")

    else:
        print("You have given the input wrong and so have been penaltied \n")

    no_of_chance = no_of_chance + 1
    print(f"{chance - no_of_chance} is left out of {chance} \n")

print("Game over")

if computer_point==human_point:
    print("Tie")

elif computer_point > human_point:
    print("Computer wins and You have Lost the game, better Luck next Time!!!")

else:
    print("Congratulations!!! Your the Winner and Computer has lost the game")

print(f"Your Point is {human_point} and Computer Point is {computer_point}")

#
# Snake Water Gun Game in Python
# The snake drinks the water, the gun shoots the snake, and gun loses with water.
#