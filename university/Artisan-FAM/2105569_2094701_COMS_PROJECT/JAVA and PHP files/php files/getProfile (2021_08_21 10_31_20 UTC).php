<?php
require_once __DIR__ . '/config.php';
	$username = $user;

	$link = mysqli_connect($server,$username,$password,$db);
	
	$user_id = $_REQUEST["user"];
	
	if (strlen($user_id)>10){
		$request1 = $link->prepare("SELECT USER_TYPE FROM PERSON WHERE PER_EMAIL = ?");
		$request1->bind_param("s",$user_id);
		$request1->execute();
		$res1 = $request1->get_result();
		$user = $res1->fetch_assoc();
		$request1->close();
		if ($user['USER_TYPE'] == "C"){
			$req = $link->prepare("SELECT PER_FNAME,PER_SNAME,PER_PHONE,PER_EMAIL,USER_TYPE FROM PERSON WHERE PER_EMAIL = ?");
			$req->bind_param("s",$user_id);
			$req->execute();
			$res = $req->get_result();
			$out = $res->fetch_assoc();
			$req->close();
			echo json_encode($out);
		}else{
			$req1 = $link->prepare("SELECT PERSON.PER_FNAME,PERSON.PER_SNAME,PERSON.PER_PHONE,PERSON.PER_EMAIL,PERSON.USER_TYPE,ARTISAN.ART_TYPE,ARTISAN.ART_BUSINESS_NAME,ARTISAN.DESCRIPTION,ARTISAN.AVG_RATING FROM PERSON INNER JOIN ARTISAN ON PERSON.PER_ID = ARTISAN.PER_ID WHERE PER_EMAIL = ?");
			$req1->bind_param("s",$user_id);
			$req1->execute();
			$res12 = $req1->get_result();
			$out1 = $res12->fetch_assoc();
			$req1->close();
			echo json_encode($out1);
		}
	}else{
		$request1 = $link->prepare("SELECT USER_TYPE FROM PERSON WHERE PER_PHONE = ?");
		$request1->bind_param("s",$user_id);
		$request1->execute();
		$res1 = $request1->get_result();
		$user = $res1->fetch_assoc();
		$request1->close();
		if ($user['USER_TYPE'] == "C"){
			$req = $link->prepare("SELECT PER_FNAME,PER_SNAME,PER_PHONE,PER_EMAIL,USER_TYPE FROM PERSON WHERE PER_PHONE = ?");
			$req->bind_param("s",$user_id);
			$req->execute();
			$res = $req->get_result();
			$out = $res->fetch_assoc();
			$req->close();
			echo json_encode($out);
		}else{
			$req1 = $link->prepare("SELECT PERSON.PER_FNAME,PERSON.PER_SNAME,PERSON.PER_PHONE,PERSON.PER_EMAIL,PERSON.USER_TYPE,ARTISAN.ART_TYPE,ARTISAN.ART_BUSINESS_NAME,ARTISAN.DESCRIPTION,ARTISAN.AVG_RATING FROM PERSON INNER JOIN ARTISAN ON PERSON.PER_ID = ARTISAN.PER_ID WHERE PER_PHONE = ?");
			$req1->bind_param("s",$user_id);
			$req1->execute();
			$res12 = $req1->get_result();
			$out1 = $res12->fetch_assoc();
			$req1->close();
			echo json_encode($out1);
		}
	}
	
	mysqli_close($link);
	
?>