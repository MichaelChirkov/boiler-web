<!DOCTYPE html>
<html>
<head>
    <title>ProКотлы | Доставка</title>
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
                <h5 class="latest-product">Доставка</h5>
            </div>

            <div class="boil-text">
            <!--    <p><h3><span>Доставка</span></p></h3> -->
                <br>

                <p><span>Мы находимся в г.Казань, способ доставки обговаривается с клиентом в индивидуальном порядке. Также возможен самовывоз.</span></p>

                <p><span>При получении товара Вам необходимо осмотреть его внешний вид, проверить комплектацию и после этого принять товар. Вместе с заказом вы получите полный комплект бухгалтерских документов.</span></p>

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