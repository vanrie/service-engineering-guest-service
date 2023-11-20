import { TEInput, TERipple } from "tw-elements-react";
import { useKeycloak } from "@react-keycloak/web";

function Register() {
  const { keycloak, initialized } = useKeycloak();

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
        mode: "no-cors",
        body: newAccount
      };
      fetch('http://localhost:8081/createUser', requestOptions)
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

              <div className="mb-4 block min-h-[1.5rem] pl-[1.5rem]">
                <input
                    className="relative float-left -ml-[1.5rem] mr-[6px] mt-[0.15rem] h-[1.125rem] w-[1.125rem] appearance-none rounded-[0.25rem] border-[0.125rem] border-solid border-neutral-300 outline-none before:pointer-events-none before:absolute before:h-[0.875rem] before:w-[0.875rem] before:scale-0 before:rounded-full before:bg-transparent before:opacity-0 before:shadow-[0px_0px_0px_13px_transparent] before:content-[''] checked:border-primary checked:bg-primary checked:before:opacity-[0.16] checked:after:absolute checked:after:-mt-px checked:after:ml-[0.25rem] checked:after:block checked:after:h-[0.8125rem] checked:after:w-[0.375rem] checked:after:rotate-45 checked:after:border-[0.125rem] checked:after:border-l-0 checked:after:border-t-0 checked:after:border-solid checked:after:border-white checked:after:bg-transparent checked:after:content-[''] hover:cursor-pointer hover:before:opacity-[0.04] hover:before:shadow-[0px_0px_0px_13px_rgba(0,0,0,0.6)] focus:shadow-none focus:transition-[border-color_0.2s] focus:before:scale-100 focus:before:opacity-[0.12] focus:before:shadow-[0px_0px_0px_13px_rgba(0,0,0,0.6)] focus:before:transition-[box-shadow_0.2s,transform_0.2s] focus:after:absolute focus:after:z-[1] focus:after:block focus:after:h-[0.875rem] focus:after:w-[0.875rem] focus:after:rounded-[0.125rem] focus:after:content-[''] checked:focus:before:scale-100 checked:focus:before:shadow-[0px_0px_0px_13px_#3b71ca] checked:focus:before:transition-[box-shadow_0.2s,transform_0.2s] checked:focus:after:-mt-px checked:focus:after:ml-[0.25rem] checked:focus:after:h-[0.8125rem] checked:focus:after:w-[0.375rem] checked:focus:after:rotate-45 checked:focus:after:rounded-none checked:focus:after:border-[0.125rem] checked:focus:after:border-l-0 checked:focus:after:border-t-0 checked:focus:after:border-solid checked:focus:after:border-white checked:focus:after:bg-transparent dark:border-neutral-600 dark:checked:border-primary dark:checked:bg-primary dark:focus:before:shadow-[0px_0px_0px_13px_rgba(255,255,255,0.4)] dark:checked:focus:before:shadow-[0px_0px_0px_13px_#3b71ca]"
                    type="checkbox"
                    value=""
                    id="checkboxDefault"/>
                <label
                    className="inline-block pl-[0.15rem] hover:cursor-pointer"
                    htmlFor="checkboxDefault">
                  Admin
                </label>
              </div>

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
                    onClick={() => keycloak.login()}

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