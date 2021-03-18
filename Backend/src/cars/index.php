<?php
    include("../config/config.php");
    $db = new dbObj();
    $con = $db->getConnection();
    $requestMethod = $_SERVER['REQUEST_METHOD'];
    switch ($requestMethod) {
        case 'GET':
            $uid = $_GET['uid'];

            if (!empty($_GET['carId'])) {
                $carId = $_GET['carId'];
                getCarInfo($uid, $carId);
            }
            else {
                listAvaibleCars($uid);
            }
            break;
        
        default:
            break;
    }

    function listAvaibleCars($uid) {
        if (empty($uid)) {
            $response = "Jelentkezzen be a funkció használatához!";
            echo json_encode($response);
            return;
        }

        global $con;
        $query = "SELECT id, brand, type, image FROM rental_db.cars WHERE quantity > 0";
        $response = array();
        $result = mysqli_query($con, $query);
        while ($row=mysqli_fetch_array($result)) {
            $response[] = $row;
        }
        echo json_encode($response);
    }

    function getCarInfo($uid, $carId) {
        if (empty($uid)) {
            $response = "Jelentkezzen be a funkció használatához!";
            echo json_encode($response);
            return;
        }
        global $con;
        $query = "SELECT * FROM rental_db.cars WHERE id =".$carId;
        $response = array();
        $result = mysqli_query($con, $query);
        while ($row=mysqli_fetch_array($result)) {
            $response[] = $row;
        }
        echo json_encode($response);
    }
?>