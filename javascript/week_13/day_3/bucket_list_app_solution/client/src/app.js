const CountriesSelectView = require('./views/countries_select_view');
const BucketListView = require('./views/bucket_list_view');
const CountryDetailView = require('./views/country_detailed_view');
const CountrySelectView = require('./views/countries_select_view');

const CountryList = require('./models/country_list');


const app = function(){
  
  //setup views

  const countriesSelectView = new CountriesSelectView(document.querySelector('#countries'));
  const countryDetailView = new CountryDetailView(document.querySelector('#info'));
  const bucketListView = new BucketListView(document.querySelector('#bucket-list'));

  //link change on select to update detail view and persist last country
  countriesSelectView.onChange = function(country) {
    countryDetailView.render(country);
  };

  //setup country list model
  const world = new CountryList('https://restcountries.eu/rest/v1');
  const bucketList = new CountryList('http://localhost:3000/bucketList');
  //update views on data update
  world.onUpdate = function(countries) {
    countriesSelectView.render(countries);
    countryDetailView.render(countries[0]);
  };

  bucketList.onUpdate = function(countries) {
    bucketListView.render(countries);
  };

 
  const addButton = document.querySelector('#add-button');
  addButton.addEventListener('click', function() {
    bucketList.addCountry(world.countries[countriesSelectView.selectElement.value]);
  });

  //get data from server
  world.populate();
  bucketList.populate();

}

document.addEventListener("DOMContentLoaded", app)
