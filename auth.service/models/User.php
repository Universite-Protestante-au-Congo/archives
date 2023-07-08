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
	static function save_token($token)
	{
		$response = false;
		$bdd = Bdd::bdd_connect();
		$crypted_token = sha1($token);
		$add_token = $bdd->prepare("INSERT INTO tokens(token) VALUES (:token)");
		
		if ( $add_token->execute(array('token'=>$crypted_token)) )
		{
			$response = $crypted_token;
		}

		return $crypted_token;
	}

	
}