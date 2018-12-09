<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>TicTacToe</title>
</head>

<body>

<form id="myForm2" action="/game">
    <table id="tikfields" >

        <c:forEach items="${fieldParam}" var="eachelemet" varStatus="outerCounter">
            <tr>

                <c:forEach items="${eachelemet}" var="entry" varStatus="innerCounter">
                    <td>
                        <input type="hidden" value="${entry}" name="${outerCounter.index}${innerCounter.index}"
                               id="${outerCounter.index+1}${innerCounter.index}">
                        <input type="BUTTON" VALUE="${entry == "Y" ? "Xod" : entry}"
                               ONCLICK='this.value="X";DoSubmit(${outerCounter.index+1}${innerCounter.index})'>
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>

</form>
<script>
    function DoSubmit(numberId) {

            document.getElementById(numberId).value = "X";
            document.getElementById("myForm2").submit();

    }
</script>
<script>
    window.onload = fc();

    function fc() {
        if (${label != null}) {
            alert('${label}');
            window.location.href = "/";
        }
    }

</script>
<form action="/" >
    <input type="submit" value="Try again">
</form>
</body>
</html>
