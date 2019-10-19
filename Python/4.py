input()
b = input()
b = list(map(int,b.split()))
su = 0
for x in b:
    if x >= 60:
        su += 1
print('%.2f' % (su/len(b)))

