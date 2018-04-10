pets = [
  {
    name: "Sir Percy",
    pet_type: :cat,
    breed: "British Shorthair",
    price: 500
  },
  {
    name: "King Bagdemagus",
    pet_type: :cat,
    breed: "British Shorthair",
    price: 500
  },
  {
    name: "Sir Lancelot",
    pet_type: :dog,
    breed: "Pomsky",
    price: 1000,
  },
  {
    name: "Arthur",
    pet_type: :dog,
    breed: "Husky",
    price: 900,
  },
  {
    name: "Tristan",
    pet_type: :dog,
    breed: "Basset Hound",
    price: 800,
  },
  {
    name: "Merlin",
    pet_type: :cat,
    breed: "Egyptian Mau",
    price: 1500,
  }
]

# Examples:

## Print out all of the names using a loop
for pet in pets
  p pet[:name]
end

## Print out all of the names using an Enumerable method
pets.each { |pet| p pet[:name] }

## Find a pet by name using a loop and if statement
result = nil

for pet in pets
  if pet[:name] == "Tristan"
    result = pet
  end
end

p result

## Find a pet using an Enumerable method
enums_result = pets.find { |pet| pet[:name] == "Tristan" }

p enums_result


# Tasks:
## Using enumerable methods:

## Find the pet which is a Husky

## Make an array of all of the pets' names

## Find out if there are any pets of breed 'Dalmation' (true or false)

## Find the most expensive pet i.e. pet with the highest/maximum price

## Find the total value (price) of all of the pets added together.

## Change each pet so their price is 50% cheaper
