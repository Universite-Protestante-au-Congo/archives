<?php
require 'altorouter/AltoRouter.php';
$router = new AltoRouter();
$router->setBasePath('/auth');



$router->map('GET','/sign_in',function(){ 
	require 'controllers/CoSignIn.php';
});

$router->map('GET','/inscription',function(){ 
	require 'controllers/CoInscription.php';
});


$match = $router->match();
if(is_array($match) && is_callable($match['target']))
{
	call_user_func_array($match['target'],$match['params']);
}else
{
	echo "Route inconnue";

}