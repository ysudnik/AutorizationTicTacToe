<html>
<body>
<h2></h2>
<form id="myForm" action="/game">
    <table >
        <tbody>
        <tr>
            <td>

                <input type="hidden" value="Y" name="00" id="11">
                <input type="BUTTON" VALUE="Xod" ONCLICK='this.value="X";DoSubmit(11)'>

            </td>
            <td>
                <input type="hidden" value="Y" name="01" id="12">
                <input type="BUTTON" VALUE="Xod" ONCLICK='this.value="X";DoSubmit(12)'>
            </td>
            <td>
                <input type="hidden" value="Y" name="02" id="13">
                <input type="BUTTON" VALUE="Xod" ONCLICK='this.value="X";DoSubmit(13)'>
            </td>
        </tr>
        <tr>
            <td>
                <input type="hidden" value="Y" name="10" id="21">
                <input type="BUTTON" VALUE="Xod" ONCLICK='this.value="X";DoSubmit(21)'>
            </td>
            <td>
                <input type="hidden" value="Y" name="11" id="22">
                <input type="BUTTON" VALUE="Xod" ONCLICK='this.value="X";DoSubmit(22)'>
            </td>
            <td>
                <input type="hidden" value="Y" name="12" id="23">
                <input type="BUTTON" VALUE="Xod" ONCLICK='this.value="X";DoSubmit(23)'>
            </td>
        </tr>
        <tr>
            <td><input type="hidden" value="Y" name="20" id="31">
                <input type="BUTTON" VALUE="Xod" ONCLICK='this.value="X";DoSubmit(31)'></td>
            <td>
                <input type="hidden" value="Y" name="21" id="32">
                <input type="BUTTON" VALUE="Xod" ONCLICK='this.value="X";DoSubmit(32)'>
            </td>
            <td>
                <input type="hidden" value="Y" name="22" id="33">
                <input type="BUTTON" VALUE="Xod" ONCLICK='this.value="X";DoSubmit(33)'>
            </td>
        </tr>
        </tbody>
    </table>
</form>
<script>
    function DoSubmit(numberId) {
        document.getElementById(numberId).value = "X";
        document.getElementById("myForm").submit()
        return true;
    }
</script>
<form action="/" >
    <input type="submit" value="Try again">
</form>
</body>
</html>
