<%@ include file="header.html" %>

<h2>Book Driving Session</h2>

<form method="POST" action="BookSessionServlet">

    Student Name:
    <input type="text"
           name="student_name"
           required>
    <br><br>

    Branch Location:
    <select name="branch_location">

        <option>Kuala Lumpur</option>
        <option>Penang</option>
        <option>Johor</option>

    </select>

    <br><br>

    Lesson Type:
    <select name="lesson_type">

        <option>Manual Car</option>
        <option>Automatic Car</option>
        <option>Motorcycle</option>

    </select>

    <br><br>

    <input type="submit"
           value="Book Session">

</form>

<%@ include file="footer.jsp" %>