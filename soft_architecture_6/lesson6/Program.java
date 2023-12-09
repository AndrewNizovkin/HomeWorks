package ru.geekbrains.lesson6;

import ru.geekbrains.lesson6.database.NotesDatabase;
import ru.geekbrains.lesson6.notes.application.ConcreteNoteEditor;
import ru.geekbrains.lesson6.notes.domain.Note;
import ru.geekbrains.lesson6.notes.infrastructure.persistance.DatabaseContext;
import ru.geekbrains.lesson6.notes.presentation.queries.controllers.NotesController;
import ru.geekbrains.lesson6.notes.presentation.queries.views.NotesConsolePresenter;

import java.util.Date;

public class Program {

    public static void main(String[] args) {
        NotesController notesController = new NotesController(new ConcreteNoteEditor(new NotesConsolePresenter(), new DatabaseContext(new NotesDatabase())));
        notesController.routeGetAll();
        Note note1 = new Note(101, 201, "My first note", "Test text", new Date());
        Note note2 = new Note(101, 201, "My first note", "Test text", new Date());

        notesController.routeAddNote(note1);
        notesController.routeAddNote(note2);

        notesController.routeGetAll();
    }

}
