<?php
require_once __DIR__ . '/config.php';

	$link = mysqli_connect($server,$user,$password,$db);
	
	$Art_user = $_REQUEST['username'];
	
	$Art_id = "";
	
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
	
	
	$Art_id = $Art_id->fetch_assoc();
	$ART = $Art_id['ART_ID'];
	
	$output = array();
	$Getlist = $link->prepare("SELECT CUS_ID FROM HIRED WHERE ART_ID = ?");
	$Getlist->bind_param("i",$ART);
	$Getlist->execute();
	$result = $Getlist->get_result();
	$Getlist->close();
	$sql1 = $link->prepare("SELECT PERSON.PER_FNAME,PERSON.PER_SNAME,PERSON.PER_PHONE,PERSON.PER_EMAIL FROM PERSON INNER JOIN CUSTOMER ON CUSTOMER.PER_ID = PERSON.PER_ID WHERE CUSTOMER.CUS_ID = ?");
	while($row = $result->fetch_assoc()){
		$cus_id = $row['CUS_ID'];
		$sql1->bind_param("i",$cus_id);
		$sql1->execute();
		$H = $sql1->get_result();
		$output[] = $H->fetch_assoc();
	}
	$sql1->close();
	echo json_encode($output);
	
	mysqli_close($link);
	
?>