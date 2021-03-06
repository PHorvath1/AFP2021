<?php 

class dbObj{
    var $host = 'db'; // service name from docker-compose.yml
    var $user = 'devuser';
    var $password = 'devpass';
    var $db = 'rental_db';
    var $conn;

    function getConnection(){
        $con = mysqli_connect($this->host,$this->user,$this->password,$this->db);
        if(mysqli_connect_errno()){
            echo 'Connection failed, ' . mysqli_connect_error();
            exit;
        }
        echo 'Succesfully connected to MySQL';
        $conn = $con;
        return $this->conn;
    }
}    
?>