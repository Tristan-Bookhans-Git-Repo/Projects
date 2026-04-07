<?php
require_once __DIR__ . '/config.php';

	$link = mysqli_connect($server,$user,$password,$db);
	
	$username = $_REQUEST["username"];
	$fname = $_REQUEST["fname"];
	$sname = $_REQUEST["sname"];
	
	$sql = "INSERT INTO USERS VALUES('$username','$fname','$sname')";
	if (mysqli_query($link,$sql)){
		$sql1 = "CREATE TABLE $username(CHATNAME VARCHAR(100),NUMMESSAGES INT(255) ,FNAME VARCHAR(50),SNAME VARCHAR(50))";
		mysqli_query($link,$sql1);
		echo json_encode("Registered");
	}
	
	mysqli_close($link);

?>