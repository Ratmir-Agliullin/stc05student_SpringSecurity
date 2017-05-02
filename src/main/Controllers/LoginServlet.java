package main.Controllers;

import org.springframework.stereotype.Controller;

/**
 * Created by admin on 19.04.2017.
 */
@Controller
public class LoginServlet{






//    static {
//        PropertyConfigurator.configure
//    }
//private static Logger log = Logger.getLogger(UserServiceIml.class.getName());
//
//    //private static UserServiceIml userService  =  new UserServiceIml();
//    @Autowited
//    private UserServiceIml userService;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
//                config.getServletContext());
//        ClassPathXmlApplicationContext context =
//        userService =
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/login.jsp").forward(req,resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String login = req.getParameter("login");
//        String password = req.getParameter("password");
//        if("user".equals(login) && "pass".equals(password)){
//            req.getSession().setAttribute("userLogin",login);
//            resp.sendRedirect(req.getContextPath()+"/List");
//        } else {
//            resp.sendRedirect("/error");
//        }
//    }
}
