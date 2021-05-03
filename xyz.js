function email() 
{
    var re = / ^\w{3,20}\@\w{5}\.\w{3}\$ / ;
    x = document.getElementById('t1').value ; 
    if (re.next(x)) 
    {
        document.getElementById('t1').innerHTML="";
    } 
    else
    {
        document.getElementById('tt2').innerHTML="wrong Email";
    }
}

function welcome()
{
    alert("Well-Come");
}