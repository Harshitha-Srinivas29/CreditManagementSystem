<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <meta name = "viewport" content = "width=device-width, initial-scale = 1">
  <title>Credit Management System</title>

      <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@900&family=Ubuntu:wght@500&display=swap" rel="stylesheet">
      <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@500&display=swap" rel="stylesheet">

      <!-- css style sheets -->
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

      <!--bootstrap scripts-->
      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

       <style>
            body{
              font-family: 'Montserrat-Black';
              text-align: center;
              background-color: #1A1A1D;
               background-image: -webkit-linear-gradient(65deg,#C3073F 50%,#1A1A1D 50%);
               /* background-position: center; */
               /*background-size:cover;
               background-repeat:no-repeat;
               height: 100vh; */
               min-height: 1000px;
            }

            h1{
                /*color : #4E4E50; */
                color : #FFFF;
                font-family: 'Ubuntu', sans-serif;
            }


            .container-fluid{
              padding: 7% 15% ;
              background-size:cover;
              background-repeat:no-repeat;
              height: 100vh;
            }

            .bttn{
              margin : 10% 3% 5% 0;
              font-family: 'Montserrat-Black',sans-serif;
            }

       </style>

  </head>

  <body>
        <div class="container-fluid">
          <h1>Credit Management System</h1>

         <form:form method="POST" action="user" >
           <button type="submit" class="btn btn-outline-light btn-lg bttn">View Users</button>
         </form:form>

        </div>


  </body>
</html>
