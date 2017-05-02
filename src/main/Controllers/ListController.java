package main.Controllers;

import main.Services.StudentService;
import main.Services.StudentServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 19.04.2017.
 */
public class ListController extends HttpServlet {

    private static StudentServiceInterface studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     req.setAttribute("value","O my GOD!!!");
 //    List<models.Student> list = new ArrayList<models.Student>();
//     Student student = new Student(1,"Vasya",23,1);
//        Student student2 = new Student(2,"Kolyan",23,1);
//        list.add(student);
//        list.add(student2);
//        req.setAttribute("list", list);
       getServletContext().getRequestDispatcher("/List.jsp").forward(req,resp);

    }


}
