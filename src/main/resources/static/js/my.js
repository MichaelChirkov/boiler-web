$(document).ready(function () {
    $(window).load(function () {
        $("#flexiselDemo1").flexisel({
            visibleItems: 4,
            animationSpeed: 300,
            autoPlay: false,
            autoPlaySpeed: 1000,
            pauseOnHover: true,
            enableResponsiveBreakpoints: true,
            responsiveBreakpoints: {
                portrait: {
                    changePoint: 480,
                    visibleItems: 1
                },
                landscape: {
                    changePoint: 640,
                    visibleItems: 2
                },
                tablet: {
                    changePoint: 768,
                    visibleItems: 3
                }
            }
        });

    });

    $('#myTab a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
    });

    $(function () {
        var menu_ul = $('.menu > li > ul'),
            menu_a = $('.menu > li > a');
        menu_ul.hide();
        menu_a.click(function (e) {
            e.preventDefault();
            if (!$(this).hasClass('active')) {
                menu_a.removeClass('active');
                menu_ul.filter(':visible').slideUp('normal');
                $(this).addClass('active').next().stop(true, true).slideDown('normal');
            } else {
                $(this).removeClass('active');
                $(this).next().stop(true, true).slideUp('normal');
            }
        });

    });

})