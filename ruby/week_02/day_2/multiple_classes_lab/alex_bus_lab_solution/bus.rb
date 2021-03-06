class Bus

  attr_reader :route_number, :destination

  def initialize(route_number, destination)
    @route_number = route_number
    @destination = destination
    @passengers = []
  end

  def drive()
    return "Brum brum"
  end

  def passenger_count()
    return @passengers.length()
  end

  def pick_up(person)
    @passengers << person
  end

  def drop_off(person)
    index = @passengers.index(person)
    @passengers.slice!(index, 1)
  end

  def empty()
    @passengers.clear()
  end

  def pick_up_from_stop(stop)
    while stop.queue_length > 0 do
      pick_up(stop.yield_passenger)
    end
  end

end
