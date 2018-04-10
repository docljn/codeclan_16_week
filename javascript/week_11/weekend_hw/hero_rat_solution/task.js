const Task = function(params){
  this.description = params.description;
  this.difficulty = params.difficulty;
  this.urgency = params.urgency;
  this.reward = params.reward;
  this.complete = params.complete;
}

Task.prototype.markComplete = function(){
  this.complete = true;
}

module.exports = Task;