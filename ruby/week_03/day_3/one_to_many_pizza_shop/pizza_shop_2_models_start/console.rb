require('pry-byebug')
require_relative('./models/pizza_order')

PizzaOrder.delete_all()


order1 = PizzaOrder.new({
    'first_name' => 'Luke',
    'last_name' => 'Skywalker',
    'quantity' => '1',
    'topping' => 'Napoli'
  })

order2 = PizzaOrder.new({
    'first_name' => 'Darth',
    'last_name' => 'Vader',
    'quantity' => '1',
    'topping' => 'Quattro Formaggi'
  })


# order3 = PizzaOrder.new({
#   'first_name'=> 'Luke',
#   'last_name'=> 'Skywalker',
#   'quantity'=> '2',
#   'topping'=> "'); DELETE FROM pizza_orders; --"})

order1.save()
order2.save()
# order3.save()

# order1.delete()

order1.first_name = "Fred"
order1.update

orders = PizzaOrder.all() # add this


binding.pry
nil
