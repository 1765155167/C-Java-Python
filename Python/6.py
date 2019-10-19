m = input()
m, n = map(int, m.split())
for x in range(m,n):
    if '7' in str(x):
        print(x)
