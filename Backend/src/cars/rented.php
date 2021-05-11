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
        $query = "SELECT rental_db.cars.brand,
                        rental_db.cars.type,
                        rental_db.cars.image,
                        rental_db.rented_cars.rental_time,
                        rental_db.rented_cars.rental_price
                    FROM rental_db.cars 
                    INNER JOIN rented_cars ON cars.id = rented_cars.cid 
                    Where rented_cars.uid =".$uid;
        $response = array();
        $result = mysqli_query($con, $query);
        while ($row=mysqli_fetch_array($result)) {
            $response[] = $row;
        }

        echo json_encode($response);
    }

    ?>