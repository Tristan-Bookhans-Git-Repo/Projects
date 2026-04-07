<?php
require_once __DIR__ . '/config.php';

	$link = mysqli_connect($server,$user,$password,$db);
	
	
	$chat = $_REQUEST["chat"];
	
	$output = array();
	$sql = "SELECT * FROM $chat";
	$result = mysqli_query($link,$sql);
	while ($row = $result->fetch_assoc()){
		$output[] = $row;
	}
	echo json_encode($output);
	
	mysqli_close($link);

?>