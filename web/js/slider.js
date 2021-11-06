//slider
var slider = $("#slider");

//botones
var siguiente = $('#btn-next');
var anterior = $('#btn-prev');

//mover ultima imagen al primer lugar
$('#slider section:last').insertBefore('#slider section:first');

//mostrar la primera imagencon un margen de -100%
slider.css('margin-left', '-' + 100 + '%');

function moverd() {
    slider.animate({
        marginLeft: '-' + 200 + '%'
    }, 700, function () {
        $('#slider section:first').insertAfter('#slider section:last');
        slider.css('margin-left', '-' + 100 + '%');
    });
}
function movera() {
    slider.animate({
        marginLeft: '-' + 0 + '%'
    }, 700, function () {
        $('#slider section:last').insertBefore('#slider section:first');
        slider.css('margin-left', '-' + 100 + '%');
    });
}

siguiente.on('click', function () {
    moverd();
});

anterior.on('click', function () {
    movera();
});

function autoplay() {
    interval = setInterval(function () {
        moverd();
    }, 5000);
}

autoplay();