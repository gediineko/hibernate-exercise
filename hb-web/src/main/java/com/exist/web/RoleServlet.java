package com.exist.web;

import com.exist.dto.RoleDto;
import com.exist.services.PersonService;
import com.exist.services.RoleService;
import com.exist.util.ServiceFactory;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/role/*")
public class RoleServlet extends HttpServlet {
    private PersonService personService = ServiceFactory.getPersonService();
    private RoleService roleService = ServiceFactory.getRoleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set<RoleDto> roleList = roleService.findAll();
        // req.setAttribute("roleList", roleList);
        // req.getRequestDispatcher("/WEB-INF/views/role/list.jsp").forward(req, resp);

        Set<RoleDto> roleList;
        try {
            String[] path = StringUtils.isNotBlank(req.getPathInfo()) ? req.getPathInfo().substring(1).split("/") : new String[]{"list", ""};
            String mode = path[0];
            Long id = (path.length > 1 && StringUtils.isNotBlank(path[1])) ? Long.valueOf(path[1]) : null;
            String view = "/WEB-INF/views/role/list.jsp";
            switch (mode){
                case "addRole":
                    roleList = roleService.findAll();
                    req.setAttribute("roleList", roleList);
                    break;
                default:
                    roleList = roleService.findAll();
                    req.setAttribute("roleList", roleList);
                    break;
            }

            req.getRequestDispatcher(view).forward(req, resp);
        
        } catch (Exception e){
            resp.sendRedirect("/role");
        }
    }
}
