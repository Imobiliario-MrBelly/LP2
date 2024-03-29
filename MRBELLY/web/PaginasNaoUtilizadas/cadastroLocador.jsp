<!DOCTYPE html>
<html lang=pt-br>

<head>
    <meta charset='UTF-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    <title>Cadastro Locador</title>
    <link rel="icon" href="./css/img/Fav icon.svg" type="image/svg" />
    <link rel='stylesheet' href='./css/utilities/bootstrap.css'>
    <link rel="stylesheet" href="./css/main.css">
    <script src='./js/utilities/bootstrap.js'></script>
    <script src='./js/utilities/jquery-3.5.1.js'></script>
    <script src='./js/cadastroLocador.js'></script>
    <script src='./js/main.js'></script>
</head>

<body class="img-background">
    <div class='container-fluid h-100'>
        <div class='row justify-content-end geral'>
            <div class='col-md-4 py-4 px-4' style='background-color: #fdfffc;'>
                <div class='container'>
                    <div class='row justify-content-between'>
                        <div class='col-md-3'>
                            <h2 class="quickBold cadastroLocador">CADASTRO</h2>
                            <p id='numeroEtapa' class="roboto etapa">Etapa 1 de 1</p>
                        </div>
                        <div class='col-md-1 mx-3 my-1'>
                            <img src="../client/css/img/monograma.png" alt="">
                        </div>
                    </div>

                </div>
                <!---------------------------------------------------------------------------------------------------------------->
                <div id='etapa1'>
                    <div class='container h-100 mt-4'>
                        <div class="row mt-5 mb-5">
                            <P class="roboto" style="font-weight: bold;">Olá, bem vindo ao Mr. Belly!</P>
                            <p class="roboto" style="font-weight: bold;">Para se cadastrar, precisamos que nos dê algumas informações essenciais, vamos lá!?</p>
                        </div>
                        <div class='row'>
                            <div class='col-md-12'>
                                <label class="roboto" style="color: #586E80;" for='nome'>Nome</label>
                            </div>
                        </div>
                        <div class='row mb-4'>
                            <div class='col-md-12'>
                                <input required type='text' name='nome' id='nome'>
                            </div>
                        </div>
                        <div class='row'>
                            <div class='col-md-12'>
                                <label class="roboto" style="color: #586E80;" for='email'>E-mail</label>
                            </div>
                        </div>
                        <div class='row mb-4'>
                            <div class='col-md-12'>
                                <input required type='email' name='email' id='email'>
                            </div>
                        </div>
                        <div class='row mb-4'>
                            <div class='col-md-3'>
                                <label class="roboto" style="color: #586E80;" for='ddd'>DDD</label>
                                <input required type='text' name='ddd' id='ddd'>
                            </div>
                            <div class='col-md-4'>
                                <label class="roboto" style="color: #586E80;" for='numero'>Número</label>
                                <input required type='text' name='numero' id='numero'>
                            </div>
                            <div class='col-md-5'>
                                <label class="roboto " style="color: #586E80;" for='tipoTelefone'>Descrição</label>
                                <select class="px-2 " name='tipoTelefone' id='tipoTelefone'>
                                    <option class="roboto" style="color:#586E80" value=''>Nenhum Marcador</option>
                                    <option value='celular' class="roboto" style="color:#586E80">Celular</option>
                                    <option value='Trabalho' class="roboto" style="color:#586E80">Trabalho</option>
                                    <option value='Casa' class="roboto" style="color:#586E80">Casa</option>
                                    <option value='Empresarial' class="roboto" style="color:#586E80">Empresarial</option>
                                    <option value='Principal' class="roboto" style="color:#586E80">Principal</option>
                                </select>
                            </div>
                        </div>
                        <div class='row mt-4 mb-5 mx-1 d-flex'>
                            <div class='row col-md-6 align-items-center'>
                                <input required class="col-4" type='radio' name='tipoPessoa' id='pessoaFisica' value='fisica' onclick='tipo(this.value)'><label class="col-8" for='fisica'> Pessoa Fisica</label>
                            </div>
                            <div class='row col-md-6 align-items-center'>
                                <input required class="col-3" type='radio' name='tipoPessoa' id='pessoaJuridica' value='juridica' onclick='tipo(this.value)'><label class="col-9" for='juridica'> Pessoa Jurídica</label>
                            </div>
                        </div>
                        <div class='row justify-content-between d-flex align-content-end '>
                            <div class='col-md-6'>
                                <button class="btn-outline" type='button' id='voltar' onclick='abrirPagina("./login.html")'>Voltar</button>
                            </div>
                            <div class='col-md-6'>
                                <button class="btn-full" type='button' id='irPara2' value='irPara2' onclick='mudarQuadro(this.value)'>Próximo</button>
                            </div>

                        </div>
                    </div>
                </div>
                <!---------------------------------------------------------------------------------------------------------------->
                <div id='etapa2'>
                    <div class='container'>
                        <div class="row mt-5 mb-4">
                            <P class="roboto" style="font-weight: bold;">Estamos quase lá!</P>
                            <p class="roboto" style="font-weight: bold;">Agora precisamos de algumas informações sobre você.</p>
                        </div>
                        <div id='quadroPessoaFisica'>
                            <div class='row mb-4'>
                                <div class='col-md-12'>
                                    <label class="roboto" style="color: #586E80;" for='sobrenome'>Sobrenome</label>
                                </div>
                                <div class='col-md-12'>
                                    <input required type='text' name='sobrenome' id='sobrenome'>
                                </div>
                            </div>
                            <div class='row mb-4'>
                                <div class='col-md-12'>
                                    <label class="roboto" style="color: #586E80;" for='cpf'>CPF</label>
                                </div>
                                <div class='col-md-12'>
                                    <input required type='text' name='cpf' id='cpf'>
                                </div>
                            </div>
                            <div class='row mb-4'>
                                <div class='col-md-12'>
                                    <label class="roboto" style="color: #586E80;" for='rg'>RG</label>
                                </div>
                                <div class='col-md-12'>
                                    <input required type='text' name='rg' id='rg'>
                                </div>
                            </div>
                            <div class='row mb-4'>
                                <div class='col-md-12'><label class="roboto" style="color: #586E80;" for='nascimento'>Data de Nascimento</label></div>
                                <div class='col-md-12'>
                                    <input required class="px-2" type='date' name='nascimento' id='nascimento'>
                                </div>
                            </div>
                            <div class='row mt-2 mx-1'>
                                <div class='col-md-6 row align-items-center'>
                                    <input required class="col-2" type='radio' name='sexo' id='masculino' value='M'><label class="col-10" for='masculino'> Masculino</label>
                                </div>
                                <div class='row col-md-6 align-items-center'>
                                    <input required class="col-2" type='radio' name='sexo' id='feminino' value='F'><label class="col-10" for='feminino'> Feminino</label>
                                </div>
                            </div>
                        </div>
                        <div id='quadroPessoaJuridica'>
                            <div class=' mt-5 mb-4'>
                                <div class='col-md-12'>
                                    <label class="roboto" style="color: #586E80;" for='cnpj'>CNPJ</label>
                                </div>
                                <div class='col-md-12'>
                                    <input required type='text' name='cnpj' id='cnpj'>
                                </div>
                            </div>
                            <div class='row mb-4'>
                                <div class='col-md-12'>
                                    <label class="roboto" style="color: #586E80;" for='razaoSocial'>Razão Social</label>
                                </div>
                                <div class='col-md-12'>
                                    <input required type='text' name='razaoSocial' id='razaoSocial'>
                                </div>
                            </div>
                            <!-- Botão do modal -->
                            <div class='row mb-5'>
                                <div class='col-md-12 mt-4'>
                                    <button class="btn-outline" type='button' data-bs-toggle='modal' data-bs-target='#exampleModal'>
                                        Cadastrar Representante
                                    </button>
                                </div>
                            </div>
                            <!-- Modal -->
                            <div class='modal fade' id='exampleModal' tabindex='-1' aria-labelledby='exampleModalLabel' aria-hidden='true'>
                                <div class='modal-dialog'>
                                    <div class='modal-content'>
                                        <div class='modal-header'>
                                            <h5 class='quickBold' id='exampleModalLabel'>Cadastrar Representante</h5>
                                            <button type='button' class='btn-close' data-bs-dismiss='modal' aria-label='Close'></button>
                                        </div>
                                        <div class='modal-body'>
                                            <div class='row mb-3 mt-2'>
                                                <div class='col-md-12'>
                                                    <label class="roboto" style="color: #586E80;" for='nome'>Nome</label>
                                                </div>
                                                <div class='col-md-12'>
                                                    <input required type='text' name='nome' id='nome'>
                                                </div>
                                            </div>
                                            <div class='row my-3'>
                                                <div class='col-md-12'>
                                                    <label class="roboto" style="color: #586E80;" for='sobrenome'>Sobrenome</label>
                                                </div>
                                                <div class='col-md-12'>
                                                    <input required type='text' name='sobrenome' id='sobrenome'>
                                                </div>
                                            </div>
                                            <div class='row my-3'>
                                                <div class='col-md-12'>
                                                    <label class="roboto" style="color: #586E80;" for='cpf'>CPF</label>
                                                </div>
                                                <div class='col-md-12'>
                                                    <input required type='text' name='cpf' id='cpf'>
                                                </div>
                                            </div>
                                            <div class='row my-3'>
                                                <div class='col-md-12'>
                                                    <label class="roboto" style="color: #586E80;" for='rg'>RG</label>
                                                </div>
                                                <div class='col-md-12'>
                                                    <input required type='text' name='rg' id='rg'>
                                                </div>
                                            </div>
                                            <div class='row my-3'>
                                                <div class='col-md-12'><label class="roboto" style="color: #586E80;" for='nascimento'>Data de Nascimento</label></div>
                                                <div class='col-md-12'>
                                                    <input required class="px-2" type='date' name='nascimento' id='nascimento'>
                                                </div>
                                            </div>
                                            <div class='row mb-2 mt-3 mx-1'>
                                                <div class='col-md-6 row align-items-center'>
                                                    <input required class="col-2" type='radio' name='sexo' id='masculino' value='M'><label class="col-10" for='masculino'> Masculino</label>
                                                </div>
                                                <div class='col-md-6 row align-items-center'>
                                                    <input required class="col-2" type='radio' name='sexo' id='feminino' value='F'><label for='feminino' class="col-10"> Feminino</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class='modal-footer'>
                                            <div class='row mx-auto'>
                                                <div class='col-md-12'>
                                                    <button class="btn-full px-5" type='button' data-bs-dismiss='modal'>OK!</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class='row justify-content-between '>
                            <div class='col-md-6 '>
                                <button class="btn-outline" type='button' id='voltarPara1' value='voltarPara1' onclick='mudarQuadro(this.value)'>Voltar</button>
                            </div>
                            <div class='col-md-6'>
                                <button class="btn-full" type='button' id='irPara3' value='irPara3' onclick='mudarQuadro(this.value)'>Próximo</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!---------------------------------------------------------------------------------------------------------------->
                <div id='etapa3'>
                    <div class='container'>

                        <div class="row mt-5 mb-4">
                            <P class="roboto" style="font-weight: bold;"></P>
                            <p class="roboto" style="font-weight: bold;">Agora precisamos do seu endereço.</p>
                        </div>
                        <div class='row mb-3'>
                            <div class='col-md-12'>
                                <label class="roboto" style="color: #586E80;" for='cep'>CEP</label>
                            </div>
                            <div class='col-md-12'>
                                <input required name='cep' type='text' id='cep' value='' maxlength='9' onblur='pesquisaCep(this.value);'>
                            </div>
                        </div>
                        <div class='row mb-3'>
                            <div class='col-md-9'>
                                <label class="roboto" style="color: #586E80;" for='rua'>Logradouro</label>
                                <input required name='rua' type='text' id='rua'>
                            </div>
                            <div class='col-md-3 '>
                                <label for='complemento'>Nº</label>
                                <input required name='complemento' type='text' id='complemento'>
                            </div>
                        </div>
                        <div class='row mb-3'>
                            <div class='col-md-12'>
                                <label class="roboto" style="color: #586E80;" for='bairro'>Bairro</label>
                            </div>
                            <div class='col-md-12'>
                                <input required name='bairro' type='text' id='bairro'>
                            </div>
                        </div>
                        <div class='row mb-3'>
                            <div class='col-md-3'>
                                <label class="roboto" style="color: #586E80;" for='uf'>Estado</label>
                                <input required name='uf' type='text' id='uf'>
                            </div>
                            <div class='col-md-9'>
                                <label class="roboto" style="color: #586E80;" for='cidade'>Cidade</label>
                                <input required name='cidade' type='text' id='cidade'>
                            </div>
                        </div>
                        <div class='row'>
                            <div class='col-md-6'>
                                <button class="btn-outline" type='button' id='voltarPara2' value='voltarPara2' onclick='mudarQuadro(this.value)'>Voltar</button>
                            </div>
                            <div class='col-md-6'>
                                <button class="btn-full" type='button' id='irPara4' value='irPara4' onclick='mudarQuadro(this.value)'>Avançar</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!---------------------------------------------------------------------------------------------------------------->
                <div id="etapa4">
                    <div class=' container'>
                        <div class="row mt-5 mb-4">
                            <P class="roboto" style="font-weight: bold;">Última etapa!</P>
                            <p class="roboto" style="font-weight: bold;">Vamos criar uma senha de acesso.</p>
                        </div>
                        <div class='row'>
                            <div class='col-md-12'>
                                <label class="roboto" style="color: #586E80;" for='senha'>Insira uma senha</label>
                            </div>
                        </div>
                        <div class='row mb-3'>
                            <div class='col-md-12'>
                                <input required type="password" name="senha" id="senha">
                            </div>
                        </div>
                        <div class='row'>
                            <div class='col-md-12'>
                                <label class="roboto" style="color: #586E80;" for='senha'>Confirme a senha</label>
                            </div>
                        </div>
                        <div class='row mb-3'>
                            <div class='col-md-12'>
                                <input required type="password" name="confirmaSenha" id="connfirmaSenha">
                            </div>
                        </div>
                        <div class='row'>
                            <div class='col-md-6'>
                                <button class="btn-outline" type='button' id='voltarPara3' value='voltarPara3' onclick='mudarQuadro(this.value)'>Voltar</button>
                            </div>
                            <div class='col-md-6'>
                                <button class="btn-full" type='submit'>Avançar</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!---------------------------------------------------------------------------------------------------------------->
            </div>
        </div>
    </div>
</body>

</html>