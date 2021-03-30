<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - MR. Belly</title>
    <link rel="icon" type="imagem/svg" href="../client/css/img/Fav icon.svg" />
    <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/utilities/bootstrap.css">
    <script src='./js/utilities/jquery-3.5.1.js'></script>
    <script src="./js/main.js"></script>
    <script src="./js/utilities/bootstrap.js"></script>
</head>

<body class="img-background">
    <div class="">
        <div class="login-frame container px-5 pb-5 pt-4 col-md-8 col-lg-5 col-xl-3 col-sm-8">
            <div class="row mb-4 justify-content-center">
                <div class="justify-content-center col-md-12 logo">
                    <img src="./css/img/Logo.png" alt="Logo Mr. Belly">
                </div>
            </div>
            <form action="">
                <div class="row">
                    <div class="col-md-12 form-group">
                        <label for="email" class="roboto" style="color: #586E80; font-size: 16px;">E-mail</label>
                    </div>
                </div>
                <div class="row mb-4">
                    <div class="col-md-12">
                        <input required type="email" class="form form-control" name="email" id="email">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 form-group">
                        <label for="senha" class="roboto" style="color: #586E80; font-size: 16px;">Senha</label>
                    </div>
                </div>
                <div class="row mb-4">
                    <div class="col-md-12">
                        <input required type="password" class="form form-control" name="senha" id="senha">
                    </div>
                </div>
                <div class="row mb-4">
                    <div class="col-md-12">
                        <button type="submit" class="btn-full btn">Entrar</button>
                    </div>
                </div>
            </form>
            <div class="row mb-1">
                <div class="col-8 nTemConta">
                    <p class="roboto my-2 col-auto" style="color: #586E80;">Ainda não tem sua conta?</p>
                </div>
                <div class="col-4 line">
                    <hr class="mt-4">
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <button class="btn-outline btn" type="button" onclick="abrirPagina('./cadastroLocador.html')">Cadastrar</button>
                </div>
            </div>
        </div>
    </div>
</body>

</html>