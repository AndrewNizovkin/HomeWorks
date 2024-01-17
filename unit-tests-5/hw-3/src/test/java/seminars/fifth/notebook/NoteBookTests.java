package seminars.fifth.notebook;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;

public class NoteBookTests {

    /**
     * Модульный. Проверяет добавление контакта репозиторием
     */
    @Test
    public void  NoteRepositoryDefaultAddsContact() {
        NoteRepository repository = new NoteRepositoryDefault();
        Contact contact = new Contact(1, "Ivan", "111-111-111");

        boolean result = repository.addContact(contact);

        assertTrue(result);

    }

    /**
     * Модульный. Проверяет редактирование репозиторием
     * записи, если контакт существует в БД
     */
    @Test
    public void NoteRepositoryDefaultEditCorrectContact() {
        NoteRepository repository = new NoteRepositoryDefault();
        Contact contact = new Contact(1, "Ivan", "111-111-111");
        repository.addContact(contact);
        Contact contact1 = new Contact(1, "Ivan", "222-222-222");

        boolean result = repository.updateContact(contact1);

        assertTrue(result);
    }

    /**
     * Модульный. Проверяет редактирование репозиторием
     * записи, если контакт НЕ существует в БД
     */
    @Test
    public void noteRepositoryDefaultEditUnCorrectContact() {
        NoteRepository repository = new NoteRepositoryDefault();
        Contact contact = new Contact(1, "Ivan", "111-111-111");
        repository.addContact(contact);
        Contact contact1 = new Contact(2, "Ivan", "222-222-222");

        boolean result = repository.updateContact(contact1);

        assertFalse(result);
    }

    /**
     * Модульный. Проверяет удаление репозиторием
     * записи, если контакт с переданным id существует
     */
    @Test
    public void noteRepositoryDefaultRemoveCorrectID() {
        NoteRepository repository = new NoteRepositoryDefault();
        Contact contact = new Contact(1, "Ivan", "111-111-111");
        repository.addContact(contact);

        boolean result = repository.removeContact(1);

        assertTrue(result);
    }

    /**
     * Модульный. Проверяет удаление репозиторием
     * записи, если контакт с переданным id НУ существует
     */
    @Test
    public void noteRepositoryDefaultRemoveUnCorrectID() {
        NoteRepository repository = new NoteRepositoryDefault();
        Contact contact = new Contact(1, "Ivan", "111-111-111");
        repository.addContact(contact);

        boolean result = repository.removeContact(2);

        assertFalse(result);
    }

    /**
     * Модульный. Проверяет возвращение репозиторием
     * записи, с указанным ID, если он существует
     */
    @Test
    public void noteRepositoryDefaultGetByCorrectID() {
        NoteRepository repository = new NoteRepositoryDefault();
        Contact contact = new Contact(1, "Ivan", "111-111-111");
        repository.addContact(contact);

        Contact result = repository.getById(1);

        assertEquals(contact, result);
    }

    /**
     * Модульный. Проверяет возвращение репозиторием
     * записи, с указанным некорректным ID
     */
    @Test
    public void noteRepositoryDefaultGetByUnCorrectID() {
        NoteRepository repository = new NoteRepositoryDefault();
        Contact contact = new Contact(1, "Ivan", "111-111-111");
        repository.addContact(contact);

        Contact result = repository.getById(2);

        assertNull(result);
    }

    /**
     * Модульный. Проверяет метод getALL репозитория
     */
    @Test
    public void noteRepositoryDefaultGetAllTest() {
        NoteRepository repository = new NoteRepositoryDefault();

        List<Contact> list = repository.getAll();

        assertNotNull(list);
    }


    /**
     * Интеграционный. Проверяет возвращение сервисом контакта по ID
     */
    @Test
    public void noteBookGetById() {
        Contact contact = new Contact(1, "Ivan", "111-111-111");
        UI ui = mock(UI.class);
        NoteView view = mock(NoteView.class);
        NoteRepository repository = mock(NoteRepository.class);
        when(repository.getById(5)).thenReturn(contact);
        NoteBook book = new NoteBook(repository, view, ui);

        Contact result = book.getById(5);

        assertEquals(contact, result);
    }

    /**
     * Интеграционный. Проверяет возвращение сервисом всех контактов
     */
    @Test
    public void noteBookGetAll() {
        UI ui = mock(UI.class);
        NoteView view = mock(NoteView.class);
        NoteRepository repository = mock(NoteRepository.class);
        NoteBook book = new NoteBook(repository, view, ui);

        book.getAll();

        verify(repository, times(1)).getAll();

    }


    /**
     * Сквозной. Проверяет добавление, редактирование и возвращение по ID сервисом контакта
     */
    @Test
    public void noteBookEditContactFromUI() {
        UI ui = mock(UI.class);
        when(ui.getID()).thenReturn(1);
        when(ui.getName()).thenReturn("Ivan");
        when(ui.getPhone()).thenReturn("111-111-111");
        NoteView view = mock(NoteView.class);
        NoteRepository repository = new NoteRepositoryDefault();
        NoteBook book = new NoteBook(repository, view, ui);

        Contact contact = new Contact(1, "Ivan", "222-222-222");
        book.addContact(contact);
        book.editCurrentContact();
        Contact result = book.getById(1);

        assertEquals("111-111-111", result.getPhone());

    }

}
