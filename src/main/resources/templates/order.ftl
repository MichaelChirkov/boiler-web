<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
    <title>ProКотлы | Корзина</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/modal.css" rel="stylesheet" type="text/css"/>
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
    <script src="assets/modal.js"></script>
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

            <!--  <div class="category-head">
                  <h5 class="latest-product">Корзина</h5>
              </div> -->
            <div style="margin-bottom: 0.3em">
                <h2>Корзина</h2>
            </div>
        <#if orderInfo != 0>
            <!--  <div class="order-clean">
                  <form action="/order/clean-all" method="post">
                      <button class="btn btn-primary" type="submit">Очистить корзину</button>
                  </form>
              </div> -->

            <table class="table mytab">
                <thead>
                <tr>
                    <th>
                        Фото
                    </th>
                    <th>
                        Товар
                    </th>
                    <th>
                        Количество
                    </th>
                    <th>
                        Цена за 1 ед.
                    </th>
                    <th>
                        Удалить
                    </th>
                </tr>
                </thead>
                <tbody>
                    <#list order.orderedProducts as orderedProduct>
                    <tr>
                        <td><img src="/image?id=${orderedProduct.product.mainImg}" style="width: 60px; height: 60px">
                        </td>
                        <td>${orderedProduct.product.name}</td>
                        <td>
                            <form action="/order/inc" , method="get">
                                <input type="hidden" name="id" value="${orderedProduct.id}">
                                <input type="number" class="count-field" min="1" name="count"
                                       value="${orderedProduct.count}">
                                <button type="submit"><img class="accept-btn" src="/ico/accept-ico.png"></button>
                            </form>
                        </td>
                        <#if orderedProduct.product.price ==0>
                            <td>По запросу</td>
                        <#elseif orderedProduct.product.discount != 0>
                            <td>${orderedProduct.product.price - orderedProduct.product.price*orderedProduct.product.discount}</td>
                        <#else>
                            <td>${orderedProduct.product.price}</td>
                        </#if>
                        <td><a href="/order/delete?id=${orderedProduct.id}">
                            <center>
                                <button class="btn btn-mini btn-danger" type="button">X</button>
                            </center>
                        </a>
                        </td>
                    </tr>
                    </#list>
                </tbody>
            </table>

            <div class="order-summary">
                <p><b>Общее количество товаров :</b> ${orPrTotalCount}</p>
                <p><b>Итого :</b> ${total} руб.</p>
            </div>
            <div class="order-clean">
                <p>
                    <a href="#myModal" role="button" class="btn btn-primary" data-toggle="modal">Оформить заказ</a>
                </p>
            </div>
            <!--  -->

        <#else>
            Ваша корзина все еще пуста
        </#if>

            <div class="clearfix"></div>
        </div>
    </div>

<#if success??>
    <div id="alertS" class="alert alert-success boiler-alert">
        <button href="#" type="button" class="close">&times;</button>
        <p>Ваш заказ успешно оформлен.
        <p>В ближайшее время мы свяжемся с вами.</p>
    </div>
</#if>


    <div class="modal" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">Оформление заказа</h3>
                </div>
                <div class="modal-body">
                    <!-- <div class="boil-modal-body"> -->
                    <form action="/confirm-order" method="post">
                        <div class="form-horizontal">
                            <div class="control-group">
                                <label class="control-label" for="inputName">Имя</label>
                                <div class="controls">
                                    <input type="text" id="inputName" name="name" placeholder="Имя" size="30">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputPatronymic">Отчество</label>
                                <div class="controls">
                                    <input type="text" id="inputPatronymic" name="patronymic" placeholder="Отчество"
                                           size="30">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputPhone">Телефон <font color="red">*</font></label>
                                <div class="controls">
                                    <input type="text" id="inputPhone" required name="phone" placeholder="Телефон"
                                           size="30">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputEmail">Электронная почта</label>
                                <div class="controls">
                                    <input type="text" id="inputEmail" name="email" placeholder="Электронная почта"
                                           size="30">
                                </div>
                            </div>
                        </div>
                        <!--  </div> -->


                        <div class="modal-footer">
                            <button class="btn" data-dismiss="modal" aria-hidden="true">Отменить</button>
                            <button class="btn btn-primary" type="submit">Подтвердить заказ</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->


<!-- end Modal -->
<script type="javascript">
    function showModal() {
        $("#myModal").modal(options)
    }
</script>

<script>
    $('.close').click(function () {
        $(this).parent().addClass('fade'); // hides alert with Bootstrap CSS3 implem
    });
</script>

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