<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main title="Person Form">
    <form class="form" action="/person/create" method="post">

        <input type="hidden" name="id" id="id" value="${person.id}">
        
            <div class="text-center">
                <h1>Person Information</h1>
            </div>
        <br>
        <c:if test="${showPersonLabel}">
            <h2 class="text-center">
                <label>${person.name}</label>
            </h2>
        </c:if>
        <br>
        <c:if test="${!showPersonLabel}">
            <div class="row">
                <div class="col-md-6">
                    <h3>Name</h3>

                    <div class="form-group">
                        <label class="control-label" for="title">Title</label>
                        <input type="text" class="form-control" id="title" placeholder="Title" name="title"
                               value='${person.name.title}'
                                <c:if test="${readonly}">
                                    readonly="readonly"
                                </c:if>
                        />
                    </div>

                    <div class="form-group">
                        <label class="control-label req" for="firstName">First Name</label>
                        <input type="text" class="form-control" id="firstName" placeholder="First Name" name="firstName"
                               required value='${person.name.firstName}'
                                <c:if test="${readonly}">
                                    readonly="readonly"
                                </c:if>
                        />
                    </div>

                    <div class="form-group">
                        <label class="control-label" for="middleName">Middle Name</label>
                        <input type="text" id="middleName" class="form-control" placeholder="Middle Name"
                               name="middleName" value='${person.name.middleName}'
                                <c:if test="${readonly}">
                                    readonly="readonly"
                                </c:if>
                        />
                    </div>

                    <div class="form-group">
                        <label class="control-label req" for="lastName">Last Name</label>
                        <input type="text" id="lastName" class="form-control" placeholder="Last Name" name="lastName"
                               required value='${person.name.lastName}'
                                <c:if test="${readonly}">
                                    readonly="readonly"
                                </c:if>
                        />
                    </div>

                    <div class="form-group">
                        <label class="control-label" for="suffix">Suffix</label>
                        <input type="text" id="suffix" class="form-control" placeholder="Suffix" name="suffix"
                               value='${person.name.suffix}'
                                <c:if test="${readonly}">
                                    readonly="readonly"
                                </c:if>
                        />
                    </div>


                    <div class="form-group">
                        <h3 class="control-label req" for="birthDate">Birth Date</h3>
                        <fmt:formatDate value="${person.birthDate}" var="birthDate" pattern="yyyy-MM-dd"/>
                        <input type="date" id="birthDate" class="form-control" placeholder="yyyy-mm-dd" name="birthDate"
                               required value='${birthDate}'
                                <c:if test="${readonly}">
                                    readonly="readonly"
                                </c:if>
                        />
                    </div>

                </div>

                <div class="col-md-6">

                    <h3>Address</h3>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="control-label" for="streetNumber">Street No.</label>
                            <input type="text" id="streetNumber" class="form-control" placeholder="Street Number"
                                   name="streetNumber" value='${person.address.streetNumber}'
                                    <c:if test="${readonly}">
                                        readonly="readonly"
                                    </c:if>
                            />
                        </div>
                        <div class="form-group col-md-6">
                            <label class="control-label" for="barangay">Barangay</label>
                            <input type="text" id="barangay" class="form-control" placeholder="Barangay" name="barangay"
                                   value='${person.address.barangay}'
                                    <c:if test="${readonly}">
                                        readonly="readonly"
                                    </c:if>
                            />
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="control-label req" for="city">City</label>
                            <input type="text" id="city" class="form-control" placeholder="City" name="city" required
                                   value='${person.address.city}'
                                    <c:if test="${readonly}">
                                        readonly="readonly"
                                    </c:if>
                            />
                        </div>
                        <div class="form-group col-md-6">
                            <label class="control-label" for="zipCode">Zip Code</label>
                            <input type="text" id="zipCode" class="form-control" placeholder="Zip Code" name="zipCode"
                                   value='${person.address.zipCode}'
                                    <c:if test="${readonly}">
                                        readonly="readonly"
                                    </c:if>
                            />
                        </div>
                    </div>

                    <h3>Other Info</h3>

                    <div class="form-group">
                        <label class="control-label" for="gwa">GWA</label>
                        <input type="number" name="gwa" id="gwa" class="form-control" placeholder="GWA"
                               value='${person.gwa}'
                                <c:if test="${readonly}">
                                    readonly="readonly"
                                </c:if>
                        />
                    </div>

                    <div class="form-group">
                        <label>Currently Employed</label>

                        <div class="radio row">
                            <div class="col-md-12">
                                <label class="col-md-3">
                                    <input type="radio" name="currentlyEmployed" id="currentlyEmployedYes" value="true"
                                            <c:if test="${person.currentlyEmployed}">
                                                checked="checked"
                                            </c:if>
                                            <c:if test="${readonly}">
                                                disabled="disabled"
                                            </c:if>
                                    /> Yes
                                </label>
                                <label class="col-md-3">
                                    <input type="radio" name="currentlyEmployed" id="currentlyEmployedNo" value="false"
                                            <c:if test="${!person.currentlyEmployed}">
                                                checked="checked"
                                            </c:if>
                                            <c:if test="${readonly}">
                                                disabled="disabled"
                                            </c:if>
                                    /> No
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label" for="dateHired">Date Hired</label>
                        <fmt:formatDate value="${person.dateHired}" var="dateHired" pattern="yyyy-MM-dd"/>
                        <input type="date" id="dateHired" class="form-control" placeholder="yyyy-mm-dd" name="dateHired"
                               id="dateHired"
                               value="${dateHired}"
                                <c:if test="${readonly}">
                                    readonly="readonly"
                                </c:if>
                        />
                    </div>

                </div>

            </div>

            <c:if test="${!readonly}">
                <div class="row form-buttons">
                    <div class="col-md-3 col-md-offset-9">
                        <button class="btn btn-primary btn-block" type="submit">Submit</button>
                    </div>
                </div>
            </c:if>
        </c:if>
    </form>


    <c:if test="${readonly}">
        <div class="row">

            <!-- Person Contact -->
            <div class="col-md-6">

                <h3>Contacts
                    <button class="btn btn-primary pull-right <c:if test="${hidden}">hidden</c:if>" 
                        data-toggle="modal" 
                        data-target="#contactModal">
                        Add Contact
                    </button>
                </h3>

                <br>

                <div>
                    <table class="table-condensed table table-bordered">
                        <thead>
                        <tr>
                            <th>Type</th>
                            <th>Info</th>
                            <th class="thActions 
                                    <c:if test="${hidden}">
                                    hidden
                                    </c:if>"
                            >Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${personContactList.isEmpty()}">
                            <tr>
                                <td colspan="3" class="text-center">Person has no contacts</td>
                            </tr>
                        </c:if>
                        <c:forEach var="contact" items="${personContactList}">
                            <tr>
                                <td>${contact.contactType}</td>
                                <td>${contact.contactInfo}</td>
                                
                                <td class="tdActions 
                                    <c:if test="${hidden}">
                                    hidden
                                    </c:if>"
                                >
                                    <span class="dropdown">
                                        <button class="btn btn-default btn-block dropdown-toggle" type="button"
                                                id="dropdownMenuContact${contact.id}"
                                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                            Actions
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuContact${contact.id}">
                                            <li><button href="#" data-toggle="modal"
                                                        data-target="#contactModal${contact.id}" class="btn btn-link">Update</button></li>
                                            <li>
                                                <form action="/person/removeContact" method="post"
                                                      id="deleteForm${contact.id}">
                                                    <input type="hidden" name="personId" value="${person.id}">
                                                    <input type="hidden" name="contactId" value="${contact.id}">
                                                    <button class="btn btn-link" type="submit">Delete</button>
                                                </form>
                                            </li>
                                        </ul>
                                    </span>
                                </td>
                            </tr>
                            <t:contactModal mode="Edit" contactId="${contact.id}"
                                            personId="${person.id}" contactType="${contact.contactType}"
                                            contactInfo="${contact.contactInfo}"/>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- Person Role -->
            <div class="col-md-6">
                <h3>Roles
                    <button class="btn btn-primary pull-right <c:if test="${hidden}">hidden</c:if>" 
                        data-toggle="modal" 
                        data-target="#roleModal">
                        Add Role
                    </button>
                </h3>
                <br>

                <div>
                    <table class="table-condensed table table-bordered">
                        <thead>
                        <tr>
                            <th>Role Title</th>
                            <th class="thActions 
                                    <c:if test="${hidden}">
                                    hidden
                                    </c:if>"
                            >Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${personRoleList.isEmpty()}">
                            <tr>
                                <td colspan="2" class="text-center">Person has no role</td>
                            </tr>
                        </c:if>
                        <c:forEach var="role" items="${personRoleList}">
                            <tr>
                                <td>${role.name}</td>
                                <td class="tdActions 
                                    <c:if test="${hidden}">
                                    hidden
                                    </c:if>"
                                >
                                    <span class="dropdown pull-right">
                                    <button class="btn btn-default dropdown-toggle" type="button"
                                            id="dropdownMenuRole${role.id}"
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                        Actions
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuRole${role.id}">
                                        <li>
                                            <form action="/person/removeRole" method="post" id="deleteForm${role.id}">
                                                <input type="hidden" name="personId" value="${person.id}">
                                                <input type="hidden" name="roleId" value="${role.id}">
                                                <button class="btn btn-link" type="submit">Delete</button>
                                            </form>
                                        </li>
                                    </ul>
                                    </span>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </c:if>

    <!-- Modal for Role-->
    <div class="modal fade" id="roleModal" tabindex="-1" role="dialog" aria-labelledby="roleModalTitle">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="roleModalTitle">Add Role</h4>
                </div>
                <div class="modal-body">
                    <form class="form" action="/person/addRole" method="post" id="addRoleForm">
                        <input type="hidden" name="personId" value='${person.id}'>

                        <div class="form-group">
                            <label class="control-label" for="role">Role</label>
                            <select name="role" id="role" class="form-control" required>
                                <option value="">Select Role</option>
                                <c:forEach var="role" items='${roleList}'>
                                    <option value="${role.id}">${role.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary" form="addRoleForm">Save changes</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal for Contacts -->
    <t:contactModal mode="Create" personId="${person.id}"/>


</t:main>