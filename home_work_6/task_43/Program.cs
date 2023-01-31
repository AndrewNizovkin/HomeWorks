/*
Задача 43: Напишите программу, которая найдёт точку 
пересечения двух прямых, заданных уравнениями 
y = k1 * x + b1, y = k2 * x + b2; значения b1, 
k1, b2 и k2 задаются пользователем.
b1 = 2, k1 = 5, b2 = 4, k2 = 9 -> (-0,5; -0,5)
*/

// Gets ratio from console
double GetRatioFromConsole(string name)
{
    Console.Write($"Введите коэффициент {name}--> ");
    return Convert.ToInt32(Console.ReadLine());
}

// Main
double k1 = GetRatioFromConsole("k1");
double b1 = GetRatioFromConsole("b1");
double k2 = GetRatioFromConsole("k2");
double b2 = GetRatioFromConsole("b2");

if (k1 == k2)
{
    Console.WriteLine("Задача не имеет решения. Линии параллельны");
}
else
{
    double interX = (b2 - b1) / (k1 - k2);
    double interY = k1 * interX + b1;
    Console.WriteLine("Координаты точки пересечения линий:");
    Console.WriteLine($"X = {interX:f3}");
    Console.WriteLine($"Y = {interY:f3}");
}
