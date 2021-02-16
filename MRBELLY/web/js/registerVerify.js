function cpf(strCPF) {
  soma = 0;
  resto = 0;
  if (strCPF == "00000000000") return false;
  for (i = 1; i <= 9; i++) {
    soma = soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
  }
  resto = (soma * 10) % 11;
  if (resto == 10 || resto == 11) resto = 0;
  if (resto != parseInt(strCPF.substring(9, 10))) return false;
  soma = 0;
  for (i = 1; i <= 10; i++) {
    soma = soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
  }
  resto = (soma * 10) % 11;
  if (resto == 10 || resto == 11) resto = 0;
  if (resto != parseInt(strCPF.substring(10, 11))) return false;
  return true;
}
function testaValidador() {
  valor = document.getElementById("teste");

  console.log(cpf(valor.value));
}

function cnpj(strCNPJ) {
  strCNPJ = strCNPJ.replace(/[^\d]+/g, "");
  if (strCNPJ == "") {
    return false;
  }

  if (strCNPJ.length != 14) {
    return false;
  }
  if (
    strCNPJ == "00000000000000" ||
    strCNPJ == "11111111111111" ||
    strCNPJ == "22222222222222" ||
    strCNPJ == "33333333333333" ||
    strCNPJ == "44444444444444" ||
    strCNPJ == "55555555555555" ||
    strCNPJ == "66666666666666" ||
    strCNPJ == "77777777777777" ||
    strCNPJ == "88888888888888" ||
    strCNPJ == "99999999999999"
  ) {
    return false;
  }

  soma = 0;
  resto = 0;
  peso = ["6", "5", "4", "3", "2", "9", "8", "7", "6", "5", "4", "3", "2"];
  for (i = 0; i <= 11; i++) {
    soma = soma + parseInt(strCNPJ.substring(i, i + 1)) * peso[i + 1];
  }
  resto = soma % 11;

  if (resto < 2) {
    dv = 0;
  } else {
    dv = 11 - resto;
  }

  if (dv != parseInt(strCNPJ.substring(12, 13))) {
    return false;
  } else {
    soma = 0;
    for (i = 0; i <= 11; i++) {
      soma = soma + parseInt(strCNPJ.substring(i, i + 1)) * peso[i];
    }
    soma = soma + dv * peso[12];
    resto = soma % 11;

    if (resto < 2) {
      dv = 0;
    } else {
      dv = 11 - resto;
    }

    if (dv != parseInt(strCNPJ.substring(13, 14))) {
      return false;
    } else return true;
  }
}
function testeCNPJ() {
  valor = document.getElementById("teste");

  console.log(cnpj(valor.value));
}
