package com.exist.web;

import com.exist.dto.RoleDto;
import com.exist.services.RoleService;
import com.exist.util.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/role/*")
public class RoleServlet extends HttpServlet {
    RoleService roleService;

    @Override
    public void init() throws ServletException {
        roleService = ServiceFactory.getRoleService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set<RoleDto> roleList = roleService.findAll();
        // req.setAttribute("roleList", roleList);
        // req.getRequestDispatcher("/WEB-INF/views/role/list.jsp").forward(req, resp);

        try {

        } catch (Exception e){
            resp.sendRedirect("/role");
        }
    }
}
