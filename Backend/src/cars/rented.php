<?php
    include("../config/config.php");
    $db = new dbObj();
    $con = $db->getConnection();

    $requestMethod = $_SERVER['REQUEST_METHOD'];
    switch ($requestMethod){
        case 'GET':
            $uid = $_GET['uid'];
            getRentedCars($uid);
            break;
    }

    function getRentedCars($uid){
        if (empty($uid)) {
            $response = "Jelentkezzen be a funkció használatához!";
            echo json_encode($response);
            return;
        }
        global $con;
        $query = "SELECT * FROM rental_db.rented_cars WHERE uid=".$uid;
        $response = array();
        $result = mysqli_query($con, $query);
        while ($row=mysqli_fetch_array($result)) {
            $response[] = $row;
        }
        echo json_encode($response);
    }

    ?>