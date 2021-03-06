import {generateAvatar} from "./generateavatar.js";

const BOOK_LINK = "https://sirius-elibrary.herokuapp.com";
// const BOOK_LINK = "http://localhost:8080";

const getUrlValues = () => {
    const values = [];
    const args = window.location.href.slice(window.location.href.indexOf('?') + 1).split(/[&#]/);
    for (let i = 0; i < args.length; i++) {
        let arg = args[i].split('=');
        values[arg[0]] = arg[1];
    }
    return values;
}

let values=getUrlValues();
document.getElementById("avatar").src=generateAvatar("YR","teal","whitesmoke");
document.getElementById("pdf-js-viewer").src=`/web/viewer.html?file=${BOOK_LINK}/book/${values['bid']}`;