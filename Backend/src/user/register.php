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
        $name = $post_vars['name'];
        $email = $post_vars['email'];
        $password = $post_vars['password'];
        $address = $post_vars['address'];
        $phone_number = $post_vars['phonenumber'];
        $query = "INSERT INTO users SET name = '".$name."', email = '".$email."', password = '".$password."', address = '".$address."', phone_number = ".$phone_number." ";
        if (mysqli_query($con, $query)) {
            $response = "Sikeres regisztráció";
        } else {
            $response = "Hiba a regisztráció során";
        }
        header('Content-Type: application/json');
        echo json_encode($response);

    }
?>