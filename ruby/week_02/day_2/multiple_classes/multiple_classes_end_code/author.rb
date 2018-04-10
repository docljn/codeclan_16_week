class Author

  attr_reader(:name)

  def initialize(name, writing_tool)
    @name = name
    @writing_tool = writing_tool
  end

  def create_bestseller(book)
    @writing_tool.write(book)
  end

end
