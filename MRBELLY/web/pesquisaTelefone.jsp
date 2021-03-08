<%-- 
    Document   : pesquisaEndereco
    Created on : 28/02/2021, 18:41:43
    Author     : vinic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pesquisa Telefone</title>
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
<<<<<<< HEAD
                <div class="mb-4"><a href="index.jsp" class="quickBold">INDEX</a></div>
                <div class="mb-4"><a href="pesquisaLogin.jsp" class="quickBold  ">LOGINS</a></div>
                <div class="mb-4"><a href="pesquisaContrato.jsp" class="quickBold ">CONTRATOS</a></div>
                <div class="mb-4"><a href="pesquisaEndereco.jsp" class="quickBold ">ENDEREÇOS</a></div>
                <div class="mb-4"><a href="pesquisaImovel.jsp" class="quickBold ">IMOVEIS</a></div>
                <div class="mb-4"><a href="pesquisaLocador.jsp" class="quickBold  ">LOCADORES</a></div>
                <div class="mb-4"><a href="pesquisaLocatario.jsp" class="quickBold ">LOCATARIOS</a></div>
                <div class="mb-4"><a href="pesquisaPessoa.jsp" class="quickBold ">PESSOAS</a></div>
                <div class="mb-4"><a href="pesquisaTelefone.jsp" class="quickBold ativo">TELEFONES</a></div>
=======
                <div class="mb-4">
                    <a href="index.jsp" class="quickBold  ">index</a>
                </div>
                <div class="mb-4">
                    <a href="pesquisaLoginController" class="quickBold">Logins</a>
                </div>
                <div class="mb-4 d-inline-block">
                    <a href="inquilinos.html" class="quickBold ">Contratos</a>
                </div>
                <div class="mb-4">
                    <a href="pesquisaEndereco" class="quickBold ativo">Endereços</a>
                </div>
                <div class="mb-4">
                    <a href="configuracoes.html" class="quickBold ">Imoveis</a>
                </div>

                <div class="mb-4">
                    <a href="#" class="quickBold  ">Locadores</a>
                </div>
                <div class="mb-4 d-inline-block">
                    <a href="inquilinos.html" class="quickBold ">locatarios</a>
                </div>
                <div class="mb-4">
                    <a href="meus-dados.html" class="quickBold ">pessoas</a>
                </div>
                <div class="mb-4">
                    <a href="configuracoes.html" class="quickBold ">telefones</a>
                </div>



>>>>>>> parent of 58cf944 (finalização das páginas pesquisa e dos controllers)
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
                            <th scope="col">numero</th>
                            <th scope="col">descricao</th>
                            <th scope="col">nome</th>
                            
                            <th colspan="2" scope="col">acoes</th>
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
                                
                                <td><button>editar</button></td>
                                <td><button>excluir</button></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <button>Adicionar novo</button>
            </div></div>



        <!--Fim Content-->

        <script src='./js/utilities/bootstrap.js'></script>
        <script src='./js/utilities/jquery-3.5.1.js'></script>
        <script src='./js/main.js'></script>

    </body>

</html>