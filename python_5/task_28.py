'''
Задача 28: Напишите рекурсивную функцию sum(a, b), возвращающую сумму 
двух целых неотрицательных чисел. Из всех арифметических операций 
допускаются только +1 и -1. Также нельзя использовать циклы.
*Пример:*
2 2
    4
'''

def get_sum_rec(c, d):
    if d == 0 and c == 0:
        return 0
    if d == 0 and c != 0: 
        return get_sum_rec(d, c - 1) + 1
    return get_sum_rec(c, d - 1) + 1

a = int(input('A--> '))
b = int(input('B--> '))
print(get_sum_rec(a, b))