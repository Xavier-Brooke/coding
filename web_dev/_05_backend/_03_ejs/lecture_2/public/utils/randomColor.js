function randomColor() {
    let r = Math.floor(Math.random() * 255) + 1 ;
    let g = Math.floor(Math.random() * 255) + 1 ;
    let b = Math.floor(Math.random() * 255) + 1 ;

    let color = `rgb(${r}, ${g}, ${b})` ;
    return color ;
}

window.randomColor = randomColor ;