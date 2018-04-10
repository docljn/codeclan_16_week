require('pg')
require_relative('../db/sql_runner')
require_relative('./customer')

class PizzaOrder

  attr_accessor :quantity, :topping
  attr_reader :id, :customer_id

  def initialize( options )
    @id = options['id'].to_i if options['id']
    @customer_id = options['customer_id'].to_i()
    @quantity = options['quantity'].to_i
    @topping = options['topping']
  end

  def customer
    sql = 'SELECT * FROM customers
    WHERE id = $1'
    values = [@customer_id]

    customer_hash_array = SqlRunner.run(sql, values)

    customer_hash = customer_hash_array[0]
    return Customer.new(customer_hash)

    # Alternative, less code & keeps customer table stuff in the Customer class
    # return Customer.find(@customer_id)
  end

  def save()
    sql =
      "INSERT INTO pizza_orders (
        customer_id,
        quantity,
        topping
      )
      VALUES ($1, $2, $3)
      RETURNING *"
    values = [@customer_id, @quantity, @topping]

    @id = SqlRunner.run(sql, values)[0]['id'].to_i
  end

  def PizzaOrder.all()
    orders = SqlRunner.run('SELECT * FROM pizza_orders')
    return orders.map {|order| PizzaOrder.new(order)}
  end

  def PizzaOrder.delete_all()
    SqlRunner.run('DELETE FROM pizza_orders')
  end

  def delete()
    sql = "DELETE FROM pizza_orders
      WHERE id = $1"
    SqlRunner.run(sql, [@id])
  end

  def update()
    sql = "UPDATE pizza_orders
      SET (
        customer_id,
        quantity,
        topping
      ) = ( $1, $2, $3 )
      WHERE id = $4"
    values = [@customer_id, @quantity, @topping, @id]
    SqlRunner.run(sql, values)
  end

end
