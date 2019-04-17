<!DOCTYPE html>
<html>

<head>
    <title>Admin panel | Характеристики</title>
    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
    <link href="/assets/styles.css" rel="stylesheet" media="screen">
    <link href="/assets/DT_bootstrap.css" rel="stylesheet" media="screen">
    <link rel="icon" type="image/x-icon" href="images/fav.ico">
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
                    <a href="calendar.html"><i class="icon-chevron-right"></i> Calendar</a>
                </li>
                <li>
                    <a href="stats.html"><i class="icon-chevron-right"></i> Statistics (Charts)</a>
                </li>
                <li>
                    <a href="form.html"><i class="icon-chevron-right"></i> Forms</a>
                </li>
                <li">
                <a href="tables.html"><i class="icon-chevron-right"></i> Tables</a>
                </li>
                <li>
                    <a href="/admin/properties"><i class="icon-chevron-right"></i> Характеристики</a>
                </li>
                <li class="active">
                    <a href="/admin/property-group"><i class="icon-chevron-right"></i>Группа характеристик</a>
                </li>
                <li>
                    <a href="buttons.html"><i class="icon-chevron-right"></i> Buttons & Icons</a>
                </li>
                <li>
                    <a href="interface.html"><i class="icon-chevron-right"></i> UI & Interface</a>
                </li>
                <li>
                    <a href="#"><span class="badge badge-success pull-right">731</span> Orders</a>
                </li>
                <li>
                    <a href="#"><span class="badge badge-success pull-right">812</span> Invoices</a>
                </li>
                <li>
                    <a href="#"><span class="badge badge-info pull-right">27</span> Clients</a>
                </li>
                <li>
                    <a href="#"><span class="badge badge-info pull-right">1,234</span> Users</a>
                </li>
                <li>
                    <a href="#"><span class="badge badge-info pull-right">2,221</span> Messages</a>
                </li>
                <li>
                    <a href="#"><span class="badge badge-info pull-right">11</span> Reports</a>
                </li>
                <li>
                    <a href="#"><span class="badge badge-important pull-right">83</span> Errors</a>
                </li>
                <li>
                    <a href="#"><span class="badge badge-warning pull-right">4,231</span> Logs</a>
                </li>
            </ul>
        </div>
        <!--/span-->
        <div class="span9" id="content">

            <div class="row-fluid">
                <!-- block -->
                <div class="block">
                    <div class="navbar navbar-inner block-header">
                        <div class="muted pull-left">Группы характеристик</div>
                    </div>
                    <div class="block-content collapse in">
                        <div class="span12">
                            <div class="table-toolbar">
                                <div class="btn-group">
                                    <a href="#"><button class="btn btn-success">Добавить<i class="icon-plus icon-white"></i></button></a>
                                </div>
                                <div class="btn-group pull-right">
                                    <button data-toggle="dropdown" class="btn dropdown-toggle">Tools <span class="caret"></span></button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Print</a></li>
                                        <li><a href="#">Save as PDF</a></li>
                                        <li><a href="#">Export to Excel</a></li>
                                    </ul>
                                </div>
                            </div>

                            <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example2">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Название</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list propertyGroups as propertyGroup>
                                <tr class="odd gradeX">
                                    <td>${propertyGroup.id}</td>
                                    <td>${propertyGroup.name}</td>
                                </tr>
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
                        <div class="muted pull-left">Группа характеристик</div>
                    </div>
                    <div class="block-content collapse in">
                        <div class="span12">
                            <form class="form-horizontal" method="post" action="/admin/properties/add">
                                <fieldset>
                                    <legend>Добавить группу</legend>
                                    <div class="control-group">
                                        <label class="control-label" for="focusedInput">Название</label>
                                        <div class="controls">
                                            <input class="input-xlarge focused" id="focusedInput" type="text" value="" name="name">
                                        </div>
                                    </div>
                                    <div class="form-actions">
                                        <button type="submit" class="btn btn-primary">Добавить</button>
                                        <button type="reset" class="btn">Отчистить</button>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="multiSelect">Характеристики группы</label>
                                        <div class="controls">
                                            <select multiple="multiple" id="multiSelect" class="chzn-select span4"
                                                    name="selectedProducts">
                                            <#list properties as property>
                                                <option value="${property.id}">${property.name}</option>
                                            </#list>
                                            </select>
                                        </div>
                                    </div>
                                </fieldset>
                            </form>

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
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.dataTables.min.js"></script>


<script src="/assets/scripts.js"></script>
<script src="/assets/DT_bootstrap.js"></script>
<script>
    $(function() {

    });
</script>
</body>

</html>