require( 'sinatra' )
require( 'sinatra/contrib/all' )
require( 'pry-byebug' )
require_relative('./models/pizza.rb')

# INDEX
get('/pizzas') do
  @pizzas = Pizza.all()
  erb(:index)
end

# NEW
get('/pizzas/new') do
  erb(:new)
end

# SHOW
get('/pizzas/:id') do
  id = params[:id]
  @pizza = Pizza.find(id)
  erb(:show)
end

# CREATE
post('/pizzas') do
  @pizza = Pizza.new(params)
  @pizza.save()
  erb(:create)
end
