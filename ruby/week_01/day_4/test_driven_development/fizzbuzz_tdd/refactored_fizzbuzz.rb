# Refactor to avoid repeating the conditional code:
def fizzbuzz(number)
  divisible_by_3 = (number % 3 == 0)
  divisible_by_5 = (number % 5 == 0)

  if divisible_by_3 && divisible_by_5
    return 'FizzBuzz'
  end

  if divisible_by_5
    return 'Buzz'
  end

  if divisible_by_3
    return 'Fizz'
  end

  return number.to_s()
end
