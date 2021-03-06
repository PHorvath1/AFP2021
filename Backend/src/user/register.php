<?php
    require_once "../config/config.php";
    $db = new dbObj();
    $con = $db->getConnection();
    $requestMethod = $_SERVER['REQUEST_METHOD'];
    switch ($requestMethod) {
        case 'POST':
            register();
            break;
        
        default:
            break;
    }



    function register(){
        global $con;
        $post_vars = json_decode(file_get_contents("php://input"),true);
        $name = $post_vars['Name'];
        $email = $post_vars['Email'];
        $password = $post_vars['Password'];
        $address = $post_vars['Address'];
        $phone_number = $post_vars['PhoneNumber'];
        $query = "INSERT INTO users (name,email,password,address,phone_number) VALUES ($name, $email, $password, $address, $phone_number)";
        if (mysqli_query($con, $query)) {
            $response = "Sikeres regisztráció";
        } else {
            $response = "Hiba a regisztráció során";
        }
        header('Content-Type: application/json');
        echo json_encode($response);

    }
?>