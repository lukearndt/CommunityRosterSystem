<html>
<body>
<h1>List of Members</h1>
<#list memberDetails as Member>
	 <li>${Member}</li>
</#list>

    <@s.form action="add-member">
        <@s.textfield label="Name" name="userName"/>
        <@s.submit value="Save"/>
    </@s.form>

</body>
</html>
