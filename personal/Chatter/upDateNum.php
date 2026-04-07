<?php
require_once __DIR__ . '/config.php';

	$link = mysqli_connect($server,$user,$password,$db);
	
	$username = $_REQUEST["username"];
	$chat = $_REQUEST["chat"];
	$num = $_REQUEST["num"];
	$num = intval($num);
	
	$sql = "UPDATE $username SET NUMMESSAGES = $num WHERE CHATNAME = '$chat'";

	mysqli_query($link,$sql);
	
	mysqli_close($link);

?>