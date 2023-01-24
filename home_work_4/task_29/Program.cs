/*
Программа создаёт двумерный массив из 8 строк. 
Первый столбец заполняет случайными двухзаначными числами, 
случайным образом выбирая ячейку, в которую помещает число, 
если ячейка ещё не занята. Во второй столбец помещает количество 
попыток, которое потребуется для поиска свободной ячейки )
*/

int[,] array = new int [8, 2];

Random rnd = new System.Random();
int number; // Случайное двухзначное число
int index; // Случайный индекс
int count; // Количество попыток

for (int i = 0; i <= array.GetUpperBound(0); i++)
{
    number = rnd.Next(10, 99);
    index = rnd.Next(0, 8);
    count = 1;
    
    while (array[index, 0] != 0)
    {
        index = rnd.Next(0, 8);
        count++;
    }
    array[index, 0] = number;
    array[index, 1] = count;
}

for (int i = 0; i <= array.GetUpperBound(0); i++)
{
    Console.WriteLine(array[i, 0] + "\t" + array[i, 1]);
}