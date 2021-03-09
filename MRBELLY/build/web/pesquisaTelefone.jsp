<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Telefones</title>
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
                <div class="mb-4"><a href="index.jsp" class="quickBold">INDEX</a></div>
                <div class="mb-4"><a href="pesquisaLoginController" class="quickBold  ">LOGINS</a></div>
                <div class="mb-4"><a href="pesquisaContrato" class="quickBold ">CONTRATOS</a></div>
                <div class="mb-4"><a href="pesquisaEndereco" class="quickBold ">ENDEREÇOS</a></div>
                <div class="mb-4"><a href="pesquisaImovel" class="quickBold ">IMOVEIS</a></div>
                <div class="mb-4"><a href="pesquisaLocador" class="quickBold  ">LOCADORES</a></div>
                <div class="mb-4"><a href="pesquisaLocatario" class="quickBold ">LOCATARIOS</a></div>
                <div class="mb-4"><a href="pesquisaPessoa" class="quickBold ">PESSOAS</a></div>
                <div class="mb-4"><a href="pesquisaTelefone" class="quickBold ativo">TELEFONES</a></div>
            </div>
        </div>
        <!--Fim Menus-->

        <!--Content-->

        <div class="container conteudo">
            <div class="row">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">DDD</th>
                            <th scope="col">NÚMERO</th>
                            <th scope="col">DESCRIÇÃO</th>
                            <th scope="col">NOME</th>

                            <th colspan="2" scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${Telefones}" var="telefone">
                            <tr>
                                <th scope="row"><c:out value="${telefone.id}"/></th>
                                <td><c:out value="${telefone.ddd}"/></td>
                                <td><c:out value="${telefone.numero}"/></td>
                                <td><c:out value="${telefone.descricao}"/></td>
                                <td><c:out value="${telefone.pessoaId.getNome()}"/></td>
                                <td><a class="btn btn-sm btn-primary" href="ManterTelefone?acao=prepararOperacao&operacao=Editar&id=<c:out value="${telefone.id}"/>">Editar</a></td>
                                <td><a class="btn btn-sm btn-danger" href="ManterTelefone?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${telefone.id}"/>">Excluir</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <form action="ManterTelefone?acao=prepararOperacao&operacao=Incluir" method="post">
                    <input class="btn btn-success" type="submit" name="btnIncluir" value="Incluir">
                </form>

            </div></div>



        <!--Fim Content-->

        <script src='./js/utilities/bootstrap.js'></script>
        <script src='./js/utilities/jquery-3.5.1.js'></script>
        <script src='./js/main.js'></script>

    </body>

</html>