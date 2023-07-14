class Employee {
  static employeesCount = 0;
  constructor(id, name) {
    this.id = id;
    this.name = name;
    Employee.employeesCount++;
  }

  display() {
    console.log(this.id + "-" + this.name);
  }
}
const emp1 = new Employee(1, "kailash");
const emp2 = new Employee(2, "digvijay");
emp1.display();
emp2.display();
console.log("count=" + Employee.employeesCount);
