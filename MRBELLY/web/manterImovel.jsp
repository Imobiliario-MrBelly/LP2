<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <!DOCTYPE html>
            <html lang="pt-br">

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Contratos</title>
                <link rel="icon" href="./css/img/Fav icon.svg" type="image/svg" />
                <link rel='stylesheet' href='./css/utilities/bootstrap.css'>
                <link rel="stylesheet" href="./css/main.css">
            </head>

            <body>

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
                        <div class="mb-4"><a href="pesquisaLogin.jsp" class="quickBold  ">LOGINS</a></div>
                        <div class="mb-4"><a href="pesquisaContrato.jsp" class="quickBold ativo">CONTRATOS</a></div>
                        <div class="mb-4"><a href="pesquisaEndereco.jsp" class="quickBold ">ENDEREÇOS</a></div>
                        <div class="mb-4"><a href="pesquisaImovel.jsp" class="quickBold ">IMOVEIS</a></div>
                        <div class="mb-4"><a href="pesquisaLocador.jsp" class="quickBold  ">LOCADORES</a></div>
                        <div class="mb-4"><a href="pesquisaLocatario.jsp" class="quickBold ">LOCATARIOS</a></div>
                        <div class="mb-4"><a href="pesquisaPessoa.jsp" class="quickBold ">PESSOAS</a></div>
                        <div class="mb-4"><a href="pesquisaTelefone.jsp" class="quickBold ">TELEFONES</a></div>
                    </div>
                </div>
                <!--Fim Menus-->



                <div class="container conteudo">
                    <h3 class="quickBold my-4">Manter imovel - ${operacao}</h3>
                    <hr>
                    <div class="row">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">LOCADOR</th>
                                    <th scope="col">LOCATÁRIO</th>
                                    <th scope="col">INÍCIO</th>
                                    <th scope="col">TÉRMINO</th>
                                    <th scope="col">VALOR</th>

                                    <th colspan="2" scope="col"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${Contratos}" var="contrato">
                                    <tr>
                                        <th scope="row">
                                            <c:out value="${contrato.id}" />
                                        </th>
                                        <th scope="row">
                                            <c:out value="${contrato.imovel.getLocador().getPessoa().getNome()}" />
                                        </th>
                                        <th scope="row">
                                            <c:out value="${contrato.locatario.getPessoa().getNome()}" />
                                        </th>
                                        <th scope="row">
                                            <c:out value="${contrato.dataInicio}" />
                                        </th>
                                        <th scope="row">
                                            <c:out value="${contrato.dataFim}" />
                                        </th>
                                        <th scope="row">
                                            <c:out value="${contrato.valor}" />
                                        </th>

                                        <td><button>Editar</button></td>
                                        <td><button>Excluir</button></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <button>Adicionar</button>
                    </div>
                </div>

                <script src='./js/utilities/bootstrap.js'></script>
                <script src='./js/utilities/jquery-3.5.1.js'></script>
                <script src='./js/main.js'></script>
            </body>

            </html>