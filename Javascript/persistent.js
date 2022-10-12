//Persistent Bugger
/*Write a function, persistence, that takes in a positive parameter num and returns 
its multiplicative persistence, which is the number of times you 
must multiply the digits in num until you reach a single digit.*/


//IN THIS PROBLEM THERE WAS A ERROR WHILE CALLING RECURSION WHICH YOU MAY NOT FIND WHILE RUNNING IT ONE TIME, 
//BUT WHEN CALLED FOR MORE THAN ONE INPUT CONITION THE COUNT VALUE WAS INCREMENTING SINCE IT HAS BEEN DECLARED HAS VAR
//THE COUNT WAS INCREMENTING WITHOUT RESETTING FOR DIFFERENT INPUT CALL, SO I HAVE ADDED THE COUNT = 0 AND USED TEMP.
//RUNNING TIME - 771ms
 
var count = 1
    var temp = count
function persistence(num) {

    let hold = String(num).split('')
    var result = 1
    console.log(hold);
    if(hold.length === 1)
    {
        //console.log("0");
      return 0
    }
    hold.forEach( (n) => (
        result *= n
          
    ))
    console.log("r->" + result);
    n = result
   // count+=1
    let hold1 = String(n).split('')
    if(hold1.length!==1)
    {
         count+=1
        console.log("count" + count);
        persistence(n)                                                                                               
    }else{
      temp = count;
      console.log("temp" + temp)
      count = 1;
    }
      return temp

}


 num = 999
 persistence(num)
