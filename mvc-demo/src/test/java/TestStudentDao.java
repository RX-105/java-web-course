import com.mvcdemo.mvcdemo.dao.StudentDao;
import com.mvcdemo.mvcdemo.daoImpl.StudentDaoImpl;
import com.mvcdemo.mvcdemo.entity.Page;
import com.mvcdemo.mvcdemo.entity.Student;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class TestStudentDao {

    private final StudentDao studentDao;

    public TestStudentDao() throws SQLException, ClassNotFoundException {
        studentDao = new StudentDaoImpl();
    }

    @Test
    void testGetAll() throws SQLException {
        System.out.println("\ntestGetAll():");
        List<Student> studentList = studentDao.getAll();
        for (Student s : studentList){
            System.out.println(s.getSname()+"\t"+s.getSid()+"\t"+s.getSage()+"\t"+s.getMajor());
        }
    }

    @Test
    void testGetById() throws SQLException {
        System.out.println("\ntestGetById():");
        Student student = studentDao.getById(4);
        System.out.println(student.getSname()+"\t"+student.getSid()+"\t"
                +student.getSage()+"\t"+student.getMajor());
    }
    @Test
    void testAdd() throws SQLException {
        System.out.println("\ntestAdd():");
        Student student1 = new Student(0,"demo","SE",20,0);
        studentDao.add(student1);
        studentDao.deleteByName(student1.getSname());
    }

    @Test
    void testDelete() throws SQLException {
        System.out.println("\ntestDelete():");
        Student student = new Student(0,"testDelete","SE",20,0);
        studentDao.add(student);
        studentDao.deleteByName(student.getSname());
        System.out.println(studentDao.getBySname(student.getSname()));
    }

    @Test
    void testUpdate() throws SQLException {
        System.out.println("\ntestUpdate():");
        Student student = new Student(0,"testUpdate","SE",20,0);
        studentDao.add(student);
        student.setStatus(1);
        studentDao.update(student);
        studentDao.deleteByName(student.getSname());
    }

    @Test
    void testPaging() throws SQLException {
        System.out.println("\ntestPaging():");
        Page<Student> page = studentDao.getByPage(2,5);
        System.out.println(page.getEntityList());
    }
}
