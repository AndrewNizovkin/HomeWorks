'''
Телефонный справочник
'''
import os
from tkinter import *
from tkinter import filedialog


def load_demo():
    return [['1', 'Иванов', 'Иван', 'Иванович', '111-111-1111111'], 
            ['2', 'Петров', 'Пётр', 'Петрович', '444-444-4444444']]

def main_menu():
    '''
    Provides choice to the user in main menu

    returns int choice
    '''
    
    return int(input('\033[33m[0] Выход            [1] Вывести справочник  [2] Запись в файл\n' + 
                     '[3] Чтение из файла  [4] Поиск(Имя)          [5] Поиск(Фамилия)\n' + 
                     '[6] Добавить запись  [7] Удалить запись      [8] Изменить запись\n--> \033[0m'))

def change_menu():
    '''
    Provides choice to the user in change menu

    returns int choice
    '''

    return int(input('\033[33m[0] Главное меню    [1] Фамилия    [2] Имя    [3] Отчество    [4] Телефон\n--> \033[0m'))

def read_file():
    '''
    Read file 'file_name' from disk
    
    Returns list with phone_book
    '''
    root = Tk()
    file = filedialog.askopenfile(filetypes=(("Текстовые файлы", "*.txt"), ("Все файлы", "*.*")))
    my_list =[]
    if file != None and os.path.isfile(str(file.name)):
        with open(file.name, 'r', encoding='UTF-8') as data:
            while True:
                line = data.readline()
                if not line:
                    break
                my_list.append(line.split())
    else:
        my_message("Файл не найден")
    root.destroy()
    return my_list


def write_file(list_):
    '''
    Write list_ to file_name
    '''
    root = Tk()
    file = filedialog.asksaveasfile(filetypes=(("Текстовые файлы", "*.txt"), ("Все файлы", "*.*")))
    count = 0
    if file != None:
        with open(file.name, 'w', encoding='UTF-8') as data:
            for i in list_:
                data.write(' '.join(i) + '\n')
                count += 1
            my_message(f"В файл {file.name} записано {count} строк")
    else:
        write_file(list_)
    root.destroy()
        
def print_book(list_, title_):
    '''
    Print to console my_fone_book
    '''
    print(title_)
    print('-' * 40)
    for i in range(len(list_)):
        print(*list_[i])
    print('-' * 40)
    print()

def print_list(list_):
    '''
    Print to console list_
    '''
    print('-' * 40)
    print(*list_)
    print('-' * 40)

def find_value(iter_, value_, col):
    '''
    Finds recods with iter[i][col] == value_

    returns list
    '''
    return [i for i in iter_ if i[col] == value_]

def find_key(list_, key_):
    '''
    Finds record in list_ with key_
    
    returns int index of the desired element
    '''
    for i in range(len(list_)):
        if int(list_[i][0]) == key_:
            return i
    return -1

def get_unique_key(list_):
    '''
    Gets unique key

    returns max + 1 value of list_[i][0]
    '''
    max_ = 0
    for i in range(len(list_)):
        current_key = int(list_[i][0])
        if  current_key > max_:
            max_ = current_key
    return max_ + 1

def change_record(list_, key_):
    '''
    Canges values of list_[key_][i]

    returns list_
    '''
    print_list(list_[key_])
    choice = change_menu()
    while choice !=0:
        if choice == 1:
            list_[key_][1] = input('\033[33mВведите фамилию--> \033[0m')
            print_list(list_[key_])
            choice = change_menu()
        elif choice == 2:
            list_[key_][2] = input('\033[33mВведите имя--> \033[0m')
            print_list(list_[key_])
            choice = change_menu()
        elif choice == 3:
            list_[key_][3] = input('\033[33mВведите отчество--> \033[0m')
            print_list(list_[key_])
            choice = change_menu()
        elif choice == 4:
            list_[key_][4] = input('\033[33mВведите номер телефона--> \033[0m')
            print_list(list_[key_])
            choice = change_menu()
    return list_

def my_message(value_):
    '''
    Print to console value_

    '''
    print()
    print(f'\033[31m{value_}\033[0m')
    print()

'''
Main
'''
my_phone_book = load_demo()
print_book(my_phone_book, "\033[32mСправочник\033[0m")
choice = main_menu()
while choice !=0:
    if choice == 1:
        print_book(my_phone_book, "\033[32mСправочник\033[0m")
        choice = main_menu()
    if choice == 2:
        write_file(my_phone_book)
        print_book(my_phone_book, "\033[32mСправочник\033[0m")
        choice = main_menu()
    elif choice == 3:
        my_phone_book = read_file()
        print_book(my_phone_book, "\033[32mСправочник\033[0m")
        choice = main_menu()
    elif choice == 4:
        find_name = input('\033[33mВведите имя--> \033[0m')
        print_book(find_value(my_phone_book, find_name, 2), f"\033[32mРезультат поиска по имени \"{find_name}\"\033[0m")
        choice = main_menu()
    elif choice == 5:
        find_name = input('\033[33mВведите фамилию--> \033[0m')
        print_book(find_value(my_phone_book, find_name, 1), f"\033[32mРезультат поиска по фамилии \"{find_name}\"\033[0m")
        choice = main_menu()
    elif choice == 6:
        list_ = input('\033[33mВведите через пробел \"Фамилия Имя Отчество Телефон\"--> \033[0m').split()
        list_.insert(0, str(get_unique_key(my_phone_book)))
        my_phone_book.append(list_)
        print_book(my_phone_book, "\033[32mСправочник\033[0m")
        choice = main_menu()
    elif choice == 7:
        key_ = find_key(my_phone_book, int(input('\033[33mВведите индекс записи--> \033[0m')))
        if key_ == -1:
            my_message("Нет такого индекса")
            print_book(my_phone_book, "\033[32mСправочник\033[0m")
            choice = main_menu()
        else:
            my_message(f"Удалёна запись:\n{my_phone_book.pop(key_)}")
            print_book(my_phone_book, "\033[32mСправочник\033[0m")
            choice = main_menu()
    elif choice == 8:
        key_ = find_key(my_phone_book, int(input('\033[33mВведите индекс записи--> \033[0m')))
        if key_ == -1:
            my_message("Нет такого индекса")
            print_book(my_phone_book, "\033[32mСправочник\033[0m")
            choice = main_menu()
        else:
            my_phone_book = change_record(my_phone_book, key_)
            print_book(my_phone_book, "\033[32mСправочник\033[0m")
            choice = main_menu()
