package main.DAO;

import main.models.ConnectionPool;
import main.models.Student;
import main.models.StudyGroup;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
/**
 * Created by admin on 19.04.2017.
 */
@Repository //
public class StudentDAO implements StudentIRF{


    private static Logger log = Logger.getLogger(StudyGroupDAO.class.getName());
    public Connection initConnection(){
        Connection connection = null;
        try {
            ConnectionPool cp = new ConnectionPool("jdbc:postgresql://localhost/Students","postgres", "Kbctyrjgbljh48");
            try {
                connection =  cp.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

    @Override
    public void UpdateStudent() {

    }

    @Override
    public void UpdateStudent(Student student) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update study_group set name = ? where id=?");
            preparedStatement.setInt(1, student.getGroupId());
            preparedStatement.setInt(2, student.getId());



            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    @Override
    public void DeleteStudent() {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from student");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    @Override
    public void InsertStudent() {

    }

    @Override
    public void InsertStudent(Student student) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO  student(name,age,group_id) VALUES (?,?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setInt(3, student.getGroupId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    @Override
    public ArrayList<Student> SelectStudent() {
        Connection connection = initConnection();
        ArrayList<Student> studentAL = new ArrayList<Student>();
        StudyGroup studyGroup = new StudyGroup();
        Student student = new Student();
        try {
            Statement statement = connection.createStatement();
            ResultSet result =
                    statement.executeQuery("select * from public.student inner join study_group"+
                            " on student.group_id = study_group.id");
            while (result.next()) {
                student.setId(result.getInt(1));
                student.setName(result.getString(2));
                student.setAge(result.getInt(3));
                student.setGroupId(result.getInt(4));
                studyGroup.setId(result.getInt(5));
                studyGroup.setName(result.getString(6));
                student.setStudyGroup(studyGroup);
                studentAL.add(student);

            }
        } catch (SQLException e) {
            log.info(e.toString());
        }
        return studentAL;
    }

}
