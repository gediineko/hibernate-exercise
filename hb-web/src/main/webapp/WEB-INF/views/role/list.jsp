<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main title="Role">
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        </thead>
        <c:if test="${roleList.isEmpty()}">
            <tr>
                <td colspan="2" class="text-center">No Role Found</td>
            </tr>
        </c:if>
        <c:forEach var="role" items="${roleList}">
            <tr>
                <td>${role.id}</td>
                <td>${role.name}</td>
            </tr>
        </c:forEach>
    </table>
</t:main>