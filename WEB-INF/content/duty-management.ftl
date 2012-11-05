<html>
<head>
	<!--5grid--><script src="http://localhost:8080/CommunityRosterSystem/css/5grid/viewport.js"></script><!--[if lt IE 9]><script src="css/5grid/ie.js"></script><![endif]--><link rel="stylesheet" href="http://localhost:8080/CommunityRosterSystem/css/5grid/responsive.css" /><!--/5grid-->
	<link rel="stylesheet" href="http://localhost:8080/CommunityRosterSystem/css/style.css" />
</head>
<body class="subpage">

		<!-- Header -->
			<div id="header-wrapper">
				<header id="header" class="5grid">
					<div class="12u-first">

						<!-- Logo -->
							<h1><a href="#">Community Roster System</a></h1>
						
						<!-- Nav -->
							<nav>
								<a href="index">Homepage</a>
								<a href="member-management">Member Management</a>
								<!--<a href="duty-management">Duty Management</a>-->
								<a href="capability-management">Capability Management</a>
							</nav>

					</div>
				</header>
			</div>

		<!-- Content -->
			<div id="content-wrapper">
				<div id="content">
					<div class="5grid">
						<div class="9u-first">
							
							<!-- Main Content -->
								<section>
										<h2>Add a New Duty</h2>
									<br>
    									<@s.form action="add-duty">
        									<@s.textfield label="Name" name="name"/>
        									<@s.textfield label="Description" name="description"/>
        									<@s.submit value="Save"/>
    									</@s.form><br>
    								<h2>Update a Duty</h2>
    								<br> 
    								    <@s.form action="update-duty">
        									<@s.textfield label="Name" name="name"/>
        									<@s.textfield label="Description" name="description"/>
        									<@s.submit value="Update"/>
    									</@s.form><br>
									<h2>Delete a Duty</h2>
									    <@s.form action="delete-duty">
        									<@s.textfield label="Name of Duty to Delete " name="name"/>
        									<@s.submit value="Delete"/>
        								</@s.form>
									<br>
									<h2>Get List of Members Who Perform This Duty</h2>
										<@s.form action="duty-capabilities">
        									<@s.textfield label="Name of Duty " name="name"/>
        									<@s.submit value="Get Capabilities"/>
        								</@s.form>
								</section>
						</div>
						<div class="3u">
							
							<!-- Sidebar -->
								<section>
									<header>
										<h2>List of Duties</h2>
									</header>
									
									<#list dutyDetails as Duty>
	 									<li>${Duty}</li>
									</#list>
								</section>
						</div>
					</div>
				</div>
			</div>

		<!-- Footer -->
			<div id="footer-wrapper">
				<footer id="footer" class="5grid">
					<div class="8u-first">
					
						<!-- Links -->
							<section>
								<h2>Links to Important Stuff</h2>
								<div class="3u-first">
									<ul class="link-list last-child">
										<li><a href="index">Homepage</a></li>
									</ul>
								</div>
								<div class="3u">
									<ul class="link-list last-child">
										<li><a href="member-management">Member Management</a></li>
									</ul>
								</div>
								<div class="3u">
									<ul class="link-list last-child">
										<li><a href="duty-management">Duty Management</a></li>
									</ul>
								</div>
								<div class="3u">
									<ul class="link-list last-child">
										<li><a href="capability-management">Capability Management</a></li>
									</ul>
								</div>
							</section> 

					</div>
					<div class="4u">
						
						<!-- Blurb -->
							<section>
								<h2>An Informative Text Blurb</h2>
								<p>
									Text that informs.
								</p>
							</section>
					
					</div>
				</footer>
			</div>
</body>
</html>
