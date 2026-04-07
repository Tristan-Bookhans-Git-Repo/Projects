<?php
require_once __DIR__ . '/config.php';

	$link = mysqli_connect($server,$user,$password,$db);
	
	$Cus_user = $_REQUEST['username'];
	
	$Cus_id = "";
	
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
	
	$Cus_id = $Cus_id->fetch_assoc();
	$CUS = $Cus_id['CUS_ID'];
	$output = array();
	$Getlist = $link->prepare("SELECT ART_ID FROM HIRED WHERE CUS_ID = ?");
	$Getlist->bind_param("i",$CUS);
	$Getlist->execute();
	$result = $Getlist->get_result();
	$Getlist->close();
	$sql1 = $link->prepare("SELECT ARTISAN.ART_BUSINESS_NAME,ARTISAN.ART_TYPE,PERSON.PER_PHONE,PERSON.PER_EMAIL FROM ARTISAN INNER JOIN PERSON ON ARTISAN.PER_ID = PERSON.PER_ID WHERE ARTISAN.ART_ID = ?");	
	while($row = $result->fetch_assoc()){
		$art_id = $row['ART_ID'];
		$sql1->bind_param("i",$art_id);
		$sql1->execute();
		$H = $sql1->get_result();
		$output[] = $H->fetch_assoc();
	}
	$sql1->close();
	echo json_encode($output);
	
	mysqli_close($link);
	
?>
