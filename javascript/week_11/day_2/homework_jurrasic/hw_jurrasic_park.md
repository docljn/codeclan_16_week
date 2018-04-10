# Jurassic Park homework

John Hammond wants to be able to manage the dinosaurs at Jurassic Park. (uhoh)

# MVP
A dinosaur should have a type (e.g. "Tyrannosaurus", "Velociraptor", "Triceratops") and a number of offspring per year. 

A park should have an enclosure that can have dinosaurs added to it.

Use TDD to write and make pass the following tests:

##### Dinosaur:
1. should have a type
2. should have a number of offspring per year

##### Park:
1. enclosure should start empty
2. should be able to add a dinosaur
3. should be able to remove all dinosaurs of a particular type
4. should get all the dinosaurs with an offspring count of more than 2


# Extension
John Hammond wants to be able to calculate how many dinosaurs there are going to be at Jurassic Park on any given year after opening, taking into consideration the number of offspring each dinosaur has annually.

Use TDD get the following tests to pass:

##### Park:
1. should be able to calculate number of dinosaurs after year one, starting with 1 dinosaur
2. should be able to calculate number of dinosaurs after year two, starting with 1 dinosaur
4. should be able to calculate number of dinosaurs after year two, starting with 2 dinosaurs


```js
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
```









