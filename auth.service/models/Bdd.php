<?php
Class Bdd {
	 static public function bdd_connect()
	 {
	 	$bdd = new PDO('mysql:host=localhost;dbname=archives_auth','root','',array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION));
	 	return $bdd;
	 }

}