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
