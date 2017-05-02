package main.DAO;

import main.models.ConnectionPool;
import main.models.Journal;
import main.models.Lessons;
import main.models.Student;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by admin on 19.04.2017.
 */
public class JournalDAO implements JournalIRF {
    private static Logger log = Logger.getLogger(JournalDAO.class.getName());

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
    public void UpdateJournal() {

    }

    @Override
    public void UpdateJournal(Journal journal) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update journal set lesson_id = ? where student_id=?");
            preparedStatement.setInt(1, journal.getLessonId());
            preparedStatement.setInt(2, journal.getStudentID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    @Override
    public void DeleteJournal() {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from journal");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    @Override
    public void InsertJournal() {

    }

    @Override
    public void InsertJournal(Journal journal) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO  journal(lesson_id,student_id) VALUES (?,?)");
            preparedStatement.setInt(1, journal.getLessonId());
            preparedStatement.setInt(2, journal.getStudentID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    @Override
    public ArrayList<Journal> SelectJournal() {
        Connection connection = initConnection();
        ArrayList<Journal> journalAL = new ArrayList<Journal>();
        Journal journal = new Journal();
        Student student = new Student();
        Lessons lessons = new Lessons();
        try {
            Statement statement = connection.createStatement();
            ResultSet result =
                    statement.executeQuery("select * from public.journal inner join lesson on"+
                            " journal.lesson_id = lesson.id " +
                            "inner join student on journal.student_id = student.id");
            while (result.next()) {
                journal.setId(result.getInt(1));

                journal.setLessonId(result.getInt(2));
                lessons.setId(result.getInt(4));
                lessons.setStudyGroupId(result.getInt(5));
                lessons.setLessonDate(result.getDate(6));
                lessons.setRoom(result.getInt(7));
                lessons.setDescription(result.getString(8));


                journal.setStudentID(result.getInt(3));
                student.setId(result.getInt(9));
                student.setName(result.getString(10));
                student.setAge(result.getInt(11));
                student.setGroupId(result.getInt(12));


                journal.setLesson(lessons);
                journal.setStudent(student);
                journalAL.add(journal);

            }
        } catch (SQLException e) {
            log.info(e.toString());
        }
        return journalAL;

    }
}
