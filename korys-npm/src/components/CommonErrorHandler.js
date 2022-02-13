import React from 'react';
import { useHistory } from 'react-router';
import AuthContext from "../contexts/AuthContext";
import axios from 'axios';

const CommonErrorHandler = ({children}) => {
    const history = useHistory();
    const { dispatch } = React.useContext(AuthContext);
    
    React.useMemo(() => {
        axios.interceptors.response.use(response => response, async(error) => {
            const expectedError = error.response && error.response.status >= 400 && error.response.status < 500;
            if (!expectedError) {

                dispatch({
                    type: "ERROR",
                    payload: null
                })
                return(
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
                    </div>
                );
                
            } else if (error.response.status === 401) {
                dispatch({
                    type: "ERROR",
                    payload: error.response.status
                })
                return(
                    <div className="modal" tabindex="-1">
                      <div className="modal-dialog">
                        <div className="modal-content">
                          <div className="modal-header">
                            <h5 className="modal-title">Neprisijungta</h5>
                            <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                          </div>
                          <div className="modal-footer">
                            <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                          </div>
                        </div>
                      </div>
                    </div>
                );
                
                
            } else if (error.response.status === 403) {
                dispatch({
                    type: "ERROR",
                    payload: error.response.status
                })
                return(
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
            else return Promise.reject(error);
            history.push("/")
        });
    }, [dispatch, history])
    return children;
}

export default CommonErrorHandler
