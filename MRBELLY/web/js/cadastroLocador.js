window.onload = iniciarPagina;

function iniciarPagina() {
    document.getElementById("etapa1").style.display = 'block';
    document.getElementById("etapa2").style.display = 'none';
    document.getElementById("etapa3").style.display = 'none';
    document.getElementById("etapa4").style.display = 'none';

    document.getElementById("pessoaFisica").checked = true;
    document.getElementById("pessoaJuridica").checked = false;
    tipo(document.getElementById("pessoaFisica").value);
}
function tipo(pessoa) {
    if (pessoa == "fisica") {
        document.getElementById("quadroPessoaFisica").style.display = 'block';
        document.getElementById("quadroPessoaJuridica").style.display = 'none';
    } else if (pessoa == "juridica") {
        document.getElementById("quadroPessoaFisica").style.display = 'none';
        document.getElementById("quadroPessoaJuridica").style.display = 'block';
    }

}
function mudarQuadro(destino) {
    if (destino == "voltarPara1") {
        document.getElementById("etapa1").style.display = 'block';
        document.getElementById("etapa2").style.display = 'none';
        document.getElementById("etapa3").style.display = 'none';
        document.getElementById("etapa4").style.display = 'none';

        document.getElementById("numeroEtapa").innerHTML = "Etapa 1 de 4";

    } else if (destino == "irPara2" || destino == "voltarPara2") {
        document.getElementById("etapa1").style.display = 'none';
        document.getElementById("etapa2").style.display = 'block';
        document.getElementById("etapa3").style.display = 'none';
        document.getElementById("etapa4").style.display = 'none';

        document.getElementById("numeroEtapa").innerHTML = "Etapa 2 de 4";

    } else if (destino == "irPara3" || destino == "voltarPara3") {
        document.getElementById("etapa1").style.display = 'none';
        document.getElementById("etapa2").style.display = 'none';
        document.getElementById("etapa3").style.display = 'block';
        document.getElementById("etapa4").style.display = 'none';

        document.getElementById("numeroEtapa").innerHTML = "Etapa 3 de 4";

    } else if (destino == "irPara4") {
        document.getElementById("etapa1").style.display = 'none';
        document.getElementById("etapa2").style.display = 'none';
        document.getElementById("etapa3").style.display = 'none';
        document.getElementById("etapa4").style.display = 'block';

        document.getElementById("numeroEtapa").innerHTML = "Etapa 4 de 4";

    }
}