<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main title="Role">
    <div class="col-md-6 col-md-offset-3">
        <h1 class="text-center">Role List</h1>
        <br>
        <br>
        <div class="row pull-right">
            <a href="#" class="btn btn-primary" data-toggle="modal" 
                data-target="#addRoleModal">New Role</a>
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
                                            id="dropdownMenu${role.id}"                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    Actions
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu${role.id}">
                                    <li><a href="#">Update</a></li>
                                    <li><a href="#">Delete</a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <!-- Role Modal -->
    <div id="addRoleModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

    <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Add Role</h4>
                </div>
                <div class="modal-body">
                    <form class="role" id="addRoleForm">

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary" form="addRoleForm">Save changes</button>
                </div>
            </div>

        </div>
    </div>
</t:main>