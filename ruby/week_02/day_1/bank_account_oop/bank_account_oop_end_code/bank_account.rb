class BankAccount

  attr_accessor :holder_name, :amount, :type

  def initialize(holder_name, amount, type)
    @holder_name = holder_name
    @amount = amount
    @type = type
    @new_property = nil
  end

  def pay_in(deposit_amount)
    @amount += deposit_amount
  end

  def pay_monthly_fee

    # awesome

    fees = {
      "business" => 50,
      "personal" => 10
    }

    @amount -= fees[@type]

    # pretty good

    # @amount -= 50 if @type == "business"
    # @amount -= 10 if @type == "personal"

    # you cannot be serious :p

    # fee = case @type
    #   when "business" then 50
    #   when "personal" then 10
    # end
    #
    # @amount -= fee

  end



end
