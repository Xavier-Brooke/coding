""" List """
# nums = [1, 876, -34, 986, 0, 86, 875, 645, 6, -75, -75, -4234]
# print(f"data type of nums :- {type(nums)}")
# print(f"list :- {nums}")
# print(f"length of list :- {len(nums)}")

# print(f"Slicing :- {nums[::-1]}")
# print(f"Slicing :- {nums[:len(nums):2]}")

""" List Methods """
# nums.append(7)
# nums.sort()
# print(f"nums after sorting :- {nums}")

""" Tuples """
# tup = (12, 8, 6, 7, -54, -34, 1, 0)
# print(f"count :- {tup.count(12)}")
# print(f"index :- {tup.index(0)}")

""" Practice Question """
# list1 = [1, 2, 3, "car", "car", 3, 2, 1, 23]
# list2 = list1.copy()
# list2.reverse()
# print(f"list1 :- {list1}")
# print(f"list2 :- {list2}")

# if list1 == list2 :
#     print(f"list1 and list2 are palindromes")
# else :
#     print(f"lists are not palindromes")

tup = ("A", "B", "C", "D", "E")
print(tup)
tup = list(tup)
tup.sort(reverse=True)
tup = tuple(tup)
print(tup)