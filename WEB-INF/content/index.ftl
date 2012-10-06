<html>
<body>
<h1>List of Members</h1>
<#list memberDetails as Member>
	 <li>${Member}</li>
</#list>

<br>
<h1>Add a New Member</h1>
    <@s.form action="add-member">
        <@s.textfield label="Name" name="name"/>
        <@s.textfield label="Address" name="address"/>
        <@s.textfield label="Suburb" name="suburb"/>
        <@s.textfield label="State" name="state"/>
        <@s.textfield label="Postcode" name="postCode"/>
        <@s.textfield label="Home Phone" name="home_Phone"/>
        <@s.textfield label="Mobile Phone" name="mobile_Phone"/>
        <@s.submit value="Save"/>
    </@s.form>

</body>
</html>
