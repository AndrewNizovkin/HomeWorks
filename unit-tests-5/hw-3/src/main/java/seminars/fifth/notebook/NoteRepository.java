package seminars.fifth.notebook;

import java.util.List;

public interface NoteRepository {

    /**
     * Добавляет новый контакт в базу данных
     * @param contact новый контакт
     * @return резултат операции
     */
    boolean addContact(Contact contact);

    /**
     * Удаляет контакт с указанным id
     * @param id
     * @return результат
     */
    boolean removeContact(int id);

    /**
     * Обновляет запись о контакте в БД
     * @param contact
     * @return
     */
    boolean updateContact(Contact contact);

    /**
     * Возвращает контакт по id
     * @param i
     * @return
     */
    Contact getById(int i);

    /**
     * Возвращает все записи из БД в виде списка контактов
     * @return
     */
    List<Contact> getAll();

}
