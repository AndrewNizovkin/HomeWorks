/*
Программа создаёт двумерный массив из 8 строк. 
Первый столбец заполняет случайными двухзаначными числами, 
случайным образом выбирая ячейку, в которую помещает число, 
если ячейка ещё не занята. Во второй столбец помещает количество 
попыток, которое потребуется для поиска свободной ячейки )
*/

int[,] array = new int[8, 3];

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
    array[index, 2] = i;
}

string str = new String('-', 36);
Console.WriteLine(str);
Console.WriteLine(" Содержимое | Количество |  Номер ");
Console.WriteLine("   ячейки   |   попыток  | прохода ");
Console.WriteLine(str);
for (int i = 0; i <= array.GetUpperBound(0); i++)
{
    //Console.WriteLine(array[i, 0] + "\t" + array[i, 1] + "\t" + array[i, 2]);
    Console.WriteLine($"     {array[i, 0],-7:D2}|     {array[i, 1],-7:D1}|     {array[i, 2],-5:D1}");
}
Console.WriteLine(str);