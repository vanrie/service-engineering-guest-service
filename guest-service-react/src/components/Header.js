import { TEInput, TERipple } from "tw-elements-react";
import CreateForm from './CreateForm'
import { useKeycloak } from "@react-keycloak/web";

function Header() {
    const { keycloak } = useKeycloak();

    return (
        <div>
        <button
            style={{right: '0'}}
            className="mt-5 mb-5 mr-4 absolute flex justify-end bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded"
            onClick={() => keycloak.logout()}
        >
            Logout
        </button>
        <header className="mx-6 p-10 flex flex-col items-center">

            <h1 className="mb-4 mt-5 text-center text-4xl font-extrabold leading-none tracking-tight text-gray-900 md:text-5xl lg:text-6xl dark:text-white">
                Manage Your Events like a Pro
            </h1>
            <p className="mb-6 text-lg text-center font-normal text-gray-500 lg:text-xl sm:px-16 xl:px-48 dark:text-gray-400">
                With this application you will never miss a single Event. Manage everything in one go. Try it out now!
            </p>
        </header>
            </div>

    );
  }
   export default Header;