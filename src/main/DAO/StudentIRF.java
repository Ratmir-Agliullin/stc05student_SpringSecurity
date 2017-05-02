package main.DAO;

import main.models.Student;

import java.util.ArrayList;

/**
 * Created by admin on 19.04.2017.
 */
public interface StudentIRF {
    public void UpdateStudent();

    void UpdateStudent(Student student);

    public void DeleteStudent();
    public void InsertStudent();

    void InsertStudent(Student student);

    public ArrayList<Student> SelectStudent();
}
