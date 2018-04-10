const assert = require('assert');
const Dinosaur = require('../dinosaur');


describe('Dinosaur', function () {

  let dinosaur;

  beforeEach(function () {
    dinosaur = new Dinosaur("T-Rex", 2);
  });

  it('has a type', function () {
    assert.strictEqual(dinosaur.type, "T-Rex");
  });

  it('has a no of offspring per year', function () {
    assert.strictEqual(dinosaur.annualOffspring, 2);
  });

  it('can make babies', function () {
    const expectedBabies = [dinosaur, dinosaur];
    const actualBabies = dinosaur.giveBirth();
    assert.deepStrictEqual(actualBabies, expectedBabies);
  });

});
