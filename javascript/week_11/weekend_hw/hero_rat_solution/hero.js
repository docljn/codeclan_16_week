const Hero = function (spec) {
  this.name = spec.name;
  this.health = 100;
  this.favouriteFood = spec.favouriteFood;
  this.tasks = [];
};

Hero.prototype.eat = function(food) {
  let multiplier = 1;
  if (food.name === this.favouriteFood) {
    multiplier = 1.5;
  }
  if (food.poisoned) {
    multiplier *= -1;
  }
  this.health = this.health + (food.nutrition * multiplier);
}

Hero.prototype.addTask = function(task){
  this.tasks.push(task);
}

Hero.prototype.viewCompleteTasks = function(){
  return this.tasks.filter(function(task){
    return task.complete === true
  })
}

Hero.prototype.viewIncompleteTasks = function(){
  return this.tasks.filter(function(task){
    return task.complete === false
  })
}


Hero.prototype.sortTasksBasic = function(numericProperty){
  // we can access properties with brackets (using string keys) as well as dot notation - e.g. task["urgency"]

  this.tasks.sort(function(task1, task2) {
    return task1[numericProperty] - task2[numericProperty];
  });
}

Hero.prototype.sortTasks = function(property, sortType){
  if (sortType === 'LowToHigh'){
    this.sortTasksBasic(property);
  } else if (sortType === 'Alphabetical') {
    this.tasks.sort(function(task1, task2) {
      return task1[property].localeCompare(task2[property])
    })
  }
}

module.exports = Hero;
