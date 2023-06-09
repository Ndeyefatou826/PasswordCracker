<?php
$login = $_POST['login'];
$password = $_POST['password'];

if ($login == "admin" && $password == "passer") {
    http_response_code(200); // OK
} else {
    http_response_code(401); // Non autorisé
}
?>
