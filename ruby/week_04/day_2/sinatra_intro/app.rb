require('sinatra')
require('sinatra/contrib/all') if development?()

get('/hello') do
  name = 'World'

  "Hello #{name}!"
end

get('/roll-die') do
  random = Random.new
  random_number = random.rand(1..6)
  "Rolling... " + random_number.to_s()
end

get('/hello/:first/:last') do
  p params

  # The params hash is a special has that allows us to use either Symbol or String keys
  # Both of these lines will work the same:
  "Hello #{params[:first]} #{params[:last]}!"
  # "Hello #{params['first']} #{params['last']}!"
end


# These last two routes are identical. The method is GET and the path is '/friends/:some_parameter'
# Only the first only will work. If we swap the order, the first one will always work. The one that comes after will be ignored

get('/friends/:name') do
  friends = ['Monica', 'Joey', 'Chandler', 'Phoebe', 'Rachel', 'Ross']

  if friends.include?(params[:name])
    "Yes! That person is a friend"
  else
    "No, I don't know a #{params[:name]}"
  end
end

get('/friends/:number') do
  friends = ['Monica', 'Joey', 'Chandler', 'Phoebe', 'Rachel', 'Ross']

  # Everything in the params hash is a string. We have to to_i if we want an Integer
  index = params[:number].to_i() - 1

  friends[index]
end
