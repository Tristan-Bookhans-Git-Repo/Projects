<?php
require_once __DIR__ . '/config.php';

	$link = mysqli_connect($server,$user,$password,$db);
	
	$Username = $_REQUEST["username"];
	$OPass = $_REQUEST["oldpass"];
	$NPass = $_REQUEST["newpass"];
	
	if (strlen($Username)>10){
		$sql1 = $link->prepare("SELECT PER_PASSWORD FROM PERSON WHERE PER_EMAIL = ?;");
		$sql1->bind_param("s",$Username);
		$sql1->execute();
		$Pass = $sql1->get_result();
		$Pass = $Pass->fetch_assoc();
		$sql1->close();
		if (password_verify($OPass,$Pass['PER_PASSWORD'])){
			$Password = password_hash($NPass,PASSWORD_DEFAULT);
			$sql = $link->prepare("UPDATE PERSON SET PER_PASSWORD = ? WHERE PER_EMAIL = ?;");
			$sql->bind_param("ss",$Password,$Username);
			$sql->execute();
			echo json_encode("Password updated");
			$sql->close();
		}else{
			echo json_encode("Invalid password");
		}
	}else{
		$sql1 = $link->prepare("SELECT PER_PASSWORD FROM PERSON WHERE PER_PHONE = ?;");
		$sql1->bind_param("s",$Username);
		$sql1->execute();
		$Pass = $sql1->get_result();
		$Pass = $Pass->fetch_assoc();
		$sql1->close();		if (password_verify($OPass,$Pass['PER_PASSWORD'])){
			$Password = password_hash($NPass,PASSWORD_DEFAULT);
			$sql = $link->prepare("UPDATE PERSON SET PER_PASSWORD = ? WHERE PER_PHONE = ?;");
			$sql->bind_param("ss",$Password,$Username);
			$sql->execute();
			echo json_encode("Password updated");
			$sql->close();
		}else{
			echo json_encode("Invalid password");
		}
	}
	
	mysqli_close($link);

?>
