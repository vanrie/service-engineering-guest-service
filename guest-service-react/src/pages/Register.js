import { TEInput, TERipple } from "tw-elements-react";
//import { useKeycloak } from "@react-keycloak/web";

function Register() {
  //const { keycloak, initialized } = useKeycloak();

  const newAccount = {
    username: null,
    email: null,
    password: null, 
    firstName: null,
    lastName: null
  };
  function handleChange(event) {
    newAccount[event.target.name] =  event.target.value;
    console.log(newAccount);

  }

  function registerNewUser(){
      const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: newAccount
      };
      fetch('http://localhost:8080/createUser', requestOptions)
          .then(response => response.json())
          .then(data => this.setState({ postId: data.id }));
  }

  return (
    <section className="h-screen">
      <div className="h-full">
        <div className="g-6 flex h-full flex-wrap items-center justify-center  mx-7">
          <div className="shrink-1 mb-12 grow-0 basis-auto md:mb-0 md:w-9/12 md:shrink-0 lg:w-6/12 xl:w-6/12">
            <img
              src="https://tecdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
              className="w-full"
              alt="Sample image"
            />
          </div>

          <div className="mb-12 md:mb-0 md:w-8/12 lg:w-5/12 xl:w-5/12">
            <form>

            <TEInput
                type="text"
                label="User Name"
                size="lg"
                className="mb-6"
                name="username"
                onChange={handleChange}
              ></TEInput>
              <TEInput
                type="email"
                label="Email address"
                size="lg"
                className="mb-6"
                name="email"
                onChange={handleChange}
              ></TEInput>

              <TEInput
                type="password"
                label="Password"
                className="mb-6"
                size="lg"
                name="password"
                onChange={handleChange}
              ></TEInput>

              <TEInput
                type="text"
                label="First Name"
                className="mb-6"
                size="lg"
                name="firstName"
                onChange={handleChange}
              ></TEInput>

              <TEInput
                type="text"
                label="Last Name"
                className="mb-6"
                size="lg"
                name="lastName"
                onChange={handleChange}
              ></TEInput>

              <div className="text-center lg:text-left">
                <TERipple rippleColor="light">
                  <button
                    type="button"
                    onClick={() => registerNewUser()}
                    className="inline-block rounded bg-primary px-7 pb-2.5 pt-3 text-sm font-medium uppercase leading-normal text-white shadow-[0_4px_9px_-4px_#3b71ca] transition duration-150 ease-in-out hover:bg-primary-600 hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:bg-primary-600 focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:outline-none focus:ring-0 active:bg-primary-700 active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] dark:shadow-[0_4px_9px_-4px_rgba(59,113,202,0.5)] dark:hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)]"
                  >
                    Register
                  </button>
                </TERipple>

                <p className="mb-0 mt-2 pt-1 text-sm font-semibold">
                  Already have an account?{" "}
                  <a
                    className="text-danger transition duration-150 ease-in-out hover:text-danger-600 focus:text-danger-600 active:text-danger-700"
                    //onClick={() => keycloak.login()}

                  >
                    Login
                  </a>
                </p>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
  );
  }
   export default Register;