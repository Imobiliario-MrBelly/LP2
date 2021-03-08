

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">

<<<<<<< HEAD
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>
        <link rel="icon" href="./css/img/Fav icon.svg" type="image/svg" />
        <link rel='stylesheet' href='./css/utilities/bootstrap.css'>
        <link rel="stylesheet" href="./css/main.css">
    </head>

    <body style="background-color: #f0f0f0;">

        <!--Menus-->
        <nav class="navbar nav-personalizado px-5 py-4">
            <a class="navbar-brand"><img src="../client/css/img/Logo home.png" alt=""></a>

            <div class="dropdown">
                <button class="btn dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Seu Barriga
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#">Sair</a>
                </div>
            </div>
        </nav>
        <div class="sidenav px-4 d-inline">
            <h5 class="quickBold mt-4">MENU</h5>
            <div class="my-5">
                <div class="mb-4"><a href="index.jsp" class="quickBold  ativo">INDEX</a></div>
                <div class="mb-4"><a href="pesquisaLogin.jsp" class="quickBold  ">LOGINS</a></div>
                <div class="mb-4"><a href="pesquisaContrato.jsp" class="quickBold ">CONTRATOS</a></div>
                <div class="mb-4"><a href="pesquisaEndereco.jsp" class="quickBold ">ENDEREÇOS</a></div>
                <div class="mb-4"><a href="pesquisaImovel.jsp" class="quickBold ">IMOVEIS</a></div>
                <div class="mb-4"><a href="pesquisaLocador.jsp" class="quickBold  ">LOCADORES</a></div>
                <div class="mb-4"><a href="pesquisaLocatario.jsp" class="quickBold ">LOCATARIOS</a></div>
                <div class="mb-4"><a href="pesquisaPessoa.jsp" class="quickBold ">PESSOAS</a></div>
                <div class="mb-4"><a href="pesquisaTelefone.jsp" class="quickBold ">TELEFONES</a></div>
            </div>
        </div>
        <!--Fim Menus-->

        <!--Content-->



        <!--Fim Content-->

        <script src='./js/utilities/bootstrap.js'></script>
        <script src='./js/utilities/jquery-3.5.1.js'></script>
        <script src='./js/main.js'></script>

    </body>
=======
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Home</title>
  <link rel="icon" href="./css/img/Fav icon.svg" type="image/svg" />
  <link rel='stylesheet' href='./css/utilities/bootstrap.css'>
  <link rel="stylesheet" href="./css/main.css">
</head>

<body style="background-color: #f0f0f0;">

  <!--Menus-->
  <nav class="navbar nav-personalizado px-5 py-4">
    <a class="navbar-brand"><img src="../client/css/img/Logo home.png" alt=""></a>

    <div class="dropdown">
      <button class="btn dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Seu Barriga
      </button>
      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        <a class="dropdown-item" href="#">Sair</a>
      </div>
    </div>
  </nav>
  <div class="sidenav px-4 d-inline">
    <h5 class="quickBold mt-4">MENU</h5>
    <div class="my-5">
         <div class="mb-4">
        <a href="index.jsp" class="quickBold  ativo">index</a>
      </div>
      <div class="mb-4">
        <a href="pesquisaLoginController" class="quickBold  ">Logins</a>
      </div>
      <div class="mb-4 d-inline-block">
        <a href="pesquisaContrato" class="quickBold ">Contratos</a>
      </div>
      <div class="mb-4">
        <a href="pesquisaEndereco" class="quickBold ">Endereços</a>
      </div>
      <div class="mb-4">
        <a href="pesquisaImoveis" class="quickBold ">Imoveis</a>
      </div>
        
        <div class="mb-4">
        <a href="pesquisaLocadores" class="quickBold  ">Locadores</a>
      </div>
      <div class="mb-4 d-inline-block">
        <a href="pesquisaLocatario" class="quickBold ">locatarios</a>
      </div>
      <div class="mb-4">
        <a href="meus-dados.html" class="quickBold ">pessoas</a>
      </div>
      <div class="mb-4">
        <a href="pesquisaTelefone" class="quickBold ">telefones</a>
      </div>

      

    </div>
  </div>
  <!--Fim Menus-->

  <!--Content-->

  

  <!--Fim Content-->

  <script src='./js/utilities/bootstrap.js'></script>
  <script src='./js/utilities/jquery-3.5.1.js'></script>
  <script src='./js/main.js'></script>

</body>
>>>>>>> parent of 58cf944 (finalização das páginas pesquisa e dos controllers)

</html>
