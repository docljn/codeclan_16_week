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
husky = pets.find { |pet| pet[:breed] == 'Husky' }
p husky

## Make an array of all of the pets' names
names = pets.map { |pet| pet[:name] }
p names

## Find out if there are any pets of breed 'Dalmation' (true or false)
# .find is always useful when trying to find one item in an array
p pets.find {|pet| pet[:breed] == 'Dalmation'} # => nil

# .any? is built specifically for this situation, just checking if something exists or not
p pets.any? {|pet| pet[:breed] == 'Dalmation'} # => false


## Find the most expensive pet i.e. pet with the highest/maximum price

# .max is pretty handy, but confusing syntax
p pets.max {|current_pet, next_pet| current_pet[:price] <=> next_pet[:price] }

# If we couldn't use max, we would have to do a few different things together
prices = pets.map {|pet| pet[:price]}
sorted = prices.sort {|a, b| b <=> a }
high_price = sorted.first
expensive_pet = pets.find {|pet| pet[:price] == max}
p expensive_pet

## Find the total value (price) of all of the pets added together.

# You could map and then reduce, a common pattern:
prices = pets.map {|pet| pet[:price]}
p prices.reduce {|total, price| total + price}
# Ruby 2.4 has .sum which is a shortcut for this reduce call

# Alex's 1 liner
p pets.reduce(0) {|total, pet| total + pet[:price]}
# Passing an argument to reduce sets this value, 0, as the initial value of the accumulator (the first parameter to the block - 'total' in this case)

## Change each pet so their price is 50% cheaper
# This will modify the original:
pets.each {|pet| pet[:price] /= 2}
p pets


# Craig's weird thing
# This avoids modifying the original 'pets' array
p pets.map do |pet|
  {
    name: pet[:name],
    pet_type: pet[:pet_type],
    breed: pet[:breed],
    price: pet[:price] / 2
  }
end
