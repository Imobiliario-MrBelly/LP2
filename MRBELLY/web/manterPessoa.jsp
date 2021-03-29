

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
                
            </div>
        </div>
        <!--Fim Menus-->

        <!--Content-->
        <div class="container conteudo">
            <div class="row">
                <div class="page-header">
                    <h1> Manter Pessoa - ${operacao}</h1>
                </div>

            </div>
            <div class="row">
                <div class="col-sm-12">
                    <form  method="post">

                        <div class="form-group">
                            <label for="txtCodPessoa">Código do Pessoa</label>
                            <input type="text" class="form-control" id="txtCodPessoa" name="txtCodPessoa" value="${pessoa.id}" readonly="">

                        </div>
                        <div class="form-group">
                            <label for="txtNome">Nome</label>
                            <input type="text" class="form-control" id="txtNome" name="txtNome" value="${pessoa.nome}"readonly>

                            </div>
                            <div class="form-group">
                                <label for="txtSobrenome">Sobrenome</label>
                                <input type="text" class="form-control" id="txtSobrenome" name="txtSobrenome" value="${pessoa.sobrenome}"readonly>                                                      
                            </div>
                            <div class="form-group">
                                <label for="txtRg">RG</label>
                                <input type="text" class="form-control" id="txtRg" name="txtRg" value="${pessoa.rg}" readonly>

                            </div>
                            <div class="form-group">
                                <label for="txtCpf">CPF</label>
                                <input type="text" class="form-control" id="txtCpf" name="txtCpf" value="${pessoa.cpf}" readonly>                                                      
                            </div>
                            <div class="form-group">
                                <label  for="txtSexo">Sexo</label>

                                <select class="form-control" id="txtSexo" name="txtSexo" readonly>
                                    <option value="M" <c:if test="${pessoa.sexo=='M'}">selected=""</c:if>>Masculino</option>
                                    <option value="F" <c:if test="${pessoa.sexo=='F'}">selected=""</c:if>>Feminimo</option>
                                    <option value="O" <c:if test="${pessoa.sexo=='O'}">selected=""</c:if>>Outros</option>
                                </select> 
                            </div>
                            <div class="form-group">
                                <label for="txtCadastro">Data de Cadastro</label>
                                <input type="text" class="form-control" id="txtCadastro" name="txtCadastro" value="${pessoa.dataCadastro}" readonly>                                                      
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