const Task = require('../task');
const assert = require('assert');
const taskEnum = require('../task_enum');

describe('Task', function() {

  let killWolf;

  beforeEach(function(){
    const taskDetail = {
      description: "Kill a wolf",
      difficulty: taskEnum.DIFFICULTY.HARD,
      urgency: taskEnum.URGENCY.HIGH,
      reward: "Bravery boost",
      complete: false
    }
    killWolf = new Task(taskDetail);
  })

  it('should have a description', function() {
    assert.strictEqual(killWolf.description, "Kill a wolf");
  });

  it('should have a difficulty level', function() {
    assert.strictEqual(killWolf.difficulty, 2);
  });

  it('should have a urgency level', function() {
    assert.strictEqual(killWolf.urgency, 2);
  });

  it('should have a reward', function(){
    assert.strictEqual(killWolf.reward, "Bravery boost");
  });

  it('should start as not complete', function() {
    assert.strictEqual(killWolf.complete, false);
  });

  it('should be able to be marked complete', function() {
    killWolf.markComplete()
    assert(killWolf.complete);
  });

});
