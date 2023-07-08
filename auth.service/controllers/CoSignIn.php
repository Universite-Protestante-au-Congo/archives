<?php
declare(strict_types=1);
include("models/User.php");

use Firebase\JWT\JWT;
use PhpAmqpLib\Connection\AMQPStreamConnection;
use PhpAmqpLib\Message\AMQPMessage;

require_once('modules/vendor/autoload.php');


/*function sendTokenToBroker($token)
{

	$connection = new AMQPStreamConnection('localhost', 5672, 'guest', 'guest');
	$channel = $connection->channel();

	$channel->queue_declare('auth.work.token', false, true, false, false);
	$channel->queue_declare('auth.notation.token', false, true, false, false);

	$msg_token = new AMQPMessage($token);

	$channel->basic_publish($msg_token, '', 'auth.work.token');
	$channel->basic_publish($msg_token, '', 'auth.notation.token');


	echo "Le message a été envoyé au broker avec succès\n";
	$channel->close();
	$connection->close();

}*/

// Creation d'une fonction pour l'envoie du token au broker (paramètres : queue/message)
function sendToBroker($queue,$message)
{

	$connection = new AMQPStreamConnection('194.163.143.59', 5672, 'guest', 'guest');
	$channel = $connection->channel();
	$channel->queue_declare($queue, false, true, false, false);
	$msg = new AMQPMessage($message);
	$channel->basic_publish($msg, '',$queue);

	echo "Le message a été envoyé au broker avec succès\n";
	$channel->close();
	$connection->close();

}



if (isset($_GET['username']) AND isset($_GET['password']))
{

	//Recuperations des infos envoyés
	$username = $_GET['username']; 
	$password = $_GET['password'];


	// Connection 
	$data =  User::authentifier($username,$password);


	// Si les données existent dans la base de données
	if ($data != false)
	{
		//echo var_dump($data);

		$secret_Key  = '68V0zWFrS72GbpPreidkQFLfj4v9m3Ti+DXc8OB0gcM='; //Clé secrète
		$date   = new DateTimeImmutable(); //Date de creation du token
		$expire_at     = $date->modify('+6 minutes')->getTimestamp();      // Date d'expiration - Add 60 seconds
		$domainName = "auth.domain"; // Domaine
		$username   = utf8_encode($data['username']); // Username 
		$name = utf8_encode($data['name']);


		
		$request_data = [
		    'iat'  => $date->getTimestamp(),         // Temps auquel le token est generé
		    'iss'  => $domainName,                   // Issuer
		    'nbf'  => $date->getTimestamp(),         // Not before
		    'exp'  => $expire_at,                    // Expire
		    'username' => $username,  				// Username
		    'name'=> $name     						// Name          				
		];

	    // Encoder avec JWT
	    $token =  JWT::encode(
	        $request_data,
	        $secret_Key,
	        'HS512'
	    );

	    
	    $crypted_token = User::save_token($token);

	    if( $crypted_token != false)
	    {
			header('Authorization:'.$crypted_token);

			//Envoie du token au service notation
			sendToBroker('auth.work.token',$crypted_token); 

			//Envoie du token au service work
			sendToBroker('auth.work.work',$crypted_token);     	
	    }


	    echo "Token crypté avec SHA1 : ".$crypted_token."\n";
	    echo "Token en dur : ".$token."\n";



	}
	else
	{
		echo "Aucun utilisateur ne correspond";
	}

}