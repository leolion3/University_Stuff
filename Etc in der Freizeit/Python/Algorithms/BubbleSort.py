array = [9,8,7,6,5,4,3,2,1,0,11,324,6,3,12,634,1,2,-1,-32849,45,234,856,34]

print("This is the unsorted list: " + str(array))

a=0
b=0

while a<len(array):
    b=0
    while b<len(array)-1:
        if array[b+1]<array[b]:
            first = array[b+1]
            array[b+1] = array[b]
            array[b] = first
        b+=1
    a+=1
    continue

print("This is the sorted list: " + str(array))
input()