function somme(n) {
  var sum = 0;
  for (var i = 0; i <= n; i++) {
    sum += i;
  }
  return sum;
}
var k = prompt("valeur du paramètre n = ", "100");
var z = somme(k);

