import { Link } from 'react-router-dom'

function Navigationbar() {   
    return (

        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <Link to="/" className="navbar-brand">
                <span>Maverick Training</span>
            </Link>

            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" >
                <span className="navbar-toggler-icon"></span>
            </button>

            <div className="collapse navbar-collapse" id="navbarSupportedContent">
                <ul className="navbar-nav mr-auto">

                    <li className="nav-item">
                        <Link to="/products" className="nav-link">Products </Link>

                    </li>


                    <li className="nav-item">
                        <Link to="/contacts" className="nav-link">Contacts </Link>
                          
                    </li>


                </ul>

            </div>
        </nav>


    );

}

export default Navigationbar;