window.addEventListener('scroll', function() {
    var scrollHeight = Math.max(
        document.body.scrollHeight, document.documentElement.scrollHeight,
        document.body.offsetHeight, document.documentElement.offsetHeight,
        document.body.clientHeight, document.documentElement.clientHeight
    );

    if (window.scrollY + window.innerHeight >= scrollHeight) {
        document.getElementById('miFooter').style.display = 'block';
    } else {
        document.getElementById('miFooter').style.display = 'none';
    }
});