<?php 

include_once("config.php");

$mysqli = new mysqli(DATABASE_HOST, DATABASE_USER, DATABASE_PWD, DATABASE_NAME);

if ($mysqli->connect_errno) {
    echo "Failed to connect to MySQL: (" . $mysqli->connect_errno . ") " . $mysqli->connect_error;
}

$res = $mysqli->query("SELECT * FROM pessoa");

$json['list'] = array();

while ($row = $res->fetch_assoc()) {
	array_push($json['list'], $row);
    
}

echo json_encode($json);


?>