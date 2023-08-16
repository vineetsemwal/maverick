/**
 * 
 * props destructured
 */
function UserDetailsFunctional({user,dept}){
 //const user=props.user;
 //const dept=props.dept;

    return (
  
      <div>
        <h1>User Details Component</h1>
        Name is {user.name}, age is {user.age}
        Department is {dept}
      </div>
    );
}
export default UserDetailsFunctional;