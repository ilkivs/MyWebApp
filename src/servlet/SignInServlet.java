package servlet;

import container.Storage;
import model.UserAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignInServlet", value = "/sign_in")
public class SignInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserAccount signInAccount = new UserAccount(login, password);

        boolean isLoginPasswordTrue = false;
        for (UserAccount userAccount : Storage.users) {
            if (userAccount.equals(signInAccount)) {
                isLoginPasswordTrue = true;
            }
        }
        if (isLoginPasswordTrue){
            out.println("Signed in!\nHello, " + login);
        }else {
            out.println("Failed! Incorrect login/password");
        }
    }
}
