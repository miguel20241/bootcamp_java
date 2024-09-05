import { useState } from 'react'

function FollowButton () {
    const [isFollowing, setIsFollowing] = useState(false)
    const btnText = isFollowing ? "Siguiendo" : "Seguir"

    return <div>
                <button onClick={() => setIsFollowing(!isFollowing)}>
                    {btnText}
                </button>
            </div> 
}

export default FollowButton;