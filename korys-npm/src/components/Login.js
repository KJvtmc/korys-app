import React from "react";
import axios from "axios";
import { useHistory } from "react-router-dom";
// import swal from "sweetalert";
import apiEndpoint from "./endpoint";
import AuthContext from "../contexts/AuthContext";
axios.defaults.withCredentials = true;

export const LoginContainer = () => {
  const initState = {
    username: "",
    password: "",
    loginError: false,
    loggingIn: false,
  };

  const [data, setData] = React.useState(initState);
  const { dispatch } = React.useContext(AuthContext);
  const history = useHistory();

  const loginInstance = axios.create();

  loginInstance.interceptors.response.use(
    (response) => response,
    async (error) => {
      const expectedError =
        error.response &&
        error.response.status >= 400 &&
        error.response.status < 500;
      if (!expectedError) {
        dispatch({
          type: "ERROR",
          payload: null,
        });
        setData({
          ...data,
          loginError: false,
          loggingIn: false,
          username: "",
          password: "",
        });
        return (
          <div className="modal" tabindex="-1">
            <div className="modal-dialog">
              <div className="modal-content">
                <div className="modal-header">
                  <h5 className="modal-title">Įvyko klaida, puslapis nurodytu adresu nepasiekiamas</h5>
                  <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div className="modal-footer">
                  <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
              </div>
            </div>
          </div>)
        
      } else if (error.response) {
        if (error.response.status === 401) {
          setData({
            ...data,
            loginError: true,
            loggingIn: false,
            username: "",
            password: "",
          });
        } else if (error.response.status === 403) {
          setData({
            ...data,
            loginError: false,
            loggingIn: false,
            username: "",
            password: "",
          });
          return (
            <div className="modal" tabindex="-1">
              <div className="modal-dialog">
                <div className="modal-content">
                  <div className="modal-header">
                    <h5 className="modal-title">Prieiga uždrausta</h5>
                    <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div className="modal-footer">
                    <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                  </div>
                </div>
              </div>
            </div>
          );
        }
      }
    }
  );

  const handleChange = (event) => {
    validateText(event);
    setData({
      ...data,
      loginError: false, // po nesėkmingo įvedimo pradėjus vesti duomenis iš naujo, paslepia klaidos pranešimą
      [event.target.name]: event.target.value,
    });
  };

  const handleCreateUser = (event) => {
    event.preventDefault();
    setData({
      ...data,
      username: data.username,
      password: data.password,
      loginError: false,
      loggingIn: true,
    });
    let userData = new URLSearchParams();
    userData.append("username", data.username);
    userData.append("password", data.password);
    loginInstance
      .post(`${apiEndpoint}/createuser`, userData, {
        headers: { "Content-type": "application/x-www-form-urlencoded" },
      })
      .then((resp) => {
        dispatch({
          type: "LOGIN",
          payload: resp.data,
        });
        history.push("/home");
      })
      .catch(() => { })
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    setData({
      ...data,
      loginError: false,
      loggingIn: true,
    });
    let userData = new URLSearchParams();
    userData.append("username", data.username);
    userData.append("password", data.password);
    loginInstance
      .get(`${apiEndpoint}/login`, userData, {
        headers: { "Content-type": "application/x-www-form-urlencoded" },
      })
      .then((resp) => {
        dispatch({
          type: "LOGIN",
          payload: resp.data,
        });
        history.push("/home");
      })
      .catch(() => { })
  };

  const validateText = (event) => {
    const target = event.target;

    if (target.validity.valueMissing && target.id === "username") {
      target.setCustomValidity("Būtina įvesti naudotojo prisijungimo vardą");
    } else if (target.validity.valueMissing && target.id === "password") {
      target.setCustomValidity("Būtina įvesti slaptažodį");
    } else {
      target.setCustomValidity("");
    }
  };

  return (
    <div className="d-flex flex-column justify-content-center align-items-center min-vh-100">
      <div className="card p-5">
        {/* Dropped form-specific layout classes for our grid system. Use our grid and utilities instead 
      of .form-group, .form-row, or .form-inline. */}
        {/* Form labels now require .form-label. */}
        {/* <img
          src={logo}
          alt="Vilniaus miesto savivaldybės vaikų darželių informacinė sistema"
          className="img-flex mb-3"
        /> */}
        <form onSubmit={handleSubmit}>
          <h3>Prisijungti</h3>
          <div className="m-3">
            <label htmlFor="username" className="form-label">
              Naudotojo vardas <span className="fieldRequired">*</span>
            </label>
            <input
              type="text"
              className="form-control"
              name="username"
              id="username"
              value={data.username}
              onChange={handleChange}
              onInvalid={validateText}
              required
              data-toggle="tooltip"
              data-placement="top"
              title="Įveskite naudotojo prisijungimo vardą"
            />
          </div>

          <div className="m-3">
            <label htmlFor="password" className="form-label">
              Slaptažodis <span className="fieldRequired">*</span>
            </label>
            <input
              type="password"
              className="form-control"
              name="password"
              id="password"
              value={data.password}
              onChange={handleChange}
              onInvalid={validateText}
              required
              data-toggle="tooltip"
              data-placement="top"
              title="Įveskite naudotojo slaptažodį"
            />
          </div>

          <button
            type="button"
            className="btn btn-link"
            style={{ paddingLeft: "0px" }}
            onClick={handleCreateUser}
            formNoValidate
          >
            Prisiregistruoti
          </button> }
          {/* Renamed .float-left and .float-right to .float-start and .float-end. */}
          <button
            type="submit"
            className="btn btn-primary float-end"
            id="btnLogin"
            disabled={data.loggingIn}
          >
            {data.loggingIn ? "Jungiamasi..." : "Prisijungti"}
          </button>
        </form>
        {data.loginError && (
          <span
            className="alert alert-danger mt-3"
            role="alert"
            id="incorrectLoginData"
          >
            Neteisingas prisijungimo vardas ir/arba slaptažodis!
          </span>
        )}
      </div>
    </div>
  );
};

export default LoginContainer;
