const Dinosaur = function(type, annualOffspring){
  this.type = type;
  this.annualOffspring = annualOffspring;
}

Dinosaur.prototype.giveBirth = function(){
  let offspring = [];
  for (let i = 0; i < this.annualOffspring; i++){
    const baby = new Dinosaur(this.type, this.annualOffspring);
    offspring.push(baby);
  }
  return offspring;
}

module.exports = Dinosaur;