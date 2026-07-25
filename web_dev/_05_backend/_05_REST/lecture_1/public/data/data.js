const { v4 : uuid } = require("uuid") ;

let data = [
    {
        id : uuid(),
        title : "Dilwale Dulhania Le Jayenge",
        acters : ["Shahrukh Khan", "Amrish Puri", "Kajol"],
        actresses : ["Kajol", "Madhuri Dixit", "Rani Mukerji"],
        generes : ["Romance", "Drama", "Comedy"],
        relaseData : "20/10/1995",
        budget : "400000000",
        revenues : "1200000000",
        rating : "8.8",
        img : "assets/img1.jfif",
        description : "A young man and woman fall in love during a trip to Europe, but family expectations and tradition test their relationship.",
        productionCompanies : ["Yash Raj Films", "Dharma Productions", "Eros International"]
    },
    {
        id : uuid(),
        title : "Baahubali: The Beginning",
        acters : ["Prabhas", "Rana Daggubati", "Anushka Shetty"],
        actresses : ["Anushka Shetty", "Tamannaah Bhatia", "Ramya Krishna"],
        generes : ["Epic", "Action", "Fantasy"],
        relaseData : "10/07/2015",
        budget : "1800000000",
        revenues : "6500000000",
        rating : "8.2",
        img : "assets/img2.jfif",
        description : "A powerful prince fights for justice and destiny while ancient kingdoms clash over a mysterious ancient kingdom and a legendary weapon.",
        productionCompanies : ["Arka Media Works", "UV Creations", "Global United Media"]
    }
]

module.exports = data ;