$(document).ready(function() { // Ждём загрузки страницы

    $(".image").click(function(){	// Событие клика на маленькое изображение
        var img = $(this);	// Получаем изображение, на которое кликнули
        var src = img.attr('src'); // Достаем из этого изображения путь до картинки
        $("body").append("<div class='popup' style='display: flex'>"+ //Добавляем в тело документа разметку всплывающего окна
            "<div class='popup_bg'></div>"+ // Блок, который будет служить фоном затемненным
                "<div style='width: 100%; margin: auto auto;'>"+
            "<img src='"+src+"' class='popup_img' />"+ // Само увеличенное фото
                "</div>"+
            "</div>");
        $(".popup").fadeIn(500); // Медленно выводим изображение
        $(".popup_bg").click(function(){	// Событие клика на затемненный фон
            $(".popup").fadeOut(500);	// Медленно убираем всплывающее окно
            setTimeout(function() {	// Выставляем таймер
                $(".popup").remove(); // Удаляем разметку всплывающего окна
            }, 800);
        });
    });

});