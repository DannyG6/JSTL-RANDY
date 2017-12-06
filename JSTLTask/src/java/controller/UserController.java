/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.UserDAO;

/**
 *
 * @author DannyG
 */
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = null;
        rd = req.getRequestDispatcher("/user.jsp");
        UserDAO userDAO = new UserDAO();
        ArrayList<User> userAL = null;

        try {
            userAL = userDAO.getUserList();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("listUser", userAL);

        try {
            String gender = req.getParameter("gender");
            System.out.println(gender);
            if (!gender.isEmpty()) {
                req.setAttribute("gender", gender);
            }
           
        }
        catch(Exception e){}

        rd.forward(req, resp);
    }

}
