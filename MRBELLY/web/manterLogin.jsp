

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Manter Login</title>
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
                <div class="mb-4"><a href="index.jsp" class="quickBold  ">INDEX</a></div>
                <div class="mb-4"><a href="pesquisaLoginController" class="quickBold  ">LOGINS</a></div>
                <div class="mb-4"><a href="pesquisaContrato" class="quickBold ">CONTRATOS</a></div>
                <div class="mb-4"><a href="pesquisaEndereco" class="quickBold ">ENDEREÇOS</a></div>
                <div class="mb-4"><a href="pesquisaImovel" class="quickBold ">IMOVEIS</a></div>
                <div class="mb-4"><a href="pesquisaLocador" class="quickBold  ">LOCADORES</a></div>
                <div class="mb-4"><a href="pesquisaLocatario" class="quickBold ">LOCATARIOS</a></div>
                <div class="mb-4"><a href="pesquisaPessoa" class="quickBold ">PESSOAS</a></div>
                <div class="mb-4"><a href="pesquisaTelefone" class="quickBold ">TELEFONES</a></div>
            </div>
        </div>
        <!--Fim Menus-->

        <!--Content-->
 <div class="container conteudo">
            <div class="row">
                <div class="page-header">
                    <h1> Manter Login - ${operacao}</h1>
                </div>
                
            </div>
                <div class="row">
                    <div class="col-sm-8">
                        <form action="ManterLogin?acao=confirmarOperacao&operacao=${operacao}" method="post">
                        
                            <div class="form-group">
                                <label for="txtCodLogin">Código do Login</label>
                                <input type="text" class="form-control" id="txtCodLogin" name="txtCodLogin" value="${login.id}">
                                                                                     
                            </div>
                            <div class="form-group">
                                <label for="txtEmail">Email</label>
                                <input type="text" class="form-control" id="txtEmail" name="txtEmail" value="${login.email}"<c:if test="${operacao=='Excluir'}">disabled=""</c:if> >
                                                                                     
                            </div>
                            <div class="form-group">
                                <label for="txtSenha">Senha</label>
                                <input type="text" class="form-control" id="txtSenha" name="txtSenha" value="${login.senha}"<c:if test="${operacao=='Excluir'}">disabled=""</c:if> >
                                                                                     
                            </div>
                        </form>
                    </div>
                </div>
 </div>


        <!--Fim Content-->

        <script src='./js/utilities/bootstrap.js'></script>
        <script src='./js/utilities/jquery-3.5.1.js'></script>
        <script src='./js/main.js'></script>

    </body>

</html>