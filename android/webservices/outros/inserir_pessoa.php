<?php 

include_once("config.php");

$mysqli = new mysqli(DATABASE_HOST, DATABASE_USER, DATABASE_PWD, DATABASE_NAME);

$json['result'] = null;
 
if($_SERVER['REQUEST_METHOD'] == "POST"){
	$nome = $_POST['nome_pessoa'];
	$telefone = $_POST['telefone_pessoa'];
	
	$res = $mysqli->query("INSERT INTO PESSOA (nome, telefone) VALUES ('$nome', '$telefone') ");
	
	$json['result'] = true;


}

echo json_encode($json);


?>