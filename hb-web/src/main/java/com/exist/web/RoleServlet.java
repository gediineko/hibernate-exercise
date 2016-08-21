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
        RoleDto roleDto;
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
                case "updateRole":
                    roleDto = roleService.findOne(id);
                    if (roleDto != null) {
                        req.setAttribute("role", roleDto);
                    } else {
                        resp.sendRedirect("/role?error=Role with id " + id + " does not exist");
                    }
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirectUrl = "/role";
        try {
            String[] path = StringUtils.isNotBlank(req.getPathInfo()) ? req.getPathInfo().substring(1).split("/") : new String[]{""};
            String mode = path[0];
            String roleName;
            switch (mode) {
                case "addRole":
                    roleName = req.getParameter("roleName");
                    // Long roleId = StringUtils.isNotBlank(req.getParameter("roleId"))
                    //     ? Long.valueOf(req.getParameter("roleId"))
                    //     : null;

                        // RoleDto roleDto = new RoleDtoBuilder()
                        //     .withId(roleId)
                        //     .withName(roleName)
                        //     .build();

                    RoleDto roleDto = new RoleDto(roleName);
                    roleService.add(roleDto);
                    break;
                case "updateRole":
                    if (StringUtils.isNotBlank(req.getParameter("roleId")) 
                        && StringUtils.isNotBlank(req.getParameter("roleName"))) {
                        roleName = req.getParameter("roleName");
                        Long roleId = Long.valueOf(req.getParameter("roleId"));
                        roleService.update(new RoleDto(roleName));
                        redirectUrl = "/role";
                    }

                    break;
                case "removeRole":
                    if (StringUtils.isNotBlank(req.getParameter("roleId"))){
                        Long roleId = Long.valueOf(req.getParameter("roleId"));
                        roleService.delete(roleId);
                        redirectUrl = "/role";

                    }
                    break;
                default:
                    break;
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            //Will just redirect back to person list
        }

        resp.sendRedirect(redirectUrl);

    }
}
