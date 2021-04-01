

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
                    <h1> Manter Locatário - ${operacao}</h1>
                </div>
            </div>
            <c:if test="${operacao=='Incluir'}">
            <div class="row" style="margin-top:20px;"><p id="mostrar">Nome do Locatário:</p></div>
            </c:if>
            <div class="row"> 
                <div class="container">
                    <br>
                    <div class="row">
                        <div class="col-sm-6" >
                            <button type="button" id="q1" onclick="q1()">Dados Pessoais</button>
                        </div>
                        <div class="col-sm-6">
                            <button type="button" id="q2" onclick="q2()">Login</button>
                        </div>
                    </div>
                    <style>
                        #q1, #q2, #q3{
                            border: 1px solid black;
                            width: 100%;
                            height: 40px;
                            border-radius: 5px;
                        }
                    </style>
                    <br>
                </div>
                <form action="ManterLocatario?acao=confirmarOperacao&operacao=${operacao}" method="post">
                    <div class="col-sm-12" id="quadro1">

                        <div class="form-group"> 
                            <input required type="text" class="form-control" id="txtCodLocatario" name="txtCodLocatario" value="${locatario.id}" readonly style="display:none">
                        </div>
                        <div class="form-group">
                            <label for="txtCodPessoa">Código Pessoa</label>
                            <input required type="text" class="form-control" id="txtCodPessoa" name="txtCodPessoa" value="${locatario.pessoa.id}" readonly>

                        </div>
                        <div class="form-group">
                            <label for="txtNome">Nome</label>
                            <input onblur="mostraNome()" required type="text" class="form-control" id="txtNome" name="txtNome" value="${locatario.pessoa.nome}" <c:if test="${operacao=='Excluir'}">readonly</c:if> maxlength="45">

                            </div>
                            <div class="form-group">
                                <label for="txtSobrenome">Sobrenome</label>
                                <input required type="text" class="form-control" id="txtSobrenome" name="txtSobrenome" value="${locatario.pessoa.sobrenome}" <c:if test="${operacao=='Excluir'}">readonly</c:if> maxlength="50">                                                      
                            </div>
                            <div class="form-group">
                                <label for="txtRg">RG</label>
                                <input required type="text" class="form-control" id="txtRg" name="txtRg" value="${locatario.pessoa.rg}" <c:if test="${operacao=='Excluir'}">readonly</c:if> maxlength="20">

                            </div>
                            <div class="form-group">
                                <label for="txtCpf">CPF</label>
                                <input required type="text" class="form-control" id="txtCpf" name="txtCpf" value="${locatario.pessoa.cpf}" <c:if test="${operacao=='Excluir'}">readonly</c:if> maxlength="11">                                                      
                            </div>
                            <div class="form-group">
                                <label  for="txtSexo">Sexo</label>

                                <select class="form-control" id="txtSexo" name="txtSexo" <c:if test="${operacao=='Excluir'}">readonly</c:if>>
                                <option value="M" <c:if test="${locatario.pessoa.sexo=='M'}">selected=""</c:if>>Masculino</option>
                                <option value="F" <c:if test="${locatario.pessoa.sexo=='F'}">selected=""</c:if>>Feminimo</option>
                                <option value="O" <c:if test="${locatario.pessoa.sexo=='O'}">selected=""</c:if>>Outros</option>
                                </select> 
                            </div>
                            <div class="form-group">
                                <label for="txtTelefone">Telefone</label>
                                <input required type="text" class="form-control" id="txtTelefone" name="txtTelefone" value="${locatario.pessoa.telefone}" <c:if test="${operacao=='Excluir'}">readonly</c:if> maxlength="11">                                                      
                            </div>

                        </div>


                        <div class="col-sm-12" id="quadro2">
                            <div class="form-group">
                                <label for="txtCodLogin">Código do Login</label>
                                <input required type="text" class="form-control" id="txtCodLogin" name="txtCodLogin" value="${locatario.login.id}" readonly>
                        </div>
                        <div class="form-group">
                            <label for="txtEmail">Email</label>
                            <input required type="text" class="form-control" id="txtEmail" name="txtEmail" value="${locatario.login.email}"<c:if test="${operacao=='Excluir'}">readonly</c:if> >
                            </div>
                            <div class="form-group">
                                <label for="txtSenha">Senha</label>
                                <input required type="text" class="form-control" id="txtSenha" name="txtSenha" value="${locatario.login.senha}"<c:if test="${operacao=='Excluir'}">readonly</c:if> >

                        </div>
                    </div>

                    <div class="form-group">
                        <br>
                        <button type="submit" class="btn btn-success">Confirmar</button>
                    </div>   
                </form>

            </div>
        </div>


        <!--Fim Content-->

        <script>
            window.onload = iniciarPagina;

            function iniciarPagina() {
                document.getElementById("quadro1").style.display = 'block';
                document.getElementById("quadro2").style.display = 'none';

                document.getElementById("q1").style.backgroundColor = '#ced4da';
                document.getElementById("q2").style.backgroundColor = '#fdfffc';

            }
            function q1() {
                document.getElementById("quadro1").style.display = 'block';
                document.getElementById("quadro2").style.display = 'none';

                document.getElementById("q1").style.backgroundColor = '#ced4da';
                document.getElementById("q2").style.backgroundColor = '#fdfffc';
            }
            function q2() {
                document.getElementById("quadro1").style.display = 'none';
                document.getElementById("quadro2").style.display = 'block';

                document.getElementById("q1").style.backgroundColor = '#fdfffc';
                document.getElementById("q2").style.backgroundColor = '#ced4da';
            }
        </script>
        <script src='./js/utilities/bootstrap.js'></script>
        <script src='./js/utilities/jquery-3.5.1.js'></script>
        <script src='./js/main.js'></script>
        <script>
            function mostraNome() {
                document.getElementById("mostrar").innerHTML = "Nome do Locatário: " + document.getElementById("txtNome").value;
            }
        </script>

    </body>

</html>