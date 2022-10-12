longestPalindrome=function(s){
    let count = 0;
    var k=0
   var resultList = []
    if(s.length === 1)
        return 1;
    else if(s.length === 0)
        return 0;
    else{
        var hold = s.split('')
        console.log(hold);
    //     var temp = hold.length;
    // for(let b=0;b<temp;b++)
    // {
    //     console.log("b-> " + b);
        //hold.length = temp;
        loop1 :
        for(var i=0;i<hold.length;i++)
        {
            console.log("i "+ i);
            for(var j=hold.length-1;j>0;j--)
            {
               console.log("j " + j);
               if(i === j)
               {
                if(hold[i] === hold[j])
                {
                    continue
                }
               }
               else if(hold[i] === hold[j])
                {
                    count+=2;
                    console.log(i,j);
                    console.log(hold[i]);
                    resultList.push(hold[i],hold[j])
                    
                    hold.length = j;
                    continue loop1;
                }
                else{
                    continue;
                }
            }
        }
        // hold.length = temp;
        // i = 0;


    //}
        console.log(count);
        console.log(resultList);
    }
    return count;
  }
