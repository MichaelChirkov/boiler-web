<!--A Design by W3layouts 
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>ProКотлы | ${product.name}</title>
    <link href="/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <!--theme-style-->
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/css/boiler.css" rel="stylesheet" type="text/css"/>
    <link href="/css/tabbable.css" rel="stylesheet" type="text/css"/>
    <link rel="icon" type="image/x-icon" href="/images/fav.ico">
    <link rel="stylesheet" href="/css/etalage.css" type="text/css"/>
    <!--//theme-style-->
    <script src="/js/bootstrap.js" type="text/javascript"></script>
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="/js/jquery.js" type="text/javascript"></script>
    <script src="/js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="/js/tabs.js" type="text/javascript"></script>
    <script src="/js/bootstrap-alert.js" type="text/javascript"></script>
    <script type="text/javascript" src="/js/jquery.flexisel.js"></script>
    <script src="/js/img.js" type="text/javascript"></script>

    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!--fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
    <!--//fonts-->

    <script src="/js/jquery.etalage.min.js"></script>
    <script>
        jQuery(document).ready(function ($) {
            $(".alert").alert();
            $('#etalage').etalage({
                thumb_image_width: 300,
                thumb_image_height: 300,
                source_image_width: 900,
                source_image_height: 900,
                show_hint: true,
            });
        });
    </script>
</head>

<body>
<!--header-->
<div class="header">
    <div class="top-header">
        <div class="container">
            <div class="top-header-left">
                <ul class="support">
                    <li><a href="tel:+79274381669"><img src="/images/phone.png"></a></li>
                    <li><a href="tel:+79274381669">тел. +7 (922) 312-12-12<span class="live"></span></a
                    ></li>
                    <li></li>
                <#--     </ul>
                     <ul class="support">-->
                    <li><a href="tel:+79274381669"><img src="/images/whatsapp.png"></a></li>
                    <li><a href="tel:+79274381669">WhatsApp +7 (922) 312-12-12<span class="live"></span></a
                    ></li>
                    <li></li>
                <#--                </ul>
                                <ul class="support">-->
                    <li><a href="tel:+79274381669"><img src="/images/mail.png"></a></li>
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
                    <a href="/"><img src="/images/logo3.png" alt=" "/></a>
                </div>
                <div class="clearfix"></div>
            </div>

            <div class="header-bottom-right">
                <a href="/order"><img src="/images/shop.png">
                    <div class="order-count">Корзина(${orderInfo})
                    </div>
                </a>
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
    <!---->
<div style="display:flex">
    <div class="sub-cate">
        <div class=" top-nav rsidebar span_1_of_left">
            <h3 class="cate">КАТЕГОРИИ</h3>
            <ul class="menu">
                <ul class="kid-menu">
                <#list categories as category>
                    <li><a href="/category/{category.id}">${category.name}</a></li>
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
                    <span class="actual dolor-left-grid">${hotProduct.price - hotProduct.price*hotProduct.discount}
                        р.</span>
                    <span class="reducedfrom">${hotProduct.price} р.</span>
                <#else>
                    <span class="actual dolor-left-grid">${hotProduct.price} р.</span>
                    <span class="reducedfrom"></span>
                </#if>
                <h6><a href="/category/${hotProduct.category.id}/product/${hotProduct.id}">${hotProduct.name}</a>
                </h6>
            </div>
        </div>
    </#if>
    </div>
    <!-- <div class="clearfix"></div> -->
    <div class=" single_top">
        <div class="single_grid">
            <div class="col1"></div>
            <div class="grid images_3_of_2">
                <ul id="etalage">
                    <li>
                        <a href="#">
                            <img style="width: 360; height: 466" class="etalage_thumb_image"
                                 src="/image?id=${product.mainImg}"
                                 class="img-responsive" style="width: 360px; height: 466px;"/>
                            <img class="etalage_source_image" src="/image?id=${product.mainImg}" class="img-responsive"
                                 title=""/>
                        </a>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="desc1 span_3_of_2">
                <h4>${product.name}</h4>
            <div class="cart-b">
            <#if product.price == 0>
                <div class="left-n zapros">По запросу</div>
                <a id="topg" class="now-get get-cart-in" href="#">ДОБАВИТЬ В
                    КОРЗИНУ</a>
            <#elseif product.discount != 0>
                <div style="margin-bottom: 5px">
                    <span class="actual dolor-left-grid">${product.price - product.price*product.discount} р.</span>
                    <a id="topg" class="now-get get-cart-in" href="#">ДОБАВИТЬ В
                        КОРЗИНУ</a>
                </div>
                    <span class="reducedfrom" style="font-size: 1.6em;>${product.price} р.</span>
            <#else>
                    <div class="left-n">${product.price} р.</div>
                <a id="topg" class="now-get get-cart-in" href="#">ДОБАВИТЬ В
                    КОРЗИНУ</a>
            </#if>


                <script>
                    $('#topg').click(function () {
                        $.ajax({
                            type: "POST",
                            url: "/add-order?id=${product.id}",
                            error: function (jqXHR) {
                                if (jqXHR.status == 888) {
                                    getOrderCount();
                                } else {
                                    alert('Произошла ошибка.');
                                }
                            }
                        });
                        $('#alertS').addClass('in');
                        $('.close').click(function () {
                            $(this).parent().removeClass('in'); // hides alert with Bootstrap CSS3 implem
                        });
                    });
                </script>
                <script>
                    function getOrderCount() {
                        $.ajax({
                            type: "GET",
                            url: "/get-order"
                        }).then(function (data) {
                            $('.order-count').text(
                                    "Корзина(" + data.count + ")"
                            );
                        });
                    }
                </script>
                <script>

                </script>
                <div class="clearfix"></div>
            </div>
            <!--
                            <div class="share">
                                <h5>**Подробнее по телефону скидку проси</h5>
                            </div> -->
        </div>
        <div class="clearfix"></div>
    </div>

    <div id="alertS" class="alert alert-success fade boiler-alert">
        <button href="#" type="button" class="close">&times;</button>
        <p>Товар успешно добавлен в корзину</p>
    </div>
    <!--------------------------------------------------------------->
<#if !product.isSparPart>
<div class="col2">
    <#if product.sparParts?size != 0>
    <ul id="flexiselDemo1">
        <#list product.sparParts as sparPart>
        <li><a href="/category/${sparPart.category.id}/product/${product.id}"><img
                style="width: 150px; height: 170px" src="/image?id=${sparPart.mainImg}"/></a>
        <div class="grid-flex"><a
                href="/category/${sparPart.category.id}/product?id=${sparPart.id}">${sparPart.name}</a>
            <#if sparPart.price == 0>
                <p>По запросу</p></div>
            <#else>
                <p>${sparPart.price} р.</p></div>
            </#if>
            </li>
        </#list>
        </ul>
    </#if>
</div>
    <script type="text/javascript">
        $(window).load(function () {
            $("#flexiselDemo1").flexisel({
                visibleItems: ${sparPartsSize},
                animationSpeed: 300,
                autoPlay: false,
                autoPlaySpeed: 1000,
                pauseOnHover: true,
                enableResponsiveBreakpoints: false,
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
    </script>

    <div class="col3">
        <ul class="tabs">
            <li class="tab-link current" data-tab="tab-1">Описание</li>
            <li class="tab-link" data-tab="tab-2">Габариты</li>
            <li class="tab-link" data-tab="tab-3">Характеристики</li>
        </ul>
        <div id="tab-1" class="tab-content current">
        ${product.description}
        </div>
        <div id="tab-2" class="tab-content">
            <div class="category-inf">
                <div class="category-inf-first">
                    <#if product.schemaImg??>
                        <img class="category image" src="/image?id=${product.schemaImg}"
                             alt="Для увеличения нажмите на изображение">
                    </#if>
                </div>
                <div class="category-inf-second" style="margin-left: 20%">
                    <table class="table table-bordered mytab">
                        <thead>
                        <tr>
                            <th align="center">
                                Размер
                            </th>
                            <th align="center">
                                Значение
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                            <#list product.properties as property>
                                <#if property.propertyName.isSize = true >
                                    <#if property.value??>
                                    <tr>
                                        <td align="center" class="bold-td">
                                        ${property.propertyName.name}</td>
                                        <td align="center">
                                            <pre>${property.value}</pre>
                                        </td>
                                    </tr>
                                    </#if>
                                </#if>
                            </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div id="tab-3" class="tab-content">
            <table class="table table-bordered mytab">
                <thead>
                <tr>
                    <th colspan="2">
                        Характеристики котла ${product.name}</th>
                </tr>
                </thead>
                <tbody>
                    <#list product.properties as property>
                        <#if property.propertyName.isSize = false >
                            <#if property.value??>
                            <tr>
                                <td align="left" class="bold-td" style="width:40%;">
                                ${property.propertyName.name}</td>
                                <td align="left">
                                            <pre>
                                            ${property.value}
                                        </pre>
                                </td>
                            </tr>
                            </#if>
                        </#if>
                    </#list>
                </tbody>
            </table>
        </div>
    </div>
<#else>
    <div class="boil-text" style="background-color: #ededed;">
    ${product.description}
    </div>
</#if>
</div>
</div>
</div>
<!-- </div> -->
<!---->
<div class="footer">
    <div class="footer-top">
        <div class="container">
            <div class="latter">
                <br>
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
                <h6>Свяжитесь с нами</h6>
                <ul>
                    <li style="font-weight: 100">info@rossen-kazan.ru</li>
                    <li style="font-weight: 100">Тел: 8(843)-248-60-77</li>
                    <li style="font-weight: 100">© rossen-kazan.ru 2018</li>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
</body>
</html>