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
								<a href="duty-management">Duty Management</a>
								<!--<a href="capabilityManagement">Capability Management</a>-->
							</nav>

					</div>
				</header>
			</div>
			
		<!-- Content -->
			<div id="content-wrapper">
				<div id="content">
					<div class="5grid">
						<div class="12u-first">
							
							<!-- Main Content -->
								<section>
										<h2>Add a Capability</h2>
									<br>
    									<@s.form action="add-capability">
        									<@s.textfield label="Member Name" name="memberName"/>
        									<@s.textfield label="Duty Name" name="dutyName"/>
        									<@s.submit value="Save"/>
    									</@s.form><br>
    								<h2>Delete a Capability</h2>
    								<br>
    								    <@s.form action="delete-capability">
        									<@s.textfield label="Member Name" name="memberName"/>
        									<@s.textfield label="Duty Name" name="dutyName"/>
        									<@s.submit value="Delete"/>
    									</@s.form><br>
								</section>
						</div>
					</div>
				</div>
			</div >

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
</div>
</div>
</div>
</div>
</body>
</html>
