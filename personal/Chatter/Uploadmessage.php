<?php
require_once __DIR__ . '/config.php';

	$link = mysqli_connect($server,$user,$password,$db);
	
	$chat = $_REQUEST["chat"];
	$message = $_REQUEST["message"];
	$sender = $_REQUEST["sender"];
	
	$sql = "INSERT INTO $chat VALUES ('$message','$sender')";
	mysqli_query($link,$sql);
	
	mysqli_close($link);

?>