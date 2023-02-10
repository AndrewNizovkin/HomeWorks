/*
Задача 68: Напишите программу вычисления функции Аккермана 
с помощью рекурсии. Даны два неотрицательных числа m и n.
m = 2, n = 3 -> A(m,n) = 9
m = 3, n = 2 -> A(m,n) = 29
*/

// Main
int m = GetNumberFromConsole("m");
int n = GetNumberFromConsole("n");
Console.WriteLine($"Результат вычисления функции Аккермана A(m, n) = {anc(m, n)}");
Console.WriteLine("PS: Спасибо за уроки ))");

// Gets result Ancerman function
int anc(int m, int n)
{
    if (m == 0) return n + 1;
    else
    {
        if ((m !=0) && (n == 0)) return anc(m - 1, 1);
        else return anc(m - 1, anc(m, n - 1));
    }
}

// Gets size from console
int GetNumberFromConsole(string name)
{
    int number;
    Console.Write($"Введите неотрицательное число {name} --> ");
    try
    {
        number = Convert.ToInt32(Console.ReadLine());
    }
    catch
    {
        Console.Beep();
        Console.WriteLine("Что-то пошло не так. Попробуйте ещё.");
        number = GetNumberFromConsole(name);
    }
    number = number >= 0 ? number : GetNumberFromConsole(name);
    return number;
}
