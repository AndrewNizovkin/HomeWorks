using ClinicService.Models;
using Microsoft.Data.Sqlite;

namespace ClinicService.Services.Impl
{
    public class PetRepository : IPetRepository
    {
        private const string connectionString = "Data Source = clinic.db;";

        /// <summary>
        /// Создаёт новую запись о питомце в базе данных 
        /// </summary>
        /// <param name="item">экземляр Pet</param>
        /// <returns></returns>
        public int Create(Pet item)
        {
            using SqliteConnection connection = new SqliteConnection();
            connection.ConnectionString = connectionString;
            connection.Open();


            using SqliteCommand command =
               new SqliteCommand("INSERT INTO Pets(ClientId, Name, Birthday) VALUES(@ClientId, @Name, @Birthday)", connection);
            command.Parameters.AddWithValue("@ClientId", item.ClientId);
            command.Parameters.AddWithValue("@Name", item.Name);
            command.Parameters.AddWithValue("@Birthday", item.Birthday.Ticks);
            command.Prepare();
            return command.ExecuteNonQuery();

        }

        /// <summary>
        /// Удаляет запись из базы данных
        /// </summary>
        /// <param name="id">id удаляемой записи</param>
        /// <returns></returns>
        public int Delete(int id)
        {
            using SqliteConnection connection = new SqliteConnection();
            connection.ConnectionString = connectionString;
            connection.Open();
            using SqliteCommand command =
                new SqliteCommand("DELETE FROM Pets WHERE PetId=@PetId", connection);
            command.Parameters.AddWithValue("@PetId", id);
            command.Prepare();
            return command.ExecuteNonQuery();

        }

        /// <summary>
        /// Возвращает список из всех записей базы данных
        /// </summary>
        /// <returns>List<Pet></returns>
        public IList<Pet> GetAll()
        {

            List<Pet> list = new List<Pet>();
            using SqliteConnection connection = new SqliteConnection();
            connection.ConnectionString = connectionString;
            connection.Open();
            using SqliteCommand command =
                new SqliteCommand("SELECT * FROM Pets", connection);
            command.Prepare();
            using SqliteDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                Pet pet = new Pet();
                pet.PetId = reader.GetInt32(0);
                pet.ClientId = reader.GetInt32(1);
                pet.Name = reader.GetString(2);
                pet.Birthday = new DateTime(reader.GetInt64(3));
                list.Add(pet);
            }
            return list;

        }

        /// <summary>
        /// Возвращает запись о питомце из базы данных с указанным ID
        /// </summary>
        /// <param name="id">Id питомца</param>
        /// <returns>ссылку на экземпляр Pet</returns>
        public Pet GetById(int id)
        {
            using SqliteConnection connection = new SqliteConnection();
            connection.ConnectionString = connectionString;
            connection.Open();
            using SqliteCommand command =
                new SqliteCommand("SELECT * FROM Pets WHERE PetId=@PetId", connection);
            command.Parameters.AddWithValue("@PetId", id);
            command.Prepare();
            SqliteDataReader reader = command.ExecuteReader();
            if (reader.Read())
            {
                Pet pet = new Pet();
                pet.PetId= reader.GetInt32(0);
                pet.ClientId = reader.GetInt32(1);
                pet.Name= reader.GetString(2);
                pet.Birthday= new DateTime(reader.GetInt64(3));
                return pet;
            }
            return null;


        }

        /// <summary>
        /// Обновляет запись о питомце в базе данных
        /// </summary>
        /// <param name="item">экземпляр Pet</param>
        /// <returns>1 - в случае успешного обновления; -1 если что-то пошло не так</returns>
        public int Update(Pet item)
        {
            using SqliteConnection connection = new SqliteConnection();
            connection.ConnectionString = connectionString;
            connection.Open();
            using SqliteCommand command =
                new SqliteCommand("UPDATE Pets SET ClientId = @ClientId, Name = @Name, Birthday = @Birthday WHERE PetId=@PetId", connection);
            command.Parameters.AddWithValue("@PetId", item.PetId);
            command.Parameters.AddWithValue("@ClientId", item.ClientId);
            command.Parameters.AddWithValue("@Name", item.Name);
            command.Parameters.AddWithValue("@Birthday", item.Birthday.Ticks);
            command.Prepare();
            return command.ExecuteNonQuery();

        }
    }
}
