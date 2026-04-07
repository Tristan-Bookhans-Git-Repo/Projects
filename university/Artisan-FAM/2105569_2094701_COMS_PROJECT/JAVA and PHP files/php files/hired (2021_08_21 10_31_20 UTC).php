<?php
require_once __DIR__ . '/config.php';
	$Server = $server;
	$User = $user;
	$Password = $password;
	$DB = $db;

	$link = mysqli_connect($Server,$User,$Password,$DB);
	
	$Cus_user = $_REQUEST['customer'];
	$Art_user = $_REQUEST['artisan'];
	
	$Cus_id = "";
	$Art_id = "";
	
	if (strlen($Cus_user) >10){
		$sql = $link->prepare("SELECT CUSTOMER.CUS_ID FROM CUSTOMER INNER JOIN PERSON ON CUSTOMER.PER_ID=PERSON.PER_ID WHERE PER_EMAIL = ?");
		$sql->bind_param("s",$Cus_user);
		$sql->execute();
		$Cus_id = $sql->get_result();
		$sql->close();
	}
	else{
		$sql = $link->prepare("SELECT CUSTOMER.CUS_ID FROM CUSTOMER INNER JOIN PERSON ON CUSTOMER.PER_ID=PERSON.PER_ID WHERE PER_PHONE = ?");
		$sql->bind_param("s",$Cus_user);
		$sql->execute();
		$Cus_id = $sql->get_result();
		$sql->close();
	}
	
	if (strlen($Art_user) >10){
		$sql = $link->prepare("SELECT ART_ID FROM ARTISAN INNER JOIN PERSON ON ARTISAN.PER_ID=PERSON.PER_ID WHERE PER_EMAIL = ?");
		$sql->bind_param("s",$Art_user);
		$sql->execute();
		$Art_id = $sql->get_result();
		$sql->close();
	}
	else{
		$sql = $link->prepare("SELECT ART_ID FROM ARTISAN INNER JOIN PERSON ON ARTISAN.PER_ID=PERSON.PER_ID WHERE PER_PHONE = ?");
		$sql->bind_param("s",$Art_user);
		$sql->execute();
		$Art_id = $sql->get_result();
		$sql->close();
	}
	
	$Cus_id = $Cus_id->fetch_assoc();
	$Art_id = $Art_id->fetch_assoc();
	$CUS = $Cus_id['CUS_ID'];
	$ART = $Art_id['ART_ID'];
	
	$check = $link->prepare("SELECT * FROM HIRED WHERE CUS_ID = ? AND ART_ID = ?;");
	$check->bind_param("ii",$CUS,$ART);
	$check->execute();
	$result2 = $check->get_result();
	if ($result2->num_rows > 0)
	{
		echo json_encode("Hired");
		exit(0);
	}
	
	$sql1 = $link->prepare("INSERT INTO HIRED(CUS_ID,ART_ID) VALUES(?,?)");
	$sql1->bind_param("ss",$CUS,$ART);

	if ($sql1->execute()){
		echo json_encode("Hired");
	}
	$sql1->close();
	mysqli_close($link);
	
?>
