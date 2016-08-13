<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main title="Index">

    <div class="row">
        <div class="col-md-6">
            <div class="col-md-8 col-md-offset-4">
                <a href="/person" class="btn btn-primary btn-block main-links">
                    <i class="fa fa-5x fa-user"></i>
                    <br>
                    <p class="h2">Person Management</p>
                </a>
            </div>
        </div>
        <div class="col-md-6">
            <div class="col-md-8">
                <a href="/role" class="btn btn-success btn-block main-links">
                    <i class="fa fa-5x fa-group"></i>
                    <br>
                    <p class="h2">Role Management</p>
                </a>
            </div>
        </div>
    </div>
</t:main>