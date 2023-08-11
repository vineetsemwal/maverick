import { Adder } from './adder';
import { Calculator } from './calculator';

describe('Calculator', () => {
let calcy:Calculator;
beforeEach(() =>{
  const adder=new MockAdder();
   calcy=new Calculator(adder);
} );

  it('should create an instance', () => {
    expect(calcy).toBeTruthy();
  });

  it("add positive numbers",()=>{
    const result=calcy.add(5,7);
    expect(result).toBe(12);
  });

  it("add by 10", ()=>{
    spyOn(calcy,'add').withArgs(5,10).and.returnValue(15);
    const result=calcy.addBy10(5);
    expect(result).toBe(15);
  });
});


class MockAdder{

  add(num1:number,num2:number):number{
     return num1+num2;
  }

}
