package main.DAO;

import main.models.ConnectionPool;
import main.models.Lessons;
import main.models.StudyGroup;


import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
/**
 * Created by admin on 19.04.2017.
 */
public class LessonsDAO implements LessonsIRF {

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
    public void UpdateLessons() {

    }

    @Override
    public void UpdateLessons(Lessons lessons) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update lesson set room = ? where id=?");
            preparedStatement.setInt(1, lessons.getRoom());
            preparedStatement.setInt(2, lessons.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    @Override
    public void DeleteLessons() {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from lesson");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    @Override
    public void InsertLessons() {

    }

    @Override
    public void InsertLessons(Lessons lesson) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO  lesson(study_group_id,lesson_date,room,description) VALUES (?,?,?,?)");
            preparedStatement.setInt(1, lesson.getStudyGroupId());
            preparedStatement.setDate(2, lesson.getLessonDate());
            preparedStatement.setInt(3, lesson.getRoom());
            preparedStatement.setString(4, lesson.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    @Override
    public ArrayList<Lessons> SelectLessons() {
        Connection connection = initConnection();
        ArrayList<Lessons> lessonsAL = new ArrayList<Lessons>();
        StudyGroup studyGroup = new StudyGroup();
        Lessons lessons = new Lessons();
        try {
            Statement statement = connection.createStatement();
            ResultSet result =
                    statement.executeQuery("select * from public.lesson inner join study_group"+
                            " on lesson.study_group_id = study_group.id");
            while (result.next()) {
                lessons.setId(result.getInt(1));
                lessons.setStudyGroupId(result.getInt(2));
                lessons.setLessonDate(result.getDate(3));
                lessons.setRoom(result.getInt(4));
                lessons.setDescription(result.getString(5));
                studyGroup.setId(result.getInt(6));
                studyGroup.setName(result.getString(7));
                lessons.setStudyGroup(studyGroup);
                lessonsAL.add(lessons);

            }
        } catch (SQLException e) {
            log.info(e.toString());
        }
        return lessonsAL;
    }
    }

