class BusStop

  attr_reader :name

  def initialize(name)
    @name = name
    @queue = []
  end

  def add_to_queue(person)
    @queue.push(person)
  end

  def queue_length()
    return @queue.length()
  end

  def yield_passenger()
    return @queue.shift()
  end

end
