""" Dictonary """

# info = {
#     "name" : "Xavier Brooke",
#     "age" : 22,
#     "city" : "Mumbai",
#     "college" : "ABC Institute",
#     "branch" : "CSE",
#     "marks" : {
#         "DSA" : 90,
#         "COA" : 98,
#         "DE" : 80,
#         "DAA" : 87,
#         "OOPS" : 82
#     },
#     "isTopper" : False,
#     "rank" : 22,
#     1 : "Extran"
# }

# print(f"Type of info :- {type(info)}")
# print(f"keys in info :- {info.keys()}")
# print(f"values in info :- {info.values()}")
# print(f"items in info :- {info.items()}")

# keys = list(info.keys())
# print(keys)
# for ele in keys :
#     print(f"{ele} -> {info.get(ele)}")

# for keys in info :
#     print(f"{keys} -> {info.get(keys)}")

# info.update({"city" : "Banglore", "country" : "India"})
# print(info)

""" Sets """
collections = {1, 2, 3, 4, 5, (6, 7, 8, 9), "10, 11, 12"}

# print(f"Type of collections :- {type(collections)}")
# print(f"Collections :- {collections}")
# collections.pop()
# collections.pop()
# print(f"Collections after removing element :- {collections}")
collections.remove("10, 11, 12")
collections.remove((6, 7, 8, 9))
print(f"Collecitons after removing some element :- {collections}")