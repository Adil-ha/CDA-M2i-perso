import React, { useRef } from "react";

const TimeForm = (props) => {
  const { timeForm } = props;
  const durationTimerInput = useRef();
  const nameInput = useRef();

  const submitFormHandler = (e) => {
    e.preventDefault();

    const durationTimer = durationTimerInput.current.value;
    const name = nameInput.current.value;

    if (durationTimer.trim() !== "" && name.trim() !== "") {
      // Générez un ID unique pour le timer
      const timerId = Date.now();
      // Appelez la fonction timeForm avec l'ID
      timeForm({ durationTimer, name, id: timerId });
    }

    durationTimerInput.current.value = "";
    nameInput.current.value = "";
  };

  return (
    <>
      <form action="#" onSubmit={submitFormHandler}>
        <div className="form-group">
          <input
            type="text"
            className="form-control"
            id="name"
            placeholder="Name Minuteur"
            ref={nameInput}
          />
        </div>
        <div className="form-group">
          <input
            type="number"
            className="form-control"
            id="time"
            placeholder="Time Minuteur"
            ref={durationTimerInput}
          />
        </div>
        <button type="submit" className="btn btn-success">
          Play
        </button>
      </form>
    </>
  );
};

export default TimeForm;
