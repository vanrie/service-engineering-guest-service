import React from "react";
import { TEInput, TERipple, TETextarea } from "tw-elements-react";

function CreateForm() {
    let newEvent = {
        name: '',
        date: '',
        description: ''
    };

    function handleChange(event) {
        newEvent[event.target.name] =  event.target.value;
    }
    function createNewEvent(){
        const requestOptions = {
            method: 'POST',
            mode: "no-cors",
            body: newEvent
        };

        fetch('http://localhost:8081/createEvent', requestOptions)
            .then(response => {
                console.log(response);
                response.json()
            })

    }


    return (
        <div className="flex flex-col">
            <h1 className="mb-4 mt-5 text-center text-4xl font-extrabold leading-none tracking-tight text-gray-900 md:text-5xl lg:text-6xl dark:text-white">
                Create your events
            </h1>
            <p className="mb-6 text-lg text-center font-normal text-gray-500 lg:text-xl sm:px-16 xl:px-48 dark:text-gray-400">
                Just add infos to your event here, so everybody can join!
            </p>
            <div className="block max-w-sm rounded-lg bg-white p-6 shadow-[0_2px_15px_-3px_rgba(0,0,0,0.07),0_10px_20px_-2px_rgba(0,0,0,0.04)] dark:bg-neutral-700">
                <form>
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

    );
}

export default CreateForm;