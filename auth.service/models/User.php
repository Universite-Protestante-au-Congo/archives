<?php
include("Bdd.php");

Class User
{


	//Fonction pour l'autentification
	static function authentifier($p_username,$p_password)
	{
		$response  = false;
		$bdd = Bdd::bdd_connect();
		$get_account = $bdd->prepare("SELECT * FROM users WHERE username = :username AND password = :password");
		$get_account->execute(array('username'=>$p_username,'password'=>$p_password));

		if($get_account->rowCount() == 1)
		{
			$response = $get_account->fetch();	
		}

		return $response;

	}

	//Fonction pour créer un utilisateur
	static function inscrire($name,$username,$password)
	{
		$bdd = Bdd::bdd_connect();
		$add_user = $bdd->prepare("INSERT INTO users(name,username,password) VALUES (:name,:username,:password)");
		
		$response = $add_user->execute(array('name' => $name,
								 'username' => $username,
								 'password' => $password));

		if($response)
		{
			$get_last_user = $bdd->query('SELECT * FROM users WHERE id_user = LAST_INSERT_ID()');
			$response = $get_last_user->fetchAll(PDO::FETCH_ASSOC);
		}


		return $response; 
	}

	//Enregistrer le token
	static function save_token($id_user,$token,$product_time,$expiration_time)
	{
		$response = false;
		$bdd = Bdd::bdd_connect();
		$product_time = time();
		$expiration_time = strtotime('+ 1 minute', $product_time);

		$add_token = $bdd->prepare("INSERT INTO tokens(id_user,token,product_time,expiration_time) VALUES (:id_user,:token,FROM_UNIXTIME(:product_time),FROM_UNIXTIME(:expiration_time))");
		
		$success = $add_token->execute(array('id_user' => $id_user,
								  'token' => $token,
								  'product_time' => $product_time,
								  'expiration_time' => $expiration_time)); 


		if($success)
		{
			$get_last_token = $bdd->query('SELECT * FROM tokens WHERE id_token = LAST_INSERT_ID()');
			$response = $get_last_token->fetchAll(PDO::FETCH_ASSOC);
			$response = json_encode($response[0]);		
		}

		return $response;
	}

	
}