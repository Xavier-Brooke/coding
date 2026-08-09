import { useState } from "react";

export default function LikeButton() {

    let [isLiked, setIsLiked] = useState(false) ;

    function toggleLike() {
        setIsLiked(!isLiked) ;
    }

    let style = {backgroundColor: "red"} ;

    return (
        <div>
            <p onClick={toggleLike}>
                {isLiked? <i className="fa-solid fa-heart" style={style}></i>: <i className="fa-regular fa-heart" ></i>}
            </p>
        </div>
    )
}