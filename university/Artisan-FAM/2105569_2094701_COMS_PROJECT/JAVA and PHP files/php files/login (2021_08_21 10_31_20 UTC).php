<?php
require_once __DIR__ . '/config.php';

	$link = mysqli_connect($server,$user,$password,$db);
	
	$Username = $_REQUEST["username"];
	$Password = $_REQUEST["password"];
	
	if (strlen($Username)<10){
		echo json_encode("Invalid username");
		exit(0);
	}
	
	if (strlen($Username)>10)
	{
		$email = $link->prepare("SELECT * FROM PERSON WHERE PER_EMAIL = ?");
		$email->bind_param("s",$Username);
		$email->execute();
		$passemail1 = $email->get_result();
		$passemail = $passemail1->fetch_assoc();
		global $Password;
		$email->close();
		if (password_verify($Password,$passemail['PER_PASSWORD'])){
			$request1 = $link->prepare("SELECT USER_TYPE FROM PERSON WHERE PER_EMAIL = ?");
			$request1->bind_param("s",$Username);
			$request1->execute();
			$request12 = $request1->get_result();
			$output1 = $request12->fetch_assoc();
			echo json_encode($output1['USER_TYPE']);
			$request1->close();
		}else{
			echo json_encode("Incorrect username or password");
		}
	}else{
		$phone = $link->prepare("SELECT * FROM PERSON WHERE PER_PHONE = ?");
		$phone->bind_param("s",$Username);
		$phone->execute();
		$passphone1 = $phone->get_result();
		$passphone = $passphone1->fetch_assoc();
		global $Password;
		$phone->close();
		if (password_verify($Password,$passphone['PER_PASSWORD'])){
			$request2 = $link->prepare("SELECT USER_TYPE FROM PERSON WHERE PER_PHONE = ?");
			$request2->bind_param("s",$Username);
			$request2->execute();
			$request22 = $request2->get_result();
			$output2 = $request22->fetch_assoc();
			echo json_encode($output2['USER_TYPE']);
			$request2->close();
		}else{
			echo json_encode("Incorrect username or password");
		}
	}
	
	mysqli_close($link);
?>
