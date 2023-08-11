import logo from './logo.svg';
import './App.css';
import { UserDetailsComponent } from './UserDetails';
/*
React.createElement(
  'div',{},
  '<h1>Main Component</h1>');
*/
function App() {
const  title="hello";
return (<div>
    <h1>Main Title is {title} </h1>
    3+5 value ={3+5}
<UserDetailsComponent/>

    </div>
  );

}

export default App;
