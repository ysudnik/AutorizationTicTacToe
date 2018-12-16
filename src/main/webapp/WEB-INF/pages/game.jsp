<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>TicTacToe</title>
</head>

<body>
<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=de">ru</a>
</span>

<form id="myForm2" action="/game" method="post">
    <table id="tikfields">


        <c:forEach items="${fieldParam}" var="eachelemet" varStatus="outerCounter">
            <tr>

                <c:forEach items="${eachelemet}" var="entry" varStatus="innerCounter">
                    <td>
                        <input type="hidden" value="${entry}" name="${outerCounter.index}${innerCounter.index}"
                               id="${outerCounter.index+1}${innerCounter.index}">
                        <input type="BUTTON" VALUE="${entry == "Y" ? "Xod" : entry}"
                               id="${outerCounter.index}${innerCounter.index}5"
                               ONCLICK='DoSubmit(${outerCounter.index+1}${innerCounter.index})'>
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>

    </table>

</form>
<script>
    function DoSubmit(numberId) {
        if (document.getElementById(numberId).value == "Y") {
            document.getElementById(numberId).value = "X";
            document.getElementById("myForm2").submit();
            document.getElementById(numberId + 5).value = "X";
        } else alert("You can't go in this field")


    }
</script>
<script>
    window.onload = fc();

    function fc() {
        if (${label != null}) {
            alert('${label}');
            window.location.href = "/startGame";
        }
    }

</script>
<form action="/startGame">
    <input type="submit" value="Try again">
</form>
</body>
</html>
