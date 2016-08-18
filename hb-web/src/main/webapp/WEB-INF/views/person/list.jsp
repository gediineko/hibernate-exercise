<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:main title="Person">
    <c:if test="${param.error != null}">
        <div class="alert alert-danger" role="alert"><strong>Oh snap! </strong>${param.error}</div>
    </c:if>
    <div class="row pull-right">
        <div class="dropdown col-md-6">
            <button class="btn btn-default dropdown-toggle" type="button" id="sortDropDown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                Sort List
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="sortDropSown">
                <li><a href="#">by GWA</a></li>
                <li><a href="#">by Date Hired</a></li>
                <li><a href="#">by Last Name</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">by ID (default)</a></li>
            </ul>
        </div>
        <a href="/person/create" class="btn btn-primary col-md-6">New Person</a>
    </div>
    <br>
    <div class="row">

        <table class="table">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Address</th>
                <th>Birth Date</th>
                <th>GWA</th>
                <th>Employed</th>
                <th>Date Hired</th>
                <th>Action</th>
            </tr>
            </thead>
            <c:if test="${personList.isEmpty()}">
                <tr>
                    <td colspan="7" class="text-center">No Person Found</td>
                </tr>
            </c:if>
            <c:forEach var="person" items="${personList}">
                <tr>
                    <td>${person.id}</td>
                    <td>${person.name}</td>
                    <td>${person.address}</td>
                    <td>
                        <fmt:formatDate value="${person.birthDate}" var="birthDate" pattern="yyyy-MM-dd"/>
                        ${birthDate}
                    </td>
                    <td>${person.gwa}</td>
                    <td>${person.currentlyEmployed ? 'Yes' : 'No'}</td>
                    <td>
                        <fmt:formatDate value="${person.dateHired}" var="dateHired" pattern="yyyy-MM-dd"/>
                        ${dateHired}
                    </td>
                    <td>
                        <div class="dropdown">
                            <button class="btn btn-default dropdown-toggle" type="button"
                                    id="dropdownMenu${person.id}"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                Actions
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu${person.id}">
                                <li><a href="/person/viewPerson/${person.id}">View Person</a></li>
                                <li><a href="/person/edit/${person.id}">Edit Person Details</a></li>
                                <li><a href="/person/editPersonContactRole/${person.id}">Edit Contacts & Roles</a></li>
                                <li><a href="/person/view/${person.id}">Delete</a></li>
                            </ul>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</t:main>