package seminars.fifth.notebook;

import java.util.LinkedList;
import java.util.List;

public class NoteBook {

private NoteRepository repository;
private NoteView view;
private UI ui;

    public NoteBook(NoteRepository repository, NoteView view, UI ui) {
        this.repository = repository;
        this.view = view;
        this.ui = ui;
    }

    /**
     * Возвращает все контакты в виде списка
     * @return
     */
    public List<Contact> getAll() {
        return repository.getAll();
    }

    /**
     * Добавляет контакт в БД
     * @param contact
     */
    public void addContact(Contact contact) {
        repository.addContact(contact);
    }
    /**
     * Обновляет запись о контакте, изменённом в ui
     */
    public void editCurrentContact() {
        Contact contact = new Contact(ui.getID(), ui.getName(), ui.getPhone());
        repository.updateContact(contact);
    }

    /**
     * Отображает все контакты
     */
    public void showAllContacts() {
        view.showAll(repository.getAll());
    }

    /**
     * Удаляет выделенную в ui запись
     */
    public void removeCurrentContact() {
        repository.removeContact(ui.getID());
    }

    /**
     * Возвращает контакат по ID
     * @param i
     * @return
     */
    public Contact getById(int i) {
        return repository.getById(i);
    }

}
