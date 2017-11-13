<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>main-page</title>
    <meta http-equiv="Content-type" content="text/html" charset="UTF-8">
  </head>
  <body>
    <form action="FrontController" method="get">
        Name:
        <input id="1" type="text" name="name"/>
        <br/>
        Surname:
        <input id="2" type="text" name="surname"/>
        <br/>
        <input id="3" type="submit" value="Send"/>
    </form>

    <script>
        var nameField = document.getElementById("1");
        var surnameField = document.getElementById("2");
        var button = document.getElementById("3");

        button.addEventListener('click',function (e) {
            if(nameField.value == ""){
                e.preventDefault();
                nameField.focus();
            }else if(surnameField.value == ""){
                e.preventDefault();
                surnameField.focus();
            }
        })
    </script>

  </body>
</html>
