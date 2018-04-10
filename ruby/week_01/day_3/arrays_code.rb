fruits = ['banana', 'apple', 'orange']

p fruits

# Accessing items by their index position
p fruits[0]
p fruits[2]

# Accessing an index beyond the end of the array
p fruits[4] # nil

# Ruby allows us to access elements in our arrays with negative indices!
# These count from the end of the array instead of the start
p fruits[-1]
p fruits[-3]

# These methods read nicely for humans, but just do the same as accessing with [0] and [-1]
p fruits.first()
p fruits.last()

# first and last can also get multiple elements, this returns another array
p fruits.first(2)
p fruits.last(3)

# These do the same thing:
my_array = []
my_array = Array.new()

p my_array

# Replacing existing item:
fruits[0] = 'grapefruit'

# A bit weird:
fruits[50] = 'mango'

# More sensible:
fruits[4] = 'mango'

# Even better, we don't need to worry about the index or the length of the array
fruits.push('mango')

# alternative syntax for push, the 'shovel' operator
fruits << 'mango'

p fruits

# Opposite of push
fruits.pop()

p fruits

# Add to the start
fruits.unshift('grape')

p fruits

# Opposite of unshift - removes the first item
fruits.shift()

p fruits

# Arrays in Ruby can hold data of mixed types
fruits_and_numbers = ['banana', 56, -5, 'apple', 7, 'grapefruit']

p fruits_and_numbers

# Even other arrays!
chaos = ['string', 300, ['a', 'rr', 'ay'], nil, 3.14, true]

p chaos
