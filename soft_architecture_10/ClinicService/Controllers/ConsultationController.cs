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
    public class ConsultationController : ControllerBase
    {
        private IConsultationRepository _consultationRepository;

        public ConsultationController(IConsultationRepository consultationRepository) 
        {
            _consultationRepository = consultationRepository;

        }

        /// <summary>
        /// Создаёт запись в БД
        /// </summary>
        /// <param name="createRequest">экземпляр CreateConsultationRequest</param>
        /// <returns>1 в случае успешного добавления</returns>
        [HttpPost("create")]
        public IActionResult Create([FromBody] CreateConsultationRequest createRequest)
        {
            Consultation consultation = new Consultation();
            consultation.ClientId = createRequest.ClientId;
            consultation.PetId = createRequest.PetId;
            consultation.ConsultationDate = createRequest.ConsultationDate;
            consultation.Description = createRequest.Description;
            return Ok(_consultationRepository.Create(consultation));
        }

        /// <summary>
        /// Обновляет запись в БД 
        /// </summary>
        /// <param name="updateRequest">экземпляр UpdateConsultationRequest</param>
        /// <returns></returns>
        [HttpPut("edit")]
        public IActionResult Update(UpdateConsultationRequest updateRequest)
        {
            Consultation consultation = new Consultation();
            consultation.ConsultationId = updateRequest.ConsultationId;
            consultation.ClientId = updateRequest.ClientId;
            consultation.PetId = updateRequest.PetId;
            consultation.ConsultationDate = updateRequest.ConsultationDate;
            consultation.Description = updateRequest.Description;
            return Ok(_consultationRepository.Update(consultation));
        }

        /// <summary>
        /// Удаляет запись с указанным в запросе ID
        /// </summary>
        /// <param name="consultationId">id записи в БД</param>
        /// <returns>1 в случае успешной операции</returns>
        [HttpDelete("delete")]
        public IActionResult Delete([FromQuery] int consultationId)
        {
            int res = _consultationRepository.Delete(consultationId);
            return Ok(res);
        }

        /// <summary>
        /// Возвращает список всех записей БД о консультациях
        /// </summary>
        /// <returns>List<Consultation></returns>
        [HttpGet("get-all")]
        public IActionResult GetAll()
        {
            return Ok(_consultationRepository.GetAll());
        }

        /// <summary>
        /// Возвращает запись о консультации из БД с указанным в Get-запросе ID
        /// </summary>
        /// <param name="consultationId">id консультации</param>
        /// <returns>экземпляр Consultation</returns>
        [HttpGet("get/{consultationId}")]
        public IActionResult GetById([FromRoute] int consultationId)
        {
            return Ok(_consultationRepository.GetById(consultationId));
        }

    }
}
