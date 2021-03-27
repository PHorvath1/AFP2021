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
        case 'UPDATE':
            $uid = $_GET['uid'];
            $carId = $_GET['carId'];
            rentCar($uid, $carId);
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

    function rentCar($uid, $carId) {
        if (empty($uid)) {
            $response = "Jelentkezzen be a funkció használatához!";
            echo json_encode($response);
            return;
        }

        global $con;
        $query = "UPDATE cars SET quantity = quantity-1 WHERE id=".$carId." AND quantity>0 LIMIT 1";
        $response = "error";
        if (mysqli_query($con, $query)) {
            if (moveToRentedCars($uid, $carId)) {
                $response = "success";
            }
        }
        echo json_encode($response);
    }

    function moveToRentedCars($uid, $carId) {
        global $con;
        $dateNow = date('Y-m-d',time());
        $rentTime = empty($_GET['rentTime']) ? 1 : $_GET['rentTime'];
        $date = strtotime("+".$rentTime." days", $dateNow);
        $price = getCarPrice($carId);
        $query = "INSERT INTO rented_cars SET uid=".$uid.", cid=".$carId.", rental_time=".$date.", price=".$price/$rentTime;
        if (mysqli_query($con, $query)) {
            return true;
        }
        return false;
    }

    function getCarPrice($carId) {
        global $con;
        $query = "SELECT price FROM cars WHERE id =".$carId;
        $response = array();
        $result = mysqli_query($con, $query);
        while ($row=mysqli_fetch_array($result)) {
            $response[] = $row;
        }
        return response['price'];
    }
    
?>