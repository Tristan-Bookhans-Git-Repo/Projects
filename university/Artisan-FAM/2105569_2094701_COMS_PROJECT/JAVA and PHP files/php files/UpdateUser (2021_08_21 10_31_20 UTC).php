<?php
require_once __DIR__ . '/config.php';
	$username = $user;

	$link = mysqli_connect($server,$username,$password,$db);

	$Fname = $_REQUEST["fname"];
	$Sname = $_REQUEST["sname"];
	$Phone = $_REQUEST["phone"];
	$Email = $_REQUEST["email"];
	$Des = $_REQUEST["description"];
	$User = $_REQUEST["user"];
	
		$emailcheck = $link->prepare("SELECT PER_ID FROM PERSON WHERE PER_EMAIL = ? && PER_EMAIL != ? && PER_EMAIL IS NOT NULL && PER_PHONE != ?");
		$emailcheck->bind_param("sss",$Email,$User,$User);
		$emailcheck->execute();
		$result2 = $emailcheck->get_result();
		if ($result2->num_rows > 0)
		{
			echo json_encode("Email address already linked to an account");
			exit(0);
		}
		$emailcheck->close();

		$phonecheck = $link->prepare("SELECT PER_ID FROM PERSON WHERE PER_PHONE = ? && PER_PHONE != ? && PER_PHONE IS NOT NULL && PER_EMAIL != ?");
		$phonecheck->bind_param("sss",$Phone,$User,$User);
		$phonecheck->execute();
		$result1 = $phonecheck->get_result();
		if ($result1->num_rows > 0)
		{
			echo json_encode("Phone number already linked to an account");
			exit(0);
		}
		$phonecheck->close();

		if (strlen($User)>10){
			$Update = $link->prepare("UPDATE PERSON SET PER_FNAME = ?,PER_SNAME = ?,PER_PHONE = ?,PER_EMAIL =? WHERE PER_EMAIL = ?;");
			$Update->bind_param("sssss",$Fname,$Sname,$Phone,$Email,$User);
			if ($Update->execute()){
				if ($Des != ""){
					$sql = $link->prepare("SELECT PER_ID FROM PERSON WHERE PER_EMAIL = ?");
					$sql->bind_param("s",$User);
					$sql->execute();
					$ID = $sql->get_result(); 
					$ID = $ID->fetch_assoc();
					$ID = $ID['PER_ID'];
					$UPDes = $link->prepare("UPDATE ARTISAN SET DESCRIPTION =? WHERE PER_ID = ?;");
					$UPDes->bind_param("si",$Des,$ID);
					$UPDes->execute();
					$UPDes->close();
					$sql->close();
				}
				echo json_encode("User Profile Updated");
			}
			$Update->close();
		}else{
			$Update = $link->prepare("UPDATE PERSON SET PER_FNAME = ?,PER_SNAME = ?,PER_PHONE = ?,PER_EMAIL =? WHERE PER_PHONE = ?;");
			$Update->bind_param("sssss",$Fname,$Sname,$Phone,$Email,$User);
			if ($Update->execute()){
				if ($Des != ""){
					$sql = $link->prepare("SELECT PER_ID FROM PERSON WHERE PER_PHONE = ?");
					$sql->bind_param("s",$User);
					$sql->execute();
					$ID = $sql->get_result(); 
					$ID = $ID->fetch_assoc();
					$ID = $ID['PER_ID'];
					$UPDes = $link->prepare("UPDATE ARTISAN SET DESCRIPTION =? WHERE PER_ID = ?;");
					$UPDes->bind_param("si",$Des,$ID);
					$UPDes->execute();
					$UPDes->close();
					$sql->close();	
				}
				echo json_encode("User Profile Updated");
			}
			$Update->close();
		}

	mysqli_close($link);
?>
