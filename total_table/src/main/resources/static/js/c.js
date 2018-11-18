window.onload=function(){
    var oDiv=document.getElementById('div1');
    var aBtn=oDiv.getElementsByTagName('input');
    var aDiv=oDiv.getElementsByTagName('div');

    for(var i=0;i<aBtn.length;i++){
        aBtn[i].index=i;
        aBtn[i].onclick=function(){
            for(var i=0;i<aBtn.length;i++){
                aBtn[i].className='';
                aDiv[i].style.display='none';
            }
            this.className='active';
            aDiv[this.index].style.display='block';
        };
    }

};
