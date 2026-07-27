"""" While loops """

# nums = (1, 2, 3, 4, 5, 6, 7, 8, 9)
# target1 = 10
# target2 = 4

# i = 0
# isTarget1Present = False
# isTarget2Present = False
# while i < len(nums) :
#     if nums[i] == target1 :
#         print(f"{target1} was present at {i}")
#         isTarget1Present = True
#         break
#     elif nums[i] == target2 :
#         print(f"{target2} was present at {i}")
#         isTarget2Present = True
#         break
#     i += 1
# else :
#     print("Break condition didn't hit")

# if((not (isTarget1Present)) and (not (isTarget2Present))) :
#     print(f"{target1} and {target2} is not present in the nums")
# elif((not (isTarget1Present))) :
#     print(f"{target1} is not present in nums")
# else :
#     print(f"{target2} is not present in nums")

"""" for loops """

# tup = (1, 2, 3, 4, 5, 6, 7, 8, 9)
# target = 30
# isPresent = False
# for num in tup :
#     if num == target :
#         print(f"{target} is present in tup")
#         isPresent = True
#         break

# if(not isPresent) :
#     print(f"{target} is not present in tup")

# n = int(input("Enter a number to print the table :- "))
# for ele in range(n, (n*10+1), n) :
#     print(f"{ele}")

# for i in range(1, 11) :
#     print(f"{n} * {i} = {n*i}")

"""" Practice """
factorial = 1
n = int(input("Enter a number :- "))

i = 2
while i <= n :
    factorial *= i
    i += 1

print(f"Factorial of {n} = {factorial}")