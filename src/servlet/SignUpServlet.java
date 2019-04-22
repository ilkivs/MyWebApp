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

@WebServlet(name = "SignUpServlet", value = "/sign_up")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserAccount signUpAccount = new UserAccount(login, password);

        boolean existUser = false;
        for (UserAccount userAccount : Storage.users) {
            if (userAccount.getLogin().equals(login)) {
                existUser = true;
            }
        }
        if (existUser){
            out.println("Failed! User is already exist");
        }else {
            Storage.users.add(signUpAccount);
            out.println("Successfully signed up, " + login + "!");
        }

    }
}
