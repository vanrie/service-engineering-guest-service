import Header from "../components/Header";
import List from "../components/List";
import CreateForm from "../components/CreateForm"
import { TEInput, TERipple, TETextarea } from "tw-elements-react";
import React from "react";

function Home() {
    const [showModal, setShowModal] = React.useState(false);

    let newEvent = {
        name: '',
        date: '',
        description: ''
    };

    function handleChange(event) {
        newEvent[event.target.name] =  event.target.value;
    }
    function createNewEvent(){
        console.log(newEvent);
        const requestOptions = {
            method: 'POST',
            mode: "no-cors",
            body: newEvent
        };

        fetch('http://localhost:8081/createEvent', requestOptions)
            .then(response => {
                console.log(response);
            })

    }

    return (
        <div>
          <Header></Header>
            <List></List>
            <button
                style={{marginLeft: '50%'}}
                onClick={() => setShowModal(true)}
                className="bg-transparent hover:bg-blue-500 hover:text-blue-500 text-blue-700 font-semibold py-2 px-4 border border-blue-500 hover:border-transparent rounded">
                Create Event
            </button>

            { showModal
                ? (
                        <div className="flex flex-col">
                            <div
                                style={{backgroundColor: 'rgba(1, 1, 1, 0.2)'}}
                                className="justify-center items-center flex overflow-x-hidden overflow-y-auto fixed inset-0 shadow-md z-50 outline-none focus:outline-none fixed top-0 bottom-0 right-0 left-0 z-50 justify-center items-center w-full md:inset-0 h-[calc(100%-1rem)] max-h-full">
                                <form className="bg-white rounded p-5" style={{minWidth: '400px'}}>
                                    <TERipple rippleColor="light" className="w-full">
                                        <button style={{padding: '0 0 20px 100%'}}
                                            type="button"
                                            onClick={() => setShowModal(false)}

                                        >
                                            X
                                        </button>
                                    </TERipple>
                                    <h2 className="text-2xl mb-5 font-extrabold dark:text-white">Create a New Event</h2>
                                    <TEInput
                                        type="text"
                                        label="Name of Event"
                                        className="mb-6"
                                        name="name"
                                        onChange={handleChange}

                                    ></TEInput>
                                    <TEInput
                                        type="date"
                                        className="mb-6"
                                        name="date"
                                        onChange={handleChange}

                                    ></TEInput>

                                    <div className="relative mb-6">
                                        <TETextarea
                                            id="exampleFormControlTextarea13"
                                            label="Description"
                                            rows={3}
                                            name="description"
                                            onChange={handleChange}

                                        />
                                    </div>

                                    <TERipple rippleColor="light" className="w-full">
                                        <button
                                            type="button"
                                            className="inline-block rounded w-full bg-primary px-6 pb-2 pt-2.5 text-xs font-medium uppercase leading-normal text-white shadow-[0_4px_9px_-4px_#3b71ca] transition duration-150 ease-in-out hover:bg-primary-600 hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:bg-primary-600 focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:outline-none focus:ring-0 active:bg-primary-700 active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] dark:shadow-[0_4px_9px_-4px_rgba(59,113,202,0.5)] dark:hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)]"
                                            onClick={() => createNewEvent()}

                                        >
                                            Send
                                        </button>
                                    </TERipple>
                                </form>
                            </div>

                        </div>
                    ): null
            }
        </div>
    );
  }

  export default Home;