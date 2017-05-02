package main.models;

import java.util.Date;
/**
 * Created by admin on 19.04.2017.
 */
public class Lessons {
    private int id;
    private StudyGroup studyGroup;
    private int studyGroupId;

    public int getStudyGroupId() {
        return studyGroupId;
    }

    public void setStudyGroupId(int studyGroupId) {
        this.studyGroupId = studyGroupId;
    }

    public java.sql.Date getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(java.sql.Date lessonDate) {
        this.lessonDate = lessonDate;
    }

    private java.sql.Date lessonDate;
    private int room;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudyGroup getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }



    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
