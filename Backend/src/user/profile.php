<?php
    include("../config/config.php");
    $db = new dbObj();
    $con = $db->getConnection();
    $requestMethod = $_SERVER['REQUEST_METHOD'];
    switch ($requestMethod) {
        case 'GET':
            $uid = $_GET['uid'];
            show($uid);
            break;
        case 'UPDATE':
            $uid = $_GET['uid'];
            $oldPassword = $_GET['oldPassword'];
            $newPassword = $_GET['newPassword'];
            changePassword($uid, $oldPassword, $newPassword);
            break;
        default:
            break;
    }

    function show($uid) {
        global $con;
        $query = "SELECT id,name,email,address,phone_number FROM rental_db.users WHERE id =".$uid;
        $response = array("status"=>"error");
        $result = mysqli_query($con, $query);
        while ($row=mysqli_fetch_array($result)) {
            $response[] = $row;
            $response["status"] = "success";
        }
        echo json_encode($response);
    }

    function changePassword($uid, $oldPassword, $newPassword){
        global $con;
        $query = "UPDATE users SET password='".$newPassword."' WHERE id=".$uid." AND password='".$oldPassword."'";
        if (mysqli_query($con, $query)){
            $response = "success";
        }
        else {
            $response = "error";
        }
        echo json_encode($response);

    }

?>