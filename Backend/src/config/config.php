<?php 

class dbObj{
    var $host = 'db'; // service name from docker-compose.yml
    var $user = 'devuser';
    var $password = 'devpass';
    var $db = 'rental_db';
    var $conn;

    function getConnection(){
        $con = mysqli_connect($this->host,$this->user,$this->password,$this->db) or die("Connection failed: ".mysqli_connect_error());
        if(mysqli_connect_errno()){
            echo 'Connection failed, ' . mysqli_connect_error();
            exit;
        }
        else {
            //echo 'Succesfully connected to MySQL';
            $this->conn = $con;
        }
        return $this->conn;
    }
}    
?>