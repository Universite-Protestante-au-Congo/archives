<?php
declare(strict_types=1);
include("models/User.php");

use Firebase\JWT\JWT;
use PhpAmqpLib\Connection\AMQPStreamConnection;
use PhpAmqpLib\Message\AMQPMessage;

require_once('modules/vendor/autoload.php');



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


if (isset($_GET['username']) AND isset($_GET['password']) AND isset($_GET['name']))
{
	//Recuperations des infos envoyés
	$name = $_GET['name']; 
	$username = $_GET['username']; 
	$password = $_GET['password'];

	$user = User::inscrire($name,$username,$password);

	if($user)
	{
		echo "Inscription reussie !";
		//echo var_dump($user);
		print_r($user);

		$json_user = json_encode($user);
		//var_dump($json_user);

		//Envoie de l'utilisateur au service notation
		sendToBroker('auth.notation.user',$json_user);
	}



}
else
{
	echo "Tous les champs doivent être remplis";
}