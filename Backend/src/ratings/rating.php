<?php
    require_once "../config/config.php";
    $db = new dbObj();
    $con = $db->getConnection();
    $requestMethod = $_SERVER['REQUEST_METHOD'];
    switch ($requestMethod) {
        case 'POST':
            rate($uid, $rating);
            break;
        
        default:
            break;
    }


    function rate($uid, $rating){

        global $con;
        $post_vars = json_decode(file_get_contents("php://input"),true);
        $rating = $post_vars['rating'];
        $query = "INSERT INTO ratings SET uid=".$_GET['id']." AND rating=".$rating;
        if (mysqli_query($con, $query)) {
            $response = "Sikeres értékelés";
        } else {
            $response = "Hiba az értékelés során";
        }
        header('Content-Type: application/json');
        echo json_encode($response);
    }
?>