# class Student :

#     @staticmethod
#     def college() :
#         print(f"ABC College")

#     def __init__(self, name, marks) :
#         self.name = name
#         self.marks =  marks

#     def getDetails(self) :
#         print(f"Name :- {self.name}")
#         print(f"Marks :- {self.marks}")

#     def getMarks(self) :
#         return self.marks
    
#     def getAvg(self) :
#         sum = 0
#         for key in marks :
#             sum += marks[key]
#         avg = sum/(len(list(marks.keys())))
#         return avg
    
# marks = {
#     "DAA" : 90,
#     "DSA" : 92,
#     "COA" : 78,
#     "DE" : 68,
#     "DM" : 70
# }

# s1 = Student("Adam", marks=marks)
# print(s1.getMarks())
# print(s1.getAvg())
# s1.college()

# from datetime import datetime as date

# class Account :

#     @staticmethod
#     def bank() :
#         print("Wlcome to Fedral Bank of Fraud")
    
#     def __init__(self, account_number, balance, password) :
#         self.account_number = account_number
#         self.balance = balance
#         self.__password = password

#     def getBalance(self) :
#         return self.balance
    
#     def credit(self, amount) :
#         if amount > 0 :
#             self.balance += amount
#             print("-".center(50, "-"))
#             print(f"An amount of ${amount} has been credited to your account successfully\nTotal Balance :- ${self.balance}")
#         else :
#             print(f"Account can't be negative")

#     def debit(self, amount)  :
#         if amount > 0 and amount < self.balance :
#             self.balance -= amount
#             print("-".center(50, "-"))
#             print(f"An amount of ${amount} has been debited from your account_number ({self.account_number}) on {date.now()}")
#             print(f"Toatal Balance ${self.balance}")
#         else :
#             print(f"Amount can't be debited")

#     def resetPassword(self, oldPassword, newPassword) :
#         if(self.__password == oldPassword) :
#             if(oldPassword == newPassword) :
#                 print(f"OLD PASSWORD AND NEW PASSWORD CAN'T BE SAME")
#             else :
#                 self.__password = newPassword
#                 print(f"Your password has been changed successfully")
#         else :
#             print(f"INVALID OLD PASSWORD")

# a1 = Account(123456789, 5000, "adam@123")
# a1.bank()
# print(f"Balance :- {a1.balance}")
# a1.credit(1000)
# a1.debit(9000)

# del a1
# a1.resetPassword("adam@123", "adam@123")

# class Person :
#     name = "rahul yadav"

    # def changeName(self, name) :
    #     oldName =  self.__class__.name
    #     self.__class__.name = name
    #     print(f"Name has been successfully changed from '{oldName.upper()}' to '{(self.__class__.name).upper()}'")

#     @classmethod
#     def changeName(cls, name) :
#         oldName = cls.name
#         cls.name = name
#         print(f"Name has been successfully changed from '{oldName.upper()}' to '{(cls.name).upper()}'")

# p1 = Person()
# print(f"Name :- {p1.name}")
# print(f"Name :- {Person.name}")
# p1.changeName("rahul Kumar")
# print(f"Name :- {p1.name}")
# print(f"Name :- {Person.name}")

# class Student :
#     def __init__(self, phy, maths, chem) :
#         self.phy = phy
#         self.chem = chem
#         self.maths = maths

#     @property
#     def getPercent(self) :
#         totalMarks = str((self.phy + self.maths + self.chem)/3)
#         return (totalMarks + "%")
    
# s1 = Student(60, 50, 90)
# print(s1.getPercent)

# class Complex :
#     def __init__(self, real, img) :
#         self.real = real
#         self.img = img
    
#     @property
#     def printNumber(self) :
#         return f"{self.real}i + {self.img}j"

#     def __add__(self, num2) :
#         newReal = self.real + num2.real
#         newImg = self.img + num2.img
#         return Complex(newReal, newImg)

# num1 = Complex(1, 2)
# print(num1.printNumber)
# num2 = Complex(3, 4)
# num3 = num1 + num2
# print(num3.printNumber)

class Order :
    def __init__(self, price) :
        self.price = price
    
    def __gt__(self, other):
        print(f"is {self.price} greater than {other.price} : {self.price > other.price}")

o1 =  Order(200)
o2 = Order(300)
# o1.__gt__(o2)
o2 > o1