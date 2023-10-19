import React, { useEffect, useState, useRef } from "react";
import kamehamehaSound from "../assets/sounds/kamehameha.swf.mp3";

const Timer = (props) => {
  const { duration, onRemove } = props;
  const [seconds, setSeconds] = useState(duration);
  const audioRef = useRef(null);

  useEffect(() => {
    if (seconds > 0) {
      const timer = setInterval(() => {
        setSeconds((prevSeconds) => prevSeconds - 1);
      }, 1000);

      return () => clearInterval(timer);
    } else {
      audioRef.current.play();
    }
  }, [seconds]);

  const formattedMinutes = Math.floor(seconds / 60);
  const formattedSeconds = seconds % 60;

  return (
    <div className="border-dark rounded d-flex">
      {seconds > 0 ? (
        <p className="mr-2">
          Temps écoulé : {formattedMinutes}:
          {formattedSeconds < 10 ? `0${formattedSeconds}` : formattedSeconds}
        </p>
      ) : (
        <p>Timer finish !</p>
      )}
      <button className="btn btn-danger" onClick={onRemove}>
        Delete
      </button>
      <audio ref={audioRef} src={kamehamehaSound} controls={false} />
    </div>
  );
};

export default Timer;
