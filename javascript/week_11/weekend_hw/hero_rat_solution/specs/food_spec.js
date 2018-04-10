const assert = require('assert');
const Food = require('../food');

describe('Food', function() {
  it('should have a name', function() {
    const food = new Food({name: 'pizza', nutrition: 20});
    assert.strictEqual('pizza', food.name);
  });
  it('should have a nutritional value', function() {
    const food = new Food({name: 'pizza', nutrition: 20});
    assert.strictEqual(20, food.nutrition);
  });
  it('should not be poisonous', function() {
    const food = new Food({name: 'pizza', nutrition: 20});
    assert.strictEqual(false, food.poisoned);
  });
  it('should be able to be poisoned', function() {
    const food = new Food({name: 'pizza', nutrition: 20});
    food.poison();
    assert.strictEqual(true, food.poisoned);
  });

});
