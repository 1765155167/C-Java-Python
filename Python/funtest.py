def funtest(a,c = 1,*args):
    if len(args) == 0:
        print('%s!' % a)
    else:
        print('a =',a,end=' ')
        print('c =',c,end=' ')
        print('args =',args,end=' ')
funtest('1',2,3)
