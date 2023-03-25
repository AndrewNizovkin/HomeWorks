'''
Задача 26:  Напишите программу, которая на вход принимает два числа A и B, 
и возводит число А в целую степень B с помощью рекурсии.
*Пример:*
A = 3; B = 5 -> 243 (3⁵)
    A = 2; B = 3 -> 8 
'''
def get_mult_rec(a, b):
    if b < 1:
        return 1
    return get_mult_rec(a, b - 1) * a

a = int(input('A--> '))
b = int(input('B--> '))
print(get_mult_rec(a, b))