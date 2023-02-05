/*
Задача 47. Задайте двумерный массив размером m×n, 
заполненный случайными вещественными числами.
m = 3, n = 4.
0,5 7 -2 -0,2
1 -3,3 8 -9,9
8 7,8 -7,1 9
*/

// Gets size from console
int GetSizeFromConsole(string name)
{
    int number;
    Console.Write($"Введите количество {name} --> ");
    try
    {
        number = Convert.ToInt32(Console.ReadLine());
    }
    catch
    {
        Console.Beep();
        Console.WriteLine("Что-то пошло не так. Попробуйте ещё.");
        number = GetSizeFromConsole(name);
    }
    number = number > 0 ? number : GetSizeFromConsole(name);
    return number;
}

// Fills an matrix with double random numbers
double[,] FillMatrix(double[,] matrix, int low, int top, int round)
{
    Random rnd = new Random();
    for (int i = 0; i < matrix.GetLength(0); i++)
    {
        for (int j = 0; j < matrix.GetLength(1); j++)
        matrix[i, j] = Math.Round(low + (rnd.NextDouble() * (top - low)), round);
    }
    return matrix;
}


// Outputs array to console 
void WriteMatrix(double[,] array)
{
    string separator = new String('-', 8 * array.GetLength(1));
    Console.WriteLine(separator);
    for (int i = 0; i < array.GetLength(0); i++)
    {
        for (int j = 0; j < array.GetLength(1); j++)
        {
            Console.Write($"{array[i, j], 6:f2} |");
        }
        Console.WriteLine();
    }
    Console.WriteLine(separator);
}

// Main
int row = GetSizeFromConsole("строк");
int column = GetSizeFromConsole("столбцов");
double[,] array = FillMatrix(new double[row, column], -10, 10, 2);
WriteMatrix(array);