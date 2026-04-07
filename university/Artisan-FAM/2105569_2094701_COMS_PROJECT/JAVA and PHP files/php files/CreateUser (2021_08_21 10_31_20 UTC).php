<?php
require_once __DIR__ . '/config.php';
	$username = $user;
	$link = mysqli_connect($server,$username,$password,$db);
	
	$Fname = $_REQUEST["fname"];
	$Sname = $_REQUEST["sname"];
	$Phone = $_REQUEST["phone"];
	$Email = $_REQUEST["email"];
	$Password1 = $_REQUEST["password"];
	$Password = password_hash($Password1,PASSWORD_DEFAULT);
	$User = $_REQUEST["user"];
	$Type = $_REQUEST["type"];
	$Bname = $_REQUEST["bname"];	
	$Descrip = $_REQUEST["description"];
	
	$checker = true;
	
	$phonecheck = $link->prepare("SELECT PER_ID FROM PERSON WHERE PER_PHONE = ?;");
	$phonecheck->bind_param("s",$Phone);
	$phonecheck->execute();
	$result1 = $phonecheck->get_result();
	if ($result1->num_rows > 0)
	{
		echo json_encode("Phone number already linked to an account");
		exit(0);
	}
	$phonecheck->close();
	
	$emailcheck = $link->prepare("SELECT PER_ID FROM PERSON WHERE PER_EMAIL = ?;");
	$emailcheck->bind_param("s",$Email);
	$emailcheck->execute();
	$result2 = $emailcheck->get_result();
	if ($result2->num_rows > 0)
	{
		echo json_encode("Email address already linked to an account");
		exit(0);
	}
	$emailcheck->close();
	
	
	$buscheck = $link->prepare("SELECT PER_ID FROM PERSON WHERE PER_EMAIL = ?;");
	$buscheck->bind_param("s",$Bname);
	$buscheck->execute();
	$result3 = $buscheck->get_result();
	if ($result3->num_rows > 0)
	{
		echo json_encode("Business name already linked to an account");
		exit(0);
	}
	$buscheck->close();
	
	$sql1 = $link->prepare("INSERT INTO PERSON(PER_FNAME,PER_SNAME,PER_PHONE,PER_EMAIL,PER_PASSWORD,USER_TYPE) VALUES(?,?,?,?,?,?)");
	$sql1->bind_param("ssssss",$Fname,$Sname,$Phone,$Email,$Password,$User);
	
	$sql2 = "CALL INSERT_ART('$User','$Type','$Descrip','$Bname');";
	
	if ($sql1->execute() != TRUE)
	{
		global $checker;
		$checker = false;
	}
	$sql1->close();

	if (mysqli_query($link,$sql2) != TRUE)
	{
		global $checker;
		$checker = false;
	}
	
	mysqli_close($link);
	if ($checker == true)
	{
		echo json_encode("Success");
	}
?>