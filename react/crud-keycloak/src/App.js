import React, { useState, useEffect } from 'react'
import './App.less'
import Book from './components/Screens/Book'
import CreateNewBook from './components/Screens/CreateNewBook'
import EditBook from './components/Screens/EditBook'
import BookTable from './components/Screens/BookTable'
import {
    BrowserRouter as Router,
    Switch, Route,
} from 'react-router-dom'
import Keycloak from 'keycloak-js';

// Routing to the different screens
const App = () => {
    const [books, setBooks] = useState([])
    useEffect(()=>{
        const keycloak = new Keycloak('/keycloak.json');
        keycloak.init({ onLoad: 'login-required' }).then(authenticated => {
          setKeycloak(keycloak)
          setAuthenticated(authenticated)
        })
      }, [])
    const [keycloak, setKeycloak] = useState(null)
    const [authenticated, setAuthenticated] = useState(false)
    
    
    if (keycloak) {
            if (authenticated) {
                window.accessToken = keycloak.token;
            return ( 
            <Router>
                <Switch>
                    <Route exact path='/books'>
                        <BookTable books={books} setBooks={setBooks}/>
                    </Route>
                    <Route exact path='/books/create'>
                        <CreateNewBook books={books} setBooks={setBooks}/>
                    </Route>
                    <Route exact path='/books/edit/:isbn'>
                        <EditBook />
                    </Route>
                    <Route exact path='/books/:isbn'>
                        <Book books={books} setBooks={setBooks}/>
                    </Route>
                </Switch>
            </Router>
        );
    }
        else return (<div className='my-12'>Unable to initiate auth!</div>)
    }
    return(
        <>
          <div className='my-12'>Keycloak initializing in a moment...</div>
        </>
        )

}

export default App;
