package student.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import student.entity.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bryancheng on 2017/4/12.
 */
@Repository
@Qualifier("FakeData")
public class FakeStudentDao implements StudentDao {
    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "Said", "Computer Science"));
                put(2, new Student(2, "Alex U", "Finance"));
                put(3, new Student(3, "Anna", "Maths"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents(){
        return students.values();
    }

    @Override
    public Student getStudentById(int id) { return students.get(id); }

    @Override
    public void deleteStudentById(int id) {
        students.remove(id);
    }

    @Override
    public void undateStudent(Student student) {


    }

    @Override
    public void insertStudentToDB(Student student) {
        students.put(student.getId(), student);
    }
}
