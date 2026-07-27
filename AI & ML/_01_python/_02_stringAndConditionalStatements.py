"""String"""
# first_name = input("Enter your first name :- ")
# last_name = input("Enter your last name :- ") 
# full_name = first_name + " " + last_name
# print(f"Hello, {full_name}")
# print(f"Your name has {len(full_name)} number of characters")

"""String methods"""
# str = "This is demo string 1"
# print(f"Slicing :- {str[::]}")
# print(f"Slicing :- {str[1::2]}")
# print(f"Slicing :- {str[::-1]}") # str[::-1] this is used to reverse string

# print(str.capitalize())
# print(str.count('i'))
# print(str.endswith("ing"))
# print(str.find("is"))
# print(str.isalnum())
# print(str.strip())

# str1 = "ABCDE"
# str2 = "abcde"
# str1 = str1.casefold()
# str2 = str2.casefold()
# print(str1 == str2)

""" Conditional Statements """
marks = list(map(int, input("Enter your marks (comma-seperated) :- ").split(",")))

avg = 0
sum = 0
for val in marks :
    sum += val

avg = sum/(len(marks))
# print(f"Your average marks is :- {avg}")
if avg >= 90 :
    print(f"Well Done your avg. is {avg}")
elif avg < 90 and avg >= 80 :
    print(f"Excellent your avg. is {avg}")
elif avg < 80 and avg >= 70 :
    print(f"Very good your avg is {avg}")
elif avg < 70 and avg > 50 :
    print(f"good your avg is {avg}")
else :
    print(f"Try again your avg is {avg}")