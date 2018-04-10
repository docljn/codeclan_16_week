const CountryDetailView = function(element) {
  this.element = element;
};

CountryDetailView.prototype.render = function(country){
    const tags = this.element.querySelectorAll('p');
    tags[0].innerText = country.name;
    tags[1].innerText = country.population;
    tags[2].innerText = country.capital;
}

module.exports = CountryDetailView;
