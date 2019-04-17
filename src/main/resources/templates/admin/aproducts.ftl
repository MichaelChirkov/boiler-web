<!DOCTYPE html>
<html>

<head>
    <title>Admin panel | Товары</title>
    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
    <link href="/css/jquery.easy-pie-chart.css" rel="stylesheet" media="screen">
    <link href="/css/chosen.min.css" rel="stylesheet" media="screen">
    <link href="/assets/styles.css" rel="stylesheet" media="screen">
    <link rel="icon" type="image/x-icon" href="images/fav.ico">

    <link href="/css/bootstrap-wysihtml5.css" rel="stylesheet" media="screen">
    <link href="/assets/DT_bootstrap.css" rel="stylesheet" media="screen">
    <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="/js/excanvas.min.js"></script><![endif]-->
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>

<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Admin Panel</a>
            <div class="nav-collapse collapse">
                <ul class="nav pull-right">
                    <li class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-user"></i> Тимур Нуруллин <i class="caret"></i>

                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a tabindex="-1" href="/admin?logout">Выход</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav">
                    <li class="active">
                        <a href="#">Главная</a>
                    </li>
                    <li>
                        <a href="/">Вернуться на сайт</a>
                    </li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span3" id="sidebar">
            <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
                <li>
                    <a href="/admin/orders"><i class="icon-chevron-right"></i> Заказы</a>
                </li>
                <li>
                    <a href="/admin/property-names"><i class="icon-chevron-right"></i> Названия характеристик</a>
                </li>
                <li>
                <a href="/admin/categories"><i class="icon-chevron-right"></i>Категории</a>
                </li>
            <#--    <li>
                    <a href="/admin/spar-parts"><i class="icon-chevron-right"></i>Запчасти</a>
                </li>-->
                <li class="active">
                    <a href="/admin/products"><i class="icon-chevron-right"></i>Товары</a>
                </li>
                <li>
                    <a href="/admin/hot-product"><i class="icon-chevron-right"></i>Горячий товар</a>
                </li>
                <li>
                    <a href="/admin/top-products"><i class="icon-chevron-right"></i>Популярные товары</a>
                </li>
                <li>
                    <a href="/admin/upload"><i class="icon-chevron-right"></i>Загрузка изображений</a>
                </li>
                <li>
                    <a href="/admin/pricelists"><i class="icon-chevron-right"></i>Прайс-листы</a>
                </li>
            </ul>
        </div>
        <!--/span-->
        <div class="span9" id="content">

            <div class="row-fluid">
                <!-- block -->
                <div class="block">
                    <div class="navbar navbar-inner block-header">
                        <div class="muted pull-left">Список Товаров</div>
                    </div>
                    <div class="block-content collapse in">
                        <div class="span12">
                            <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example2">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Название</th>
                                    <th>Цена</th>
                                    <th>Скидка</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list products as product>
                                <tr class="odd gradeX">
                                    <td>${product.id}</td>
                                    <td>${product.name}</td>
                                    <td>${product.price}</td>
                                    <td>
                                        <#if product.discount = 0>
                                            отсутствует
                                            <#else>
                                            ${product.discount*100} %
                                        </#if>
                                    </td>
                                    <td>
                                      <center><a href="/admin/product/edit?id=${product.id}"><button class="btn btn-primary"><i class="icon-pencil icon-white"></i> Изменить</button></a></center>
                                    </td>

                                    <td>
                                        <center><a href="/admin/product/delete?id=${product.id}"><button class="btn btn-danger"><i class="icon-remove icon-white"></i> Удалить</button></a></center>
                                    </td>
                                </#list>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- /block -->
            </div>
            <div class="row-fluid">
                <!-- block -->
                <div class="block">
                    <div class="navbar navbar-inner block-header">
                        <div class="muted pull-left"></div>
                    </div>
                    <div class="block-content collapse in">
                        <div class="span12">
                        <#if category??>
                            <form class="form-horizontal" method="post" action="/admin/products/add" enctype="multipart/form-data">
                                <fieldset>
                                    <legend>Добавить товар</legend>

                                        <div class="control-group">
                                            <label class="control-label" for="select01">Категория</label>
                                            <div class="controls">
                                            <select id="select01" class="chzn-select" name="category">
                                                <option value ="${category.id}" selected>${category.name}</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="control-group">
                                            <label class="control-label" for="focusedInput">Название</label>
                                            <div class="controls">
                                                <input class="input-xlarge focused" id="focusedInput" type="text" value="" name="name">
                                            </div>
                                        </div>
                                    <div class="control-group">
                                        <label class="control-label" for="isSize">Запчасть</label>
                                        <div class="controls">
                                            <input type="checkbox" id="isSize" name="isSparPart" value="true" onclick="isASparPart()">
                                        </div>
                                    </div>
                                    <script>
                                        function isASparPart(){
                                            $("div.aproduct").remove();
                                            $("div.aproduct1").remove();
                                        }
                                    </script>
                                        <div class="control-group">
                                            <label class="control-label" for="focusedInput">Цена</label>
                                            <div class="controls">
                                                <input class="input-xlarge focused" id="focusedInput" type="text" value="" name="price">
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label" for="focusedInput">Скидка</label>
                                            <div class="controls">
                                                <input class="input-xlarge focused" id="focusedInput" type="text" value="" name="discount">
                                            </div>
                                        </div>
                                    <div class="control-group">
                                        <label class="control-label" for="fileInput">Изображение Основное</label>
                                        <div class="controls">
                                            <input class="input-file uniform_on" id="fileInput" type="file" name="mainImg">
                                        </div>
                                    </div>
                                    <div class="aproduct1">
                                    <div class="control-group">
                                        <label class="control-label" for="fileInput">Изображение Схемы</label>
                                        <div class="controls">
                                            <input class="input-file uniform_on" id="fileInput" type="file" name="schemaImg">
                                        </div>
                                    </div>
                                    </div>

                                        <div class="control-group">
                                            <label class="control-label" for="textarea2">Описание</label>
                                            <div class="controls">
                                                <textarea class="input-xlarge textarea" name="description" placeholder="Введите текст ..." style="width: 700px; height: 200px"></textarea>
                                            </div>
                                        </div>


                                    <div class="aproduct">
                                        <div class="control-group">
                                            <label class="control-label" for="multiSelect">Комплектующие/запчасти</label>
                                            <div class="controls">
                                                <select multiple="multiple" id="multiSelect" class="chzn-select span4"
                                                        name="selectedSparParts">
                                                    <#list products as sparPart>
                                                        <#if sparPart.isSparPart == true>
                                                        <option value="${sparPart.id}">${sparPart.name}</option>
                                                        </#if>
                                                    </#list>
                                                </select>
                                            </div>
                                        </div>
                                        <h5>Характеристики</h5>
                                        <#list propertyNames as propertyName>
                                        <#if propertyName.isSize == false>
                                            <div class="control-group">
                                                <label class="control-label" for="focusedInput">${propertyName.name}</label>
                                                <div class="controls">
                                                  <!--  <input class="input-xlarge focused" id="focusedInput" type="text" value="" name="${propertyName.name}"> -->
                                                    <textarea class="input-xlarge focused" id="focusedInput" type="text" value="" name="${propertyName.name}"></textarea>
                                                </div>
                                            </div>
                                        </#if>
                                        </#list>
                                        <h5>Габариты</h5>
                                    <#list propertyNames as propertyName>
                                        <#if propertyName.isSize == true>
                                            <div class="control-group">
                                                <label class="control-label" for="focusedInput">${propertyName.name}</label>
                                                <div class="controls">
                                                   <!-- <input class="input-xlarge focused" id="focusedInput" type="text" value="" name="${propertyName.name}"> -->
                                                    <textarea class="input-xlarge focused" id="focusedInput" type="text" value="" name="${propertyName.name}"></textarea>
                                                </div>
                                            </div>
                                        </#if>
                                    </#list>
                                    </div>
                                        <div class="form-actions">
                                            <button type="submit" class="btn btn-primary">Добавить</button>
                                            <button type="reset" class="btn">Отчистить</button>
                                        </div>
                                </fieldset>
                            </form>

                                    <#else>
                                    <form class="form-horizontal" method="get" action="/admin/products">
                                    <fieldset>
                                        <legend>Добавить товар</legend>
                                        <!--<div class="control-group">
                                            <label class="control-label" for="select01">Категория</label>
                                            <div class="controls">
                                                <select id="select01" class="chzn-select" name="category" onchange="this.form.submit()">

                                                </select>
                                            </div>
                                        </div> -->
                                        <div class="control-group">
                                            <label class="control-label">Category<span class="required">*</span></label>
                                            <div class="controls">
                                                <select class="span6 m-wrap" name="category" onchange="this.form.submit()">
                                                    <option>Выберите категорию</option>
                                                    <#list categories as category>
                                                        <option value="${category.id}">${category.name}</option>
                                                    </#list>
                                                </select>
                                            </div>
                                        </div>

                                    </fieldset>
                                    </form>
                                    </#if>



                                    <!--  <div class="control-group">
                                          <label class="control-label" for="optionsCheckbox2">Является размером</label>
                                          <div class="controls">
                                              <label>
                                                  <input type="checkbox" id="optionsCheckbox2" value="true" name="isSize">
                                                  Поставьте отметку, если характеристика является размером
                                              </label>
                                          </div>
                                      </div> -->




                        </div>
                    </div>
                </div>
                <!-- /block -->
            </div>
        </div>
    </div>
    <hr>
    <footer>
        <p>&copy; rossen-kazan.ru 2018</p>
    </footer>
</div>
<!--/.fluid-container-->

<script src="/js/jquery-1.9.1.js"></script>
<script src="/js/jquery-1.9.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.dataTables.min.js"></script>
<script src="/js/easypiechart/jquery.easy-pie-chart.js"></script>
<script src="/js/scripts.js"></script>
<script src="/js/chosen.jquery.min.js"></script>
<script src="/js/wysihtml5-0.3.0.js"></script>
<script src="/js/bootstrap-wysihtml5.js"></script>



<script src="/assets/scripts.js"></script>
<script src="/assets/DT_bootstrap.js"></script>
<script>
    $(function () {

    });
</script>
<script>
    $(function () {
        $(".chzn-select").chosen();
        $('.textarea').wysihtml5();

    });
</script>
<script>

    $(function () {
        // Easy pie charts
        $('.chart').easyPieChart({animate: 1000});
    });
</script>
</body>

</html>