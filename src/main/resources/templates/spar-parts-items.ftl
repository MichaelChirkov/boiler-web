<!DOCTYPE html>
<html>
<head>
    <title>ProКотлы | Категории</title>
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
    <script src="js/jquery.min.js"></script>
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
            <div class=" chain-grid menu-chain">
                <a href="single.html"><img class="img-responsive chain"
                                           src="http://www.rossen.su/image/cache/data/g_b-228x228.PNG" alt=" "/></a>
                <div class="grid-chain-bottom chain-watch">
                    <span class="actual dolor-left-grid">7 200 р.</span>
                    <span class="reducedfrom">7 830 р.</span>
                    <h6><a href="single.html">Группа безопасности RS-D 200 — RS-D 400</a></h6>
                </div>
            </div>

        </div>
        <div class="shoes-grid">

            <div class="category-head">
                <h5 class="latest-product"> Запчасти и комплектующие</h5>

            </div>

            <div class="category-inf">
                <div class="category-inf-first">
                    <img class="category" src="${category.imgUrl}">
                </div>
                <div class="category-inf-second">
                ${category.description}
                    <!--                        <center><img class="delivery" src="images/delivery.png"></center> -->
                </div>
            </div>

            <div class="product-left">
            <#list products as product>

                <div class="col-md-4 chain-grid">
                    <a href="/category/${category.id}/product/${product.id}"><img class="img-responsive chain"
                                                                                     src="http://www.rossen.su/image/cache/data/h40-150x150.PNG"
                                                                                     alt=" "/></a>
                    <div class="grid-chain-bottom">
                        <h6><a href="/category/${category.id}/product/${product.id}">${product.name}</a></h6>
                        <div class="star-price">
                            <div class="dolor-grid">
                                <#if product.discount != 0>
                                    <span class="actual">${product.price - product.price*product.discount}р.</span>
                                    <p>
                                        <span class="reducedfrom">${product.price} р.</span></p>
                                <#else>
                                    <span class="actual">${product.price} р.</span>
                                    <p>
                                        <span class="reducedfrom"></span></p>
                                </#if>


                            </div>
                            <a class="now-get get-cart" href="/category/${category.id}/product/${product.id}">Подробнее</a>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </#list>
                <div class="clearfix"></div>

            </div>
            <div class="clearfix"></div>
        </div>
    </div>

    <div class="clearfix"></div>
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
                <li><a href="#">Котлы RS-A
                    (40-500 кВт)</a></li>
                <li><a href="#">Котлы RS-D
                    (200-15000 кВт)</a></li>
                <li><a href="#">Котлы RS-H
                    (40-800 кВт)</a></li>
                <li><a href="/chimneys">Дымовые трубы</a></li>
                <li><a href="/modular-boiler">Модульные котельные</a></li>
                <li><a href="#">Печи банные</a></li>
                <li><a href="/spar-parts">Запчасти</a></li>
            </ul>
        </div>
        <div class="footer-bottom-cate">
            <h6>Информация</h6>
            <ul>
                <li><a href="/how-to-buy">Как купить</a></li>
                <li><a href="/delivery">Доставка</a></li>
                <li><a href="/about">О нас</a></li>
                <li><a href="/guarantees">Гарантии</li>
                <li><a href="/pricelists">Прайс-листы</a></li>
                <li><a href="#">Контакты</a></li>

            </ul>
        </div>
        <div class="footer-bottom-cate cate-bottom">
            <ul>
                <li class="phone">Телефон +7 (923) 231-23-12</li>
                <li class="temp"><p class="footer-class">Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a>
                </p></li>
            </ul>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
</div>
</body>
</html>