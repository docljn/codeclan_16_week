const assert = require('assert');
const Park = require('../park');
const Dinosaur = require('../dinosaur');

describe('Park', function() {
  
    let park;
    let dilophosaurus;
    let velociraptor1;
    let velociraptor2;
    let velociraptor3;
    let velociraptor4;
  
    beforeEach(function() {
      park = new Park();
      tyrannosaurus = new Dinosaur("tyrannosaurus", 3);
      dilophosaurus = new Dinosaur("dilophosaurus", 2);
      velociraptor1 = new Dinosaur("velociraptor", 3);
      velociraptor2 = new Dinosaur("velociraptor", 3);
      velociraptor3 = new Dinosaur("velociraptor", 3);
      velociraptor4 = new Dinosaur("velociraptor", 3);
    });
  
    it('should start empty', function() {
      assert.strictEqual(park.enclosure.length, 0);
    });
  
    it('should be able to add Dinosaur', function(){
      park.addDinosaur(tyrannosaurus);
      assert.strictEqual(park.enclosure.length, 1);
    });
  
    it('should be able to remove all dinosaurs of a particular type and return modified enclosure', function(){
      park.addDinosaur(tyrannosaurus);
      park.addDinosaur(velociraptor1);
      park.addDinosaur(velociraptor2);
      const expected = [tyrannosaurus];
      park.removeDinosaurByType("velociraptor");
      assert.deepEqual(park.enclosure, expected);
    });
  
    it('should get all the dinosaurs with an average offspring count of more than 2', function(){
      park.addDinosaur(tyrannosaurus);
      park.addDinosaur(dilophosaurus);
      park.addDinosaur(velociraptor1);
      const expected = [tyrannosaurus, velociraptor1];
      assert.deepEqual(park.dinosaursWithOffSpringMoreThan(2), expected);
    });
  
    it('should be able to calculate number of dinosaurs after 1 year starting with 1 dinosaur', function(){
      park.addDinosaur(tyrannosaurus);
      assert.strictEqual(park.calculateDinosaurs(1), 4);
    });
  
    it('should be able to calculate number of dinosaurs after 2 years starting with 1 dinosaur', function(){
      park.addDinosaur(tyrannosaurus);
      assert.strictEqual(park.calculateDinosaurs(2), 16);
    });
  
    it('should be able to calculate number of dinosaur after year two starting with 2 dinosaurs', function(){
      park.addDinosaur(tyrannosaurus);
      park.addDinosaur(dilophosaurus);
      assert.strictEqual(park.calculateDinosaurs(2), 25);
    });

  
  });