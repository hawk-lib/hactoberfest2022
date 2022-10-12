var isPP = function(n){
    for (var m = 2; m * m <= n; ++ m)
    for (var k = 2; Math.pow(m, k) <= n; ++ k)
      if (Math.pow(m, k) == n) return [m, k];
  return null;
  }

console.log(isPP(81))