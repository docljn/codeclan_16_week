const Hero = require('../hero');
const Food = require('../food');
const assert = require('assert');
const taskEnum = require("../task_enum.js");

describe('Hero', function() {

  let hero;

  beforeEach(function(){
    hero = new Hero({name: 'Ift', favouriteFood:'pizza'});
  })

  it('should have a name', function() {
    assert.strictEqual(hero.name, 'Ift');
  });

  it('should start at 100 health', function() {
    assert.strictEqual(hero.health, 100);
  });

  it('should have a fav food', function() {
    assert.strictEqual(hero.favouriteFood, 'pizza');
  });

  it('should be able to gain health through eating', function() {
    const foodStub = { name:'aFood', nutrition: 20};
    hero.eat(foodStub);
    assert.strictEqual(hero.health, 120);
  });

  it('should be able to gain 1.5 times nutrition if fav food', function() {
    // We don't need to instantiate a whole new Food object to test the effect in hero
    // this strategy continues in later tests
    const foodStub = { name:'pizza', nutrition:20 };
    hero.eat(foodStub);
    assert.strictEqual(hero.health, 130);
  });

  it('should lose health if made poisonous', function() {
    const food = new Food({name: 'cake', nutrition: 20});
    food.poison();
    hero.eat(food);
    assert.strictEqual(hero.health, 80);
  });

  it('should have an empty collection of tasks', function(){
    assert.strictEqual(hero.tasks.length, 0);
    assert.strictEqual(hero.tasks.constructor, Array);
  });

  it('should be able add a task', function(){
    const taskStub = {description: "Kill a wolf"};
    hero.addTask(taskStub);
    assert.deepStrictEqual(hero.tasks[0], taskStub);
  });

  it('should be able to view completed tasks', function(){
    hero.addTask({complete: true});
    hero.addTask({complete: false});
    hero.addTask({complete: false});
    const completeTasks = hero.viewCompleteTasks();
    const expected = [{complete: true}];
    assert.deepStrictEqual(completeTasks, expected);
  });
  it('should be able to view incomplete tasks', function(){
    hero.addTask({complete: true});
    hero.addTask({complete: false});
    hero.addTask({complete: false});
    const incompleteTasks = hero.viewIncompleteTasks();
    const expected = [{complete: false}, {complete: false}];
    assert.deepStrictEqual(incompleteTasks, expected);
  });

  describe('should be able to sort tasks - basic (low to high number)', function(){
    it('by a property', function(){
      const task1 = {difficulty: 1};
      const task2 = {difficulty: 2};
      const task3 = {difficulty: 3};
      hero.addTask(task2);
      hero.addTask(task3);
      hero.addTask(task1);
      hero.sortTasksBasic("difficulty");
      assert.deepStrictEqual(hero.tasks, [task1, task2, task3])
    });
  })

  describe('should be able to sort tasks - advanced', function(){
    it('by difficulty', function(){
      const easy = { difficulty: taskEnum.DIFFICULTY.EASY };
      const medium = { difficulty: taskEnum.DIFFICULTY.MEDIUM };
      const hard = { difficulty: taskEnum.DIFFICULTY.HARD };
      hero.addTask(hard);
      hero.addTask(easy);
      hero.addTask(medium);
      hero.sortTasks("difficulty" , "LowToHigh");
      assert.deepStrictEqual( hero.tasks, [easy, medium, hard]);
    });
    it('by urgency', function(){
      const low = { urgency: taskEnum.URGENCY.LOW };
      const medium = { urgency: taskEnum.URGENCY.MEDIUM };
      const high = { urgency: taskEnum.URGENCY.HIGH };
      hero.addTask(medium);
      hero.addTask(high);
      hero.addTask(low);
      hero.sortTasks("urgency", "LowToHigh");
      assert.deepStrictEqual( hero.tasks, [low, medium, high]);
    });
    it('by reward', function(){
      const firstInAlphabet = "A task";
      const lastInAlphabet = "Z task";
      const firstTask = {reward: firstInAlphabet};
      const lastTask = {reward: lastInAlphabet};
      hero.addTask(lastTask);
      hero.addTask(firstTask);
      hero.sortTasks("reward", "Alphabetical");
      assert.deepStrictEqual( hero.tasks, [firstTask, lastTask]);
    });
  })



});
