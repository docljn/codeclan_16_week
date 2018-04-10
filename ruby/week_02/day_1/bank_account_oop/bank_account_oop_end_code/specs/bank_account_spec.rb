require('minitest/autorun')
require('minitest/rg')
require_relative('../bank_account')

class TestBankAccount < MiniTest::Test

  def setup
    @bank_account = BankAccount.new("John", 500, "business")
  end

  def test_account_name
    assert_equal("John", @bank_account.holder_name)
  end

  def test_account_amount
    assert_equal(500, @bank_account.amount)
  end

  def test_account_type
    assert_equal('business',@bank_account.type)
  end

  def test_set_holder_name
    @bank_account.holder_name = "Joanna"
    assert_equal("Joanna", @bank_account.holder_name)
  end

  def test_set_account_amount
    @bank_account.amount = 10000
    assert_equal(10000, @bank_account.amount)
  end

  def test_set_account_type
    account = BankAccount.new("john", 600, "personal")
    assert_equal('personal', account.type)
  end

  def test_pay_into_account
    @bank_account.pay_in(100)
    assert_equal(600, @bank_account.amount)
  end

  def test_pay_monthly_fee__business
    business_account = BankAccount.new("john", 500, "business")
    business_account.pay_monthly_fee
    assert_equal(450, business_account.amount)
  end

  def test_pay_monthly_fee__personal
    personal_account = BankAccount.new("john", 600, "personal")
    personal_account.pay_monthly_fee
    assert_equal(590, personal_account.amount)
  end

end
