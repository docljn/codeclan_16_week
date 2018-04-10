chickens = [
  'Margaret',
  'Hetty',
  'Mabel',
  'Craig',
  'Max'
]

# chickens.each_with_index do |chicken, index|
#   p "#{chicken} is at index #{index}"
# end

found_chicken = chickens.find {|chicken| chicken[0] == 'H'}

# p found_chicken

# Just finds first
found_chicken = chickens.find {|chicken| chicken[0] == 'M'}

# p found_chicken

# p chickens

all_m_chickens = chickens.find_all {|chicken| chicken[0] == 'M'}

# p all_m_chickens

# string = chickens.reduce {|accumulator, chicken| accumulator + chicken}
#
# p string

numbers = [5, 6, 7, 8, 9]


sum = numbers.reduce do |running_total, current_number|

  p "running_total: #{running_total}"
  p "current_number: #{current_number}"
  # p "index: #{index}"

  running_total + current_number
end

p sum

# for loop style
# sum = 0
#
# for current_number in numbers
#   sum += current_number
# end
