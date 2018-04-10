const UI = require('./views/ui');

const app = function(){
  const ui = new UI();

  const request = new XMLHttpRequest();
  request.open('GET', 'http://localhost:3000/api/films')
  request.addEventListener('load', function(){
    const jsonString = this.responseText;
    const films = JSON.parse(jsonString);
    ui.render(films);
  })
  request.send();



  // ui.render(films);
}

window.addEventListener('load', app);
