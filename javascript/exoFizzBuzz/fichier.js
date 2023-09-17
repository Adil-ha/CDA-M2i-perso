let tab = [];
let fb = "FizzBuzz";
let fizz = "Fizz";
let buzz = "Buzz";
for (let i = 1; i < 101; i++) {
  tab[i] = i;

  if (tab[i] % 3 == 0 && tab[i] % 5 == 0) {
    tab[i] = fb;
  } else if (tab[i] % 3 == 0) {
    tab[i] = fizz;
  } else if (tab[i] % 5 == 0) {
    tab[i] = buzz;
  }
}
tab.shift();
console.log(tab.join("  "));
