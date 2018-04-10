const BucketListView = function(listElement) {
  this.listElement = listElement;
  this.onChange = undefined;
  this.countries = [];
};

BucketListView.prototype.render = function(countries){
    this.listElement.innerHTML = "";
    this.countries = countries;
    this.countries.forEach(function(country) {
      this.addItem(country);
    }.bind(this));
}

BucketListView.prototype.addItem = function(country, index){
    const li = document.createElement("li");
    li.innerHTML = country.name;
    this.listElement.appendChild(li);
}


module.exports = BucketListView;
