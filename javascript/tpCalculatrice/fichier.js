let btns = document.querySelectorAll(".btn");
let calcul = document.querySelector(".calcul");
let result = document.querySelector(".result");
let egal = document.querySelector(".egal");

btns.forEach((btn) => {
  btn.addEventListener("click", (e) => {
    if (btn.dataset.parent == "cancel") {
      calcul.innerHTML = "";
      result.innerHTML = "";
    }
    if (btn.dataset.parent == "egal") {
      result.innerHTML = `=${eval(calcul.innerHTML)}`;
    }
    calcul.innerHTML += e.target.id;
  });
});

document.addEventListener("keydown", (e) => {
  if (e.key != "Enter") {
    calcul.innerHTML += e.key;
  }

  if (e.key === "Enter") {
    result.innerHTML = `=${eval(calcul.innerHTML)}`;
  }
});
