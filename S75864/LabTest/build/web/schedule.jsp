<%-- 
    Document   : schedule
    Created on : 16 Jun 2026, 3:41:09 PM
    Author     : MP3 LECT
--%>

<%@ page import="java.util.*" %>
<%@ page import="com.lab.bean.SessionBean" %>

<%@ include file="header.html" %>

<h2>Centralized Schedule Dashboard</h2>

<table border="1">

<tr>
    <th>ID</th>
    <th>Student Name</th>
    <th>Branch</th>
    <th>Lesson Type</th>
    <th>Status</th>
</tr>

<%
List<SessionBean> list =
(List<SessionBean>)request.getAttribute("sessionList");

for(SessionBean s : list){
%>

<tr>
    <td><%= s.getSession_id() %></td>
    <td><%= s.getStudent_name() %></td>
    <td><%= s.getBranch_location() %></td>
    <td><%= s.getLesson_type() %></td>
    <td><%= s.getStatus() %></td>
</tr>

<%
}
%>

</table>

<%@ include file="footer.jsp" %>