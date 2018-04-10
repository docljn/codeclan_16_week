require('pry-byebug')
require_relative('./models/pizza_order')
require_relative('./models/customer')

PizzaOrder.delete_all()
Customer.delete_all()

customer1 = Customer.new({
  'first_name' => 'Jason',
  'last_name' => 'Byrne'
})
customer1.save()

order1 = PizzaOrder.new({
  'topping' => 'Mushroom',
  'quantity' => '2',
  'customer_id' => customer1.id
})
order1.save()

order2 = PizzaOrder.new({
  'topping' => 'Cheese',
  'quantity' => '5',
  'customer_id' => customer1.id
})
order2.save()

all_orders = PizzaOrder.all()
#
# order2.delete()
#
# updated = PizzaOrder.all()

binding.pry
nil
