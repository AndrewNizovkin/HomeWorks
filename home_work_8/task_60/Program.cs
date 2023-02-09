/*
Задача 60. ...Сформируйте трёхмерный массив из 
неповторяющихся двузначных чисел. 
Напишите программу, которая будет построчно выводить массив, 
добавляя индексы каждого элемента.
Массив размером 2 x 2 x 2
66(0,0,0) 25(0,1,0)
34(1,0,0) 41(1,1,0)
27(0,0,1) 90(0,1,1)
26(1,0,1) 55(1,1,1)
*/

// Main
Random rnd = new Random();
int[,,] arrayCubic = new int[rnd.Next(2, 5), rnd.Next(2, 5), rnd.Next(2, 5)];
FillArrayCubic();
WriteArrayCubic();

// Fill cubic array
void FillArrayCubic()
{
    //Random rnd = new Random();
    for (int i = 0; i < arrayCubic.GetLength(0); i++)
    {
        for (int j = 0; j < arrayCubic.GetLength(1); j++)
        {
            for (int k = 0; k < arrayCubic.GetLength(2); k++)
            {
                arrayCubic[i, j, k] = GetUniqueNumber();
            }
        }
    }
}

// Outputs cubic array to console
void WriteArrayCubic()
{
    for (int i = 0; i < arrayCubic.GetLength(0); i++)
    {
        for (int j = 0; j < arrayCubic.GetLength(1); j++)
        {
            for (int k = 0; k < arrayCubic.GetLength(2); k++)
            {
                Console.Write($"{arrayCubic[i, j, k],5}[{i}, {j}, {k}]");
            }
            Console.WriteLine();
        }
        Console.WriteLine();
    }
}

// Gets unique number
int GetUniqueNumber()
{
    int number = rnd.Next(10, 100);
    foreach (int element in arrayCubic)
        number = element != number ? number : GetUniqueNumber();
    return number;
}