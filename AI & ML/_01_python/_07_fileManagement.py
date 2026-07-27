# f = open("demo.txt", "w")
# f.write("This text is written throuhg python file\n")
# f.write("We are learning fileManagement in python")

# import os
# os.remove("demo.txt")

''' Practice '''

def change_data(data, target, newStr) :
    return data.replace(target, newStr)

def search(data, target) :
    return data.find(target)

def print_line(data, target) :
    arr = data.split("\n")
    for i in range(0, len(arr)) :
        idx = arr[i].find(target)
        if idx != -1 :
            return f"{target} is present in line {i+1} at {idx}"
        
    return -1


with open("practice.txt", "w+") as f :
    f.write("Hi everyone\nWe are learning file I/O\nusing Java\nI like programming in Java")
    f.seek(0)

    # data = f.read()
    # str = "Java"
    # newStr = "Python"
    # data = change_data(data, str, newStr)
    # f.seek(0)
    # f.write(data)
    # f.seek(0)

    # data = f.read()
    # target = "learning"
    # isTargetPresent = search(data, target)
    # if(isTargetPresent != -1) :
    #     print(f"{target} is present in the file at {isTargetPresent}")
    # else :
    #     print(f"{target} is not present in the file")

    data = f.read()
    target = "learning"
    print(print_line(data, target))