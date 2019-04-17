<!DOCTYPE html>
<html>
<head>
    <title>ProКотлы | Дымовые трубы</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <!--theme-style-->
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/boiler.css" rel="stylesheet" type="text/css"/>
    <link rel="icon" type="image/x-icon" href="images/fav.ico">
    <!--//theme-style-->
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!--fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
    <!--//fonts-->
    <script src="/js/jquery.js" type="text/javascript"></script>
    <script src="/js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/img.js" type="text/javascript" language="JavaScript"></script>
    <!--script-->
</head>
<body>
<!--header-->
<div class="header">
    <div class="top-header">
        <div class="container">
            <div class="top-header-left">
                <ul class="support">
                    <li><a href="tel:+79274381669"><img src="images/phone.png"></a></li>
                    <li><a href="tel:+79274381669">тел. +7 (922) 312-12-12<span class="live"></span></a
                    ></li>
                    <li> </li>
                <#--     </ul>
                     <ul class="support">-->
                    <li><a href="tel:+79274381669"><img src="images/whatsapp.png"></a></li>
                    <li><a href="tel:+79274381669">WhatsApp +7 (922) 312-12-12<span class="live"></span></a
                    ></li>
                    <li> </li>
                <#--                </ul>
                                <ul class="support">-->
                    <li><a href="tel:+79274381669"><img src="images/mail.png"></a></li>
                    <li><a href="mailto:info@rossen-kazan.ru">info@rossen-kazan.ru<span class="live"></span></a
                    ></li>
                </ul>

                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="bottom-header">
        <div class="container">
            <div class="header-bottom-left">
                <div class="logo">
                    <a href="/"><img src="images/logo3.png" alt=" "/></a>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="header-bottom-right">
                <a href="/order"><img src="images/shop.png""> Корзина(${orderInfo})</a>
                <div class="clearfix"></div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!---->
<div class="container">
    <div class="header-menu">
        <ul class="hr">
            <li><a href="/">Главная</a></li>
            <li><a href="/how-to-buy">Как купить</a></li>
            <li><a href="/delivery">Доставка</a></li>
            <li><a href="/guarantees">Гарантии</a></li>
            <li><a href="/about">О бренде</a></li>
            <li><a href="//pricelists">Прайс-лист</a></li>
            <li><a href="/#">Контакты</a></li>
        </ul>
    </div>
    <div style="display:flex">
        <div class="sub-cate">
            <div class=" top-nav rsidebar span_1_of_left">
                <h3 class="cate">КАТЕГОРИИ</h3>
                <ul class="menu">
                    <ul class="kid-menu ">
                    <#list categories as category>
                        <li><a href="/category/${category.id}">${category.name}</a></li>
                    </#list>
                        <li><a href="/chimneys">Дымовые трубы</a></li>
                        <li><a href="/modular-boiler">Модульные котельные</a></li>
                        <li><a href="/spar-parts">Запчасти</a></li>
                    </ul>
                </ul>
            </div>
            <!--initiate accordion-->
            <script type="text/javascript">
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
            </script>
        <#if hotProduct??>
            <div class=" chain-grid menu-chain">
                <a href="/category/${hotProduct.category.id}/product/${hotProduct.id}"><img
                        class="img-responsive chain"
                        src="/image?id=${hotProduct.mainImg}" style="padding: 10px;"/></a>
                <div class="grid-chain-bottom chain-watch">
                    <#if hotProduct.price ==0>
                        <span class="actual dolor-left-grid zapros-hot">По запросу</span>
                        <span class="reducedfrom"></span>
                    <#elseif hotProduct.discount != 0>
                        <span class="actual dolor-left-grid">${hotProduct.price - hotProduct.price*hotProduct.discount} р.</span>
                        <span class="reducedfrom">${hotProduct.price} р.</span>
                    <#else>
                        <span class="actual dolor-left-grid">${hotProduct.price} р.</span>
                        <span class="reducedfrom"></span>
                    </#if>
                    <h6><a href="/category/${hotProduct.category.id}/product/${hotProduct.id}">${hotProduct.name}</a></h6>
                </div>
            </div>
        </#if>
        </div>
        <div class="shoes-grid">

            <div class="category-head">
                <h5 class="latest-product">Дымовые трубы</h5>
            </div>

            <div class="boil-text" style="font-size:12px">
                <br>
                <p><b>У нас вы можете заказать дымовые трубы для котлов и котельных изготовления непосредственно ООО
                    «Завод Котельного Оборудования» («ROSSEN»), так и стороннего производителя («Фабрика
                    Дымоходов»).</b></p>
                <div style="flex-direction: column">
                    <div><p>Дымовая труба или дымоход - труба, создающая тягу для отвода дымовых газов в атмосферу.
                        Дымовая труба состоит из вертикального ствола и отдельных горизонтальных или наклонных участков
                        для присоединения к теплогенерирующему агрегату.</p>
                        <p>Дымовые трубы - являются сложным инженерно-техническим сооружением, требующих проведения
                            основательных расчетов и разработки проектно-конструкторской документации.</p>
                        <p>Дымовая труба является неотъемлемой частью котельных и когенерационных установок.</p>
                        <p>В настоящее время дымоходы претерпели большие изменения. Это связано в первую очередь с тем,
                            что тепловые устройства стали более эффективно работать и температура исходящих газов (дыма)
                            существенно понизилась, что не позволяет быстро прогреть дымоход. Это приводит к образованию
                            сернистого конденсата, который в короткие сроки разрушает дымоходы из кирпича,
                            асбестоцемента и обычной стали.</p>
                        <p>Для нас стали привычными, заменившие кирпичные постройки, модульные здания котельных,
                            административные строения. Не обошел прогресс стороной и промышленные дымовые трубы. Строить
                            их из кирпича, как раньше - дорого и долго. На смену им пришли модульные конструкции
                            газоотводов, изготовленных из нержавеющей стали. Как правило, такие конструкции представляют
                            собой многоствольную дымовую трубу, как правило по одному для каждого котла в составе
                            котельной.</p>
                        <p>Основные преимущества таких дымовых труб заключаются в следующем:</p>
                        <ul style="margin-left: 5px;">
                            <li>возможность установить на одну мачту несколько дымоотводящих стволов;</li>
                            <li>удобство обслуживания - нет необходимости останавливать всю котельную в случае чистки
                                или замены элементов дымохода одного из котлов;
                            </li>
                            <li>возможность увеличения количества дымоотводящих стволов, в случае реконструкции или
                                увеличения мощности котельной;
                            </li>
                            <li>долговечность конструкции - благодаря применению устойчивой к воздействию агрессивных
                                сред и высокой температуры нержавеющей стали и высококачественного утеплителя,
                                снижающего образование конденсата содержащего кислоты.
                            </li>
                        </ul>
                        <br>
                        <p><b>Дымовые трубы, изготавливаемые нашим заводом различаются по типам:</b></p>
                        <ul style="margin-left: 5px; list-style-type: none">
                           <li>1. Дымовая труба настенного крепления (фасадная) предназначена для монтажа и крепления к
                            несущей опорной конструкции (фасад здания, каркасные строения).</li>
                            <li>  2. Дымовые трубы на несущей башне.</li>
                        </ul>
                        <br>
                        <p><b><i> Дымовые трубы соответствуют требованиям нормативных документов.</i></b></p>
                        <br>

                        ООО «Завод Котельного Оборудования» ведет производство и продажу следующих типов труб:
                        <ul style="margin-left: 5px">
                            <li>фасадные настенного крепления;</li>
                            <li>мачтовые колонные;</li>
                            <li>мачтовые с одно - и четырехмачтовой башней;</li>
                            <li>одно - и многоствольные самонесущие.</li>

                        </ul>
                    </div>

                    <div>
                        <center><img src="/image?id=8" style="width: 500px; height: 550px"></center>
                    </div>
                    <div>
                        <center><img src="/image?id=9" style="width: 500px; height: 550px"></center>
                    </div>
                    <br>

                    <div class="clearfix"></div>


                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
    </div>

    <!---->
    <div class="footer">
        <div class="footer-top">
            <div class="container">
                <div class="latter">
                    <br>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    <div class="footer-bottom">
        <div class="container">
            <div class="footer-bottom-cate">
                <ul>
                    <li></li>
                </ul>
            </div>
            <div class="footer-bottom-cate bottom-grid-cat">
                <h6>Категории</h6>
                <ul>
                <#list categories as category>
                    <li><a href="/category/${category.id}">${category.name}</a></li>
                </#list>
                    <li><a href="/chimneys">Дымовые трубы</a></li>
                    <li><a href="/modular-boiler">Модульные котельные</a></li>
                    <!--   <li><a href="/spar-parts">Запчасти</a></li> -->
                </ul>
            </div>
            <div class="footer-bottom-cate">
                <h6>Информация</h6>
                <ul>
                    <li><a href="/how-to-buy">Как купить</a></li>
                    <li><a href="/delivery">Доставка</a></li>
                    <li><a href="/guarantees">Гарантии</a></li>
                    <li><a href="/about">О бренде</li>
                    <li><a href="/pricelists">Прайс-лист</a></li>

                </ul>
            </div>
            <div class="footer-bottom-cate cate-bottom">
                <!---
                                <li class="phone">Телефон +7 (923) 231-23-12</li>
                                <li class="temp"><p class="footer-class">Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a>
                                </p></li>
                 -->
                <h6>Свяжитесь с нами</h6>
                <ul>
                    <li style="font-weight: 100">info@rossen-kazan.ru</li>
                    <li style="font-weight: 100">Тел: 8(843)-248-60-77</li>
                    <li style="font-weight: 100">© rossen-kazan.ru 2018 </li>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
</body>
</html>