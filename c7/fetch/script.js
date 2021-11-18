const main = document.querySelector("main");
const url = 'https://reqres.in/api/users?page=2'

function userTemplate(el){
    return `<a href="${el.avatar}">${el.id} - ${el.first_name} ${el.last_name}</a><br/>`
}

function bindData(response){
    response.data.forEach(el => {
        main.innerHTML += userTemplate(el)  
    })
}

fetch(url)
    .then(response => response.json())
    .then(data => bindData(data))
    .catch(err => console.error(err));