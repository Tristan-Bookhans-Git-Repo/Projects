<?php
require_once __DIR__ . '/config.php';

	$link = mysqli_connect($server,$user,$password,$db);
	
	$Comment = $_REQUEST['comm'];
	$Rate = $_REQUEST['rate'];
	$User = $_REQUEST['username'];
	$Art = $_REQUEST['artisan'];
	
	$Cus_id = "";
	$Art_id = "";
	
	if (strlen($User) >10){
		$sql = $link->prepare("SELECT CUSTOMER.CUS_ID FROM CUSTOMER INNER JOIN PERSON ON CUSTOMER.PER_ID=PERSON.PER_ID WHERE PER_EMAIL = ?");
		$sql->bind_param("s",$User);
		$sql->execute();
		$Cus_id = $sql->get_result();
		$sql->close();
	}
	else{
		$sql = $link->prepare("SELECT CUSTOMER.CUS_ID FROM CUSTOMER INNER JOIN PERSON ON CUSTOMER.PER_ID=PERSON.PER_ID WHERE PER_PHONE = ?");
		$sql->bind_param("s",$User);
		$sql->execute();
		$Cus_id = $sql->get_result();
		$sql->close();
	}
	
	if (strlen($Art) >10){
		$sql = $link->prepare("SELECT ART_ID FROM ARTISAN INNER JOIN PERSON ON ARTISAN.PER_ID=PERSON.PER_ID WHERE PER_EMAIL = ?");
		$sql->bind_param("s",$Art);
		$sql->execute();
		$Art_id = $sql->get_result();
		$sql->close();
	}
	else{
		$sql = $link->prepare("SELECT ART_ID FROM ARTISAN INNER JOIN PERSON ON ARTISAN.PER_ID=PERSON.PER_ID WHERE PER_PHONE = ?");
		$sql->bind_param("s",$Art);
		$sql->execute();
		$Art_id = $sql->get_result();
		$sql->close();
	}
	
	$Cus_id = $Cus_id->fetch_assoc();
	$Art_id = $Art_id->fetch_assoc();
	$CUS = $Cus_id['CUS_ID'];
	$ART = $Art_id['ART_ID'];
	
	$sql = $link->prepare("INSERT INTO CUS_COMMENTS(CUS_ID,ART_ID,COMMENTS,RATING) VALUES(?,?,?,?)");
	$sql->bind_param("iisi",$CUS,$ART,$Comment,$Rate);
	if ($sql->execute()){
		echo json_encode("Comment saved");
	}else{
		echo json_encode("You have not hired this artisan");
	}
	$sql->close();
	
	mysqli_close($link);

?>