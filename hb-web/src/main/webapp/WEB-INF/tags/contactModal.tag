<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@tag description="Contact modal Template" pageEncoding="UTF-8" %>
<%@attribute name="personId"  %>
<%@attribute name="contactId"  %>
<%@attribute name="contactType"  %>
<%@attribute name="contactInfo"  %>
<%@attribute name="mode" required="true" %>
<div class="modal fade" id="contactModal${contactId}" tabindex="-1" role="dialog" aria-labelledby="contactModalTitle${contactId}">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="contactModalTitle${contactId}">${mode} Contact</h4>
            </div>
            <div class="modal-body">
                <form class="form" action="${mode.equals('Create') ? '/person/addContact' : '/person/updateContact'}" method="post" id="contactForm${contactId}">
                    <input type="hidden" name="personId" value='${personId}'>
                    <input type="hidden" name="contactId" value='${contactId}'>

                    <div class="form-group">
                        <label for="contactType" class="control-label req">Contact Type</label>
                        <select name="contactType" id="contactType" class="form-control" required>
                            <option value="">Select One</option>
                            <option value="Mobile Number" ${contactType.equals('Mobile Number') ? 'selected' : ''}>Mobile Number</option>
                            <option value="Land Line"  ${contactType.equals('Land Line') ? 'selected' : ''}>Land Line</option>
                            <option value="Email"  ${contactType.equals('Email') ? 'selected' : ''}>Email</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="contactInfo" class="control-label req">Contact Info</label>
                        <input type="text" id="contactInfo" name="contactInfo" class="form-control" required value="${contactInfo}">
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary" form="contactForm${contactId}">${mode.equals('Edit') ? 'Save Changes' : 'Submit'}</button>
            </div>
        </div>
    </div>
</div>