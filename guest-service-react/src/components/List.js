import React from 'react';
function List(user) {
    const [showModal, setShowModal] = React.useState(false);

    let events = [
        {
            name: 'testevent',
            date: '123-123-2-2'
        },
        {
            name: 'testevent 2',
            date: '123-123-2-2'
        },
    ];

    React.useEffect(() => {
        getAllEvents();
    });

    function getAllEvents(){
        const requestOptions = {
            method: 'GET',
            mode: "no-cors"
        };

        fetch('http://localhost:8081/getAllEvents', requestOptions);
/*

        fetch('http://localhost:8081/getAllEvents', requestOptions)
            .then(response => {
                console.log(response);
                response.json();
            });*/
    }

    function getMyEvents(){
        const requestOptions = {
            method: 'GET',
            mode: "no-cors",
        };
        fetch('http://localhost:8081/getAllParticipations', requestOptions)
            .then(response => {
                console.log(response);
                //go through events and check if I already participate
                response.json()
            });
    }


    function signUpForEvent(event){
        /*
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: {username: '', eventName: event.name},
            mode: "no-cors"
        };
        fetch('http://localhost:8081/createParticipation', requestOptions)
            .then(response => response.json())
            .then(data => this.setState({ postId: data.id }));*/
    }

    function deleteEvent(event){
        /*
        const requestOptions = {
            method: 'DELETE',
        };
        fetch('http://localhost:8081/deleteEvent/' + event.name, requestOptions)
            .then(response => response.json())
            .then(data => this.setState({ postId: data.id }));
            */

    }

    function deleteParticipation(event){
        /*
        const requestOptions = {
            method: 'DELETE',
            mode: "no-cors",
        };
        fetch('http://localhost:8081/deleteParticipation/' + user.username + '/' + event.name, requestOptions)
            .then(response => response.json())
            .then(data => this.setState({ postId: data.id }));
            */
    }


    return(
        <div className="flex flex-col">
            <div className="overflow-x-auto sm:-mx-6 lg:-mx-8">
                <div className="inline-block min-w-full py-2 sm:px-6 lg:px-8">
                    <div className="overflow-hidden">
                        <table className="min-w-full text-left text-sm font-light">
                            <thead className="border-b font-medium dark:border-neutral-500">
                            <tr>
                                <th scope="col" className="px-6 py-4">Name</th>
                                <th scope="col" className="px-6 py-4">Date</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                events.map(event =>
                                    <tr className="border-b dark:border-neutral-500">
                                        <td className="whitespace-nowrap px-6 py-4 font-medium">{event.name}</td>
                                        <td className="whitespace-nowrap px-6 py-4">{event.date}</td>
                                        <td className="whitespace-nowrap px-6 py-4" onClick={deleteEvent(event)}>
                                            <button
                                                className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full"
                                                onClick={() => setShowModal(true)}
                                            >
                                                Show Details
                                            </button>

                                        </td>
                                        <td className="whitespace-nowrap px-6 py-4" onClick={signUpForEvent(event)}>
                                            <button
                                                className="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded-full">
                                                Register
                                            </button>
                                        </td>
                                        <td className="whitespace-nowrap px-6 py-4" onClick={deleteEvent(event)}>
                                            <button
                                                className="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded-full">
                                                Delete
                                            </button>
                                        </td>

                                    </tr>
                                )
                            }
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            {showModal ? (
                <>
                    <div
                        className="justify-center items-center flex overflow-x-hidden overflow-y-auto fixed inset-0 shadow-md z-50 outline-none focus:outline-none fixed top-20 right-0 left-0 z-50 justify-center items-center w-full md:inset-0 h-[calc(100%-1rem)] max-h-full"
                    >
                        <div className="relative w-auto my-6 mx-auto max-w-3xl">
                            {/*content*/}
                            <div className="border-0 rounded-lg shadow-lg relative flex flex-col w-full bg-white outline-none focus:outline-none">
                                {/*header*/}
                                <div className="flex items-start justify-between p-5 border-b border-solid border-blueGray-200 rounded-t">
                                    <h3 className="text-3xl font-semibold">
                                        Modal Title
                                    </h3>
                                    <button
                                        className="p-1 ml-auto bg-transparent border-0 text-black opacity-5 float-right text-3xl leading-none font-semibold outline-none focus:outline-none"
                                        onClick={() => setShowModal(false)}
                                    >
                    <span className="bg-transparent text-black opacity-5 h-6 w-6 text-2xl block outline-none focus:outline-none">
                      ×
                    </span>
                                    </button>
                                </div>
                                {/*body*/}
                                <div className="relative p-6 flex-auto">
                                    <p className="my-4 text-blueGray-500 text-lg leading-relaxed">
                                        I always felt like I could do anything. That’s the main
                                        thing people are controlled by! Thoughts- their perception
                                        of themselves! They're slowed down by their perception of
                                        themselves. If you're taught you can’t do anything, you
                                        won’t do anything. I was taught I could do everything.
                                    </p>
                                </div>
                                {/*footer*/}
                                <div className="flex items-center justify-end p-6 border-t border-solid border-blueGray-200 rounded-b">
                                    <button
                                        className="text-red-500 background-transparent font-bold uppercase px-6 py-2 text-sm outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
                                        type="button"
                                        onClick={() => setShowModal(false)}
                                    >
                                        Close
                                    </button>
                                    <button
                                        className="bg-emerald-500 text-white active:bg-emerald-600 font-bold uppercase text-sm px-6 py-3 rounded shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
                                        type="button"
                                        onClick={() => setShowModal(false)}
                                    >
                                        Save Changes
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="opacity-25 fixed inset-0 z-40 bg-black"></div>
                </>
            ) : null}
        </div>
    );
}

export default List;



