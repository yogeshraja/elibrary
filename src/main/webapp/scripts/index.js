import {generateAvatar} from "./generateavatar.js";

const BOOK_LINK = "http://localhost:8080/books";

const constructBookElements = function (data) {

    var $container = $('.container');

    for (let i = 0; i < data.length; i++) {

        let $bookCard = $('<div>');
        $bookCard.attr('class', 'book-card');

        let $bookImage = $('<div>');
        $bookImage.attr('class', 'book-img');

        let $bookImg = $('<img>');
        $bookImg.attr('src', data[i].image);

        $bookImage.append($bookImg);

        let $bookName = $('<h3>');
        $bookName.attr('class', 'book-name');
        $bookName.text(data[i].title);

        let $bookInfo = $('<div>');
        $bookInfo.attr('class', 'book-info');

        let $bookYear = $('<p>');
        $bookYear.attr('class', 'book-year');

        $bookYear.text(data[i].year);

        let $dot = $('<p>');
        $dot.attr('class', 'dot');

        let $bookPages = $('<p>');
        $bookPages.attr('class', 'pages');

        $bookPages.text(data[i].pages + ' pages');

        let $bookAuthor = $('<p>');
        $bookAuthor.attr('class', 'book-author');

        $bookAuthor.text(data[i].author);

        $bookInfo.append($bookYear);
        $bookInfo.append($dot);
        $bookInfo.append($bookPages);
        $bookInfo.append($bookAuthor);


        $bookCard.append($bookImage);
        $bookCard.append($bookName);
        $bookCard.append($bookInfo);

        $bookCard.click(() => {
            location.href = `/book/view/${data[i].bid}`
        })

        $container.append($bookCard);
    }
}

const bookData = function () {

    $.getJSON(BOOK_LINK, (data) => {

        console.log(data);
        constructBookElements(data);

    });
}

let lastsearch="";

const init = function () {

    bookData();
    document.getElementById("avatar").src = generateAvatar("YR", "teal", "whitesmoke");
    document.getElementById("search-submit").addEventListener("click", (e) => {
        e.preventDefault();
        let searchterm = $("#searchterm").val();
        let deepsearch = $("#deepsearch").prop('checked');
        let url = `/books/search?searchterm=${searchterm}&deepsearch=${deepsearch}`;
        if (lastsearch!=="" || searchterm !== "") {
            console.log(lastsearch);
            lastsearch = searchterm;
            $.getJSON(url, (data) => {
                $('.container').empty();
                constructBookElements(data);
            });
        }
    })
}

init();
