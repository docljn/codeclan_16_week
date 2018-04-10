const express = require('express');
const countriesRouter = express.Router();
const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost:27017';

MongoClient.connect(url, function(err, client){
  const db = client.db('bucket_list_app');

  countriesRouter.get('/bucketList', function(req, res) {
    const collection = db.collection('bucket_countries');
    collection.find({}).toArray(function(err, docs) {
      res.json(docs);
    })
  })

  countriesRouter.post('/bucketList', function(req, res) {
    const collection = db.collection('bucket_countries');
    collection.insert(req.body.country);
    res.status(200);
    res.send();
  })

})


module.exports = countriesRouter;
