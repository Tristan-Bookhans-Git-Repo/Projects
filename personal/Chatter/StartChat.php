<?php
require_once __DIR__ . '/config.php';

	$link = mysqli_connect($server,$user,$password,$db);
	
	$username = $_REQUEST["username"];
	$fname = $_REQUEST["fname"];
	$sname = $_REQUEST["sname"];
	$me = $_REQUEST["me"];
	$chat = null;
	
	if ($username>$me){
		$chat = $username.$me;
    }else{
        $chat = $me.$username;
    }
	
	$check = "SELECT * FROM $me WHERE CHATNAME = '$chat';";
	$result1 = mysqli_query($link,$check);
	if ($result1->num_rows > 0)
	{
		echo json_encode("Chat already Created");
		exit(0);
	}
	
	$sql = "INSERT INTO $me VALUES('$chat',0,'$fname','$sname')";
	mysqli_query($link,$sql);
	
	$sql = "SELECT * FROM USERS WHERE USERNAME = '$me'";
	$result = mysqli_query($link,$sql);
	$result = $result->fetch_assoc();
	$myname = $result['FNAME'];
	$mysurname = $result['SNAME'];
	
	$sql = "INSERT INTO $username VALUES('$chat',0,'$myname','$mysurname')";
	mysqli_query($link,$sql);
	
	$sql = "CREATE TABLE $chat(MESSAGES TEXT(65000),SENDER VARCHAR(100))";
	mysqli_query($link,$sql);
	
	echo ("Chat created");
	
	mysqli_close($link);

?>