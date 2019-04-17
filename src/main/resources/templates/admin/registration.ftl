<!DOCTYPE html>
<html>
  <head>
    <title>Admin Регистрация</title>
    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
    <link href="/assets/styles.css" rel="stylesheet" media="screen">
      <link rel="icon" type="image/x-icon" href="images/fav.ico">
     <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
  </head>
  <body id="login">
    <div class="container">

      <form class="form-signin" action="/admin/registration" method="post">
        <h2 class="form-signin-heading">Регистрация нового администратора</h2>
      <#if logout??>
          <div class="alert alert-info" role="alert">Вы успешно вышли из профиля.</div>
      </#if>
      <#if error??>
          <div class="alert alert-danger" role="alert">Неправильный логин или пароль. Повторите ввод.</div>
      </#if>
      <#if registr_success??>
          <div class="alert alert-success" role="alert">Вы успешно зарегистрированы, пожалуйста выполните вход.</div>
      </#if>
        <input type="text" class="input-block-level" placeholder="Username" name="username">
        <input type="password" class="input-block-level" placeholder="Password" name="password">
          <input type="text" class="input-block-level" placeholder="Name" name="name">
        <button class="btn btn-large btn-primary" type="submit">Зарегистрировать</button>
      </form>

    </div> <!-- /container -->
    <script src="/js/jquery-1.9.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
  </body>
</html>