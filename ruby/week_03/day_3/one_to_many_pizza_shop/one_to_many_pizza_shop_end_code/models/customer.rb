require_relative('../db/sql_runner')

class Customer

  attr_reader(:id)
  attr_accessor(:first_name, :last_name)

  def initialize(options)
    @id = options['id'].to_i() if options['id']
    @first_name = options['first_name']
    @last_name = options['last_name']
  end

  def pizza_orders
    # We could keep this code in the PizzaOrder class if we added a .find_many method to it
    # return PizzaOrder.find_many(@id)

    sql = 'SELECT * FROM pizza_orders
    WHERE customer_id = $1'

    order_hashes = SqlRunner.run(sql, [@id])

    order_objects = order_hashes.map do |order_hash|
      PizzaOrder.new(order_hash)
    end

    return order_objects

  end

  def save
    sql = "
    INSERT INTO customers (first_name, last_name)
    VALUES ($1, $2)
    RETURNING id;"
    result = SqlRunner.run(sql, [@first_name, @last_name])
    @id = result[0]['id'].to_i()

    # Step by step
    # array_of_hashes = db.exec_prepared('save', values)
    # id_hash = array_of_hashes[0]
    # string_of_id = id_hash['id']
    # int_id = string_of_id.to_i()
    # @id = int_id

  end

  def Customer.delete_all
    SqlRunner.run('DELETE FROM customers;')
  end

end
