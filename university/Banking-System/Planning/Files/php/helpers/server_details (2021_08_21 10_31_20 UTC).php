<?php
// Load environment variables from .env file
$envFile = __DIR__ . '/.env';
if (file_exists($envFile)) {
    $lines = file($envFile, FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
    foreach ($lines as $line) {
        if (strpos(trim($line), '#') === 0) continue;
        list($key, $value) = explode('=', $line, 2);
        $_ENV[trim($key)] = trim($value);
    }
}

$serverName = $_ENV['DB_HOST'] ?? '';
$serverUsername = $_ENV['DB_USER'] ?? '';
$serverPassword = $_ENV['DB_PASSWORD'] ?? '';
$dbName = $_ENV['DB_NAME'] ?? '';
$serverPort = $_ENV['DB_PORT'] ?? '3306';

// Create connection
$conn = new mysqli($serverName, $serverUsername, $serverPassword, $dbName, $serverPort);

// Check connection
if ($conn->connect_error) {
    echo json_encode(
        array(
            array("error" => "Connection Failed", "status" => FALSE)
        )
    );
    return;
}
?>
