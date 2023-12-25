using ClinicService.Models;
using Microsoft.Data.Sqlite;

namespace ClinicService.Services.Impl
{
    public class ConsultationRepository : IConsultationRepository
    {
        private const string connectionString = "Data Source = clinic.db;";

        /// <summary>
        /// Создаёт новую запись о консультации в базе данных 
        /// </summary>
        /// <param name="item">Экземпляр Consultation</param>
        /// <returns></returns>
        public int Create(Consultation item)
        {
            using SqliteConnection connection = new SqliteConnection();
            connection.ConnectionString = connectionString;
            connection.Open();
            using SqliteCommand command =
               new SqliteCommand("INSERT INTO Consultations(ClientId, PetId, ConsultationDate, Description) VALUES(@ClientId, @PetId, @ConsultationDate, @Description)", connection);
            command.Parameters.AddWithValue("@ClientId", item.ClientId);
            command.Parameters.AddWithValue("@PetId", item.PetId);
            command.Parameters.AddWithValue("@ConsultationDate", item.ConsultationDate.Ticks);
            command.Parameters.AddWithValue("@Description", item.Description);
            command.Prepare();
            return command.ExecuteNonQuery();

        }

        /// <summary>
        /// Удаляет запись о консультациииз базы данных
        /// </summary>
        /// <param name="id">id удаляемой записи</param>
        /// <returns>1 в случае успешной операции</returns>
        public int Delete(int id)
        {
            using SqliteConnection connection = new SqliteConnection();
            connection.ConnectionString = connectionString;
            connection.Open();
            using SqliteCommand command =
                new SqliteCommand("DELETE FROM Consultations WHERE ConsultationId=@ConsultationId", connection);
            command.Parameters.AddWithValue("@ConsultationId", id);
            command.Prepare();
            return command.ExecuteNonQuery();

        }

        /// <summary>
        /// Возвращает список всех консультаций из базы данных
        /// </summary>
        /// <returns>List<Consultation></returns>
        public IList<Consultation> GetAll()
        {

            List<Consultation> list = new List<Consultation>();
            using SqliteConnection connection = new SqliteConnection();
            connection.ConnectionString = connectionString;
            connection.Open();
            using SqliteCommand command =
                new SqliteCommand("SELECT * FROM Consultations", connection);
            command.Prepare();
            using SqliteDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                Consultation consultation = new Consultation();
                consultation.ConsultationId = reader.GetInt32(0);
                consultation.ClientId = reader.GetInt32(1);
                consultation.PetId = reader.GetInt32(2);
                consultation.ConsultationDate = new DateTime(reader.GetInt64(3));
                consultation.Description = reader.GetString(4);
                list.Add(consultation);
            }
            return list;

        }

        /// <summary>
        /// Возвращает запись о консультации из базы данных с указанным ID
        /// </summary>
        /// <param name="id">Id консультации</param>
        /// <returns>ссылку на экземпляр Consultation</returns>

        public Consultation GetById(int id)
        {
            using SqliteConnection connection = new SqliteConnection();
            connection.ConnectionString = connectionString;
            connection.Open();
            using SqliteCommand command =
                new SqliteCommand("SELECT * FROM Consultations WHERE ConsultationId=@ConsultationId", connection);
            command.Parameters.AddWithValue("@ConsultationId", id);
            command.Prepare();
            SqliteDataReader reader = command.ExecuteReader();
            if (reader.Read())
            {
                Consultation consultation = new Consultation();
                consultation.ConsultationId = reader.GetInt32(0);
                consultation.ClientId = reader.GetInt32(1);
                consultation.PetId = reader.GetInt32(2);
                consultation.ConsultationDate = new DateTime(reader.GetInt64(3));
                consultation.Description = reader.GetString(4);
                return consultation;
            }
            return null;

        }

        /// <summary>
        /// Обновляет запись о консультации в базе данных
        /// </summary>
        /// <param name="item">экземпляр Consultation</param>
        /// <returns>1 - в случае успешного обновления; -1 если что-то пошло не так</returns>
        public int Update(Consultation item)
        {
            using SqliteConnection connection = new SqliteConnection();
            connection.ConnectionString = connectionString;
            connection.Open();
            using SqliteCommand command =
                new SqliteCommand("UPDATE Consultations SET ClientId = @ClientId, PetId = @PetId, ConsultationDate = @ConsultationDate, Description = @Description WHERE ConsultationId=@ConsultationId", connection);
            command.Parameters.AddWithValue("@ConsultationId", item.ConsultationId);
            command.Parameters.AddWithValue("@ClientId", item.ClientId);
            command.Parameters.AddWithValue("@PetId", item.PetId);
            command.Parameters.AddWithValue("@ConsultationDate", item.ConsultationDate.Ticks);
            command.Parameters.AddWithValue("@Description", item.Description);
            command.Prepare();
            return command.ExecuteNonQuery();

        }
    }
}
