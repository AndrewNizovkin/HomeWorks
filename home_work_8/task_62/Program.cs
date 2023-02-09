/*
Задача 62. Напишите программу, которая заполнит 
спирально массив 4 на 4.
Например, на выходе получается вот такой массив:
01 02 03 04
12 13 14 05
11 16 15 06
10 09 08 07
*/

// Main
Random rnd = new Random();
int size = rnd.Next(2, 21);
int[,] matrix = new int[size, size];

string direction = "East";
int layer = 0;
int i = 0;
int j = 0;
for (int k = 1; k <= size * size; k++) FillArraySpirally(k);

WriteMatrix(matrix);

// Fills array spirally
void FillArraySpirally(int value)
{
    matrix[i, j] = value;
    switch (direction)
    {
        case "East":
        if (j < size - 1 - layer) j++;
        else
        {
            i++;
            direction = "South";
        }
        break;
        case "South":
        if (i < size - 1 - layer) i++;
        else
        {
            direction = "West";
            j--;
        }
        break;
        case "West":
        if (j > 0 + layer) j--;
        else
        {
            direction = "North";
            i--;
        }
        break;
        case "North":
        if (i > 1 + layer) i--;
        else
        {
            direction = "East";
            j++;
            layer++;
        }
        break;
    }
}

// Outputs int matrix to console 
void WriteMatrix(int[,] matrix)
{
    for (int i = 0; i < matrix.GetLength(0); i++)
    {
        for (int j = 0; j < matrix.GetLength(1); j++)
        {
            Console.Write($"{matrix[i, j],4}");
            Console.ForegroundColor = ConsoleColor.White;
        }
        Console.WriteLine();
    }
}
