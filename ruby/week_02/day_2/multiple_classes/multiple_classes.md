# Multiple Classes

Well done,  we have become object orientated programmers,  by creating a class and instantiating objects using it.

When object orientated programming becomes really powerful is when an object uses an other object to help it in a task.  Enough theory,  let's look at an example.

## Delegating To Other Objects

### Exposing instance variables: getters, setters

Let's look at the situation of an author that writes text using a writing tool. The way of typing depends on the writing tool's type.

First, we want to create tests for our Authors. In terminal:

```bash
#terminal

mkdir multiple_classes
cd multiple_classes
mkdir specs
touch specs/author_specs.rb
```

Then open it up in atom!

```ruby
#specs/wizard_specs.rb

require('minitest/autorun')
require_relative('../author')

class TestAuthor < MiniTest::Test

  def setup
    @author = Author.new("Neil Gaiman", "MacBook Pro", "laptop")
  end

  def test_author_has_name
    assert_equal("Neil Gaiman", @author.name())
  end

end
```

Great! The first thing we want to test is if we can create an author, and then access their name. Let's do it!

```bash
#terminal

touch author.rb
```

```ruby
# wizard.rb

class Author

  attr_reader(:name)

  def initialize(name, writing_tool_name, writing_tool_type)
    @name = name
    @writing_tool_name = writing_tool_name
    @writing_tool_type = writing_tool_type
  end

end
```

Brilliant, test should pass no problem! Let's move on.

Authors are not authors without creating novels or poems! Let's add the ability of writing to our author class! This method should take in some text, and return it to us.

First, we write our test:

```ruby
# author_spec.rb
# same

def test_can_write
  assert_equal("American Gods", @author.create_bestseller("American Gods"))
end

```

Then we write the method to pass the test!

```ruby
# author.rb
# as before

  def create_bestseller(book)
    return book
  end

```

Boom! Job's done. But then again, this is not really interactive. Let's do something with the writing tool's type! If it's

First, let's write another test:

```ruby
# author_spec.rb
# same

def test_author_can_type_with_typewriter
  assert_equal("Nevermore, with old school click clacking", @author.create_bestseller("Nevermore"))
end
```

```ruby
# author.rb

  def create_bestseller(book)
    if @writing_tool_type == "typewriter"
       return "#{book}, with old school click clacking"
    else
       return book
    end
  end
```

Great!
Wait...something is not quite right. What if I want to give our author a different writing tool? The only thing I could do is setting both the name of the writing tool type and the name... This is not really clean... And is it really the author's responsibility to know about the type and name of the tool?

Let's delegate the job of knowing tool names and types to its own class!

In terminal:

```bash
#terminal

touch writing_tool.rb
touch specs/writing_tool_spec.rb
```

```ruby
# writing_tool_spec.rb

require('minitest/autorun')
require_relative('../writing_tool')

class TestWritingTool < MiniTest::Test

  def setup
    @typewriter = WritingTool.new("Remington", "typewriter")
  end

  def test_writing_tool_has_name
    assert_equal("Remington", @typewriter.name())
  end

  def test_writing_tool_has_type
    assert_equal("typewriter", @typewriter.type())
  end

end
```

Let's make our tests pass!

```ruby
# wand.rb
class WritingTool

  attr_reader(:name, :type)

  def initialize(name, type)
    @name = name
    @type = type
  end

end
```

Excellent!

Now here comes the magical part: From now on, we can instantiate a writing tool, and instead of the author being responsible for being aware of the writing tool's name and type, the writing_tool object can handle all this for us! Let's go back to our author.rb, and refactor our code!

```ruby
# author.rb
class Author

  def initialize(name, writing_tool) #UPDATE
    @name = name
    @writing_tool = writing_tool #UPDATE
  end

  def create_bestseller(book)
    @writing_tool.write(book) #UPDATE
  end

end
```
Since its the writing_tool's job to keep track of the type, we can give the responsibility of checking it to the writing_tool class!
```ruby
# writing_tool.rb

def write(book)
  if @type == "typewriter"
    return "#{book}, with old school click clacking"
  else
    return book
  end
end

```

Dang, but then our tests are failing! Let's rework them to suit them to the changes we made!

```ruby
# wizard_spec.rb
require('minitest/autorun')
require_relative('../author')
require_relative('../writing_tool')

class TestWizard < MiniTest::Test

  def setup
    @typewriter = WritingTool.new("Remington", "typewriter")
    @laptop = WritingTool.new("MacBook Pro", "laptop")
    @author1 = Author.new("E.A. Poe", @typewriter)
    @author2 = Author.new("Neil Gaiman", @laptop)
  end

  def test_author_got_name
    assert_equal("E.A. Poe", @author1.name())
  end

  def test_author_can_type_with_typewriter
    expected = "Nevermore, with old school click clacking"
    actual = @author1.create_bestseller("Nevermore")
    assert_equal(expected, actual)
  end

end
```

Did we have to change anything with our actual tests? No, we did not. Everything passes just as fine as before. The author here has delegated the behaviour of their writing  to the writing_tool.

What object is responsible for what is one of the major challenges of object orientated programming.  There are thousands of books of this, and we enter the realm of Object Orientated Design.  For now I would not worry too much about the design and focus on getting things working.  Make it work, make it right, make it fast.

## Collection objects

> This bit is totally optional. There is a lab to cover this if the students are up to it.

We've already seen arrays and hashes. Objects whose role is to hold other objects.  Let's look at how we can use these to create our own collections.  

### Creating a collection of authors

```ruby

#specs/publisher_spec.rb

require "minitest/autorun"

require_relative "../author"
require_relative "../writing_tool"
require_relative "../publisher"

class TestPublisher < MiniTest::Test
  def setup
    @typewriter = WritingTool.new("Remington DeLuxe 5", "typewriter")
    @laptop = WritingTool.new("MacBook Pro", "laptop")
    @author1 = Author.new("H.P. Lovecraft", @typewriter)
    @author2 = Author.new("Neil Gaiman", @laptop)
    @authors = [@author1, @author2]
    @publisher = Publisher.new("Penguin Books", @authors)
  end

  def test_publisher_can_collaborate()
    expected = ["Call of Cthulhu - old school click clacking", "Call of Cthulhu"]
    assert_equal(expected, @publisher.collaborate("Call of Cthulhu"))
  end
end

#publisher.rb

class Publisher
  def initialize(name, authors)
    @name = name
    @authors = authors
  end

  def collaborate(book)
    collaborated_texts = []

    for author in @authors
      collaborated_texts.push(author.write(book))
    end

    return collaborated_texts
  end
end
```
