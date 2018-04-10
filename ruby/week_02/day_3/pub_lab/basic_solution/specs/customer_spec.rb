require("minitest/autorun")
require_relative("../customer")

class CustomerTest < MiniTest::Test

  def setup
    @customer = Customer.new("Jarrod", 10.0)
  end

  def test_customer_has_name
    assert_equal("Jarrod", @customer.name())
  end

  def test_customer_has_money
    assert_equal(10.0, @customer.wallet())
  end

end
