import {generateAvatar} from "./generateavatar.js";
document.getElementById("avatar").src=generateAvatar("YR","teal","whitesmoke");
$('#file').change(()=>{
    let filename = $('#file')[0].files[0].name;
    filename=filename.slice(0,filename.indexOf('.pdf'))
    const values = filename.split('|');
    $('#title').val(values[0].trim());
    $('#author').val(values[1].trim());
    $('#year').val(values[2].trim());
})

const submitBook=()=>{
    $.ajax({
        url:"http://localhost:8080/upload",
        data:$('#add-book-form').serialize(),
        cache: false,
        contentType: "multipart/form-data",
        method: 'POST',
        type: 'POST',
    }).done(()=>{
        alert("Success");
        $('#add-book-form').reset();
    }).fail(()=>{
        alert("Success");
    }).always(()=>{
        $('#submit-button')[0].disabled= false;
    })
}

// document.getElementById('submit-button').addEventListener('click', function (event) {
//     event.preventDefault();
//     submitBook();
// });