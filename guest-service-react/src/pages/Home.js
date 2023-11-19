import Header from "../components/Header";
import List from "../components/List";
import CreateForm from "../components/CreateForm"
import { TEInput, TERipple } from "tw-elements-react";

function Home() {
    const newEvent = {
        date: null,
        name: ''
    }
    function createNewEvent(){
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: newEvent
        };
        fetch('http://localhost:8080/createEvent', requestOptions)
            .then(response => response.json())
            .then(data => this.setState({ postId: data.id }));

    }

    return (
        <div>
          <Header></Header>
            <List></List>
        </div>
    );
  }

  export default Home;