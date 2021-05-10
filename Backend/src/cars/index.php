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
        case 'PUT':
            $carId = $_GET['carId'];
            decreaseQuantity($carId);
            break;
        case 'POST':
            rentCar();
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

    function rentCar() {
        global $con;
        $post_vars = json_decode(file_get_contents("php://input"),true);
        $uid = intval($post_vars['uid']);
        if (empty($uid)) {
            $response = "Jelentkezzen be a funkció használatához!";
            echo json_encode($response);
            return;
        }
        $carId = intval($post_vars['cid']);
        $rentTime = $post_vars['rental_time'];
        $price = intval($post_vars['rental_price']);
        $dateNow = date('Y-m-d',time());
        $rentDate = empty($rentTime) ? $dateNow : $rentTime;
        $query = "INSERT INTO rented_cars SET uid = ".$uid.", cid = ".$carId.", rental_time = '".$rentDate."', rental_price =".$price;
        $response = "error";
        if (mysqli_query($con, $query)) {
            $response = "success";
        }
        header("Content-Type: application/json");
        echo json_encode($response);
    }

    function decreaseQuantity($carId){
        global $con;
        $query = "UPDATE cars SET quantity = quantity-1 WHERE id=".$carId." AND quantity>0 LIMIT 1";
        $response = "error";
        if (mysqli_query($con, $query)) {
            $response = "success";
        }
        header("Content-Type: application/json");
        echo json_encode($response);
    }
?>