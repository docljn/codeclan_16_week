require('minitest/autorun')
require_relative('../author')
require_relative('../writing_tool')

class TestWizard < MiniTest::Test

  def setup
    @typewriter = WritingTool.new("Remington DeLuxe 5", "typewriter")
    @laptop = WritingTool.new("MacBook Pro", "laptop")
    @author1 = Author.new("E.A. Poe", @typewriter)
    @author2 = Author.new("Neil Gaiman", @laptop)
  end

  def test_author_got_name
    assert_equal("E.A. Poe", @author1.name())
  end

  def test_author_can_create_bestseller_with_typewriter
    expected = "Nevermore, with old school click clacking"
    actual = @author1.write("Nevermore")
    assert_equal(expected, actual)
  end

  def test_author_can_create_bestseller_with_laptop
    expected = "American Gods"
    actual = @author2.write("American Gods")
    assert_equal(expected, actual)
  end

end
