"Taking input"
# name = input("Enter your name :- ")
# print(f"Type of name :- {type(name)}")
# print(f"Welcome {name}")

name = input("Enter your name :- ")
age = int(input("Enter your age :- "))
# marks = list(input("Enter your marks :- "))
marks = list(map(int, input("Enter your marks (comma-separated) :- ").split(",")))
print(f"Name :- {name}")
print(f"Age :- {age}")
print(f"Marks :- {marks}")