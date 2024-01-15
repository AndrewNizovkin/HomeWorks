using ClinicService.Data;

namespace ClinicConsole
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Нажмите клавишу");
            Console.ReadKey();

            ClinicServiceClient clinicClient = new ClinicServiceClient("http://localhost:5036/", new HttpClient());

            List<Client> clients = clinicClient.ClientGetAllAsync().Result.ToList();
            Console.WriteLine("Список клиентов:");
            foreach (Client client in clients)
            {
                Console.WriteLine("id: " + client.ClientId);
                Console.WriteLine("Фамилия: " + client.SurName);
                Console.WriteLine("Имя: " + client.FirstName);
                Console.WriteLine("Отчество: " + client.Patronymic);
                Console.WriteLine("Дата рождения: " + client.Birthday.DateTime);
                Console.WriteLine("Документ: " + client.Document);
                Console.WriteLine();
            }

            // Добавляем нового клиента

            CreateClientRequest newClient = new CreateClientRequest();
            newClient.SurName = "Низовкин";
            newClient.FirstName = "Андрей";
            newClient.Patronymic = "Викторович";
            newClient.Birthday = DateTime.Now;
            newClient.Document = "111 111111";

            clinicClient.ClientCreateAsync(newClient);

            clients.Clear();
            clients = clinicClient.ClientGetAllAsync().Result.ToList();

            foreach (Client client in clients)
            {
                Console.WriteLine("id: " + client.ClientId);
                Console.WriteLine("Фамилия: " + client.SurName);
                Console.WriteLine("Имя: " + client.FirstName);
                Console.WriteLine("Отчество: " + client.Patronymic);
                Console.WriteLine("Дата рождения: " + client.Birthday.DateTime);
                Console.WriteLine("Документ: " + client.Document);
                Console.WriteLine();
            }

            // Удаляем клиента с id=1")

            clinicClient.ClientDeleteAsync(1);

            clients.Clear();
            clients = clinicClient.ClientGetAllAsync().Result.ToList();

            foreach (Client client in clients)
            {
                Console.WriteLine("id: " + client.ClientId);
                Console.WriteLine("Фамилия: " + client.SurName);
                Console.WriteLine("Имя: " + client.FirstName);
                Console.WriteLine("Отчество: " + client.Patronymic);
                Console.WriteLine("Дата рождения: " + client.Birthday.DateTime);
                Console.WriteLine("Документ: " + client.Document);
                Console.WriteLine();
            }


            // Редактируем информацию о клиенте с id=4

            UpdateClientRequest updateClient = new UpdateClientRequest();
            updateClient.ClientId = 2;
            updateClient.SurName = "Пупкин";
            updateClient.FirstName = "Иван";
            updateClient.Patronymic = "Иванович";
            updateClient.Birthday = DateTime.Now;
            updateClient.Document = "222 222222";


            clinicClient.ClientUpdateAsync(updateClient);

            clients = clinicClient.ClientGetAllAsync().Result.ToList();
            Console.WriteLine("Список клиентов:");
            foreach (Client client in clients)
            {
                Console.WriteLine("id: " + client.ClientId);
                Console.WriteLine("Фамилия: " + client.SurName);
                Console.WriteLine("Имя: " + client.FirstName);
                Console.WriteLine("Отчество: " + client.Patronymic);
                Console.WriteLine("Дата рождения: " + client.Birthday.DateTime);
                Console.WriteLine("Документ: " + client.Document);
                Console.WriteLine();
            }




            Console.WriteLine("Нажмите на любую клавишу для завершения работы приложения ...");
            Console.ReadKey();
        }
    }
}
