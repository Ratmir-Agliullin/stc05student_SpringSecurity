package main.Services;

import main.DAO.StudentDAO;
import main.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

import static org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.hasRole;

/**
 * Created by admin on 19.04.2017.
 */
@Secured("ROLE_USER")
public class StudentService implements StudentServiceInterface{

    @Autowired
      public static studentInterface = new public StudentDAO();
    public static List<Student> getAllStudents(){
        return StudentDAO.getAll();
    }
}
