import staff.Employee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    Employee employee;

    @Before
    public void before(){
        employee = new Employee("John Smith", "JT458729C", 20000.00);
    }

    @Test
    public void hasName(){
        assertEquals("John Smith", employee.getName());
    }

    @Test
    public void hasNiNumber(){
        assertEquals("JT458729C", employee.getNiNumber());
    }

    @Test
    public void hasSalary(){
        assertEquals(20000.00, employee.getSalary(), 0.1);
    }

    @Test
    public void canSetName(){
        employee.setName("Jack Jarvis");
        assertEquals("Jack Jarvis", employee.getName());
    }
    @Test
    public void canRaiseSalary(){
        employee.raiseSalary(10000.00);
        assertEquals(30000.00, employee.getSalary(), 0.1);
    }

    @Test
    public void canGetBonus(){
        assertEquals(200.00, employee.payBonus(), 0.1);
    }


}
