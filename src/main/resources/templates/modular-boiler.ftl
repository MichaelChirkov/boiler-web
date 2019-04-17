<!DOCTYPE html>
<html>
<head>
    <title>ProКотлы | Модульные котельные</title>
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
                    <li></li>
                <#--     </ul>
                     <ul class="support">-->
                    <li><a href="tel:+79274381669"><img src="images/whatsapp.png"></a></li>
                    <li><a href="tel:+79274381669">WhatsApp +7 (922) 312-12-12<span class="live"></span></a
                    ></li>
                    <li></li>
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
            <li><a href="/pricelists">Прайс-лист</a></li>
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
                <h5 class="latest-product">Модульные котельные</h5>
            </div>

            <div class="boil-text" style="font-size:12px">
                <div id="alertS" class="alert alert-info">
                    <strong>Внимание!</strong>
                    <p> Все модульные котельные изготавливаются под заказ. Характеристики котельной, её комплектация и
                        сроки производства обговариваются индивидуально с каждым клиентом.</p>
                    <p> Подать заявку можно: написав нам на почту <b>info@rossen-kazan.ru</b>, или позвонив нам по
                        телефону <b>89274334377.</b></p>
                </div>
                <div style="flex-direction: column">

                    <div> Модульные водогрейные котельные марки МК-В предназначены для отопления и горячего
                        водоснабжения коммунальных, производственно-административных, социальных и культурно-бытовых
                        объектов. Могут использоваться в качестве центрального или автономного источников энергии. В
                        котельных устанавливаются водотрубные котлы собственного производства; горелочные устройства,
                        насосное и теплообменное оборудование, системы автоматики и безопасности ведущих мировых
                        производителей(Honeywell, SIT). Все поставляемое оборудование имеет сертификаты соответствия и
                        разрешения на промышленное применение на территории Российской Федерации.
                    </div>
                    <br>
                    <div>
                        <img src="/image?id=6" style="float: right; width: 240px; height: 420px">
                        <ul>
                            <li>Котельная изготавливается в виде одного или нескольких блоков, что обеспечивает
                                удобство транспортировки.
                            </li>
                            <li>Выпускаемая котельная- полностью готовый к работе продукт.</li>
                            <li>Для ввода котельной в эксплуатацию требуется минимальный перечень разрешительных
                                документов
                            </li>
                            <li>Изготовление котельной, установка и ввод в эксплуатацию производятся в кратчайшие
                                сроки от 2 до 4 месяцев.
                            </li>
                            <li>При изготовлении модульных котельных применяются комплектующие высокого качества
                                известных мировых фирм-производителей(Honeywell, SIT и т.д).
                            </li>
                            <li>Полная автоматизация работы котельной, позволяющая обходиться без обслуживающего
                                персонала в помещении котельной.
                            </li>
                            <li>Возможность удаленного контроля за работой котельной.</li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <br>
                    <div>
                        <center><b>Базовая комплектация котельных</b></center>
                        <br>
                        <ul style="list-style-type: none">
                            <li>1) Два котла</li>
                            <li> 2) Автоматизированные горелки в комплекте с автоматикой безопасности</li>
                            <li>3) Насосное оборудование</li>
                            <li> 4) Система управления котельной</li>
                            <li> 5) Водоподготовительное оборудование</li>
                            <li> 6) Арматура и трубопроводы</li>
                            <li> 7) Контрольно-измерительные приборы</li>
                            <li> 8) Утепленный блок-контейнер</li>
                        </ul style="list-style-type: none">
                        <br>
                        <center><b>Дополнительная комплектация котельной</b>(по желанию заказчика)</center>
                        <br>
                        <ul>
                            <li> 1) Коммерческий узел учета тепла</li>
                            <li> 2) Коммерческий узел учета газа</li>
                            <li> 3) Блок горячего водоснабжения</li>
                            <li> 4) Газорегуляторный узел</li>
                            <li> 5) Пластинчатый теплообменник</li>
                            <br>
                        </ul>
                    </div>
                    <br>
                    <div>
                        <img src="/image?id=7" style="float: left; size: 80%; style=" list-style-type: none"">
                        <ul>
                            <li> 1 - котел водогрейный</li>
                            <li> 2 - насосное оборудование</li>
                            <li> 3 - щит управления котельной</li>
                            <li> 4 - расширительный бак</li>
                            <li> 5 - блок ГВС</li>
                            <li> 6 - пластинчатый теплообменник</li>
                            <li> 7 - автоматизированые горелки</li>
                            <li> 8 - водоподготовительное оборудование</li>
                            <li> 9 - арматура и трубопроводы</li>
                            <li> 10 - газорегуляторный узел</li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div>
                        <br><br>
                        <center><b>Технические характеристики</center>
                        </b>
                        <br>
                        <ul>
                            <li>Мощность от 0,1 до 40 МВт.</li>
                            <li>Рабочая температура до +95°С</li>
                            <li>(по спецзаказу до + 115°С).</li>
                            <li> Рабочее давление 0,5 МПа</li>
                            <li> (по спецзаказу 1,0 МПа).</li>
                            <li> Температура уходящих газов не более 170°С.</li>
                            <li> Класс пожароопасности блок-контейнера - III А.</li>
                            <li> Климатическое исполнение - УХЛ.</li>
                        </ul>
                        <ul><b>Вид топлива:</b>
                            <li>природный газ ГОСТ 5545-87</li>
                            <li>сжиженный бытовой газ LPG (пропан-бутан)</li>
                            <li>легкое дизельное топливо</li>
                        </ul>


                        <br>
                        <p>По спец. заказу модульная котельная может комплектоваться модемом GSM передающим сигнал о
                            сбое, а так же по выбору Заказчика, современным оборудованием удовлетворяющим требованиям по
                            безопасной эксплуатации, качеству, удобству обслуживания.</p>
                        <p>Автоматизация позволяет обслуживать котельную без присутствия персонала. Система управления,
                            сигнализации и защиты подает сигнал аварии если нарушены рабочие параметры, пожар,
                            загазованность, проникли посторонние лица в помещение котельной и воздействует на газовый
                            клапан.</p>

                    </div>

                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
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
</body>
</html>