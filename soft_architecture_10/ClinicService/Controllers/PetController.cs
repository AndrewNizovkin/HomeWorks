using ClinicService.Models.Requests;
using ClinicService.Models;
using ClinicService.Services;
using ClinicService.Services.Impl;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace ClinicService.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PetController : ControllerBase
    {
        private IPetRepository _petRepository;

        public PetController(IPetRepository petRepository)
        {
            _petRepository = petRepository;
        }

        /// <summary>
        /// Создаёт запись в БД
        /// </summary>
        /// <param name="createRequest">экземпляр CreatePetRequest</param>
        /// <returns>1 в случае успешного добавления</returns>
        [HttpPost("create")]
        public IActionResult Create([FromBody] CreatePetRequest createRequest)
        {
            Pet pet = new Pet();
            pet.ClientId = createRequest.ClientId;
            pet.Name = createRequest.Name;
            pet.Birthday = createRequest.Birthday;
            return Ok(_petRepository.Create(pet));
        }

        /// <summary>
        /// Обновляет запись в БД 
        /// </summary>
        /// <param name="updateRequest">экземпляр CreatePetRequest</param>
        /// <returns></returns>
        [HttpPut("edit")]
        public IActionResult Update(UpdatePetRequest updateRequest)
        {
            Pet pet = new Pet();
            pet.PetId = updateRequest.PetId;
            pet.ClientId = updateRequest.ClientId;
            pet.Name = updateRequest.Name;
            pet.Birthday = updateRequest.Birthday;
            return Ok(_petRepository.Update(pet));
        }

        /// <summary>
        /// Удаляет запись с указанным в запросе ID
        /// </summary>
        /// <param name="petId">id записи в БД</param>
        /// <returns>1 в случае успешной операции</returns>
        [HttpDelete("delete")]
        public IActionResult Delete([FromQuery] int petId)
        {
            int res = _petRepository.Delete(petId);
            return Ok(res);
        }

        /// <summary>
        /// Возвращает список всех записей БД о питомцах
        /// </summary>
        /// <returns>List<Pet></returns>
        [HttpGet("get-all")]
        public IActionResult GetAll()
        {
            return Ok(_petRepository.GetAll());
        }

        /// <summary>
        /// Возвращает запись о питомце из БД с указанным в Get-запросе ID
        /// </summary>
        /// <param name="petId">id питомца</param>
        /// <returns>экземпляр Pet</returns>
        [HttpGet("get/{petId}")]
        public IActionResult GetById([FromRoute] int petId)
        {
            return Ok(_petRepository.GetById(petId));
        }

    }
}
