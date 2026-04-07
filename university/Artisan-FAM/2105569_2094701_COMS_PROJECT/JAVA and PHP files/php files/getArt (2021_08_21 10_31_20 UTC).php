<?php
require_once __DIR__ . '/config.php';

	$link = mysqli_connect($server,$user,$password,$db);
	
	$output = array();
	$sql = "SELECT PERSON.PER_FNAME,PERSON.PER_SNAME,PERSON.PER_PHONE,PERSON.PER_EMAIL,ARTISAN.ART_TYPE,ARTISAN.ART_BUSINESS_NAME,ARTISAN.DESCRIPTION,ARTISAN.AVG_RATING FROM PERSON INNER JOIN ARTISAN ON PERSON.PER_ID = ARTISAN.PER_ID ORDER BY ARTISAN.AVG_RATING DESC";
	$result = mysqli_query($link,$sql);
	while ($row = $result->fetch_assoc()){
		$output[] = $row ;
	}
	echo json_encode($output);
	
	mysqli_close($link);

?>