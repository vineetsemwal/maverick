class Employee {

    constructor(id) {
        this._id = id;
    }

    get id() {
        console.log("inside get id");
        return this._id;
    }

    set id(id) {
        if(id<0){
            throw new Error('id cant be smaller than zero');
        }
        console.log("inside set id");
        this._id = id;
    }

}

const emp = new Employee(10);
emp.id = 20;
const id = emp.id;
console.log(id);
console.log(emp._id);