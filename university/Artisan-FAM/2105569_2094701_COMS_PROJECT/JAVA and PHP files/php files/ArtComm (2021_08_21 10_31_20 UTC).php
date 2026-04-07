<?php
require_once __DIR__ . '/config.php';

	$link = mysqli_connect($server,$user,$password,$db);
	
	$username = $_REQUEST['username'];	
	$art_id ="";
	
	if (strlen($username) >10){
		$sql = $link->prepare("SELECT ART_ID FROM ARTISAN INNER JOIN PERSON ON ARTISAN.PER_ID = PERSON.PER_ID WHERE PERSON.PER_EMAIL = ?");
		$sql->bind_param("s",$username);
		$sql->execute();
		$art_id = $sql->get_result();
	}else{
		$sql = $link->prepare("SELECT ART_ID FROM ARTISAN INNER JOIN PERSON ON ARTISAN.PER_ID = PERSON.PER_ID WHERE PERSON.PER_PHONE = ?");
		$sql->bind_param("s",$username);
		$sql->execute();
		$art_id = $sql->get_result();
	}

	$sql->close();
	
	$art_id = $art_id->fetch_assoc();
	$ART = $art_id['ART_ID'];
	
	
	$output = array();
	$sql = $link->prepare("SELECT PERSON.PER_FNAME,PERSON.PER_SNAME,PERSON.PER_PHONE,PERSON.PER_EMAIL,CUS_COMMENTS.COMMENTS,CUS_COMMENTS.RATING FROM PERSON INNER JOIN CUSTOMER ON PERSON.PER_ID = CUSTOMER.PER_ID INNER JOIN CUS_COMMENTS ON CUSTOMER.CUS_ID = CUS_COMMENTS.CUS_ID WHERE CUS_COMMENTS.ART_ID = ?");
	$sql->bind_param("i",$ART);
	$sql->execute();
	$result = $sql->get_result();
	while($row = $result->fetch_assoc()){
		global $output;
		array_unshift($output,$row);

	}
	
	$sql->close();	

	echo json_encode($output);
	
	mysqli_close($link);
	
?>