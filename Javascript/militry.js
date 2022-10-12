function timeConversion(s) {
    var hold = s[0]
    if(s[s.length-2] === 'P')
    {
        for(let i=1;i<2;i++)
        {
             hold += s[i]
              
        }
        hold = 12 + parseInt(hold)
        console.log(hold)
    }

}

var res = []
var holdH = s[0]
var holdM = s[2]
var holdS = s[5]
if(s[s.length-2] === 'P')
{
    for(let i=1;i<2;i++)
    {
         holdH += s[i]
          
    }
    for(let j=3;j<5;j++)
    {
        holdM += s[j]
    }
    for(let k=6;k<8;k++)
    {
        holdS += s[k]
    }
    holdH = 12 + parseInt(holdH)
    res.push(holdH)
    res.push(holdM)
    res.push(holdS)
    console.log(res.join(''))
}
if(s[s.length-2] === 'A')
{
    for(let i=1;i<2;i++)
    {
         holdH += 0      
    }
    for(let j=3;j<5;j++)
    {
        holdM += s[j]
    }
    for(let k=6;k<8;k++)
    {
        holdS += s[k]
    }
    //holdH = 00;
    res.push(holdH)
    res.push(holdM)
    res.push(holdS)
    console.log(res.join(''))
}
return (res.join(''))