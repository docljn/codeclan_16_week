chickens = [
  'Margaret',
  'Hetty',
  'Mabel',
  'Craig',
  'Max'
]

# throws an error if we loop through something that's not an array
# chickens = 3

for chicken in chickens
  p chicken
end

# curly bracket syntax, for 1 line .each blocks
chickens.each() { |chicken| p chicken }

chickens.each do |chicken|
  angry_chicken = chicken.upcase()
  p angry_chicken
end

chickens = [
  'Margaret',
  'Hetty',
  'Mabel',
  'Craig',
  'Max'
]

angry_chickens = []

chickens.each do |chicken|
  angry_chickens.push(chicken.upcase())
end

angry_chickens = chickens.map do |chicken|
  chicken.upcase()
end

p chickens
p angry_chickens


hashes = [
  {name: 'Craig'},
  {name: 'Zsolt'}
]

names = hashes.map {|person| person[:name]}

p hashes
p names


chickens = [
  'Margaret',
  'Hetty',
  'Mabel',
  'Craig',
  'Max'
]

angry_chickens = chickens.map do |chicken|
  'ruby just does what we tell it to though. no magic'
end

p angry_chickens
