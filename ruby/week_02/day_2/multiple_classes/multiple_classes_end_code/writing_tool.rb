class WritingTool

  attr_reader(:name)

  def initialize(name, type)
    @name = name
    @type = type
  end

  def write(book)
    if @type == "typewriter"
      return "#{book} - old school click clacking"
    else
      return book
    end
  end

end
