"""" Functions """

# def cal_sum(a,b,c) :
#     return (a+b+c)

# print(cal_sum(c=13, a=22, b = 23))

"""" Recursions """
# def show(n) :
#     if n == 0 :
#         return
#     print(n, end=",")
#     show(n-1)
#     print(n, end=",")

# show(5)

# def cal_sum(n) :
#     if n == 1 :
#         return 1
#     return n + cal_sum(n-1)

# print(cal_sum(10))

def print_list(nums, idx=0) :
    if idx == len(nums) :
        return
    print(f"Value at {idx} is {nums[idx]}")
    print_list(nums, idx+1)
    return

nums = [1, 2, 3, 4, 5, 6, 7, "This is the end"]
print_list(nums)