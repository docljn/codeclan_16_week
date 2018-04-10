document.addEventListener('DOMContentLoaded', function(){
  const canvas = document.getElementById('main-canvas');
  // console.log('canvas', canvas);
  const context = canvas.getContext('2d');

  //draw rectangle
  context.fillStyle = 'blue';
  context.fillRect(10, 10, 50, 50);

  //drawing a line
  context.beginPath();
  context.moveTo(100, 100);
  context.lineTo(100, 200);
  context.stroke();

  //draw triangle
  context.beginPath();
  context.moveTo(200, 200);
  context.lineTo(200, 300);
  context.lineTo(100, 300);
  context.closePath();
  context.stroke();

  //draw circle

  canvas.addEventListener('mousemove', function(event){
    drawCircle(event.x, event.y);
  })


  const drawCircle = function(x, y){
    context.beginPath();
    context.arc(x, y, 50, 0, Math.PI*2, true);
    context.stroke();
  }

  const changeColour = function(){
    console.log(this.value);
    context.strokeStyle = this.value;
  }

  const colourPicker = document.querySelector('#input-colour');
  colourPicker.addEventListener('change', changeColour);



  // const img = document.createElement('img');
  // img.src = "https://media.licdn.com/media/AAEAAQAAAAAAAAa_AAAAJDY3OGM1YmFiLWU0YjMtNGU5MC04ZGZjLTE4MmVlMGZkMjk4Ng.jpg";
  //
  // var drawManny = function(x, y){
  //   context.drawImage(img, x, y, 25, 25);
  // }
  //
  // img.addEventListener('load', function(){
  //   canvas.addEventListener('mousemove', function(event){
  //     drawManny(event.x, event.y);
  //   })
  // });
})
