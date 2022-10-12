function wave(str){
    var res = []
    var hold = str.split('')
    console.log(hold);
    for(let i=0;i<str.length;i++)
    {
        if(hold[i] === ' ')
        {
            continue;
        }
        hold[i] = hold[i].toUpperCase();
        //hold = hold.join('')
        res.push(hold.join(''))
        hold[i] = hold[i].toLowerCase();

    }
    //console.log(hold);
    console.log(res);
    
  }



 //wave("hello")
 wave("two words")