<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main title="Role">
    <div class="col-md-6 col-md-offset-3">
        <h1 class="text-center">Role List</h1>
        <br>
        <br>
        <div class="row pull-right">
            <a href="#" class="btn btn-primary" data-toggle="modal" 
                data-target="#roleModal">New Role</a>
        </div>
        <br>
        <br>
        <div class="row">
            <table class="table">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th class="pull-right">Actions</th>
                </tr>
                </thead>
                <c:if test="${roleList.isEmpty()}">
                    <tr>
                        <td colspan="3" class="text-center">No Role Found</td>
                    </tr>
                </c:if>
                <c:forEach var="role" items="${roleList}">
                    <tr>
                        <td>${role.id}</td>
                        <td>${role.name}</td>
                        <td>
                            <div class="dropdown pull-right">
                                <button class="btn btn-default dropdown-toggle" type="button"
                                            id="dropdownMenu${role.id}"
                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    Actions
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu${role.id}">
                                    <li><button href="#" data-toggle="modal"
                                                data-target="#roleModal${role.id}" class="btn btn-link">Update</button></li>
                                    <li>
                                        <form action="/role/removeRole" method="post"
                                              id="deleteForm${role.id}">
                                            <input type="hidden" name="roleId" value="${role.id}">
                                            <button class="btn btn-link" type="submit">Delete</button>
                                        </form>
                                    </li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <!-- Role Modal -->
    
    <t:roleModal mode="Create"/>
</t:main>