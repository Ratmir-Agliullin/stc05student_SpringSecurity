package main.DAO;


import main.models.Lessons;

import java.util.ArrayList;
/**
 * Created by admin on 19.04.2017.
 */
public interface LessonsIRF {

    public void UpdateLessons();

    void UpdateLessons(Lessons lessons);

    public void DeleteLessons();
    public void InsertLessons();

    void InsertLessons(Lessons lesson);

    public ArrayList<Lessons> SelectLessons();
}
