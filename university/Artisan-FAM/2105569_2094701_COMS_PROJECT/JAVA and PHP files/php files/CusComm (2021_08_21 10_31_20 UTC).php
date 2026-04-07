<?php
require_once __DIR__ . '/config.php';

	$link = mysqli_connect($server,$user,$password,$db);
	
	$username = $_REQUEST['username'];
	
	$cus_id ="";
	
	if (strlen($username) >10){
		$sql = $link->prepare("SELECT CUS_ID FROM CUSTOMER INNER JOIN PERSON ON CUSTOMER.PER_ID = PERSON.PER_ID WHERE PERSON.PER_EMAIL = ?");
		$sql->bind_param("s",$username);
		$sql->execute();
		$cus_id = $sql->get_result();
		$sql->close();
	}else{
		$sql = $link->prepare("SELECT CUS_ID FROM CUSTOMER INNER JOIN PERSON ON CUSTOMER.PER_ID = PERSON.PER_ID WHERE PERSON.PER_PHONE = ?");
		$sql->bind_param("s",$username);
		$sql->execute();
		$cus_id = $sql->get_result();
		$sql->close();
	}
	
	$cus_id = $cus_id->fetch_assoc();
	$CUS = $cus_id['CUS_ID'];	

	$output = array();
	$sql = $link->prepare("SELECT PERSON.PER_FNAME,PERSON.PER_SNAME,PERSON.PER_PHONE,PERSON.PER_EMAIL,ART_COMMENTS.COMMENTS,ART_COMMENTS.RATING FROM PERSON INNER JOIN ARTISAN ON PERSON.PER_ID = ARTISAN.PER_ID INNER JOIN ART_COMMENTS ON ARTISAN.ART_ID = ART_COMMENTS.ART_ID WHERE ART_COMMENTS.CUS_ID = ?");
	$sql->bind_param("i",$CUS);
	$sql->execute();	
	$result = $sql->get_result();
	while($row = $result->fetch_assoc()){
		global $output;
		array_unshift($output,$row);
	}
	$sql->close();
	
	mysqli_close($link);
	
?>