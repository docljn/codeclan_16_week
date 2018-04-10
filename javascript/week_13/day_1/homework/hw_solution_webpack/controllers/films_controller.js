const express = require('express');
const filmRouter = express.Router();
const films = require('../client/src/models/films')();
const Film = require('../client/src/models/film');
const Review = require('../client/src/models/review');

//show
filmRouter.get('/:id', function(req, res){
  res.json(films[req.params.id]);
});

//index
filmRouter.get('/', function(req, res) {
  res.json(films);
});

//update
filmRouter.put('/:id', function(req, res) {
  const film = new Film({
    title: req.body.title,
    actors: req.body.actors
  });
  films[req.params.id] = film;
  res.json({data: films});
});

//create
filmRouter.post('/', function(req, res) {
  const film = new Film({
    title: req.body.title,
    actors: req.body.actors 
  });
  films.push(film);
  res.json({data: films});
});

//destroy
filmRouter.delete('/:id', function(req, res) {
  films.splice(req.params.id, 1);
  res.json({data: films});
});

//create review
filmRouter.post('/:id/reviews', function(req, res) {
  const film = films[req.params.id];
  const review1 = new Review({
    comment: req.body.comment,
    rating: req.body.rating,
    author: req.body.author
  });
  film.addReview(review1);
  res.json({data: films});
});


module.exports = filmRouter;
