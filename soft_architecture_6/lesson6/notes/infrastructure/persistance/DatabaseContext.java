package ru.geekbrains.lesson6.notes.infrastructure.persistance;

import ru.geekbrains.lesson6.database.NotesDatabase;
import ru.geekbrains.lesson6.database.NotesRecord;
import ru.geekbrains.lesson6.notes.application.interfaces.NotesDatabaseContext;
import ru.geekbrains.lesson6.notes.domain.Note;
import ru.geekbrains.lesson6.notes.infrastructure.persistance.configuration.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class DatabaseContext extends DbContext implements NotesDatabaseContext {


    public DatabaseContext(Database database) {
        super(database);
    }

    public Collection<Note> getAll() {
        Collection<Note> notesList = new ArrayList<>();
        //TODO: Этого кастинга быть не должно, тут должен работать внутренний механизм фреймворка
        for (NotesRecord record : ((NotesDatabase)database).getNotesTable().getRecords()){
            notesList.add(new Note(
                    record.getId(),
                    record.getUserId(),
                    record.getTitle(),
                    record.getDetails(),
                    record.getCreationDate()
            ));
        }
        return notesList;
    }

    public boolean saveChanges(){
        //TODO: Сохранение изменений в базе данных

        return true;
    }

    /**
     * Добавляет запись в бд
     * @param note запись
     */
    public boolean addRecord(Note note) {
        Collection<NotesRecord> notesRecords = ((NotesDatabase)database).getNotesTable().getRecords();
        NotesRecord notesRecord = new NotesRecord(note.getTitle(), note.getDetails());
        notesRecord.setCreationDate(note.getCreationDate());
        notesRecord.setId(note.getId());
        notesRecord.setUserId(note.getUserId());
        notesRecords.add(notesRecord);
        return true;
    }


    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }
}
