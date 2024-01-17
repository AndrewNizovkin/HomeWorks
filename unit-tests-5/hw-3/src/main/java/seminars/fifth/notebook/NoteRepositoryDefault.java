package seminars.fifth.notebook;

import java.util.ArrayList;
import java.util.List;

public class NoteRepositoryDefault implements NoteRepository{
    private List<Contact> contacts = new ArrayList<>();

    /**
     * Добавляет новый контакт в базу данных
     *
     * @param contact новый контакт
     * @return резултат операции
     */
    @Override
    public boolean addContact(Contact contact) {
        if (contact != null) {
            contacts.add(contact);
            return true;
        }
        return false;
    }

    /**
     * Удаляет контакт с указанным id
     *
     * @param id
     * @return результат
     */
    @Override
    public boolean removeContact(int id) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId() == id) {
                contacts.remove(i);
                return true;
            }
        }

        return false;
    }

    /**
     * Обновляет запись о контакте в БД
     *
     * @param contact
     * @return
     */
    @Override
    public boolean updateContact(Contact contact) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId() == contact.getId()) {
                contacts.get(i).setName(contact.getName());
                contacts.get(i).setPhone(contact.getPhone());
                return true;
            }
        }
        boolean result = false;

        // код обновления записи в БД, соотверствующей переданному сонтакту

        return result;
    }

    /**
     * Возвращает контакт по id
     *
     * @param i
     * @return
     */
    @Override
    public Contact getById(int i) {
        for (Contact contact: contacts) {
            if (contact.getId() == i) return contact;
        }

        return null;
    }

    /**
     * Возвращает все записи из БД в виде списка контактов
     *
     * @return
     */
    @Override
    public List<Contact> getAll() {
        List<Contact> contacts = new ArrayList<>();

        // помещает все записи из БД в список

        return contacts;
    }
}
