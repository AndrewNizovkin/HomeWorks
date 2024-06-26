'''
Задача 34:  Винни-Пух попросил Вас посмотреть, есть ли в его стихах ритм. 
Поскольку разобраться в его кричалках не настолько просто, насколько легко 
он их придумывает, Вам стоит написать программу. Винни-Пух считает, 
что ритм есть, если число слогов (т.е. число гласных букв) в каждой фразе 
стихотворения одинаковое. Фраза может состоять из одного слова, 
если во фразе несколько слов, то они разделяются дефисами. 
Фразы отделяются друг от друга пробелами. Стихотворение  
Винни-Пух вбивает в программу с клавиатуры. 
В ответе напишите “Парам пам-пам”, если с ритмом все в порядке и 
“Пам парам”, если с ритмом все не в порядке
*Пример:*
**Ввод:** пара-ра-рам рам-пам-папам па-ра-па-да    
**Вывод:** Парам пам-пам  

'''

my_vowels = {'а', 'е', 'ё', 'и', 'й', 'о', 'у', 'ы', 'э', 'ю', 'я'}

def count_vowel(text):
    '''
    Gets the number of vowels in the `text`
    
    '''
    return len([i for i in text if i in my_vowels])

my_input = input('Стихотворение Винни-Пуха-->').split()
print('ритм есть') if len({count_vowel(x) for x in my_input}) == 1 \
    else print('ритма нет')
