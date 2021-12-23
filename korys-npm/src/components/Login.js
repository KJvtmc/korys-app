import React, { useContext } from "react";
import { LoginContext } from '../contexts/LoginContext';

function Login() {
  const { setUsername, setShowusername } = useContext(LoginContext);

  return (
    <form className="container-fluid">
      <div className="input-group">
        {/* <span className="input-group-text" id="basic-addon1">@</span> */}
        <input type="text"
          className="form-control"
          placeholder="Username"
          aria-label="Username"
          aria-describedby="basic-addon1"
          onChange={(e) => {
            setUsername(e.target.value);
          }}
        />
        <button onClick={() => {
          setShowusername(true);
        }}
        >
          Login
        </button>
      </div>
    </form>
  )
}
export default Login;