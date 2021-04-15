<?php
    include("../config/config.php");
    $db = new dbObj();
    $con = $db->getConnection();
    $requestMethod = $_SERVER['REQUEST_METHOD'];
    switch ($requestMethod) {
        case 'GET':
            login($_GET['email'], $_GET['password']);
            break;
        
        default:
            break;
    }

    function login($email, $password) {
        global $con;
        $query = "SELECT id FROM rental_db.users WHERE email ='".$email."' AND password='".$password."'";
        $response = array("id" => -1 , "status"=>"error");
        $result = mysqli_query($con, $query);
        while ($row=mysqli_fetch_array($result)) {
            $response["id"] = (int)$row["id"] ;
            $response["status"] = "success";
        }
        echo json_encode($response);
}
?>