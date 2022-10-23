import random


def winner (computer,you):
    # check is game is a tie
    
    if you == computer: 
        print(f"YOU CHOONSE {you}" )
        print(f"COMPUTER CHOOSE {computer}")
        print(f"GAME IS A TIE ")
        
        
    # compare values of you and computer
    
    if you == 'snake 🐍' and computer == 'water 💦' :
        print(f"YOU CHOONSE {you}")
        print(f"COMPUTER CHOOSE {computer}")
        print(f"YOU WIN ")
    elif you == 'snake 🐍' and computer == 'gun 🔫' :
        print(f"YOU CHOONSE {you}")
        print(f"COMPUTER CHOOSE {computer}")
        print(f"YOU LOOSE ")
    elif you == 'water 💦' and computer == 'snake 🐍' :
        print(f"YOU CHOONSE {you} ")
        print(f"COMPUTER CHOOSE {computer}")
        print(f"YOU LOOSE ")
    elif you == 'water 💦' and computer == 'gun 🔫' :
        print(f"YOU CHOONSE {you}")
        print(f"COMPUTER CHOOSE {computer}")
        print(f"YOU LOOSE ")
    elif you == 'gun 🔫' and computer == 'water 💦' :
        print(f"YOU CHOONSE {you}")
        print(f"COMPUTER CHOOSE {computer}")
        print(f"YOU LOOSE ")
    elif you == 'gun 🔫' and computer == 'snake 🐍' :
        print(f"YOU CHOONSE {you} ")
        print(f"COMPUTER CHOOSE {computer}")
        print(f"YOU WIN ")
        

# assigning random values  to computer from range 1 to 3 
computer=random.randint(1,3)

if computer == 1:
    computer= 'snake 🐍'
if computer == 2:
    computer= 'water 💦'
if computer == 3:
    computer= 'gun 🔫'
    
you=(input("snake(s) 🐍  water(w) 💦  or gun(g) 🔫 ? :  " ))
if you == 's':
        you='snake 🐍'    
elif you == 'w':
        you='water 💦'   
elif you == 'g':
        you='gun 🔫'   
else:
    print("INVALID CHOICE")        

winner(computer,you)             # calling winner function