package main.DAO;

import main.DAO.StudyGroupIRF;
import main.models.ConnectionPool;
import main.models.StudyGroup;


import java.sql.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Logger;


/**
 * Created by admin on 19.04.2017.
 */
public class StudyGroupDAO implements StudyGroupIRF{
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
    public void UpdateStudyGroup() {

    }

    @Override
    public void UpdateStudyGroup(StudyGroup studyGroup) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update study_group set name = ? where id=?");
            preparedStatement.setString(1, studyGroup.getName());
            preparedStatement.setInt(2, studyGroup.getId());



            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    @Override
    public void DeleteStudyGroup() {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from study_group");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    @Override
    public void InsertStudyGroup() {

    }

    @Override
    public void InsertStudyGroup(StudyGroup studyGroup) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO  study_group(name) VALUES (?)");
            preparedStatement.setString(1, studyGroup.getName());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    @Override
    public ArrayList<StudyGroup> SelectStudyGroup() {
        Connection connection = initConnection();
        ArrayList<StudyGroup> studyGroupAL = new ArrayList<StudyGroup>();
        StudyGroup studyGroup = new StudyGroup();
        try {
            Statement statement = connection.createStatement();
            ResultSet result =
                    statement.executeQuery("select * from public.study_group");
            while (result.next()) {
                studyGroup.setId(result.getInt(1));
                studyGroup.setName(result.getString(2));
                studyGroupAL.add(studyGroup);

            }
        } catch (SQLException e) {
            log.info(e.toString());
        }
        return studyGroupAL;
    }


}

