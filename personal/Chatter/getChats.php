<?php
require_once __DIR__ . '/config.php';

	$link = mysqli_connect($server,$user,$password,$db);
	
	$username = $_REQUEST["username"];
	
	$output = array();
	$sql = "SELECT * FROM $username";
	$result = mysqli_query($link,$sql);
	while ($row = $result->fetch_assoc()){
		$output[] = $row ;
	}
	echo json_encode($output);
	
	mysqli_close($link);

?>