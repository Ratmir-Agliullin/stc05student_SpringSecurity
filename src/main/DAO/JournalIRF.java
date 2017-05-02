package main.DAO;

import main.models.Journal;

import java.util.ArrayList;

/**
 * Created by admin on 19.04.2017.
 */
public interface JournalIRF {

    public void UpdateJournal();

    void UpdateJournal(Journal journal);

    public void DeleteJournal();
    public void InsertJournal();

    void InsertJournal(Journal journal);

    public ArrayList<Journal> SelectJournal();
}
