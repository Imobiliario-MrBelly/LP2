function abrirPagina(link){
    window.location.href = link; 
}

function limparEndereco() {
    document.getElementById('rua').value = ("");
    document.getElementById('bairro').value = ("");
    document.getElementById('cidade').value = ("");
    document.getElementById('uf').value = ("");
}

function preencherEndereco(conteudo) {
    if (!("erro" in conteudo)) {
        document.getElementById('rua').value = (conteudo.logradouro);
        document.getElementById('bairro').value = (conteudo.bairro);
        document.getElementById('cidade').value = (conteudo.localidade);
        document.getElementById('uf').value = (conteudo.uf);
    } 
    else {
        limparEndereco();
        alert("CEP não encontrado.");
    }
}
function pesquisaCep(valor) {
    var cep = valor.replace(/\D/g, '');
    if (cep != "") {
        var validacep = /^[0-9]{8}$/;
        if (validacep.test(cep)) {
            document.getElementById('rua').value = "...";
            document.getElementById('bairro').value = "...";
            document.getElementById('cidade').value = "...";
            document.getElementById('uf').value = "...";

            var script = document.createElement('script');
            script.src = 'https://viacep.com.br/ws/' + cep + '/json/?callback=preencherEndereco';

            document.body.appendChild(script);

        } //end if.
        else {
            //cep é inválido.
            limparEndereco();
            alert("Formato de CEP inválido.");
        }
    } //end if.
    else {
        //cep sem valor, limpa formulário.
        limparEndereco();
    }
};
function limpar(string) {
    var novaString = "";
    for (var i = 0; i < sujo.length; i++) {
        if (string.charCodeAt(i) >= 48 && string.charCodeAt(i) <= 57) {
            novaString += string.charAt(i)
        };
    }
    return novaString;
}
function formatarCPF(cpf) {
    cpf = limpar(cpf);

    if (cpf.length < 4)
        return cpf;
    if (cpf.length < 7)
        return cpf.substr(0, 3) + '.' + cpf.substr(3, 3);
    if (cpf.length < 10)
        return cpf.substr(0, 3) + '.' + cpf.substr(3, 3) + '.' + cpf.substr(6, 3);
    if (cpf.length >= 10)
        return cpf.substr(0, 3) + '.' + cpf.substr(3, 3) + '.' + cpf.substr(6, 3)
            + '-' + cpf.substr(9, 2);
}