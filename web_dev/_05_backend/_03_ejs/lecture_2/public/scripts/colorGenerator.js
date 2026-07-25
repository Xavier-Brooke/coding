let btn = document.getElementById("btn") ;
let div = document.getElementById("colorContainer") ;

btn.addEventListener("click", () => {
    let color = randomColor() ;
    div.style.backgroundColor = color ;
    div.style.borderColor = color ;

    let h3 = document.getElementById("colorInfo") ;
    h3.innerHTML = `Generated Color :- <span style="color:${color};">${color}</span>`
})