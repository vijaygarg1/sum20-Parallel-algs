package ut.ee382v.parallelalorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dinhvan5481 on 6/30/17.
 */
public class Student {
    public int id;
    public String firstName;
    public String lastName;
    public int classId;
    public String gender;
    public double gpa;

    public Student(int id, String firstName, String lastName, String gender, int classId, double gpa) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.classId = classId;
        this.gender = gender;
        this.gpa = gpa;
    }

    public void setClass(int classId) {
        this.classId = classId;
    }

    public int getClassId() {
        return classId;
    }

    @Override
    public String toString() {
        return "Student id: " + id + " name: " + firstName + " " + lastName;
    }
}
