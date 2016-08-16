package com.exist.web;

import com.exist.dto.*;
import com.exist.services.ContactService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet("/person/*")
public class PersonServlet extends HttpServlet {
    private PersonService personService = ServiceFactory.getPersonService();
    private RoleService roleService = ServiceFactory.getRoleService();
    private ContactService contactService = ServiceFactory.getContactService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String[] path = StringUtils.isNotBlank(req.getPathInfo()) ? req.getPathInfo().substring(1).split("/") : new String[]{"list", ""};
            String mode = path[0];
            Long id = (path.length > 1 && StringUtils.isNotBlank(path[1])) ? Long.valueOf(path[1]) : null;
            String view = "/WEB-INF/views/person/list.jsp";

            PersonDto personDto;
            switch (mode) {
                case "create":
                    view = "/WEB-INF/views/person/form.jsp";
                    break;
                case "edit":
                    personDto = personService.findOne(id);
                    if (personDto != null) {
                        req.setAttribute("person", personDto);
                        view = "/WEB-INF/views/person/form.jsp";
                    } else {
                        resp.sendRedirect("/person?error=Person with id " + id + " does not exist");
                    }
                    break;
                case "view":
                    personDto = personService.findOne(id);
                    if (personDto != null) {
                        Set<RoleDto> personRoleList = roleService.findAllByPerson(personDto.getId());
                        Set<RoleDto> roleList = roleService.findAllNotIn(personRoleList.stream().map(RoleDto::getId).collect(Collectors.toList()));
                        List<ContactDto> personContactList = contactService.findAllByPerson(personDto.getId());

                        req.setAttribute("person", personDto);
                        req.setAttribute("personRoleList", personRoleList);
                        req.setAttribute("readonly", true);
                        req.setAttribute("roleList", roleList);

                        req.setAttribute("personContactList", personContactList);

                        view = "/WEB-INF/views/person/form.jsp";
                    } else {
                        resp.sendRedirect("/person?error=Person with id " + id + " does not exist");
                    }
                    break;
                case "list":
                default:
                    List<PersonDto> personList = personService.findAll("id", "asc");
                    req.setAttribute("personList", personList);
                    break;
            }

            req.getRequestDispatcher(view).forward(req, resp);
        } catch (NumberFormatException ex) {
            resp.sendRedirect("/person");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirectUrl = "/person";
        try {
            String[] path = StringUtils.isNotBlank(req.getPathInfo()) ? req.getPathInfo().substring(1).split("/") : new String[]{""};
            String mode = path[0];
            switch (mode) {
                case "create":
                    PersonDto person = buildPerson(req);
                    personService.add(person);
                    break;
                case "addRole":
                    if (StringUtils.isNotBlank(req.getParameter("personId")) && StringUtils.isNotBlank(req.getParameter("role"))) {
                        Long personId = Long.valueOf(req.getParameter("personId"));
                        Long roleId = Long.valueOf(req.getParameter("role"));
                        personService.addRole(personId, roleId);
                        redirectUrl = "/person/view/" + personId;
                    }
                    break;
                case "removeRole":
                    if (StringUtils.isNotBlank(req.getParameter("personId")) && StringUtils.isNotBlank(req.getParameter("roleId"))) {
                        Long personId = Long.valueOf(req.getParameter("personId"));
                        Long roleId = Long.valueOf(req.getParameter("roleId"));
                        personService.removeRole(personId, roleId);
                        redirectUrl = "/person/view/" + personId;
                    }
                    break;
                case "updateContact":

                default:
                    break;
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            //Will just redirect back to person list
        }

        resp.sendRedirect(redirectUrl);
    }

    private PersonDto buildPerson(HttpServletRequest req) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Long id = StringUtils.isBlank(req.getParameter("id"))
                ? null
                : Long.valueOf(req.getParameter("id"));

        String title = req.getParameter("title");
        String firstName = req.getParameter("firstName");
        String middleName = req.getParameter("middleName");
        String lastName = req.getParameter("lastName");
        String suffix = req.getParameter("suffix");
        Date birthDate;
        try {
            birthDate = StringUtils.isBlank(req.getParameter("birthDate")) ? null : formatter.parse(req.getParameter("birthDate"));
        } catch (ParseException e) {
            birthDate = null;
        }

        String streetNumber = req.getParameter("streetNumber");
        String barangay = req.getParameter("barangay");
        String city = req.getParameter("city");
        String zipCode = req.getParameter("zipCode");

        Double gwa = StringUtils.isBlank(req.getParameter("gwa"))
                ? null
                : Double.valueOf(req.getParameter("gwa"));

        Boolean currentlyEmployed = StringUtils.isBlank(req.getParameter("currentlyEmployed"))
                ? null
                : Boolean.valueOf(req.getParameter("currentlyEmployed"));

        Date dateHired;
        try {
            dateHired = StringUtils.isBlank(req.getParameter("dateHired")) ? null : formatter.parse(req.getParameter("dateHired"));
        } catch (ParseException e) {
            dateHired = null;
        }

        PersonDto person = new PersonDtoBuilder()
                .withId(id)
                .withName(
                        new NameDtoBuilder()
                                .withTitle(title)
                                .withFirstName(firstName)
                                .withMiddleName(middleName)
                                .withLastName(lastName)
                                .withSuffix(suffix)
                                .build()
                ).withAddress(
                        new AddressDtoBuilder()
                                .withStreetNumber(streetNumber)
                                .withBarangay(barangay)
                                .withCity(city)
                                .withZipCode(zipCode)
                                .build()
                ).withBirthDate(birthDate)
                .withGwa(gwa)
                .withCurrentlyEmployed(currentlyEmployed)
                .withDateHired(dateHired)
                .build();

        return person;
    }
}
