require('minitest/autorun')
require('minitest/rg')
require_relative('../fizzbuzz.rb')

class FizzBuzzSpec < MiniTest::Test

  def test_takes_input
    fizzbuzz(0)
  end

  def test_3_returns_fizz
    actual = fizzbuzz(3)
    expected = 'Fizz'
    assert_equal(expected, actual)
  end

  def test_5_returns_buzz
    assert_equal('Buzz', fizzbuzz(5))
  end

  def test_10_returns_buzz
    assert_equal('Buzz', fizzbuzz(10))
  end

  def test_15_returns_fizzbuzz
    result = fizzbuzz(15)
    expected_value = 'FizzBuzz'
    assert_equal(expected_value, result)
  end

  def test_30_returns_fizzbuzz
    result = fizzbuzz(30)
    assert_equal('FizzBuzz', result)
  end

  def test_7_returns_string_7
    expected = '7'
    assert_equal(expected, fizzbuzz(7))
  end

  def test_0_returns_fizzbuzz
    assert_equal('FizzBuzz', fizzbuzz(0))
  end

  def test_6_returns_fizz
    assert_equal('Fizz', fizzbuzz(6))
  end

end
