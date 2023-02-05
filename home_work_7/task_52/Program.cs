/*
Задача 52. Задайте двумерный массив из целых чисел. 
Найдите среднее арифметическое элементов в каждом 
столбце.
Например, задан массив:
1 4 7 2
5 9 2 3
8 4 2 4
Среднее арифметическое каждого столбца: 4,6; 5,6; 3,6; 3.
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

// Outputs int matrix to console 
void WriteMatrix(int[,] matrix)
{
    string separator = new String('-', 8 * matrix.GetLength(1));
    Console.WriteLine(separator);
    for (int i = 0; i < matrix.GetLength(0); i++)
    {
        for (int j = 0; j < matrix.GetLength(1); j++)
            Console.Write($"{matrix[i, j],4}   |");
        Console.WriteLine();
    }
    Console.WriteLine(separator);
}

// Outputs double array to console
void WriteArray(double[] array)
{
    string separator = new String('-', 8 * array.Length);
    Console.WriteLine(separator);
    foreach (double realNumber in array) Console.Write($"{realNumber,5:f1}  |");
    Console.WriteLine();
    Console.WriteLine(separator);
}

// Gets the array of arithmetic mean of the columns of the matrix
double[] GetArithmeticMean(int[,] matrix)
{
    double[] array = new double[matrix.GetLength(1)];
    for (int i = 0; i < matrix.GetLength(0); i++)
    {
        for (int j = 0; j < matrix.GetLength(1); j++)
            array[j] += matrix[i, j];
    }
    for (int i = 0; i < array.Length; i++)
        array[i] /= matrix.GetLength(0);
    return array;
}

// Main
int row = GetSizeFromConsole("строк");
int column = GetSizeFromConsole("столбцов");
int[,] matrix = FillMatrix(new int[row, column], 1, 11);
WriteMatrix(matrix);
WriteArray(GetArithmeticMean(matrix));