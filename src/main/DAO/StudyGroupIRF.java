package main.DAO;

import main.models.StudyGroup;

import java.util.ArrayList;

/**
 * Created by admin on 19.04.2017.
 */
public interface StudyGroupIRF {
    public void UpdateStudyGroup();

    void UpdateStudyGroup(StudyGroup studyGroup);

    public void DeleteStudyGroup();
    public void InsertStudyGroup();

    void InsertStudyGroup(StudyGroup studyGroup);

    public ArrayList<StudyGroup> SelectStudyGroup();
}
