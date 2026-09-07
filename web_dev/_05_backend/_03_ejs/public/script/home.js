const btn = document.getElementById('follow') ;

btn.addEventListener('click', () => {
    const followerCount = document.getElementById('followers') ;
    let val = followerCount.innerText ;
    val = val.split(':-')[1] ;
    val = Number(val) ;
    val += 1 ;
    followerCount.innerText = `Followers :- ${val}`
})