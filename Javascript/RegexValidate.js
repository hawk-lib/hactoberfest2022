//Regex validate PIN code



function validatePIN (pin) {
    var hold = (pin).split('')
    console.log(hold);
    if(hold.length === 4 || hold.length === 6)
    {
        for(let i=0;i<hold.length;i++)
        {
            if((isNaN(hold[i])) || (hold[i] === '\n'))
            {
                return false
            }
        }
        return true
  }else{
      return false
  }
}
  console.log(validatePIN("123"));
  //console.log(result);