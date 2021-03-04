<?php 

$host = 'db'; // service name from docker-compose.yml
$user = 'devuser';
$password = 'devpass';
$db =  'rental_db';

$conn = new mysqli($host,$user,$password,$db);
if($conn->connect_error){
    echo 'connection failed' . $conn->connect_error;
    exit;
}
echo 'Succesfully connected to MySQL';