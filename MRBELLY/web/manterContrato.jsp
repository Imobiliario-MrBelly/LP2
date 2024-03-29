

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
        <nav class="navbar nav-personalizado fixed-top px-5 py-4">
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
                
            </div>
        </div>
        <!--Fim Menus-->

        <!--Content-->
        <div class="container conteudo">
            <div class="row">
                <div class="page-header">
                    <h1> Manter Contrato - ${operacao}</h1>
                </div>

            </div>
            <div class="row">
                <div class="col-sm-12">
                    <form action="ManterContrato?acao=confirmarOperacao&operacao=${operacao}" method="post">

                        <div class="form-group">
                            <label for="txtCodContrato">Código do Contrato</label>
                            <input required type="text" class="form-control" id="txtCodContrato" name="txtCodContrato" value="${contrato.id}" readonly>

                        </div>
                        <div class="form-group">
                            <div class="form-group">
                                <label for="txtImovel">Imovel:</label>
                                
                                <select name="txtImovel" id="txtImovel"<c:if test="${operacao=='Excluir'}">readonly tabindex="-1"</c:if>>
                                    <c:if test = "${operacao=='Incluir'}">
                                        <c:forEach items="${imoveis}" var="imovel">

                                            <option value="${imovel.id}"<c:if test="${imovel.id==contrato.imovel.id}">selected=""</c:if>>
                                                ${imovel.descricao}
                                            </option>

                                        </c:forEach>  
                                    </c:if>
                                    <c:if test = "${operacao!='Incluir'}">  
                                        <c:forEach items="${imoveis}" var="imovel">
                                            <c:if test="${imovel.locador.id==contrato.imovel.locador.id}">
                                                <option value="${imovel.id}"
                                                        <c:if test="${imovel.id==contrato.imovel.id}">selected=""</c:if>>
                                                    ${imovel.descricao}
                                                </option>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                </select>
                            </div>



                        </div>
                        <div class="form-group">
                            <label for="txtLocatario">Locatario:</label>
                            <select name="txtLocatario" id="txtLocatario" <c:if test="${operacao=='Excluir'}">readonly tabindex="-1"</c:if>>

                                <c:forEach items="${locatarios}" var="locatario">
                                    <option value="${locatario.id}"
                                            <c:if test="${locatario.id==contrato.locatario.id}">selected=""</c:if>>
                                        ${locatario.pessoa.nome} ${locatario.pessoa.sobrenome}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="txtInicio">Data de Início</label>
                            <input required type="date" class="form-control" id="txtInicio" name="txtInicio" value="${contrato.dataInicio}"<c:if test="${operacao=='Excluir'}">readonly</c:if>>

                            </div>
                            <div class="form-group">
                                <label for="txtFim">Data de Término</label>
                                <input required type="date" class="form-control" id="txtFim" name="txtFim" value="${contrato.dataFim}" <c:if test="${operacao=='Excluir'}">readonly</c:if>>

                            </div>
                            <div class="form-group">
                                <label for="txtValor">Valor</label>
                                <input required type="text" class="form-control" id="txtValor" name="txtValor" value="${contrato.valor}" <c:if test="${operacao=='Excluir'}">readonly</c:if>>

                        </div>
                        <div class="form-group">
                            <br>
                            <button type="submit" class="btn btn-success"> Confirmar</button> </div>        
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