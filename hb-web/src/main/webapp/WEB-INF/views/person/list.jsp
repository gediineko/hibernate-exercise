<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main title="Person">
    <c:if test="${param.error != null}">
        <div class="alert alert-danger" role="alert"><strong>Oh snap! </strong>${param.error}</div>
    </c:if>
    <div class="row">
        <a href="/person/create" class="btn btn-primary pull-right">New Person</a>
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
                    <td>${person.birthDate}</td>
                    <td>${person.gwa}</td>
                    <td>${person.currentlyEmployed ? 'Yes' : 'No'}</td>
                    <td>${person.dateHired}</td>
                    <td>
                        <div class="dropdown">
                            <button class="btn btn-default dropdown-toggle" type="button"
                                    id="dropdownMenu${person.id}"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                Actions
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu${person.id}">
                                <li><a href="/person/view/${person.id}">View</a></li>
                                <li><a href="/person/edit/${person.id}">Edit</a></li>
                            </ul>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</t:main>