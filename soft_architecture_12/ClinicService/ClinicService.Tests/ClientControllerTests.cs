using ClinicService.Controllers;
using ClinicService.Models;
using ClinicService.Models.Requests;
using ClinicService.Services;
using Microsoft.AspNetCore.Mvc;
using Moq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClinicService.Tests
{
    public class ClientControllerTests
    {
        private ClientController _clientController;
        private Mock<IClientRepository> _mockClientRepository;

        public ClientControllerTests()
        {
            _mockClientRepository = new Mock<IClientRepository>();
            _clientController = new ClientController(_mockClientRepository.Object); 
        }

        [Fact]
        public void GetAllClientsTest()
        {
            List<Client> clients = new List<Client>();
            clients.Add(new Client ());
            clients.Add(new Client());
            clients.Add(new Client());

            _mockClientRepository
                .Setup(repository => repository.GetAll())
                .Returns(clients);

            var operationReault = _clientController.GetAll();

            Assert.IsType<OkObjectResult>(operationReault.Result);

            var result = (OkObjectResult)operationReault.Result;
            Assert.IsAssignableFrom<List<Client>>(result.Value);

            _mockClientRepository.Verify(repository => repository.GetAll(), Times.AtLeastOnce);     
        }

        public static object[][] CorrectCreateClientData =
        {
            new object[] { new DateTime(1986, 1, 22), "AA1 B11222", "Иванов1", "Станислав1", "Андреевич1" },
            new object[] { new DateTime(1986, 1, 22), "AA1 B11222", "Иванов2", "Станислав2", "Андреевич2" },
            //new object[] { new DateTime(2013, 1, 22), "AA1 B11222", "Иванов3", "Станислав3", "Андреевич3" },
            new object[] { new DateTime(2018, 1, 22), "AA1 B11222", "Иванов4", "Станислав4", "Андреевич4" },
            new object[] { new DateTime(1986, 1, 22), "AA1 B11222", "Иванов5", "Станислав5", "Андреевич5" },
            //new object[] { new DateTime(1986, 1, 22), "AA1 B11222", "Иванов", "", "Андреевич" },
            new object[] { new DateTime(1986, 1, 22), "AA1 B11222", "Иванов6", "Станислав6", "Андреевич6" },
            new object[] { new DateTime(1986, 1, 22), "AA1 B11222", "Иванов7", "Станислав7", "Андреевич7" },
            new object[] { new DateTime(1986, 1, 22), "AA1 B11222", "Иванов8", "Станислав8", "Андреевич8" },

        };

        [Theory]
        [MemberData(nameof(CorrectCreateClientData))]
        public void CreateClientTest(
            DateTime birthday, string document, string surName, string firstName, string patronymic)
        {
            // [1] Подготовка данных для тестирования

            CreateClientRequest createClientRequest = new CreateClientRequest();
            createClientRequest.Birthday = birthday;
            createClientRequest.Document = document;
            createClientRequest.SurName = surName;
            createClientRequest.FirstName = firstName;
            createClientRequest.Patronymic = patronymic;

            int res = 1;

            _mockClientRepository
                .Setup(repository => repository.Create(It.IsNotNull<Client>()))
                .Returns(res);


            // [2] Исполнение тестируемого метода
            var operationResult = _clientController.Create(createClientRequest);

            // [3] Подготовка эталонного результата и проверка результата
            Assert.IsType<OkObjectResult>(operationResult.Result);

            var result = (OkObjectResult)operationResult.Result;
            Assert.IsAssignableFrom<int>(result.Value);

            _mockClientRepository.Verify(repository =>
            repository.Create(It.IsNotNull<Client>()), Times.AtLeastOnce());
        }

        public static object[][] CorrectUpdateClientData =
        {
            new object[] { 1, new DateTime(1986, 1, 22), "AA1 B11222", "Иванов1", "Станислав1", "Андреевич1" },
            new object[] { 2, new DateTime(1986, 1, 22), "AA1 B11222", "Иванов2", "Станислав2", "Андреевич2" },
            new object[] { 3, new DateTime(2018, 1, 22), "AA1 B11222", "Иванов4", "Станислав4", "Андреевич4" },
            new object[] { 4, new DateTime(1986, 1, 22), "AA1 B11222", "Иванов5", "Станислав5", "Андреевич5" },
            new object[] { 5, new DateTime(1986, 1, 22), "AA1 B11222", "Иванов6", "Станислав6", "Андреевич6" },
            new object[] { 6, new DateTime(1986, 1, 22), "AA1 B11222", "Иванов7", "Станислав7", "Андреевич7" },
            new object[] { 7, new DateTime(1986, 1, 22), "AA1 B11222", "Иванов8", "Станислав8", "Андреевич8" },

        };



        [Theory]
        [MemberData(nameof(CorrectUpdateClientData))]
        public void EditClientTest(
            int clientId, DateTime birthday, string document, string surName, string firstName, string patronymic)
        {
            // [1] Подготовка данных для тестирования

            UpdateClientRequest updateClientRequest = new UpdateClientRequest();
            updateClientRequest.ClientId = clientId;
            updateClientRequest.Birthday = birthday;
            updateClientRequest.Document = document;
            updateClientRequest.SurName = surName;
            updateClientRequest.FirstName = firstName;
            updateClientRequest.Patronymic = patronymic;

            int res = 1;

            _mockClientRepository
                .Setup(repository => repository.Update(It.IsNotNull<Client>()))
                .Returns(res);


            // [2] Исполнение тестируемого метода
            var operationResult = _clientController.Update(updateClientRequest);

            // [3] Подготовка эталонного результата и проверка результата
            Assert.IsType<OkObjectResult>(operationResult.Result);

            var result = (OkObjectResult)operationResult.Result;
            Assert.IsAssignableFrom<int>(result.Value);

            _mockClientRepository.Verify(repository =>
            repository.Create(It.IsNotNull<Client>()), Times.AtLeastOnce());
        }


        [Fact]
        public void DeleteClientTest()
        {
            int answer = 1;

            _mockClientRepository
                .Setup(repository => repository.Delete(1)).Returns(answer);

            var operationResult = _clientController.Delete(2);
            Assert.IsType<OkObjectResult>(operationResult.Result);

            var result = (OkObjectResult)operationResult.Result;
            Assert.IsAssignableFrom<int>(result.Value);

            _mockClientRepository.Verify(repository =>
            repository.Delete(2), Times.AtLeastOnce());
        }

    }

}
