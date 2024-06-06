<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page Under Maintenance</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Arial', sans-serif;
        }

        body {
            background-color: #f3f4f6;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #333;
        }

        .maintenance-container {
            text-align: center;
            padding: 40px 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            background-color: #fff;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }

        .maintenance-content h1 {
            font-size: 2.5em;
            margin-bottom: 20px;
        }

        .maintenance-content p {
            font-size: 1.2em;
            margin-bottom: 20px;
        }

        .loader {
            border: 8px solid #f3f4f6;
            border-top: 8px solid #3498db;
            border-radius: 50%;
            width: 60px;
            height: 60px;
            animation: spin 2s linear infinite;
            margin: 0 auto;
        }

        @keyframes spin {
            0% {
                transform: rotate(0deg);
            }
            100% {
                transform: rotate(360deg);
            }
        }
    </style>
</head>
<body>
<jsp:include page="adminBar.jsp" />
    <div class="maintenance-container">
        <div class="maintenance-content">
            <h1>We'll Be Back Soon!</h1>
            <p>Our website is currently undergoing maintenance. We should be back shortly. Thank you for your patience.</p>
            <div class="loader"></div>
        </div>
    </div>
</body>
</html>
