const formulario = document.querySelector('#form');

let nome = document.querySelector('#Nome');
let labelNome = document.querySelector('#LabelNome');
let validNome = false;

let telefone = document.querySelector('#Telefone');
let labelTelefone = document.querySelector('#LabelTelefone');
let validTelefone = false;

let email = document.querySelector('#Email');
let labelEmail = document.querySelector('#LabelEmail');
let validEmail = false;

let senha = document.querySelector('#Senha');
let labelSenha = document.querySelector('#LabelSenha');
let validSenha = false;

let confSenha = document.querySelector('#ConfSenha');
let labelconfSenha = document.querySelector('#LabelConfSenha');
let validconfSenha = false;



nome.addEventListener('keyup', () => {
    if (nome.value.length <= 2) {
        labelNome.setAttribute('style', 'color:red')
        labelNome.innerHTML = 'Nome completo'
        nome.setAttribute('style', 'border-color: red')
        validNome = false
    }
    else {
        labelNome.setAttribute('style', 'color:green')
        labelNome.innerHTML = 'Nome'
        nome.setAttribute('style', 'border-color: green')
        validNome = true
    }
})

telefone.addEventListener('keyup', () => {
    if (telefone.value.length <= 10) {
        labelTelefone.setAttribute('style', 'color:red')
        labelTelefone.innerHTML = 'Telefone'
        telefone.setAttribute('style', 'border-color: red')
        validTelefone = false
    }
    else {
        labelTelefone.setAttribute('style', 'color:green')
        labelTelefone.innerHTML = 'Telefone'
        telefone.setAttribute('style', 'border-color: green')
        validTelefone = true
    }
})
email.addEventListener('keyup', () => {
    if (email.value.length <= 7) {
        labelEmail.setAttribute('style', 'color:red')
        labelEmail.innerHTML = 'email'
        email.setAttribute('style', 'border-color: red')
        validEmail = false
    }
    else {
        labelEmail.setAttribute('style', 'color:green')
        labelTelefone.innerHTML = 'email'
        email.setAttribute('style', 'border-color: green')
        validEmail = true
    }
})
senha.addEventListener('keyup', () => {
    if (senha.value.length <= 4) {
        labelSenha.setAttribute('style', 'color:red')
        labelSenha.innerHTML = '5 digitos ou mais'
        senha.setAttribute('style', 'border-color: red')
        validSenha = false
    } else {
        labelSenha.setAttribute('style', 'color:green')
        labelSenha.innerHTML = 'Senha'
        senha.setAttribute('style', 'border-color: green')
        validSenha = true
    }
})

ConfSenha.addEventListener('keyup', () => {
    if (senha.value != confSenha.value) {
        labelconfSenha.setAttribute('style', 'color:red')
        labelconfSenha.innerHTML = 'Senhas não conferem'
        confSenha.setAttribute('style', 'border-color: red')
        validconfSenha = false
    } else {
        labelconfSenha.setAttribute('style', 'color:green')
        labelconfSenha.innerHTML = 'Confirme Senha'
        confSenha.setAttribute('style', 'border-color: green')
        validconfSenha = true
    }
})




function cadastrar() {
    if (validNome && validTelefone && validEmail && validSenha && validconfSenha) {

        fetch("http://localhost:8080/usuarios"),
        {
            Headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'

            },
            method: 'POST',
            body: JSON.stringify({
                nome: nome.value,
                telefone: telefone.value,
                email: email.value,
                senha: senha.value,
                confSenha: confSenha.value,
            })

        }
    };
};

function limpar() {
    nome.value = "";
    telefone.value = "";
    email.value = "";
    senha.value = "";
    confSenha.value = "";

};

formulario.addEventListener("submit", function (event) {
    event.preventDefault();
    cadastrar();
    limpar();
});
