/*
Задача 50. Напишите программу, которая на вход 
принимает позиции элемента в двумерном массиве, 
и возвращает значение этого элемента или же указание,
что такого элемента нет.
Например, задан массив:
1 4 7 2
5 9 2 3
8 4 2 4
17 -> такого числа в массиве нет
*/

// Fills an matrix with int random numbers
int[,] FillMatrix(int[,] array, int low, int top)
{
    Random rnd = new Random();
    for (int i = 0; i < array.GetLength(0); i++)
    {
        for (int j = 0; j < array.GetLength(1); j++)
        array[i, j] = rnd.Next(low, top);
    }
    return array;
}

// Gets positon of element from console
int GetPositionFromConsole(string name)
{
    int number;
    Console.Write($"Введите номер {name} --> ");
    try
    {
        number = Convert.ToInt32(Console.ReadLine());
    }
    catch
    {
        Console.Beep();
        Console.WriteLine("Что-то пошло не так. Попробуйте ещё.");
        number = GetPositionFromConsole(name);
    }
    number = number > 0 ? number : GetPositionFromConsole(name);
    return number;
}

// Outputs int matrix to console 
void WriteMatrix(int[,] array)
{
    string separator = new String('-', 8 * array.GetLength(1));
    Console.WriteLine(separator);
    for (int i = 0; i < array.GetLength(0); i++)
    {
        for (int j = 0; j < array.GetLength(1); j++)
        {
            Console.Write($"{array[i, j], 4}   |");
        }
        Console.WriteLine();
    }
    Console.WriteLine(separator);
}

// Checks for a hit in the range
bool inRange(int[,] matrix, int row, int column) 
{
    return row <= matrix.GetLength(0) && column <= matrix.GetLength(1);
}

// Main
int[,] matrix = FillMatrix(new int[4, 7], -10, 10);
WriteMatrix(matrix);
Console.WriteLine("Введите позицию искомого элемента, начиная с 1 (натуральное число):");
int row = GetPositionFromConsole("строки");
int column = GetPositionFromConsole("стобца");
if (inRange(matrix, row, column))
{
    Console.WriteLine("Значение элемента, на указанной позиции = " + matrix[row - 1, column - 1]);
}
else
{
    Console.WriteLine("Указанная позиция не существует в данной таблице");
}