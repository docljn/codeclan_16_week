# Inheritance Lab.

Your task is to model and create a system to store information for employees of a large development company.
You should use TDD, inheritance and packages for this.

#### Create an `Employee` parent class in a package called staff.
- `Employee` will have a name, NI number and salary.
- Create and test Getters for all properties.
- Add a method named `raiseSalary` with takes in a parameter of type double to increment the salary.
- Add a method called `payBonus` which returns 1% of the employees salary.

#### Create a subclass of `Employee` called `Manager` in a new package called `management`.
- Create a new package called `management`.
- Create a class for Manager in this package
- Add a property to store the department name in a property called `deptName`.
- Create a constructor that includes all the parameters needed for `Employee` and `deptName`.
- Add a getter method for `deptName`.

#### Create subclasses of `Employee`: `Developer` and `DatabaseAdmin` in a new package called `techStaff`.
- Create a new package called `techStaff`.
Cretae 2 new classes in this package for `Developer` and `DatabaseAdmin`.
- These should take in the same parameters as `Employee` and pass them to `Employee` constructor.

#### Create a subclass of `Manager` called `Director`.
- Add a private property to store a double value `budget`.
- Create a constructor for `Director` that includes the parameters needed for `Manager` and the `budget` parameter.
- Create a getter method for this property.


## Extensions

### Prevent unwanted values

- Prevent a negative value for the `raiseSalary` method.
- Allow the user to change the Employees name and prevent a null value from being entered.
- Override the `payBonus` in director to return 2% of their salary.
